package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Color;

public class AddReview {

	private JFrame frmAddReview;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddReview window = new AddReview();
					window.frmAddReview.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddReview() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAddReview = new JFrame();
		frmAddReview.setTitle("Add review");
		frmAddReview.setBounds(100, 100, 700, 500);
		frmAddReview.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddReview.getContentPane().setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(86, 73, 500, 200);
		frmAddReview.getContentPane().add(textPane);
		
		JButton btnNewButton = new JButton("Aggiungi");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 20));
		btnNewButton.setBounds(86, 374, 132, 48);
		frmAddReview.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Annulla");
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 20));
		btnNewButton_1.setBounds(454, 374, 132, 48);
		frmAddReview.getContentPane().add(btnNewButton_1);
		
		JLabel lblReview = new JLabel("Review:");
		lblReview.setFont(new Font("Arial", Font.PLAIN, 20));
		lblReview.setBounds(86, 32, 86, 40);
		frmAddReview.getContentPane().add(lblReview);
		
		JLabel lblVote = new JLabel("Vote:");
		lblVote.setFont(new Font("Arial", Font.PLAIN, 20));
		lblVote.setBounds(86, 286, 86, 40);
		frmAddReview.getContentPane().add(lblVote);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setFont(new Font("Arial", Font.PLAIN, 20));
		comboBox.setBounds(86, 327, 70, 28);
		frmAddReview.getContentPane().add(comboBox);
		for(int i = 1; i < 11 ; i++)
		comboBox.addItem(i);
	}
}