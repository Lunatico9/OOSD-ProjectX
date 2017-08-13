package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.AddGameController;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddGame {

	private JFrame frame;
	private JTextField textTitle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddGame window = new AddGame();
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
	public AddGame() {
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
		
		JLabel lbl = new JLabel("Titolo:");
		lbl.setBounds(95, 110, 45, 21);
		frame.getContentPane().add(lbl);
		
		JLabel lblTitle = new JLabel("Inserisci nuovo gioco");
		lblTitle.setBounds(142, 23, 150, 21);
		frame.getContentPane().add(lblTitle);
		
		textTitle = new JTextField();
		textTitle.setBounds(142, 110, 86, 20);
		frame.getContentPane().add(textTitle);
		textTitle.setColumns(10);
		
		JButton btnNewButton = new JButton("Aggiungi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddGameController.AddGame(textTitle.getText());
			}
		});
		btnNewButton.setBounds(142, 198, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
