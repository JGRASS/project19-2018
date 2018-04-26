package domZdravlja.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ZakaziPregledKodSpecijalisteGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblLekar;
	private JTextField textFieldLekar;
	private JLabel lblPacijent;
	private JTextField textFieldPacijent;
	private JTextField textFieldVrstaPregleda;
	private JLabel lblVrstaPregleda;
	private JLabel lblDatum;
	private JTextField textFieldDatum;
	private JButton btnZakazi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZakaziPregledKodSpecijalisteGUI frame = new ZakaziPregledKodSpecijalisteGUI();
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
	public ZakaziPregledKodSpecijalisteGUI() {
		setTitle("Zakazi pregled kod specijaliste");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblLekar());
		contentPane.add(getTextFieldLekar());
		contentPane.add(getLblPacijent());
		contentPane.add(getTextFieldPacijent());
		contentPane.add(getTextFieldVrstaPregleda());
		contentPane.add(getLblVrstaPregleda());
		contentPane.add(getLblDatum());
		contentPane.add(getTextFieldDatum());
		contentPane.add(getBtnZakazi());
	}
	private JLabel getLblLekar() {
		if (lblLekar == null) {
			lblLekar = new JLabel("Lekar:");
			lblLekar.setBounds(12, 13, 92, 16);
		}
		return lblLekar;
	}
	private JTextField getTextFieldLekar() {
		if (textFieldLekar == null) {
			textFieldLekar = new JTextField();
			textFieldLekar.setBounds(116, 10, 116, 22);
			textFieldLekar.setColumns(10);
		}
		return textFieldLekar;
	}
	private JLabel getLblPacijent() {
		if (lblPacijent == null) {
			lblPacijent = new JLabel("Pacijent:");
			lblPacijent.setBounds(12, 57, 92, 16);
		}
		return lblPacijent;
	}
	private JTextField getTextFieldPacijent() {
		if (textFieldPacijent == null) {
			textFieldPacijent = new JTextField();
			textFieldPacijent.setBounds(116, 54, 116, 22);
			textFieldPacijent.setColumns(10);
		}
		return textFieldPacijent;
	}
	private JTextField getTextFieldVrstaPregleda() {
		if (textFieldVrstaPregleda == null) {
			textFieldVrstaPregleda = new JTextField();
			textFieldVrstaPregleda.setBounds(116, 99, 116, 22);
			textFieldVrstaPregleda.setColumns(10);
		}
		return textFieldVrstaPregleda;
	}
	private JLabel getLblVrstaPregleda() {
		if (lblVrstaPregleda == null) {
			lblVrstaPregleda = new JLabel("Vrsta pregleda:");
			lblVrstaPregleda.setBounds(12, 102, 92, 16);
		}
		return lblVrstaPregleda;
	}
	private JLabel getLblDatum() {
		if (lblDatum == null) {
			lblDatum = new JLabel("Datum:");
			lblDatum.setBounds(12, 147, 56, 16);
		}
		return lblDatum;
	}
	private JTextField getTextFieldDatum() {
		if (textFieldDatum == null) {
			textFieldDatum = new JTextField();
			textFieldDatum.setBounds(116, 144, 116, 22);
			textFieldDatum.setColumns(10);
		}
		return textFieldDatum;
	}
	private JButton getBtnZakazi() {
		if (btnZakazi == null) {
			btnZakazi = new JButton("Zakazi");
			btnZakazi.setBounds(7, 195, 97, 25);
		}
		return btnZakazi;
	}
}
