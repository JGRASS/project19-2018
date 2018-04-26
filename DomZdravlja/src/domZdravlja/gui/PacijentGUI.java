package domZdravlja.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class PacijentGUI extends JFrame {

	private JPanel contentPane;
	private JButton btnPrikaziIstorijuPregleda;
	private JButton btnPrikaziZakazanePreglede;
	private JButton btnPromeniLekara;
	private JButton btnZakaziPregled;
	private JButton btnOtkaziPregled;
	

	/**
	 * Create the frame.
	 */
	public PacijentGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnPrikaziIstorijuPregleda());
		contentPane.add(getBtnPrikaziZakazanePreglede());
		contentPane.add(getBtnPromeniLekara());
		contentPane.add(getBtnZakaziPregled());
		contentPane.add(getBtnOtkaziPregled());
	}

	private JButton getBtnPrikaziIstorijuPregleda() {
		if (btnPrikaziIstorijuPregleda == null) {
			btnPrikaziIstorijuPregleda = new JButton("Prikazi istoriju pregleda");
			btnPrikaziIstorijuPregleda.setBounds(27, 59, 181, 25);
		}
		return btnPrikaziIstorijuPregleda;
	}
	private JButton getBtnPrikaziZakazanePreglede() {
		if (btnPrikaziZakazanePreglede == null) {
			btnPrikaziZakazanePreglede = new JButton("Prikazi zakazane preglede");
			btnPrikaziZakazanePreglede.setBounds(27, 136, 181, 25);
		}
		return btnPrikaziZakazanePreglede;
	}
	private JButton getBtnPromeniLekara() {
		if (btnPromeniLekara == null) {
			btnPromeniLekara = new JButton("Promeni lekara");
			btnPromeniLekara.setBounds(275, 31, 125, 25);
		}
		return btnPromeniLekara;
	}
	private JButton getBtnZakaziPregled() {
		if (btnZakaziPregled == null) {
			btnZakaziPregled = new JButton("Zakazi pregled");
			btnZakaziPregled.setBounds(275, 97, 125, 25);
		}
		return btnZakaziPregled;
	}
	private JButton getBtnOtkaziPregled() {
		if (btnOtkaziPregled == null) {
			btnOtkaziPregled = new JButton("Otkazi pregled");
			btnOtkaziPregled.setBounds(275, 168, 125, 25);
		}
		return btnOtkaziPregled;
	}
}
