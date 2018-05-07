package domZdravlja.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Date;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import domZdravlja.klase.DatumIVreme;
import domZdravlja.klase.Lekar;
import domZdravlja.klase.Pacijent;
import domZdravlja.klase.Pregled;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;

public class GlavniProzorGUI extends JFrame {

	private JPanel contentPane;
	private JButton btnLekar;
	private JButton btnPacijent;
	public static LinkedList<Lekar> lekari = new LinkedList<Lekar>();
	public static LinkedList<Pacijent> pacijenti = new LinkedList<Pacijent>();

	private GlavniProzorGUI gp;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenu mnHelp;
	private JMenuItem mntmAbout;
	private JMenuItem mntmLekar;
	private JMenuItem mntmPacijent;
	private JMenuItem mntmExit;

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
		contentPane.add(getMenuBar_1());
		
		JLabel lblNastaviteRadKao = new JLabel("Nastavite rad kao:");
		lblNastaviteRadKao.setBounds(46, 58, 127, 16);
		contentPane.add(lblNastaviteRadKao);
		this.gp = this;
		// Narednih par linija koda su proba, ubacujem lekara u listu da ne bi bila
		// prazna, da bih mogao da testiram
		Lekar l = new Lekar();
		l.setIDLekara("1234567");
		l.setImeIPrezime("Bojan Djekic");
		l.setPregledi(null);
		l.setSifra("1234567");
		l.setSpecijalizacija("Ginekolog");
		
		lekari.add(l);
		
		//proba - pacijent
		Pacijent p = new Pacijent();
		p.setImePrezime("Mila Dikic");
		p.setLbo("12345678910");
		p.setDatumRodjenja("28. 06. 1997.");
		p.setIzabraniLekar(l);
		
		pacijenti.add(p);
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
			btnLekar.setBounds(47, 113, 126, 51);
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
			btnPacijent.setBounds(253, 113, 126, 51);
		}
		return btnPacijent;
	}

	public static LinkedList<Lekar> vratiSpecijaliste(String specijalizacija) {
		if (lekari.isEmpty())
			return null;
		LinkedList<Lekar> lekariSpecijaliste = new LinkedList<Lekar>();
		for (int i = 0; i < lekari.size(); i++) {
			Lekar l = lekari.get(i);
			if (l.getSpecijalizacija().equals(specijalizacija))
				lekariSpecijaliste.add(l);
		}
		return lekariSpecijaliste;
	}

	public static Pacijent vratiPacijenta(String imePrezime) {
		if (pacijenti == null)
			return null;
		for (int i = 0; i < pacijenti.size(); i++) {
			Pacijent p = pacijenti.get(i);
			if (p.getImePrezime().equals(imePrezime))
				return p;
		}
		return null;
	}

	public static Lekar vratiLekara(String imePrezime) {
		if (lekari == null)
			return null;
		for (int i = 0; i < lekari.size(); i++) {
			Lekar l = lekari.get(i);
			if (l.getImeIPrezime().equals(imePrezime))
				return l;
		}
		return null;
	}

	public static void dodajPregled(Pregled p) {
		int indeks = lekari.indexOf(p.getLekar());
		Lekar l = lekari.get(indeks);
		LinkedList<Pregled> preglediLekara = l.getPregledi();
		preglediLekara.add(p);
		l.setPregledi(preglediLekara);
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.setBounds(0, 0, 432, 26);
			menuBar.add(getMnFile());
			menuBar.add(getMnHelp());
		}
		return menuBar;
	}
	private JMenu getMnFile() {
		if (mnFile == null) {
			mnFile = new JMenu("File");
			mnFile.add(getMntmLekar());
			mnFile.add(getMntmPacijent());
			mnFile.add(getMntmExit());
		}
		return mnFile;
	}
	private JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu("Help");
			mnHelp.add(getMntmAbout());
		}
		return mnHelp;
	}
	private JMenuItem getMntmAbout() {
		if (mntmAbout == null) {
			mntmAbout = new JMenuItem("About");
			mntmAbout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane j = new JOptionPane();
					j.showMessageDialog(j, "Mi smo studenti FON-a, a ovo je nas domaci iz programiranja 2.\n"
							+ "Dimitrijevic Sofija 116/16\nDikic Mila 58/16\nDjekic Bojan 73/16","O nama",j.INFORMATION_MESSAGE);
				}
			});
		}
		return mntmAbout;
	}
	private JMenuItem getMntmLekar() {
		if (mntmLekar == null) {
			mntmLekar = new JMenuItem("Lekar");
			mntmLekar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					OtvoriLekaraGUI o = new OtvoriLekaraGUI(gp);
					o.setVisible(true);
				}
			});
		}
		return mntmLekar;
	}
	private JMenuItem getMntmPacijent() {
		if (mntmPacijent == null) {
			mntmPacijent = new JMenuItem("Pacijent");
			mntmPacijent.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					OtvoriPacijentaGUI o = new OtvoriPacijentaGUI(gp);
					o.setVisible(true);
				}
			});
		}
		return mntmPacijent;
	}
	private JMenuItem getMntmExit() {
		if (mntmExit == null) {
			mntmExit = new JMenuItem("Exit");
			mntmExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane j = new JOptionPane();
					int opcija = j.showConfirmDialog(j, "Da li ste sigurni?", "Kraj rada", j.YES_NO_OPTION);
					if (opcija == j.YES_OPTION) {
						System.exit(0);
					}
				}
			});
		}
		return mntmExit;
	}
}
