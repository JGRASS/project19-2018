package domZdravlja.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import domZdravlja.klase.Lekar;
import domZdravlja.klase.Pacijent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class DodajPacijentaGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblUnesiteVaseIme;
	private JTextField textField;
	private JLabel lblLbo;
	private JTextField textField_1;
	private JLabel lblDatumRodjenja;
	private JTextField textField_2;
	private JLabel lblIzabraniLekar;
	private JComboBox comboBox;
	private GlavniProzorGUI gp;
	private JButton btnNapraviNalog;
	private JButton btnOdustani;

	/**
	 * Create the frame.
	 */
	public DodajPacijentaGUI(GlavniProzorGUI gp) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblUnesiteVaseIme());
		contentPane.add(getTextField());
		contentPane.add(getLblLbo());
		contentPane.add(getTextField_1());
		contentPane.add(getLblDatumRodjenja());
		contentPane.add(getTextField_2());
		contentPane.add(getLblIzabraniLekar());
		contentPane.add(getComboBox());
		contentPane.add(getBtnNapraviNalog());
		contentPane.add(getBtnOdustani());
		this.gp = gp;
	}

	private JLabel getLblUnesiteVaseIme() {
		if (lblUnesiteVaseIme == null) {
			lblUnesiteVaseIme = new JLabel("Unesite Vase ime i prezime");
			lblUnesiteVaseIme.setBounds(12, 33, 156, 16);
		}
		return lblUnesiteVaseIme;
	}

	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(200, 30, 116, 22);
			textField.setColumns(10);
		}
		return textField;
	}

	private JLabel getLblLbo() {
		if (lblLbo == null) {
			lblLbo = new JLabel("LBO");
			lblLbo.setBounds(12, 80, 56, 16);
		}
		return lblLbo;
	}

	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setBounds(200, 80, 116, 22);
			textField_1.setColumns(10);
		}
		return textField_1;
	}

	private JLabel getLblDatumRodjenja() {
		if (lblDatumRodjenja == null) {
			lblDatumRodjenja = new JLabel("Datum rodjenja");
			lblDatumRodjenja.setBounds(12, 133, 116, 16);
		}
		return lblDatumRodjenja;
	}

	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setBounds(200, 130, 116, 22);
			textField_2.setColumns(10);
		}
		return textField_2;
	}

	private JLabel getLblIzabraniLekar() {
		if (lblIzabraniLekar == null) {
			lblIzabraniLekar = new JLabel("Izabrani lekar");
			lblIzabraniLekar.setBounds(12, 181, 105, 16);
		}
		return lblIzabraniLekar;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setBounds(200, 181, 31, 22);
		}
		return comboBox;
	}

	private JButton getBtnNapraviNalog() {
		if (btnNapraviNalog == null) {
			btnNapraviNalog = new JButton("Napravi nalog");
			btnNapraviNalog.addActionListener(new ActionListener() {
				@SuppressWarnings("static-access")
				public void actionPerformed(ActionEvent e) {
					if (textField.getText() == null || textField.getText().isEmpty() || textField_1.getText() == null
							|| textField_1.getText().isEmpty() || textField_2.getText() == null
							|| textField_2.getText().isEmpty()) {
						JOptionPane j = new JOptionPane();
						j.showMessageDialog(j, "Sva polja moraju biti popunjena.","Greska!",j.ERROR_MESSAGE);
					} else {
						Pacijent p = new Pacijent();
						p.setDatumRodjenja(textField_2.getText());
						p.setImePrezime(textField.getText());
						p.setLbo(textField_1.getText());
						p.setIzabraniLekar((Lekar) comboBox.getSelectedItem());
						gp.pacijenti.add(p);
						PacijentGUI pg = new PacijentGUI(p);
						pg.setTitle(p.getImePrezime() + " LBO: " + p.getLbo());
						pg.setVisible(true);
						dispose();
					}
				}
			});
			btnNapraviNalog.setBounds(12, 215, 116, 25);
		}
		return btnNapraviNalog;
	}

	private JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
			btnOdustani.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			btnOdustani.setBounds(252, 215, 97, 25);
		}
		return btnOdustani;
	}
}
