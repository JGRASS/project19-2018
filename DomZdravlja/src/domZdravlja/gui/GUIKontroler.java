package domZdravlja.gui;

import java.awt.EventQueue;
import java.awt.Label;
import java.awt.TextArea;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.toedter.calendar.JCalendar;

import domZdravlja.klase.DatumIVreme;
import domZdravlja.klase.Lekar;
import domZdravlja.klase.Pacijent;
import domZdravlja.klase.Pregled;

public class GUIKontroler {
	public static GlavniProzorGUI gp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIKontroler.gp = new GlavniProzorGUI();
					GUIKontroler.gp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static LinkedList<Lekar> vratiSpecijaliste(String specijalizacija) {
		if (GUIKontroler.gp.lekariSpecijaliste.isEmpty())
			return null;
		LinkedList<Lekar> lekariSpecijaliste = new LinkedList<Lekar>();
		for (int i = 0; i < GUIKontroler.gp.lekariSpecijaliste.size(); i++) {
			Lekar l = GUIKontroler.gp.lekariSpecijaliste.get(i);
			if (l.getSpecijalizacija().equals(specijalizacija))
				lekariSpecijaliste.add(l);
		}
		return lekariSpecijaliste;
	}

	public static Pacijent vratiPacijentaIme(String imePrezime) {
		if (GUIKontroler.gp.pacijenti == null)
			return null;
		for (int i = 0; i < GUIKontroler.gp.pacijenti.size(); i++) {
			Pacijent p = GUIKontroler.gp.pacijenti.get(i);
			if (p.getImePrezime().equals(imePrezime))
				return p;
		}
		return null;
	}

	public static Lekar vratiLekara(String imePrezime) {
		if (GUIKontroler.gp.lekariSpecijaliste == null)
			return null;
		for (int i = 0; i < GUIKontroler.gp.lekariSpecijaliste.size(); i++) {
			Lekar l = GUIKontroler.gp.lekariSpecijaliste.get(i);
			if (l.getImeIPrezime().equals(imePrezime))
				return l;
		}
		return null;
	}

	public static void dodajPregled(Pregled p) {
		int indeks = GUIKontroler.gp.lekariSpecijaliste.indexOf(p.getLekar());
		Lekar l = GUIKontroler.gp.lekariSpecijaliste.get(indeks);
		LinkedList<Pregled> preglediLekara = new LinkedList<Pregled>();
		preglediLekara = l.getPregledi();
		preglediLekara.add(p);
		GUIKontroler.gp.lekariSpecijaliste.get(indeks).setPregledi(preglediLekara);
	}

	@SuppressWarnings("unlikely-arg-type")
	public static Lekar vratiLekara(String lozinka, String ID) {
		for (int i = 0; i < gp.lekariSpecijaliste.size(); i++) {
			if (gp.lekariSpecijaliste.get(i).getIDLekara().equals(ID) && gp.lekariSpecijaliste.get(i).getSifra().equals(lozinka)) {
				return gp.lekariSpecijaliste.get(i);
			}
		}
		for (int i = 0; i < gp.lekariOpstePrakse.size(); i++) {
			if (gp.lekariOpstePrakse.get(i).getIDLekara().equals(ID) && gp.lekariOpstePrakse.get(i).getSifra().equals(lozinka)) {
				return gp.lekariOpstePrakse.get(i);
			}
		}
		return null;
	}

	public static String prikaziZakazanePreglede(java.util.Date datumOd, java.util.Date datumDo) {
		LinkedList<Pregled> sviPregledi = new LinkedList<>();
		sviPregledi = PrikaziZakazanePregledeGUI.lekar.getPregledi();

		String s = "";

		for (int i = 0; i < sviPregledi.size(); i++) {
			Pregled p = sviPregledi.get(i);
			java.util.Date datum = p.getDatumIVreme().getDatum();
			if ((datum.equals(datumOd) || datum.after(datumOd)) && (datum.equals(datumDo) || datum.before(datumDo)))
				s = s + "\n " + p.IzvestajZaLekara();
		}
		return s;
	}

