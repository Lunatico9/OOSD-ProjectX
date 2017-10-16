package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.MainModeratorController;
import model.Actor;
import model.dao.Review_DAO;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;

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
	 * @throws Exception 
	 */
	public MainModerator(Actor user) throws Exception {
		this.user = user;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize() throws Exception {
		frame = new JFrame();
		frame.setTitle("Main moderator");
		frame.setBounds(100, 100, 700, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Gestisci utenti");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainModeratorController.GestisciUser(user);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(193, 136, 300, 50);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnGestisciNuoveRecensioni = new JButton("Gestisci nuove recensioni");
		btnGestisciNuoveRecensioni.setFont(new Font("Times New Roman", Font.BOLD, 20));
		ResultSet rst=Review_DAO.ReviewDaValutare();
		if(rst.next()){
			btnGestisciNuoveRecensioni.setEnabled(true);
		}
		else btnGestisciNuoveRecensioni.setEnabled(false);
		btnGestisciNuoveRecensioni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainModeratorController.GestisciRec(user);
				frame.dispose();
			}
		});
		btnGestisciNuoveRecensioni.setBounds(193, 268, 300, 50);
		frame.getContentPane().add(btnGestisciNuoveRecensioni);
		
		JButton btnUtilizzaAccountCome = new JButton("Utilizza account come utente");
		btnUtilizzaAccountCome.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnUtilizzaAccountCome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainModeratorController.Utente(user);
				frame.dispose();
			}
		});
		btnUtilizzaAccountCome.setBounds(193, 402, 300, 50);
		frame.getContentPane().add(btnUtilizzaAccountCome);
		
		ImageIcon Sfondo= new ImageIcon("src/Immagini/Sfondo.jpg");
		Image scaledImage = Sfondo.getImage().getScaledInstance(700, 600, Image.SCALE_DEFAULT);
		Sfondo.setImage(scaledImage);
		JLabel lblNewLabel_5 = new JLabel(Sfondo);
		lblNewLabel_5.setBounds(0, 0, 684, 561);
		frame.getContentPane().add(lblNewLabel_5);
	}
}
