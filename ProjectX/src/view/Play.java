package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import controller.PlayController;
import model.Actor;
import model.Game;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
 
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
		
		ImageIcon Start= new ImageIcon("src/Immagini/Start.png");
		
		JButton btnNewButton = new JButton(Start);
		btnNewButton.setOpaque(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					user = PlayController.Gioca(user);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(154, 270, 150, 40);
		frame.getContentPane().add(btnNewButton);
		
		ImageIcon Titolo= new ImageIcon("src/Immagini/"+game.getName()+" logo.png");
		Image scaledImageT = Titolo.getImage().getScaledInstance(500, 200, Image.SCALE_DEFAULT);
		Titolo.setImage(scaledImageT);
		
		JLabel lblStaiGiocandoA = new JLabel(Titolo);
		lblStaiGiocandoA.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblStaiGiocandoA.setBounds(79, 15, 500, 200);
		frame.getContentPane().add(lblStaiGiocandoA);
		
		ImageIcon Exit= new ImageIcon("src/Immagini/Exit.png");
		
		JButton btnEsci = new JButton(Exit);
		btnEsci.setBorderPainted(false);
		btnEsci.setContentAreaFilled(false);
		btnEsci.setOpaque(false);
		btnEsci.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnEsci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MainUser.main(user);
			}
		});
		btnEsci.setBounds(225, 409, 150, 40);
		frame.getContentPane().add(btnEsci);
		
		ImageIcon Sfondo= new ImageIcon("src/Immagini/Sfondo.jpg");
		Image scaledImage = Sfondo.getImage().getScaledInstance(700, 600, Image.SCALE_DEFAULT);
		Sfondo.setImage(scaledImage);
		JLabel lblNewLabel_5 = new JLabel(Sfondo);
		lblNewLabel_5.setBounds(0, 0, 684, 561);
		frame.getContentPane().add(lblNewLabel_5);
	}
}