	public static void metoda1(String textField, String textField_1, String textField_2, String comboBox,
			DodajPacijentaGUI dp) {
		if (textField == null || textField.isEmpty() || textField_1 == null || textField_1.isEmpty()
				|| textField_1.length() != 11 || textField_2 == null || textField_2.isEmpty()) {
			JOptionPane j = new JOptionPane();
			j.showMessageDialog(j, "Sva polja moraju biti popunjena i LBO mora imati 11 cifara.", "Greska!",
					j.ERROR_MESSAGE);
		} else {
			Pacijent p = new Pacijent();
			p.setDatumRodjenja(textField_2);
			p.setImePrezime(textField);
			p.setLbo(textField_1);
			for (int i = 0; i < GUIKontroler.gp.lekariOpstePrakse.size(); i++) {
				if (GUIKontroler.gp.lekariOpstePrakse.get(i).getImeIPrezime().equals(comboBox))
					p.setIzabraniLekar(GUIKontroler.gp.lekariOpstePrakse.get(i));
			}
			GUIKontroler.gp.pacijenti.add(p);
			try (FileWriter writer = new FileWriter("lib/pacijenti.json")) {
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
				gson.toJson(gp.pacijenti,writer);
			} catch (IOException e) {
				e.printStackTrace();
			}
			PacijentGUI pg = new PacijentGUI(p);
			pg.setTitle(p.getImePrezime() + " LBO: " + p.getLbo());
			pg.setVisible(true);
			GUIKontroler.gp.dispose();
			dp.dispose();
		}
	}

	public static void metoda2(String textField, String textField_1, OtvoriLekaraGUI ol) {
		String ID = textField;
		String lozinka = textField_1;
		if (lozinka.length() == 7 && ID.length() == 7) {
			Lekar l = GUIKontroler.vratiLekara(lozinka, ID);
			if (l == null) {
				JOptionPane j = new JOptionPane();
				j.showMessageDialog(j, "Gre�ka prilikom prijavljivanja. Ne postoji lekar sa unetim ID-om i lozinkom."
						+ "\nPokusajte ponovo.", "Greska!", j.ERROR_MESSAGE);
			} else {
				LekarGUI lg = new LekarGUI(l);
				lg.setVisible(true);
				GUIKontroler.gp.dispose();
				ol.dispose();
			}
		} else {
			JOptionPane j = new JOptionPane();
			j.showMessageDialog(j,
					"Gre�ka prilikom prijavljivanja. ID i lozinka moraju imati po 7 karaktera." + "\nPokusajte ponovo.",
					"Greska!", j.ERROR_MESSAGE);
		}
	}

	public static Pacijent vratiPacijentaLBO(String LBO) {
		if (GUIKontroler.gp.pacijenti == null)
			return null;
		for (int i = 0; i < GUIKontroler.gp.pacijenti.size(); i++) {
			Pacijent p = GUIKontroler.gp.pacijenti.get(i);
			if (p.getLbo().equals(LBO))
				return p;
		}
		return null;
	}

	public static void metoda3(String textFieldLBO, OtvoriPacijentaGUI op) {
		if (textFieldLBO.length() == 11) {
			Pacijent p = vratiPacijentaLBO(textFieldLBO);
			if (p == null) {
				JOptionPane j = new JOptionPane();
				int opcija = j.showConfirmDialog(j, "Ne postoji pacijent sa unetim LBO. Napravi nalog?", "Greska!",
						j.INFORMATION_MESSAGE, j.YES_NO_OPTION);
				if (opcija == JOptionPane.YES_OPTION) {
					DodajPacijentaGUI dp = new DodajPacijentaGUI();
					dp.setVisible(true);
				}
			} else {
				PacijentGUI pg = new PacijentGUI(p);
				pg.setVisible(true);
				GUIKontroler.gp.dispose();
				op.dispose();
			}
		} else {
			JOptionPane j = new JOptionPane();
			j.showMessageDialog(j, "Pogresno unet LBO. Mora imati 11 znakova.\nPokusajte ponovo.", "Greska!",
					j.ERROR_MESSAGE);
		}
	}

	public static Pregled noviPregled(Pacijent pacijent, JCalendar calendar, int spinField, int comboBox_1) {
		DatumIVreme datumIVreme = new DatumIVreme();
		datumIVreme.setDatum(calendar.getDate());
		datumIVreme.setSati((Integer) spinField);
		datumIVreme.setMinuti((Integer) comboBox_1);
		Pregled p = new Pregled();
		p.setDatumIVreme(datumIVreme);
		p.setLekar(pacijent.getIzabraniLekar());
		p.setPacijent(pacijent);
		return p;
	}

