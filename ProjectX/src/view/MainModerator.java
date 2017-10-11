package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import controller.MainModeratorController;
import model.Actor;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainModerator {

	private JFrame frame;
	private Actor user;
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
		frame.setTitle("Main moderator");
		frame.setBounds(100, 100, 700, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Gestisci utenti");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainModeratorController.GestisciUser(user);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(86, 27, 198, 36);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnGestisciNuoveRecensioni = new JButton("Gestisci nuove recensioni");
		btnGestisciNuoveRecensioni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainModeratorController.GestisciRec(user);
				frame.dispose();
			}
		});
		btnGestisciNuoveRecensioni.setBounds(86, 96, 198, 36);
		frame.getContentPane().add(btnGestisciNuoveRecensioni);
		
		JButton btnUtilizzaAccountCome = new JButton("Utilizza account come utente");
		btnUtilizzaAccountCome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainModeratorController.Utente(user);
				frame.dispose();
			}
		});
		btnUtilizzaAccountCome.setBounds(86, 164, 198, 36);
		frame.getContentPane().add(btnUtilizzaAccountCome);
	}
}
