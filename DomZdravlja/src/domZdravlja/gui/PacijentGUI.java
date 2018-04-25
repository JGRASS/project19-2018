package domZdravlja.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PacijentGUI {

	private JFrame frmPacijent;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PacijentGUI window = new PacijentGUI();
					window.frmPacijent.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PacijentGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPacijent = new JFrame();
		frmPacijent.setTitle("Pacijent");
		frmPacijent.setBounds(100, 100, 450, 300);
		frmPacijent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPacijent.getContentPane().setLayout(null);
		
		JButton btnZakaziPregled = new JButton("Zakazi pregled");
		btnZakaziPregled.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnZakaziPregled.setBounds(259, 82, 120, 40);
		frmPacijent.getContentPane().add(btnZakaziPregled);
		
		JButton btnOtkaziPregled = new JButton("Otkazi pregled");
		btnOtkaziPregled.setBounds(259, 134, 120, 41);
		frmPacijent.getContentPane().add(btnOtkaziPregled);
		
		JButton btnPromeniLekara = new JButton("Promeni lekara");
		btnPromeniLekara.setBounds(259, 28, 120, 32);
		frmPacijent.getContentPane().add(btnPromeniLekara);
		
		JButton btnPrikaziIstorijuPregleda = new JButton("Prikazi istoriju pregleda");
		btnPrikaziIstorijuPregleda.setBounds(44, 42, 167, 40);
		frmPacijent.getContentPane().add(btnPrikaziIstorijuPregleda);
		
		JButton btnPrikaziZakazanePreglede = new JButton("Prikazi zakazane preglede");
		btnPrikaziZakazanePreglede.setBounds(44, 117, 167, 40);
		frmPacijent.getContentPane().add(btnPrikaziZakazanePreglede);
	}
}