	public static void prebaciUIstoriju(Pacijent pacijent) {
		for (int i = 0; i < pacijent.zakazaniPregledi.size(); i++) {
			if (pacijent.zakazaniPregledi.get(i).getDatumIVreme().getDatum().before(new Date())) {
				pacijent.istorijaPregleda.add(pacijent.zakazaniPregledi.get(i));
				pacijent.zakazaniPregledi.remove(i);
			}
		}
	}

	public static void metoda4(Pacijent pacijent, String comboBox_1) {
		for (int i = 0; i < GUIKontroler.gp.lekariOpstePrakse.size(); i++) {
			if (GUIKontroler.gp.lekariOpstePrakse.get(i).getImeIPrezime().equals(comboBox_1)) {
				pacijent.setIzabraniLekar(GUIKontroler.gp.lekariOpstePrakse.get(i));
				break;
			}
		}
	}

	public static void metoda5(java.util.Date datumOD, java.util.Date datumDO, TextArea textAreaPregledi,
			JLabel lblZakazniPregledi) {
		
		lblZakazniPregledi.setVisible(true);
		textAreaPregledi.setVisible(true);

		String s = GUIKontroler.prikaziZakazanePreglede(datumOD, datumDO);
		if (s.equals(""))
			textAreaPregledi.setText("Ne postoji ni jedan zakazani pregled u trazenom periodu.");
		else
			textAreaPregledi.setText(s);

	}

	public static void metoda6(JLabel lblLekar, JComboBox comboBoxPacijenti, JLabel lblDatum, Label lblVreme,
			JButton btnZakazi, JButton btnPotvrdi, JLabel lblPacijent, JComboBox comboBoxLekariSpecijaliste,
			JComboBox comboBoxSat, JComboBox comboBoxMinut, JCalendar calendar_1, JTextField textFieldSpecijalizacija) {

		LinkedList<Lekar> specijalisti = GUIKontroler.vratiSpecijaliste(textFieldSpecijalizacija.getText());

		if (specijalisti != null && !specijalisti.isEmpty()) {
			lblLekar.setVisible(true);
			lblPacijent.setVisible(true);

			lblDatum.setVisible(true);
			lblVreme.setVisible(true);

			btnZakazi.setVisible(true);
			btnPotvrdi.setVisible(false);

			comboBoxLekariSpecijaliste.setVisible(true);
			comboBoxPacijenti.setVisible(true);
			comboBoxSat.setVisible(true);
			comboBoxMinut.setVisible(true);

			calendar_1.setVisible(true);

			for (int i = 0; i < specijalisti.size(); i++) {
				comboBoxLekariSpecijaliste.addItem(specijalisti.get(i).getImeIPrezime());
			}

			LinkedList<Pacijent> sviPacijenti = GUIKontroler.gp.pacijenti;

			for (int i = 0; i < sviPacijenti.size(); i++) {
				comboBoxPacijenti.addItem(sviPacijenti.get(i).getImePrezime());
			}

		} else {
			JOptionPane j = new JOptionPane();
			JOptionPane.showMessageDialog(j, "Ne postoji lekar sa trazenom specijalizacijom u Domu zdravlja.",
					"Greska!", j.ERROR_MESSAGE);

		}
	}

	public static void metoda7(String imePrezime, JCalendar calendar_1, JComboBox comboBoxMinut, JComboBox comboBoxSat,
			JComboBox comboBoxLekariSpecijaliste) {
		Pregled p = new Pregled();
		DatumIVreme datum = new DatumIVreme();

		if (GUIKontroler.vratiPacijentaIme(imePrezime) != null && comboBoxLekariSpecijaliste.getSelectedItem() != null
				&& calendar_1.getDate() != null && comboBoxMinut.getSelectedItem() != null
				&& comboBoxSat.getSelectedItem() != null) {
			p.setPacijent(GUIKontroler.vratiPacijentaIme(imePrezime));

			datum.setDatum(calendar_1.getDate());
			datum.setSati((int) comboBoxSat.getSelectedItem());
			datum.setMinuti((int) comboBoxMinut.getSelectedItem());

			p.setDatumIVreme(datum);

			p.setLekar(GUIKontroler.vratiLekara((String) comboBoxLekariSpecijaliste.getSelectedItem()));

			GUIKontroler.dodajPregled(p);
		} else {
			JOptionPane j = new JOptionPane();
			JOptionPane.showMessageDialog(j, "Morate izabrati vrednosti u svim poljima!", "Greska!", j.ERROR_MESSAGE);
		}

	}
}
