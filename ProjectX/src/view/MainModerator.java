package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import model.Actor;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainModerator {

	private JFrame frame;
	private Actor user;
	private String type = "moderatore";
	/**
	 * Launch the application.
	 */
	public static void main(Actor user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainModerator window = new MainModerator(user);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainModerator(Actor user) {
		this.user = user;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Gestisci utenti");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				PromotionDemotionModerator.main(null);
			}
		});
		btnNewButton.setBounds(41, 27, 198, 36);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnGestisciNuoveRecensioni = new JButton("Gestisci nuove recensioni");
		btnGestisciNuoveRecensioni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AcceptReview.main(user);
			}
		});
		btnGestisciNuoveRecensioni.setBounds(41, 74, 198, 36);
		frame.getContentPane().add(btnGestisciNuoveRecensioni);
		
		JButton btnUtilizzaAccountCome = new JButton("Utilizza account come utente");
		btnUtilizzaAccountCome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MainUser.main(user);
			}
		});
		btnUtilizzaAccountCome.setBounds(41, 121, 198, 36);
		frame.getContentPane().add(btnUtilizzaAccountCome);
	}
}
