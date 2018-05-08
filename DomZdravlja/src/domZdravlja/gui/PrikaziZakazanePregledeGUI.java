package domZdravlja.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import domZdravlja.klase.DatumIVreme;
import domZdravlja.klase.Lekar;
import domZdravlja.klase.Pregled;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextPane;
import java.awt.TextArea;

public class PrikaziZakazanePregledeGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblIzaberiteInterval;
	private JLabel lblOd;
	private JLabel lblDo;
	private JLabel lblZakazniPregledi;
	private JButton btnPrikaziPreglede;
	private JDateChooser dateChooserOD;
	private JDateChooser dateChooserDO;
	public static Lekar lekar;
	private TextArea textAreaPregledi;

	/**
	 * Create the frame.
	 */
	public PrikaziZakazanePregledeGUI(Lekar l) {
		setResizable(false);
		lekar = l;

		setTitle("Zakazani pregledi");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblIzaberiteInterval());
		contentPane.add(getLblOd());
		contentPane.add(getLblDo());
		contentPane.add(getLblZakazniPregledi());
		contentPane.add(getBtnPrikaziPreglede());
		contentPane.add(getDateChooserOD());
		contentPane.add(getDateChooserDO());
		contentPane.add(getTextAreaPregledi());

	}

	private JLabel getLblIzaberiteInterval() {
		if (lblIzaberiteInterval == null) {
			lblIzaberiteInterval = new JLabel("Izaberite interval:");
			lblIzaberiteInterval.setBounds(12, 13, 130, 30);
		}
		return lblIzaberiteInterval;
	}

	private JLabel getLblOd() {
		if (lblOd == null) {
			lblOd = new JLabel("Od:");
			lblOd.setBounds(12, 59, 56, 16);
		}
		return lblOd;
	}

	private JLabel getLblDo() {
		if (lblDo == null) {
			lblDo = new JLabel("Do:");
			lblDo.setBounds(173, 59, 56, 16);
		}
		return lblDo;
	}

	private JLabel getLblZakazniPregledi() {
		if (lblZakazniPregledi == null) {
			lblZakazniPregledi = new JLabel("Zakazni pregledi:");
			lblZakazniPregledi.setBounds(12, 128, 130, 16);
			lblZakazniPregledi.setVisible(false);
		}
		return lblZakazniPregledi;
	}

	private JButton getBtnPrikaziPreglede() {
		if (btnPrikaziPreglede == null) {
			btnPrikaziPreglede = new JButton("Prikazi preglede");
			btnPrikaziPreglede.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.metoda5(dateChooserOD.getDate(), dateChooserOD.getDate(),textAreaPregledi,lblZakazniPregledi);
				}
			});
			btnPrikaziPreglede.setBounds(12, 90, 149, 25);
		}
		return btnPrikaziPreglede;
	}

	private JDateChooser getDateChooserOD() {
		if (dateChooserOD == null) {
			dateChooserOD = new JDateChooser();
			dateChooserOD.setBounds(42, 56, 100, 22);
		}
		return dateChooserOD;
	}

	private JDateChooser getDateChooserDO() {
		if (dateChooserDO == null) {
			dateChooserDO = new JDateChooser();
			dateChooserDO.setBounds(216, 53, 100, 22);
		}
		return dateChooserDO;
	}

	private TextArea getTextAreaPregledi() {
		if (textAreaPregledi == null) {
			textAreaPregledi = new TextArea();
			textAreaPregledi.setBounds(10, 152, 412, 91);
			textAreaPregledi.setVisible(false);
		}
		return textAreaPregledi;
	}
}
