package domZdravlja.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
	/**
	 * Create the frame.
	 */
	public OtvoriPacijentaGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblUnesiteVašLbo());
		contentPane.add(getTextFieldLBO());
		contentPane.add(getBtnPotvrdi());
		contentPane.add(getBtnOdustani());
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
			textFieldLBO.addKeyListener(new KeyAdapter() {
				@Override//Ogranicava korisnika na unos iskljucivo cifara
				public void keyTyped(KeyEvent arg0) {
					char vChar = arg0.getKeyChar();
                    if (!(Character.isDigit(vChar)
                            || (vChar == KeyEvent.VK_BACK_SPACE)
                            || (vChar == KeyEvent.VK_DELETE))) {
                        arg0.consume();
                    }
				}
			});
			textFieldLBO.setBounds(181, 65, 116, 22);
			textFieldLBO.setColumns(11);
		}
		return textFieldLBO;
	}
	private JButton getBtnPotvrdi() {
		if (btnPotvrdi == null) {
			btnPotvrdi = new JButton("Potvrdi");
			btnPotvrdi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					boolean LBOB = true;
					String LBO = textFieldLBO.getText();
					if (LBO.length() == 11) {
						/*
						 * Ovo znaci da je dobro unesem LBO(jer su sve cifre i ima ih 11)
						 *  i da se onda pristupa jednom od dva prozora u zavisnosti da li
						 * je novi pacijent ili vec postoji u listi
						 */
					}
					else {
						JOptionPane j = new JOptionPane();
						j.showMessageDialog(j, "Pogresno unet LBO.\nPokusajte ponovo.", "Greska!",j.ERROR_MESSAGE);
					}
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
