package domZdravlja.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import domZdravlja.klase.Lekar;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OtvoriLekaraGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblUnesiteVaId;
	private JTextField textField;
	private JLabel lblUnesiteVauLozinku;
	private JButton btnPotvrdi;
	private JButton btnOdustani;
	private GlavniProzorGUI gp;
	private JTextField textField_1;
	/**
	 * Create the frame.
	 */
	public OtvoriLekaraGUI(GlavniProzorGUI gp) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblUnesiteVaId());
		contentPane.add(getTextField());
		contentPane.add(getLblUnesiteVauLozinku());
		contentPane.add(getBtnPotvrdi());
		contentPane.add(getBtnOdustani());
		contentPane.add(getTextField_1());
		this.gp = gp;
	}

	private JLabel getLblUnesiteVaId() {
		if (lblUnesiteVaId == null) {
			lblUnesiteVaId = new JLabel("Unesite Va\u0161 ID");
			lblUnesiteVaId.setBounds(52, 54, 115, 16);
		}
		return lblUnesiteVaId;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(228, 51, 116, 22);
			textField.setColumns(10);
		}
		return textField;
	}
	private JLabel getLblUnesiteVauLozinku() {
		if (lblUnesiteVauLozinku == null) {
			lblUnesiteVauLozinku = new JLabel("Unesite Va\u0161u lozinku");
			lblUnesiteVauLozinku.setBounds(52, 121, 134, 16);
		}
		return lblUnesiteVauLozinku;
	}
	@SuppressWarnings("unlikely-arg-type")
	private Lekar vratiLekara(String lozinka,String ID) {
		for (int i = 0; i < gp.lekari.size(); i++) {
			if (gp.lekari.get(i).getIDLekara().equals(ID) && gp.lekari.get(i).getSifra().equals(lozinka)) {
				return gp.lekari.get(i);
			}
		}
		return null;
	}
	private JButton getBtnPotvrdi() {
		if (btnPotvrdi == null) {
			btnPotvrdi = new JButton("Potvrdi");
			btnPotvrdi.addActionListener(new ActionListener() {
				@SuppressWarnings("static-access")
				public void actionPerformed(ActionEvent e) {
					String ID = textField.getText();
					String lozinka = textField_1.getText();
					if (lozinka.length() == 7 && ID.length() == 7) {
						Lekar l = vratiLekara(lozinka,ID);
						if (l == null) {
							JOptionPane j = new JOptionPane();
							j.showMessageDialog(j, "Greška prilikom prijavljivanja. Ne postoji lekar sa unetim ID-om i lozinkom."
									+ "\nPokusajte ponovo.", "Greska!",j.ERROR_MESSAGE);
						}
						else {
							LekarGUI lg = new LekarGUI();
							lg.setVisible(true);
						}
					}
					else {
						JOptionPane j = new JOptionPane();
						j.showMessageDialog(j, "Greška prilikom prijavljivanja. ID i lozinka moraju imati po 10 karaktera."
								+ "\nPokusajte ponovo.", "Greska!",j.ERROR_MESSAGE);
					}
				}
			});
			btnPotvrdi.setBounds(52, 183, 97, 25);
		}
		return btnPotvrdi;
	}
	private JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
			btnOdustani.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnOdustani.setBounds(247, 183, 97, 25);
		}
		return btnOdustani;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setBounds(228, 118, 116, 22);
			textField_1.setColumns(10);
		}
		return textField_1;
	}
}
