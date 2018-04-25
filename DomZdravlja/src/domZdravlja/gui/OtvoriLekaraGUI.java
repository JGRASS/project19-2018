package domZdravlja.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
	private JPasswordField passwordField;
	private JButton btnPotvrdi;
	private JButton btnOdustani;

	/**
	 * Create the frame.
	 */
	public OtvoriLekaraGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblUnesiteVaId());
		contentPane.add(getTextField());
		contentPane.add(getLblUnesiteVauLozinku());
		contentPane.add(getPasswordField());
		contentPane.add(getBtnPotvrdi());
		contentPane.add(getBtnOdustani());
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
			textField.addKeyListener(new KeyAdapter() {
				@Override//Ogranicava korisnika na unos iskljucivo cifara
				public void keyTyped(KeyEvent e) {
					char vChar = e.getKeyChar();
                    if (!(Character.isDigit(vChar)
                            || (vChar == KeyEvent.VK_BACK_SPACE)
                            || (vChar == KeyEvent.VK_DELETE))) {
                        e.consume();
                    }
				}
			});
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
	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.addKeyListener(new KeyAdapter() {
				@Override//Ogranicava korisnika na unos iskljucivo cifara
				public void keyTyped(KeyEvent e) {
					char vChar = e.getKeyChar();
                    if (!(Character.isDigit(vChar)
                            || (vChar == KeyEvent.VK_BACK_SPACE)
                            || (vChar == KeyEvent.VK_DELETE))) {
                        e.consume();
                    }
				}
			});
			passwordField.setBounds(228, 118, 116, 22);
		}
		return passwordField;
	}
	private JButton getBtnPotvrdi() {
		if (btnPotvrdi == null) {
			btnPotvrdi = new JButton("Potvrdi");
			btnPotvrdi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String ID = textField.getText();
					char[] lozinka = passwordField.getPassword();
					if (lozinka.length == 10 && ID.length() == 10) {
						/*
						 * Znaci da je lozinka OK i pristupa se prozoru LekarGUI
						 * stavio sam random da je velicina lozinke i id-a 10, to mozemo promeniti
						 */
					}
					else {
						JOptionPane j = new JOptionPane();
						j.showMessageDialog(j, "Greška prilikom prijavljivanja.\nPokusajte ponovo.", "Greska!",j.ERROR_MESSAGE);
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
}
