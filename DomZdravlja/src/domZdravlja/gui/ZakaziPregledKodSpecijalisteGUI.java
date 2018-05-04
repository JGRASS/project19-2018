package domZdravlja.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ComboBoxUI;
import javax.swing.plaf.basic.BasicComboBoxUI.ComboBoxLayoutManager;

import domZdravlja.klase.Lekar;
import domZdravlja.klase.Pregled;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JDialog;

public class ZakaziPregledKodSpecijalisteGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblLekar;
	private JLabel lblPacijent;
	private JTextField textFieldPacijent;
	private JTextField textFieldVrstaPregleda;
	private JLabel lblVrstaPregleda;
	private JLabel lblDatum;
	private JButton btnZakazi;
	private JTextField textFieldSpecijalizacija;
	private JComboBox comboBoxDan;
	private JComboBox comboBoxMesec;
	private JComboBox comboBoxGodina;
	private JComboBox<String> comboBoxLekariSpecijaliste;

	/**
	 * Create the frame.
	 */
	public ZakaziPregledKodSpecijalisteGUI() {
		setTitle("Zakazi pregled kod specijaliste");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblLekar());
		contentPane.add(getLblPacijent());
		contentPane.add(getTextFieldPacijent());
		contentPane.add(getTextFieldVrstaPregleda());
		contentPane.add(getLblVrstaPregleda());
		contentPane.add(getLblDatum());
		contentPane.add(getBtnZakazi());

		lblLekar.setVisible(false);
		lblPacijent.setVisible(false);
		lblVrstaPregleda.setVisible(false);
		lblDatum.setVisible(false);

		textFieldPacijent.setVisible(false);
		textFieldVrstaPregleda.setVisible(false);

		btnZakazi.setVisible(false);

		JLabel lblUnesiteSpecijalizaciju = new JLabel("Unesite specijalizaciju: ");
		lblUnesiteSpecijalizaciju.setBounds(10, 11, 189, 14);
		contentPane.add(lblUnesiteSpecijalizaciju);

		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				LinkedList<Lekar> specijalisti = GlavniProzorGUI.vratiSpecijaliste(textFieldSpecijalizacija.getText());
				if (specijalisti != null && !specijalisti.isEmpty()) {
					lblLekar.setVisible(true);
					lblPacijent.setVisible(true);
					lblVrstaPregleda.setVisible(true);
					lblDatum.setVisible(true);

					textFieldPacijent.setVisible(true);
					textFieldVrstaPregleda.setVisible(true);

					btnZakazi.setVisible(true);
					btnPotvrdi.setVisible(false);

					comboBoxDan.setVisible(true);
					comboBoxMesec.setVisible(true);
					comboBoxGodina.setVisible(true);
					comboBoxLekariSpecijaliste.setVisible(true);

					for (int i = 0; i < specijalisti.size(); i++) {
						comboBoxLekariSpecijaliste.addItem(specijalisti.get(i).getImeIPrezime());
					}

				} else {
					JOptionPane j = new JOptionPane();
					JOptionPane.showMessageDialog(j, "Ne postoji lekar sa trazenom specijalizacijom u Domu zdravlja.",
							"Greska!", j.ERROR_MESSAGE);

				}
			}
		});
		btnPotvrdi.setBounds(335, 7, 89, 23);
		contentPane.add(btnPotvrdi);

		textFieldSpecijalizacija = new JTextField();
		textFieldSpecijalizacija.setBounds(209, 8, 116, 20);
		contentPane.add(textFieldSpecijalizacija);
		textFieldSpecijalizacija.setColumns(10);
		contentPane.add(getComboBoxDan());
		contentPane.add(getComboBoxMesec());
		contentPane.add(getComboBoxGodina());
		contentPane.add(getComboBoxLekariSpecijaliste());

	}

	private JLabel getLblLekar() {
		if (lblLekar == null) {
			lblLekar = new JLabel("Lekar:");
			lblLekar.setBounds(12, 63, 92, 16);
		}
		return lblLekar;
	}

	private JLabel getLblPacijent() {
		if (lblPacijent == null) {
			lblPacijent = new JLabel("Pacijent:");
			lblPacijent.setBounds(12, 99, 92, 16);
		}
		return lblPacijent;
	}

	private JTextField getTextFieldPacijent() {
		if (textFieldPacijent == null) {
			textFieldPacijent = new JTextField();
			textFieldPacijent.setBounds(114, 96, 116, 22);
			textFieldPacijent.setColumns(10);
		}
		return textFieldPacijent;
	}

	private JTextField getTextFieldVrstaPregleda() {
		if (textFieldVrstaPregleda == null) {
			textFieldVrstaPregleda = new JTextField();
			textFieldVrstaPregleda.setBounds(114, 129, 116, 22);
			textFieldVrstaPregleda.setColumns(10);
		}
		return textFieldVrstaPregleda;
	}

	private JLabel getLblVrstaPregleda() {
		if (lblVrstaPregleda == null) {
			lblVrstaPregleda = new JLabel("Vrsta pregleda:");
			lblVrstaPregleda.setBounds(12, 132, 92, 16);
		}
		return lblVrstaPregleda;
	}

	private JLabel getLblDatum() {
		if (lblDatum == null) {
			lblDatum = new JLabel("Datum:");
			lblDatum.setBounds(10, 170, 56, 16);
		}
		return lblDatum;
	}

	private JButton getBtnZakazi() {
		if (btnZakazi == null) {
			btnZakazi = new JButton("Zakazi");
			btnZakazi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Pregled p = new Pregled();
					GregorianCalendar datum = new GregorianCalendar();

					p.setPacijent(GlavniProzorGUI.vratiPacijenta(textFieldPacijent.getText()));
					p.setVrstaPregleda(textFieldVrstaPregleda.getText());

					datum.set(comboBoxGodina.getSelectedIndex(), comboBoxMesec.getSelectedIndex() - 1,
							comboBoxDan.getSelectedIndex());
					//p.setDatumIVreme(datum);
					
					p.setLekar(GlavniProzorGUI.vratiLekara((String) comboBoxLekariSpecijaliste.getSelectedItem()));
					
					GlavniProzorGUI.dodajPregled(p);

				}
			});
			btnZakazi.setBounds(7, 226, 97, 25);
		}
		return btnZakazi;
	}

	private JComboBox getComboBoxDan() {
		if (comboBoxDan == null) {
			comboBoxDan = new JComboBox();
			comboBoxDan.setBounds(114, 168, 38, 20);
			for (int i = 1; i < 32; i++) {
				comboBoxDan.addItem(i);
			}
			comboBoxDan.setVisible(false);
		}
		return comboBoxDan;
	}

	private JComboBox getComboBoxMesec() {
		if (comboBoxMesec == null) {
			comboBoxMesec = new JComboBox();
			comboBoxMesec.setBounds(192, 168, 38, 20);
			for (int i = 1; i < 13; i++) {
				comboBoxMesec.addItem(i);
			}
			comboBoxMesec.setVisible(false);
		}
		return comboBoxMesec;
	}

	private JComboBox getComboBoxGodina() {
		if (comboBoxGodina == null) {
			comboBoxGodina = new JComboBox();
			comboBoxGodina.setBounds(254, 168, 38, 20);
			for (int i = 2018; i < 2020; i++) {
				comboBoxGodina.addItem(i);
			}
			comboBoxGodina.setVisible(false);
		}
		return comboBoxGodina;
	}

	private JComboBox getComboBoxLekariSpecijaliste() {
		if (comboBoxLekariSpecijaliste == null) {
			comboBoxLekariSpecijaliste = new JComboBox<>();
			comboBoxLekariSpecijaliste.setBounds(114, 61, 115, 20);
			comboBoxLekariSpecijaliste.setVisible(false);
		}
		return comboBoxLekariSpecijaliste;
	}
}
