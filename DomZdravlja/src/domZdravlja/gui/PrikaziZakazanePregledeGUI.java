package domZdravlja.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import domZdravlja.klase.Lekar;
import domZdravlja.klase.Pregled;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;

public class PrikaziZakazanePregledeGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblIzaberiteInterval;
	private JLabel lblOd;
	private JTextField textFieldOd;
	private JLabel lblDo;
	private JTextField textFieldDo;
	private JScrollPane scrollPanePregledi;
	private JLabel lblZakazniPregledi;
	private JButton btnPrikaziPreglede;

	/**
	 * Create the frame.
	 */
	public PrikaziZakazanePregledeGUI() {
		setTitle("Zakazani pregledi");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblIzaberiteInterval());
		contentPane.add(getLblOd());
		contentPane.add(getTextFieldOd());
		contentPane.add(getLblDo());
		contentPane.add(getTextFieldDo());
		contentPane.add(getScrollPanePregledi());
		contentPane.add(getLblZakazniPregledi());
		contentPane.add(getBtnPrikaziPreglede());

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

	private JTextField getTextFieldOd() {
		if (textFieldOd == null) {
			textFieldOd = new JTextField();
			textFieldOd.setBounds(45, 56, 116, 22);
			textFieldOd.setColumns(10);
		}
		return textFieldOd;
	}

	private JLabel getLblDo() {
		if (lblDo == null) {
			lblDo = new JLabel("Do:");
			lblDo.setBounds(173, 59, 56, 16);
		}
		return lblDo;
	}

	private JTextField getTextFieldDo() {
		if (textFieldDo == null) {
			textFieldDo = new JTextField();
			textFieldDo.setBounds(214, 56, 116, 22);
			textFieldDo.setColumns(10);
		}
		return textFieldDo;
	}

	private JScrollPane getScrollPanePregledi() {
		if (scrollPanePregledi == null) {
			scrollPanePregledi = new JScrollPane();
			scrollPanePregledi.setBounds(12, 157, 374, 83);
		}
		return scrollPanePregledi;
	}

	private JLabel getLblZakazniPregledi() {
		if (lblZakazniPregledi == null) {
			lblZakazniPregledi = new JLabel("Zakazni pregledi:");
			lblZakazniPregledi.setBounds(12, 128, 130, 16);
		}
		return lblZakazniPregledi;
	}

	private JButton getBtnPrikaziPreglede() {
		if (btnPrikaziPreglede == null) {
			btnPrikaziPreglede = new JButton("Prikazi preglede");
			btnPrikaziPreglede.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btnPrikaziPreglede.setBounds(12, 90, 149, 25);
		}
		return btnPrikaziPreglede;
	}
}
