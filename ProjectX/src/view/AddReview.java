package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;

import controller.AddReviewController;
import database.DatabaseMySQL;
import model.Actor;
import model.Game;
import model.Review;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Dimension;

public class AddReview {

	private Actor user;
	private Game game;
	private JFrame frmAddReview;

	/**
	 * Launch the application.
	 */
	public static void main(Actor user, Game game) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddReview window = new AddReview(user, game);
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
	public AddReview(Actor user, Game game) throws Exception {
		this.user = user;
		this.game = game;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize() throws Exception {
		String querygame ="SELECT idGame FROM game WHERE name = name";
		
		frmAddReview = new JFrame();
		frmAddReview.setTitle("Add review");
		frmAddReview.setBounds(100, 100, 700, 600);
		frmAddReview.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddReview.getContentPane().setLayout(null);
		
		JTextArea textPane = new JTextArea();
		textPane.setWrapStyleWord(true);
		textPane.setLineWrap(true);
		textPane.setBounds(75, 85, 525, 255);
		frmAddReview.getContentPane().add(textPane);
		
		JComboBox<Integer> comboBox = new JComboBox<Integer>();
		comboBox.setBounds(298, 423, 70, 28);
		comboBox.setBackground(Color.WHITE);
		comboBox.setFont(new Font("Arial", Font.PLAIN, 20));
		frmAddReview.getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("Aggiungi");
		btnNewButton.setBounds(520, 502, 132, 48);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Review review = new Review(textPane.getText(),(int)comboBox.getSelectedItem(), game.getId(), 0 , user.getId());
				try {
					AddReviewController.AddReview(review);
					MainUser.main(user);
					frmAddReview.dispose();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 20));
		frmAddReview.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Annulla");
		btnNewButton_1.setBounds(29, 502, 132, 48);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAddReview.dispose();
				AddReviewController.Annulla(user);
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 20));
		frmAddReview.getContentPane().add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(29, 52, 623, 319);
		frmAddReview.getContentPane().add(panel);
		panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "RECENSIONE"));
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(253, 400, 158, 68);
		frmAddReview.getContentPane().add(panel_1);
		panel_1.setBorder(BorderFactory.createTitledBorder(
		BorderFactory.createEtchedBorder(), "VOTO"));
		
		ImageIcon Sfondo= new ImageIcon("src/Immagini/Sfondo.jpg");
		Image scaledImage = Sfondo.getImage().getScaledInstance(700, 600, Image.SCALE_DEFAULT);
		Sfondo.setImage(scaledImage);
		JLabel lblNewLabel_5 = new JLabel(Sfondo);
		lblNewLabel_5.setBounds(0, 0, 684, 561);
		frmAddReview.getContentPane().add(lblNewLabel_5);
		
		for(int i = 1; i < 11 ; i++)
		comboBox.addItem(i);
	}
}