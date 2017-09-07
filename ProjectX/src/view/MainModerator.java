package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainModerator {

	private JFrame frame;
	private String username;
	/**
	 * Launch the application.
	 */
	public static void main(String username) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainModerator window = new MainModerator(username);
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
	public MainModerator(String username) {
		initialize();
		this.username = username;
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
				AcceptReview.main(null);
			}
		});
		btnGestisciNuoveRecensioni.setBounds(41, 74, 198, 36);
		frame.getContentPane().add(btnGestisciNuoveRecensioni);
		
		JButton btnUtilizzaAccountCome = new JButton("Utilizza account come utente");
		btnUtilizzaAccountCome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainUser.main(null);
			}
		});
		btnUtilizzaAccountCome.setBounds(41, 121, 198, 36);
		frame.getContentPane().add(btnUtilizzaAccountCome);
	}
}
