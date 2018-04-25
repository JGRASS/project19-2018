package domZdravlja.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GlavniProzorGUI extends JFrame {

	private JPanel contentPane;
	private JButton btnLekar;
	private JButton btnPacijent;
	//private LinkedList<Lekar> lekari;
	//private LinkedList<Pacijent> pacijenti;
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
			btnLekar.setBounds(47, 113, 97, 25);
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
			btnPacijent.setBounds(282, 113, 97, 25);
		}
		return btnPacijent;
	}
}
