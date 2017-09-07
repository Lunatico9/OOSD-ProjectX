package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;

import controller.AddReviewController;
import database.DatabaseMySQL;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class AddReview {

	private JFrame frmAddReview;
	private int username;
	private int game;

	/**
	 * Launch the application.
	 */
	public static void main(String username, String game) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddReview window = new AddReview(username, game);
					window.frmAddReview.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public AddReview(String username, String name) throws Exception {
		initialize(username, name);
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize(String username, String name) throws Exception {
		String query = "SELECT idUser FROM user WHERE username = username";
		String querygame ="SELECT idGame FROM game WHERE name = name";
		ResultSet rstgame = DatabaseMySQL.SendQuery(querygame);
		ResultSet rst = DatabaseMySQL.SendQuery(query);
		if(rst.next())
			this.username = rst.getInt(1);
		if(rstgame.next())
			this.game = rstgame.getInt(1);
		System.out.println(game);
		
		frmAddReview = new JFrame();
		frmAddReview.setTitle("Add review");
		frmAddReview.setBounds(100, 100, 700, 500);
		frmAddReview.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddReview.getContentPane().setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(110, 72, 450, 200);
		frmAddReview.getContentPane().add(textPane);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setFont(new Font("Arial", Font.PLAIN, 20));
		comboBox.setBounds(110, 362, 70, 28);
		frmAddReview.getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("Aggiungi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					AddReviewController.AddReview(textPane.getText(), (int)comboBox.getSelectedItem());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 20));
		btnNewButton.setBounds(298, 352, 132, 48);
		frmAddReview.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Annulla");
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 20));
		btnNewButton_1.setBounds(470, 352, 132, 48);
		frmAddReview.getContentPane().add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(65, 38, 537, 269);
		frmAddReview.getContentPane().add(panel);
		panel.setBorder(BorderFactory.createTitledBorder(
		BorderFactory.createEtchedBorder(), "RECENSIONE"));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(65, 339, 158, 68);
		frmAddReview.getContentPane().add(panel_1);
		panel_1.setBorder(BorderFactory.createTitledBorder(
		BorderFactory.createEtchedBorder(), "VOTO"));
		
		for(int i = 1; i < 11 ; i++)
		comboBox.addItem(i);
	}
}