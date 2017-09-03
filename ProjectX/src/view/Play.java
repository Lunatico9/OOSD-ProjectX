package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

import controller.PlayController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
 
public class Play {

	private JFrame frame;
	private String username;
	private String game;

	/**
	 * Create the application.
	 * @param game2 
	 * @param username2 
	 * 
	 * 
	 */
	
	public static void main(String username2, String game2) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Play window = new Play(username2, game2);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	public Play(String username2, String game2) {
		username = username2;
		game = game2;
		initialize(username2, game2);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param game2 
	 * @param username2 
	 */
	private void initialize(String username2, String game2) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Gioca");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					PlayController.Gioca(username);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(117, 92, 203, 66);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblStaiGiocandoA = new JLabel("Stai giocando a " + game2);
		lblStaiGiocandoA.setBounds(59, 39, 343, 23);
		frame.getContentPane().add(lblStaiGiocandoA);
		
		JButton btnEsci = new JButton("Esci");
		btnEsci.setBounds(0, 238, 89, 23);
		frame.getContentPane().add(btnEsci);
	}

	
}
