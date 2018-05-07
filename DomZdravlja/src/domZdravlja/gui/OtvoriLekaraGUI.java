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
	private JTextField textField_1;
	private OtvoriLekaraGUI ol;
	/**
	 * Create the frame.
	 */
	public OtvoriLekaraGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		ol = this;
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

	private JButton getBtnPotvrdi() {
		if (btnPotvrdi == null) {
			btnPotvrdi = new JButton("Potvrdi");
			btnPotvrdi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.metoda2(textField.getText(),textField_1.getText(),ol);
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
