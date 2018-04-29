package domZdravlja.gui;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Dimension;

public class LekarGUI extends JFrame {

	private JPanel contentPane;
	private JButton btnZakaziPregledKod;
	private JButton btnPrikaziZakazanePreglede;
	private JLabel lblImeIPrezime;
	private JTextField textFieldImeIPrezime;
	private JLabel lblId;
	private JTextField textFieldID;
	private JLabel lblSpecijalizacija;
	private JTextField textFieldSpecijalizacija;
	private JButton btnKrajRada;
	/**
	 * Create the frame.
	 */
	public LekarGUI() {
		setTitle("Lekar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblImeIPrezime());
		contentPane.add(getTextFieldImeIPrezime());
		contentPane.add(getLblSpecijalizacija());
		contentPane.add(getTextFieldSpecijalizacija());
		contentPane.add(getLblId());
		contentPane.add(getTextFieldID());
		contentPane.add(getBtnZakaziPregledKod());
		contentPane.add(getBtnPrikaziZakazanePreglede());
		contentPane.add(getBtnKrajRada());
	}
	private JButton getBtnZakaziPregledKod() {
		if (btnZakaziPregledKod == null) {
			btnZakaziPregledKod = new JButton("Zakazi pregled kod specijaliste");
			btnZakaziPregledKod.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ZakaziPregledKodSpecijalisteGUI z = new ZakaziPregledKodSpecijalisteGUI();
					z.setVisible(true);
				}
			});
			btnZakaziPregledKod.setBounds(12, 140, 235, 25);
		}
		return btnZakaziPregledKod;
	}
	private JButton getBtnPrikaziZakazanePreglede() {
		if (btnPrikaziZakazanePreglede == null) {
			btnPrikaziZakazanePreglede = new JButton("Prikazi zakazane preglede");
			btnPrikaziZakazanePreglede.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					PrikaziZakazanePregledeGUI p = new PrikaziZakazanePregledeGUI();
					p.setVisible(true);
				}
			});
			btnPrikaziZakazanePreglede.setBounds(12, 178, 235, 25);
		}
		return btnPrikaziZakazanePreglede;
	}
	private JLabel getLblImeIPrezime() {
		if (lblImeIPrezime == null) {
			lblImeIPrezime = new JLabel("Ime i prezime: ");
			lblImeIPrezime.setBounds(38, 13, 116, 16);
		}
		return lblImeIPrezime;
	}
	private JTextField getTextFieldImeIPrezime() {
		if (textFieldImeIPrezime == null) {
			textFieldImeIPrezime = new JTextField();
			textFieldImeIPrezime.setBounds(164, 10, 116, 22);
			textFieldImeIPrezime.setColumns(10);
		}
		return textFieldImeIPrezime;
	}
	private JLabel getLblId() {
		if (lblId == null) {
			lblId = new JLabel("ID:");
			lblId.setBounds(38, 81, 45, 16);
		}
		return lblId;
	}
	private JTextField getTextFieldID() {
		if (textFieldID == null) {
			textFieldID = new JTextField();
			textFieldID.setBounds(164, 80, 116, 22);
			textFieldID.setColumns(10);
		}
		return textFieldID;
	}
	private JLabel getLblSpecijalizacija() {
		if (lblSpecijalizacija == null) {
			lblSpecijalizacija = new JLabel("Specijalizacija:");
			lblSpecijalizacija.setBounds(38, 52, 114, 16);
		}
		return lblSpecijalizacija;
	}
	private JTextField getTextFieldSpecijalizacija() {
		if (textFieldSpecijalizacija == null) {
			textFieldSpecijalizacija = new JTextField();
			textFieldSpecijalizacija.setBounds(164, 45, 116, 22);
			textFieldSpecijalizacija.setColumns(10);
		}
		return textFieldSpecijalizacija;
	}
	private JButton getBtnKrajRada() {
		if (btnKrajRada == null) {
			btnKrajRada = new JButton("Kraj rada");
			btnKrajRada.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JOptionPane j = new JOptionPane();
					int opcija = j.showConfirmDialog(j, "Da li ste sigurni?","Kraj rada",j.YES_NO_OPTION);
					if (opcija == j.YES_OPTION) {
						System.exit(0);
					}
				}
			});
			btnKrajRada.setBounds(323, 215, 97, 25);
		}
		return btnKrajRada;
	}
}
