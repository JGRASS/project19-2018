package domZdravlja.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import domZdravlja.klase.Lekar;
import domZdravlja.klase.Pacijent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GlavniProzorGUI extends JFrame {

	private JPanel contentPane;
	private JButton btnLekar;
	private JButton btnPacijent;
	public LinkedList<Lekar> lekari = new LinkedList<Lekar>();
	public LinkedList<Pacijent> pacijenti = new LinkedList<Pacijent>();
	
	private GlavniProzorGUI gp;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GlavniProzorGUI frame = new GlavniProzorGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GlavniProzorGUI() {
		setTitle("Dom Zdravlja");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnLekar());
		contentPane.add(getBtnPacijent());
		this.gp = this;
		//Narednih par linija koda su proba, ubacujem lekara u listu da ne bi bila prazna, da bih mogao da testiram
		Lekar l = new Lekar();
		l.setIDLekara("1234567");
		l.setImeIPrezime("Bojan Car");
		l.setPregledi(null);
		l.setSifra("1234567");
		l.setSpecijalizacija("Ginekolog");
		lekari.add(l);
	}

	private JButton getBtnLekar() {
		if (btnLekar == null) {
			btnLekar = new JButton("Lekar");
			btnLekar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					OtvoriLekaraGUI o = new OtvoriLekaraGUI(gp);
					o.setVisible(true);
				}
			});
			btnLekar.setBounds(47, 113, 97, 25);
		}
		return btnLekar;
	}
	private JButton getBtnPacijent() {
		if (btnPacijent == null) {
			btnPacijent = new JButton("Pacijent");
			btnPacijent.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					OtvoriPacijentaGUI o = new OtvoriPacijentaGUI(gp);
					o.setVisible(true);
				}
			});
			btnPacijent.setBounds(282, 113, 97, 25);
		}
		return btnPacijent;
	}
}
