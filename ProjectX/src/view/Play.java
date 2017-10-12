package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

import controller.PlayController;
import model.Actor;
import model.Game;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
 
public class Play {

	private JFrame frame;
	private Actor user;
	private Game game;

	/**
	 * Create the application.
	 * @param game2 
	 * @param username2 
	 * 
	 * 
	 */
	
	public static void main(Actor user, Game game) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Play window = new Play(user, game);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	public Play(Actor user, Game game) {
		this.user = user;
		this.game = game;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @param game 
	 * @param user 
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Play");
		frame.setBounds(100, 100, 700, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Gioca");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 30));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					user = PlayController.Gioca(user);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(152, 226, 350, 80);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblStaiGiocandoA = new JLabel("Stai giocando a " + game.getName());
		lblStaiGiocandoA.setFont(new Font("Arial", Font.PLAIN, 18));
		lblStaiGiocandoA.setBounds(152, 157, 382, 30);
		frame.getContentPane().add(lblStaiGiocandoA);
		
		JButton btnEsci = new JButton("Esci");
		btnEsci.setFont(new Font("Arial", Font.PLAIN, 16));
		btnEsci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MainUser.main(user);
			}
		});
		btnEsci.setBounds(262, 409, 130, 40);
		frame.getContentPane().add(btnEsci);
	}

	
}
