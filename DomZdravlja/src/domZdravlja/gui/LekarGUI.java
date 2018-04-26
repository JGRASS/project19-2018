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

public class LekarGUI extends JFrame {

	private JPanel contentPane;
	private JButton btnZakaziPregledKod;
	private JButton btnPrikaziZakazanePreglede;
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
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		contentPane.add(getBtnZakaziPregledKod());
		contentPane.add(getBtnPrikaziZakazanePreglede());
	}
	private JButton getBtnZakaziPregledKod() {
		if (btnZakaziPregledKod == null) {
			btnZakaziPregledKod = new JButton("Zakazi pregled kod specijaliste");
		}
		return btnZakaziPregledKod;
	}
	private JButton getBtnPrikaziZakazanePreglede() {
		if (btnPrikaziZakazanePreglede == null) {
			btnPrikaziZakazanePreglede = new JButton("Prikazi zakazane preglede");
		}
		return btnPrikaziZakazanePreglede;
	}
}
