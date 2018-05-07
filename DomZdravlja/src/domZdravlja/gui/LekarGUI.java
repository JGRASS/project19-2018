package domZdravlja.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import domZdravlja.klase.DatumIVreme;
import domZdravlja.klase.Lekar;
import domZdravlja.klase.Pregled;

public class LekarGUI extends JFrame {

	private JPanel contentPane;
	private JButton btnZakaziPregledKod;
	private JButton btnPrikaziZakazanePreglede;
	private JLabel lblImeIPrezime;
	private JLabel lblId;
	private JLabel lblSpecijalizacija;
	private JButton btnKrajRada;
	private Lekar lekar;

	/**
	 * Create the frame.
	 */
	public LekarGUI(Lekar l) {
		lekar = l;

		setTitle("Lekar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblImeIPrezime());
		contentPane.add(getLblSpecijalizacija());
		contentPane.add(getLblId());
		contentPane.add(getBtnZakaziPregledKod());
		contentPane.add(getBtnPrikaziZakazanePreglede());
		contentPane.add(getBtnKrajRada());

		lblId.setText(lblId.getText() + " " + l.getIDLekara());
		lblImeIPrezime.setText(lblImeIPrezime.getText() + " " + l.getImeIPrezime());
		lblSpecijalizacija.setText(lblSpecijalizacija.getText() + " " + l.getSpecijalizacija());
	}

	private JButton getBtnZakaziPregledKod() {
		if (btnZakaziPregledKod == null) {
			btnZakaziPregledKod = new JButton("Zakazi pregled kod specijaliste");
			btnZakaziPregledKod.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ZakaziPregledKodSpecijalisteGUI z = new ZakaziPregledKodSpecijalisteGUI();
					z.setVisible(true);
				}
			});
			btnZakaziPregledKod.setBounds(12, 140, 235, 25);
		}
		return btnZakaziPregledKod;
	}

	private JButton getBtnPrikaziZakazanePreglede() {
		if (btnPrikaziZakazanePreglede == null) {
			btnPrikaziZakazanePreglede = new JButton("Prikazi zakazane preglede");
			btnPrikaziZakazanePreglede.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					PrikaziZakazanePregledeGUI p = new PrikaziZakazanePregledeGUI(lekar);
					p.setVisible(true);
				}
			});
			btnPrikaziZakazanePreglede.setBounds(12, 178, 235, 25);
		}
		return btnPrikaziZakazanePreglede;
	}

	private JLabel getLblImeIPrezime() {
		if (lblImeIPrezime == null) {
			lblImeIPrezime = new JLabel("Ime i prezime: ");
			lblImeIPrezime.setBounds(38, 13, 298, 16);
		}
		return lblImeIPrezime;
	}

	private JLabel getLblId() {
		if (lblId == null) {
			lblId = new JLabel("ID:");
			lblId.setBounds(38, 81, 298, 16);
		}
		return lblId;
	}

	private JLabel getLblSpecijalizacija() {
		if (lblSpecijalizacija == null) {
			lblSpecijalizacija = new JLabel("Specijalizacija:");
			lblSpecijalizacija.setBounds(38, 52, 298, 16);
		}
		return lblSpecijalizacija;
	}

	private JButton getBtnKrajRada() {
		if (btnKrajRada == null) {
			btnKrajRada = new JButton("Kraj rada");
			btnKrajRada.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JOptionPane j = new JOptionPane();
					int opcija = j.showConfirmDialog(j, "Da li ste sigurni?", "Kraj rada", j.YES_NO_OPTION);
					if (opcija == j.YES_OPTION) {
						System.exit(0);
					}
				}
			});
			btnKrajRada.setBounds(323, 215, 97, 25);
		}
		return btnKrajRada;
	}

}
