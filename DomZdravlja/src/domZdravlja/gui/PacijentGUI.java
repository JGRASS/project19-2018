package domZdravlja.gui;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import domZdravlja.klase.DatumIVreme;
import domZdravlja.klase.Pacijent;
import domZdravlja.klase.Pregled;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import com.toedter.calendar.JCalendar;
import com.toedter.components.JSpinField;

public class PacijentGUI extends JFrame {

	private JPanel contentPane;
	private JButton btnPrikaziIstorijuPregleda;
	private JButton btnPrikaziZakazanePreglede;
	private JButton btnPromeniLekara;
	private JButton btnZakaziPregled;
	private JButton btnOtkaziPregled;
	private Pregled pregled;
	private Pacijent pacijent;
	private JCalendar calendar;
	private JSpinField spinField;
	private JTextArea textArea;
	private JComboBox comboBox_1;

	/**
	 * Create the frame.
	 */
	public PacijentGUI(Pacijent pacijent) {
		this.pacijent = pacijent;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 597, 343);
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
		textArea.setBounds(248, 193, 305, 100);
		contentPane.add(textArea);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(155, 165, 28, 20);
		contentPane.add(comboBox);
		
		calendar = new JCalendar();
		calendar.setBounds(260, 31, 156, 134);
		contentPane.add(calendar);
		
		spinField = new JSpinField();
		spinField.setValue(7);
		spinField.setMinimum(7);
		spinField.setMaximum(19);
		spinField.setBounds(464, 44, 48, 20);
		contentPane.add(spinField);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(543, 44, 28, 20);
		contentPane.add(comboBox_1);
		comboBox_1.addItem(0);
		comboBox_1.addItem(15);
		comboBox_1.addItem(30);
		comboBox_1.addItem(45);
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
			btnPromeniLekara.setBounds(21, 163, 103, 25);
		}
		return btnPromeniLekara;
	}
	private JButton getBtnZakaziPregled() {
		if (btnZakaziPregled == null) {
			btnZakaziPregled = new JButton("Zakazi pregled");
			btnZakaziPregled.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					pregled = noviPregled();
					pacijent.zakazaniPregledi.add(pregled);
				}
			});
			btnZakaziPregled.setBounds(446, 93, 125, 25);
		}
		return btnZakaziPregled;
	}
	private JButton getBtnOtkaziPregled() {
		if (btnOtkaziPregled == null) {
			btnOtkaziPregled = new JButton("Otkazi pregled");
			btnOtkaziPregled.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					pregled = noviPregled();
					for (int i = 0; i < pacijent.zakazaniPregledi.size(); i++) {
						if(pacijent.zakazaniPregledi.get(i).equals(pregled)) {
							pacijent.zakazaniPregledi.remove(i);
						}
					}
				}
			});
			btnOtkaziPregled.setBounds(446, 130, 125, 25);
		}
		return btnOtkaziPregled;
	}
	public Pregled noviPregled() {
		DatumIVreme datumIVreme = new DatumIVreme();
		datumIVreme.setDatum(calendar.getDate());
		datumIVreme.setSati(spinField.getValue());
		datumIVreme.setMinuti((Integer)comboBox_1.getSelectedItem());
		Pregled p = new Pregled();
		p.setDatumIVreme(datumIVreme);
		p.setLekar(pacijent.getIzabraniLekar());
		p.setPacijent(pacijent);
		//p.setVrstaPregleda(pacijent.getIzabraniLekar().getSpecijalizacija());
		return p;
	}
}

