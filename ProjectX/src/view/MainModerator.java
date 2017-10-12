package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import controller.MainModeratorController;
import model.Actor;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

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
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainModeratorController.GestisciUser(user);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(193, 136, 300, 50);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnGestisciNuoveRecensioni = new JButton("Gestisci nuove recensioni");
		btnGestisciNuoveRecensioni.setFont(new Font("Arial", Font.PLAIN, 20));
		btnGestisciNuoveRecensioni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainModeratorController.GestisciRec(user);
				frame.dispose();
			}
		});
		btnGestisciNuoveRecensioni.setBounds(193, 268, 300, 50);
		frame.getContentPane().add(btnGestisciNuoveRecensioni);
		
		JButton btnUtilizzaAccountCome = new JButton("Utilizza account come utente");
		btnUtilizzaAccountCome.setFont(new Font("Arial", Font.PLAIN, 20));
		btnUtilizzaAccountCome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainModeratorController.Utente(user);
				frame.dispose();
			}
		});
		btnUtilizzaAccountCome.setBounds(193, 402, 300, 50);
		frame.getContentPane().add(btnUtilizzaAccountCome);
	}
}
