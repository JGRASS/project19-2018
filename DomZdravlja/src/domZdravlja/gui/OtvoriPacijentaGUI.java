package domZdravlja.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import domZdravlja.klase.Pacijent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class OtvoriPacijentaGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblUnesiteVašLbo;
	private JTextField textFieldLBO;
	private JButton btnPotvrdi;
	private JButton btnOdustani;
	private OtvoriPacijentaGUI op;
	/**
	 * Create the frame.
	 */
	public OtvoriPacijentaGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblUnesiteVašLbo());
		contentPane.add(getTextFieldLBO());
		contentPane.add(getBtnPotvrdi());
		contentPane.add(getBtnOdustani());
		op = this;
	}

	private JLabel getLblUnesiteVašLbo() {
		if (lblUnesiteVašLbo == null) {
			lblUnesiteVašLbo = new JLabel("Unesite Va\u0161 LBO");
			lblUnesiteVašLbo.setBounds(29, 68, 115, 16);
		}
		return lblUnesiteVašLbo;
	}
	private JTextField getTextFieldLBO() {
		if (textFieldLBO == null) {
			textFieldLBO = new JTextField();
			textFieldLBO.setBounds(181, 65, 116, 22);
			textFieldLBO.setColumns(11);
		}
		return textFieldLBO;
	}
	private Pacijent vratiPacijenta(String LBO) {
		for (int i = 0; i < GUIKontroler.gp.pacijenti.size(); i++) {
			if (GUIKontroler.gp.pacijenti.get(i).getLbo().equals(LBO)) {
				return GUIKontroler.gp.pacijenti.get(i);
			}
		}
		return null;
	}
	private JButton getBtnPotvrdi() {
		if (btnPotvrdi == null) {
			btnPotvrdi = new JButton("Potvrdi");
			btnPotvrdi.addActionListener(new ActionListener() {
				@SuppressWarnings("static-access")
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.metoda3(textFieldLBO.getText(),op);
				}
			});
			btnPotvrdi.setBounds(74, 148, 97, 25);
		}
		return btnPotvrdi;
	}
	private JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
			btnOdustani.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnOdustani.setBounds(252, 148, 97, 25);
		}
		return btnOdustani;
	}
}
