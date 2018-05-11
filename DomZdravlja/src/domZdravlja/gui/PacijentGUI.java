package domZdravlja.gui;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import domZdravlja.klase.DatumIVreme;
import domZdravlja.klase.Pacijent;
import domZdravlja.klase.Pregled;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Date;
import java.awt.event.ActionEvent;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import com.toedter.calendar.JCalendar;
import com.toedter.components.JSpinField;
import java.awt.Point;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;

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
		setResizable(false);
		this.pacijent = pacijent;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 759, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnPrikaziIstorijuPregleda());
		contentPane.add(getBtnPrikaziZakazanePreglede());
		contentPane.add(getBtnPromeniLekara());
		contentPane.add(getBtnZakaziPregled());
		contentPane.add(getBtnOtkaziPregled());
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(331, 201, 375, 190);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(172, 268, 147, 20);
		for (int i = 0; i < GUIKontroler.gp.lekariOpstePrakse.size(); i++) {
			comboBox.addItem(GUIKontroler.gp.lekariOpstePrakse.get(i).getImeIPrezime());
		}
		contentPane.add(comboBox);
		
		calendar = new JCalendar();
		calendar.setBounds(331, 35, 228, 154);
		contentPane.add(calendar);
		
		spinField = new JSpinField();
		spinField.setValue(7);
		spinField.setMinimum(7);
		spinField.setMaximum(19);
		spinField.setBounds(581, 35, 59, 20);
		contentPane.add(spinField);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(658, 35, 48, 20);
		contentPane.add(comboBox_1);
		comboBox_1.addItem(0);
		comboBox_1.addItem(15);
		comboBox_1.addItem(30);
		comboBox_1.addItem(45);
		
		JLabel lblPodaciOPacijentu = new JLabel("PODACI O PACIJENTU:");
		lblPodaciOPacijentu.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPodaciOPacijentu.setBounds(21, 35, 196, 20);
		contentPane.add(lblPodaciOPacijentu);
		
		JLabel lblImeIPrezime = new JLabel("Ime i prezime:");
		lblImeIPrezime.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblImeIPrezime.setBounds(159, 78, 114, 20);
		contentPane.add(lblImeIPrezime);
		
		JLabel lblLbo = new JLabel("LBO:");
		lblLbo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLbo.setBounds(21, 120, 46, 14);
		contentPane.add(lblLbo);
		
		JLabel lblDatumRodjenja = new JLabel("Datum rodjenja:");
		lblDatumRodjenja.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDatumRodjenja.setBounds(159, 159, 135, 18);
		contentPane.add(lblDatumRodjenja);
		
		JLabel lblIzabraniLekar = new JLabel("Izabrani lekar:");
		lblIzabraniLekar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIzabraniLekar.setBounds(21, 201, 135, 25);
		contentPane.add(lblIzabraniLekar);
		
		JLabel lblimePrezime = new JLabel("Ime i prezime:");
		lblimePrezime.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblimePrezime.setBounds(21, 78, 141, 20);
		lblImeIPrezime.setText(pacijent.getImePrezime());
		contentPane.add(lblimePrezime);
		
		JLabel lblLBO = new JLabel("New label");
		lblLBO.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLBO.setBounds(159, 120, 141, 20);
		lblLBO.setText(pacijent.getLbo());
		contentPane.add(lblLBO);
		
		JLabel lblDatRodj = new JLabel("Datum rodjenja:");
		lblDatRodj.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDatRodj.setBounds(21, 158, 141, 20);
		lblDatumRodjenja.setText(pacijent.getDatumRodjenja());
		contentPane.add(lblDatRodj);
		
		JLabel lblLekar = new JLabel("New label");
		lblLekar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLekar.setBounds(159, 202, 141, 20);
		lblLekar.setText(pacijent.getIzabraniLekar().getImeIPrezime());
		contentPane.add(lblLekar);
	}

	private JButton getBtnPrikaziIstorijuPregleda() {
		if (btnPrikaziIstorijuPregleda == null) {
			btnPrikaziIstorijuPregleda = new JButton("Prikazi istoriju pregleda");
			btnPrikaziIstorijuPregleda.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.prebaciUIstoriju(pacijent);
					textArea.setText(pacijent.istorija());
				}
				}
			);
			btnPrikaziIstorijuPregleda.setBounds(528, 402, 178, 25);
		}
		return btnPrikaziIstorijuPregleda;
	}
	private JButton getBtnPrikaziZakazanePreglede() {
		if (btnPrikaziZakazanePreglede == null) {
			btnPrikaziZakazanePreglede = new JButton("Prikazi zakazane preglede");
			btnPrikaziZakazanePreglede.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textArea.setText(null);
					textArea.setText(pacijent.zakazaniPregledi());
				}
				}
			);
			btnPrikaziZakazanePreglede.setBounds(331, 402, 196, 25);
		}
		return btnPrikaziZakazanePreglede;
	}
	private JButton getBtnPromeniLekara() {
		if (btnPromeniLekara == null) {
			btnPromeniLekara = new JButton("Promeni lekara");
			btnPromeniLekara.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.metoda4(pacijent,comboBox_1.getSelectedItem().toString());
				}
			});
			btnPromeniLekara.setBounds(21, 262, 141, 32);
		}
		return btnPromeniLekara;
	}
	private JButton getBtnZakaziPregled() {
		if (btnZakaziPregled == null) {
			btnZakaziPregled = new JButton("Zakazi pregled");
			btnZakaziPregled.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					pregled = GUIKontroler.noviPregled(pacijent,calendar,(Integer)spinField.getValue(),(Integer)comboBox_1.getSelectedItem());
					pacijent.zakazaniPregledi.add(pregled);
				}
			});
			btnZakaziPregled.setBounds(581, 78, 125, 44);
		}
		return btnZakaziPregled;
	}
	private JButton getBtnOtkaziPregled() {
		if (btnOtkaziPregled == null) {
			btnOtkaziPregled = new JButton("Otkazi pregled");
			btnOtkaziPregled.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					pregled = GUIKontroler.noviPregled(pacijent,calendar,(Integer)spinField.getValue(),(Integer)comboBox_1.getSelectedItem());
					for (int i = 0; i < pacijent.zakazaniPregledi.size(); i++) {
						Pregled p = pacijent.zakazaniPregledi.get(i);
						if(p.getDatumIVreme().getDatum().equals(calendar.getDate()) && p.getLekar().equals(p.getLekar())
								&& p.getDatumIVreme().getSati() == spinField.getValue()
								&& p.getDatumIVreme().getMinuti() == (Integer)comboBox_1.getSelectedItem()){
							pacijent.zakazaniPregledi.remove(p);
						}
					}
				}
			});
			btnOtkaziPregled.setBounds(581, 133, 125, 44);
		}
		return btnOtkaziPregled;
	}
	
}

