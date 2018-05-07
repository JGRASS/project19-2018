package domZdravlja.gui;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JCalendar;

import domZdravlja.klase.DatumIVreme;
import domZdravlja.klase.Lekar;
import domZdravlja.klase.Pacijent;
import domZdravlja.klase.Pregled;

public class ZakaziPregledKodSpecijalisteGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblLekar;
	private JLabel lblPacijent;
	private JLabel lblDatum;
	private JButton btnZakazi;
	private JTextField textFieldSpecijalizacija;

	private JComboBox<String> comboBoxLekariSpecijaliste;
	private JCalendar calendar;
	private JCalendar calendar_1;
	private Label lblVreme;
	private JComboBox comboBoxSat;
	private JComboBox comboBoxMinut;
	private JComboBox comboBoxPacijenti;

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
		contentPane.add(getLblDatum());
		contentPane.add(getBtnZakazi());

		lblLekar.setVisible(false);
		lblPacijent.setVisible(false);
		lblDatum.setVisible(false);

		btnZakazi.setVisible(false);

		JLabel lblUnesiteSpecijalizaciju = new JLabel("Unesite specijalizaciju: ");
		lblUnesiteSpecijalizaciju.setBounds(10, 11, 189, 14);
		contentPane.add(lblUnesiteSpecijalizaciju);

		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIKontroler.metoda6(lblLekar, comboBoxPacijenti, lblDatum, lblVreme, btnZakazi, btnPotvrdi,
						lblPacijent, comboBoxLekariSpecijaliste, comboBoxSat, comboBoxMinut, calendar_1,
						textFieldSpecijalizacija);
			}
		});
		btnPotvrdi.setBounds(335, 7, 89, 23);
		contentPane.add(btnPotvrdi);

		textFieldSpecijalizacija = new JTextField();
		textFieldSpecijalizacija.setBounds(209, 8, 116, 20);
		contentPane.add(textFieldSpecijalizacija);
		textFieldSpecijalizacija.setColumns(10);
		contentPane.add(getComboBoxLekariSpecijaliste());
		contentPane.add(getCalendar_1());
		contentPane.add(getLblVreme());
		contentPane.add(getComboBoxSat());
		contentPane.add(getComboBoxMinut());
		contentPane.add(getComboBoxPacijenti());

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

	private JLabel getLblDatum() {
		if (lblDatum == null) {
			lblDatum = new JLabel("Datum:");
			lblDatum.setBounds(269, 63, 56, 16);
		}
		return lblDatum;
	}

	private JButton getBtnZakazi() {
		if (btnZakazi == null) {
			btnZakazi = new JButton("Zakazi");
			btnZakazi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.metoda7((String)comboBoxPacijenti.getSelectedItem(), calendar_1, comboBoxMinut, comboBoxSat,
							comboBoxLekariSpecijaliste);
				}
			});
			btnZakazi.setBounds(7, 226, 97, 25);
		}
		return btnZakazi;
	}

	private JComboBox getComboBoxLekariSpecijaliste() {
		if (comboBoxLekariSpecijaliste == null) {
			comboBoxLekariSpecijaliste = new JComboBox<>();
			comboBoxLekariSpecijaliste.setBounds(114, 61, 115, 20);
			comboBoxLekariSpecijaliste.setVisible(false);
		}
		return comboBoxLekariSpecijaliste;
	}

	private JCalendar getCalendar_1() {
		if (calendar_1 == null) {
			calendar_1 = new JCalendar();
			calendar_1.setBounds(234, 85, 164, 106);
			calendar_1.setVisible(false);
		}
		return calendar_1;
	}

	private Label getLblVreme() {
		if (lblVreme == null) {
			lblVreme = new Label("Vreme:");
			lblVreme.setBounds(269, 198, 70, 24);
			lblVreme.setVisible(false);
		}
		return lblVreme;
	}

	private JComboBox getComboBoxSat() {
		if (comboBoxSat == null) {
			comboBoxSat = new JComboBox();
			comboBoxSat.setBounds(269, 227, 56, 22);

			for (int i = 8; i < 20; i++) {
				comboBoxSat.addItem(i);
			}

			comboBoxSat.setVisible(false);
		}
		return comboBoxSat;
	}

	private JComboBox getComboBoxMinut() {
		if (comboBoxMinut == null) {
			comboBoxMinut = new JComboBox();
			comboBoxMinut.setBounds(335, 227, 63, 22);

			for (int i = 0; i < 60; i += 15) {
				comboBoxMinut.addItem(i);
			}

			comboBoxMinut.setVisible(false);
		}
		return comboBoxMinut;
	}

	private JComboBox getComboBoxPacijenti() {
		if (comboBoxPacijenti == null) {
			comboBoxPacijenti = new JComboBox();
			comboBoxPacijenti.setBounds(113, 96, 116, 22);
			comboBoxPacijenti.setVisible(false);
		}
		return comboBoxPacijenti;
	}
}
