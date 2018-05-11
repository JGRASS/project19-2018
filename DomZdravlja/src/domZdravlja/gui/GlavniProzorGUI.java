package domZdravlja.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

import domZdravlja.klase.Lekar;
import domZdravlja.klase.Pacijent;
import domZdravlja.klase.Pregled;

public class GlavniProzorGUI extends JFrame implements Serializable{

	private JPanel contentPane;
	private JButton btnLekar;
	private JButton btnPacijent;
	public LinkedList<Lekar> lekariOpstePrakse = new LinkedList<Lekar>();
	public LinkedList<Lekar> lekariSpecijaliste = new LinkedList<Lekar>();
	public LinkedList<Pacijent> pacijenti = new LinkedList<Pacijent>();

	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenu mnHelp;
	private JMenuItem mntmAbout;
	private JMenuItem mntmLekar;
	private JMenuItem mntmPacijent;
	private JMenuItem mntmExit;

	/**
	 * Create the frame.
	 */
	public GlavniProzorGUI() {
		setResizable(false);
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
		
		
		FileReader in;
		try {
			in = new FileReader("lib/lekariSpecijaliste.json");
			Gson gson = new GsonBuilder().create();
			JsonArray jsonarr = gson.fromJson(in, JsonArray.class);
			
			for (int i = 0; i < jsonarr.size(); i++) {
				Lekar lekar = gson.fromJson(jsonarr.get(i), Lekar.class);
				lekariSpecijaliste.add(lekar);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			in = new FileReader("lib/lekariOpstePrakse.json");
			Gson gson = new GsonBuilder().create();
			JsonArray jsonarr = gson.fromJson(in, JsonArray.class);
			
			for (int i = 0; i < jsonarr.size(); i++) {
				Lekar lekar = gson.fromJson(jsonarr.get(i), Lekar.class);
				lekariOpstePrakse.add(lekar);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			in = new FileReader("lib/pacijenti.json");
			Gson gson = new GsonBuilder().create();
			JsonArray jsonarr = gson.fromJson(in, JsonArray.class);
			
			for (int i = 0; i < jsonarr.size(); i++) {
				Pacijent pacijent = gson.fromJson(jsonarr.get(i), Pacijent.class);
				pacijenti.add(pacijent);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private JButton getBtnLekar() {
		if (btnLekar == null) {
			btnLekar = new JButton("Lekar");
			btnLekar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					OtvoriLekaraGUI o = new OtvoriLekaraGUI();
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
					OtvoriPacijentaGUI o = new OtvoriPacijentaGUI();
					o.setVisible(true);
				}
			});
			btnPacijent.setBounds(253, 113, 126, 51);
		}
		return btnPacijent;
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.setBounds(0, 0, 444, 26);
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
					j.showMessageDialog(j,
							"Mi smo studenti FON-a, a ovo je nas domaci iz programiranja 2.\n"
									+ "Dimitrijevic Sofija 116/16\nDikic Mila 58/16\nDjekic Bojan 73/16",
							"O nama", j.INFORMATION_MESSAGE);
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
					OtvoriLekaraGUI o = new OtvoriLekaraGUI();
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
					OtvoriPacijentaGUI o = new OtvoriPacijentaGUI();
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
