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
import com.toedter.calendar.JCalendar;

public class PrikaziZakazanePregledeGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblIzaberiteInterval;
	private JLabel lblOd;
	private JLabel lblDo;
	private JLabel lblZakazniPregledi;
	private JButton btnPrikaziPreglede;
	public static Lekar lekar;
	private TextArea textAreaPregledi;
	private JCalendar calendarOD;
	private JCalendar calendarDO;
	

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
		contentPane.add(getTextAreaPregledi());
		contentPane.add(getCalendarOD());
		contentPane.add(getCalendarDO());

	}

	private JLabel getLblIzaberiteInterval() {
		if (lblIzaberiteInterval == null) {
			lblIzaberiteInterval = new JLabel("Izaberite interval:");
			lblIzaberiteInterval.setBounds(0, 0, 130, 30);
		}
		return lblIzaberiteInterval;
	}

	private JLabel getLblOd() {
		if (lblOd == null) {
			lblOd = new JLabel("Od:");
			lblOd.setBounds(0, 25, 56, 16);
		}
		return lblOd;
	}

	private JLabel getLblDo() {
		if (lblDo == null) {
			lblDo = new JLabel("Do:");
			lblDo.setBounds(217, 25, 56, 16);
		}
		return lblDo;
	}

	private JLabel getLblZakazniPregledi() {
		if (lblZakazniPregledi == null) {
			lblZakazniPregledi = new JLabel("Zakazni pregledi:");
			lblZakazniPregledi.setBounds(12, 155, 130, 16);
			lblZakazniPregledi.setVisible(false);
		}
		return lblZakazniPregledi;
	}

	private JButton getBtnPrikaziPreglede() {
		if (btnPrikaziPreglede == null) {
			btnPrikaziPreglede = new JButton("Prikazi preglede");
			btnPrikaziPreglede.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.metoda5(calendarOD.getDate(), calendarDO.getDate(),textAreaPregledi,lblZakazniPregledi);
				}
			});
			btnPrikaziPreglede.setBounds(12, 125, 149, 25);
		}
		return btnPrikaziPreglede;
	}

	private TextArea getTextAreaPregledi() {
		if (textAreaPregledi == null) {
			textAreaPregledi = new TextArea();
			textAreaPregledi.setBounds(10, 177, 412, 66);
			textAreaPregledi.setVisible(false);
		}
		return textAreaPregledi;
	}
	private JCalendar getCalendarOD() {
		if (calendarOD == null) {
			calendarOD = new JCalendar();
			calendarOD.setBounds(31, 25, 162, 98);
		}
		return calendarOD;
	}
	private JCalendar getCalendarDO() {
		if (calendarDO == null) {
			calendarDO = new JCalendar();
			calendarDO.setBounds(259, 25, 162, 98);
		}
		return calendarDO;
	}
}
