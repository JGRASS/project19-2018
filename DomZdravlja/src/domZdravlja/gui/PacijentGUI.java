package domZdravlja.gui;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import domZdravlja.klase.Pacijent;
import domZdravlja.klase.Pregled;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class PacijentGUI extends JFrame {

	private JPanel contentPane;
	private JButton btnPrikaziIstorijuPregleda;
	private JButton btnPrikaziZakazanePreglede;
	private JButton btnPromeniLekara;
	private JButton btnZakaziPregled;
	private JButton btnOtkaziPregled;
	private Pregled pregled;
	private Pacijent pacijent;
	JTextArea textArea;
	

	/**
	 * Create the frame.
	 */
	public PacijentGUI(Pacijent pacijent) {
		this.pacijent = pacijent;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 544, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnPrikaziIstorijuPregleda());
		contentPane.add(getBtnPrikaziZakazanePreglede());
		contentPane.add(getBtnPromeniLekara());
		contentPane.add(getBtnZakaziPregled());
		contentPane.add(getBtnOtkaziPregled());
		
		textArea = new JTextArea();
		textArea.setBounds(263, 31, 232, 135);
		contentPane.add(textArea);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(155, 165, 28, 20);
		contentPane.add(comboBox);
		/*for (int i = 0; i < array.length; i++) {
			
		}
		comboBox.addItem(item);*/
	}

	private JButton getBtnPrikaziIstorijuPregleda() {
		if (btnPrikaziIstorijuPregleda == null) {
			btnPrikaziIstorijuPregleda = new JButton("Prikazi istoriju pregleda");
			btnPrikaziIstorijuPregleda.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textArea.setText(pacijent.Istorija());
				}
				}
			);
			btnPrikaziIstorijuPregleda.setBounds(10, 31, 181, 25);
		}
		return btnPrikaziIstorijuPregleda;
	}
	private JButton getBtnPrikaziZakazanePreglede() {
		if (btnPrikaziZakazanePreglede == null) {
			btnPrikaziZakazanePreglede = new JButton("Prikazi zakazane preglede");
			btnPrikaziZakazanePreglede.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textArea.setText(pacijent.ZakazaniPregledi());
				}
				}
			);
			btnPrikaziZakazanePreglede.setBounds(10, 93, 181, 25);
		}
		return btnPrikaziZakazanePreglede;
	}
	private JButton getBtnPromeniLekara() {
		if (btnPromeniLekara == null) {
			btnPromeniLekara = new JButton("Promeni lekara");
			btnPromeniLekara.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					pacijent.izaberiLekara("");
				}
			});
			btnPromeniLekara.setBounds(21, 163, 84, 25);
		}
		return btnPromeniLekara;
	}
	private JButton getBtnZakaziPregled() {
		if (btnZakaziPregled == null) {
			btnZakaziPregled = new JButton("Zakazi pregled");
			btnZakaziPregled.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Pregled p = new Pregled();
					//p.setDatumIVreme(datumIVreme);
				}
			});
			btnZakaziPregled.setBounds(47, 203, 125, 25);
		}
		return btnZakaziPregled;
	}
	private JButton getBtnOtkaziPregled() {
		if (btnOtkaziPregled == null) {
			btnOtkaziPregled = new JButton("Otkazi pregled");
			btnOtkaziPregled.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btnOtkaziPregled.setBounds(47, 239, 125, 25);
		}
		return btnOtkaziPregled;
	}
}

