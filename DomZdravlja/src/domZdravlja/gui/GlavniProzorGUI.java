package domZdravlja.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Date;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import domZdravlja.klase.DatumIVreme;
import domZdravlja.klase.Lekar;
import domZdravlja.klase.Pacijent;
import domZdravlja.klase.Pregled;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GlavniProzorGUI extends JFrame {

	private JPanel contentPane;
	private JButton btnLekar;
	private JButton btnPacijent;
	public static LinkedList<Lekar> lekari = new LinkedList<Lekar>();
	public static LinkedList<Pacijent> pacijenti = new LinkedList<Pacijent>();

	private GlavniProzorGUI gp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GlavniProzorGUI frame = new GlavniProzorGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GlavniProzorGUI() {
		setTitle("Dom Zdravlja");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnLekar());
		contentPane.add(getBtnPacijent());
		this.gp = this;
		// Narednih par linija koda su proba, ubacujem lekara u listu da ne bi bila
		// prazna, da bih mogao da testiram
		Lekar l = new Lekar();
		l.setIDLekara("1234567");
		l.setImeIPrezime("Bojan Djekic");
		l.setPregledi(null);
		l.setSifra("1234567");
		l.setSpecijalizacija("Ginekolog");
		
		lekari.add(l);
		
		//proba - pacijent
		Pacijent p = new Pacijent();
		p.setImePrezime("Mila Dikic");
		p.setLbo("12345678910");
		p.setDatumRodjenja("28. 06. 1997.");
		p.setIzabraniLekar(l);
		
		pacijenti.add(p);
	}

	private JButton getBtnLekar() {
		if (btnLekar == null) {
			btnLekar = new JButton("Lekar");
			btnLekar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					OtvoriLekaraGUI o = new OtvoriLekaraGUI(gp);
					o.setVisible(true);
				}
			});
			btnLekar.setBounds(47, 113, 97, 25);
		}
		return btnLekar;
	}

	private JButton getBtnPacijent() {
		if (btnPacijent == null) {
			btnPacijent = new JButton("Pacijent");
			btnPacijent.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					OtvoriPacijentaGUI o = new OtvoriPacijentaGUI(gp);
					o.setVisible(true);
				}
			});
			btnPacijent.setBounds(282, 113, 97, 25);
		}
		return btnPacijent;
	}

	public static LinkedList<Lekar> vratiSpecijaliste(String specijalizacija) {
		if (lekari.isEmpty())
			return null;
		LinkedList<Lekar> lekariSpecijaliste = new LinkedList<Lekar>();
		for (int i = 0; i < lekari.size(); i++) {
			Lekar l = lekari.get(i);
			if (l.getSpecijalizacija().equals(specijalizacija))
				lekariSpecijaliste.add(l);
		}
		return lekariSpecijaliste;
	}

	public static Pacijent vratiPacijenta(String imePrezime) {
		if (pacijenti == null)
			return null;
		for (int i = 0; i < pacijenti.size(); i++) {
			Pacijent p = pacijenti.get(i);
			if (p.getImePrezime().equals(imePrezime))
				return p;
		}
		return null;
	}

	public static Lekar vratiLekara(String imePrezime) {
		if (lekari == null)
			return null;
		for (int i = 0; i < lekari.size(); i++) {
			Lekar l = lekari.get(i);
			if (l.getImeIPrezime().equals(imePrezime))
				return l;
		}
		return null;
	}

	public static void dodajPregled(Pregled p) {
		int indeks = lekari.indexOf(p.getLekar());
		Lekar l = lekari.get(indeks);
		LinkedList<Pregled> preglediLekara = l.getPregledi();
		preglediLekara.add(p);
		l.setPregledi(preglediLekara);
	}
}
