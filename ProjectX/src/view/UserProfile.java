package view;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.ResultSet;

import javax.swing.JPanel;

import database.DatabaseMySQL;
import javax.swing.SwingConstants;

public class UserProfile {

	private JFrame frame;
	private String username, Nome, Cognome, Password, Email;
	private int EXP, Lvl;
	/**
	 * Launch the application.
	 */
	public static void main(String username) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserProfile window = new UserProfile(username);
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
	public UserProfile(String username) {
		this.username = username;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("User profile");
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		String query= "Select name, surname, email, password FROM user WHERE username='"+username+"'"; //da aggiungere ,exp sul Select
		ResultSet rst;
		
		try {
			rst = DatabaseMySQL.SendQuery(query);
			if(rst.next()){
				 Nome= rst.getString("name");
				 Cognome= rst.getString("surname");
				 Email = rst.getString("email");
				 Password= rst.getString("password");
				 //EXP=rst.getInt(exp);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNome.setBounds(54, 106, 100, 29);
		frame.getContentPane().add(lblNome);
		
		JLabel lblCognome = new JLabel("Cognome");
		lblCognome.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCognome.setBounds(54, 136, 100, 29);
		frame.getContentPane().add(lblCognome);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 16));
		lblEmail.setBounds(54, 164, 100, 29);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 16));
		lblPassword.setBounds(54, 193, 100, 29);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblLivello = new JLabel("Livello");
		lblLivello.setFont(new Font("Arial", Font.PLAIN, 16));
		lblLivello.setBounds(384, 288, 100, 29);
		frame.getContentPane().add(lblLivello);
		
		JLabel lblPuntiEsperienza = new JLabel("Punti esperienza");
		lblPuntiEsperienza.setFont(new Font("Arial", Font.PLAIN, 16));
		lblPuntiEsperienza.setBounds(384, 318, 116, 29);
		frame.getContentPane().add(lblPuntiEsperienza);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel.setText(Nome);
		lblNewLabel.setBounds(166, 106, 292, 29);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("Cognome");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Arial", Font.PLAIN, 16));
		label.setText(Cognome);
		label.setBounds(166, 136, 292, 29);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Email");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Arial", Font.PLAIN, 16));
		label_1.setText(Email);
		label_1.setBounds(166, 164, 292, 29);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Password");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Arial", Font.PLAIN, 16));
		label_2.setText(Password);
		label_2.setBounds(166, 193, 292, 29);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Livello");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Arial", Font.PLAIN, 16));
		label_3.setText("Lvl");
		label_3.setBounds(510, 288, 110, 29);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Punti esperienza");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Arial", Font.PLAIN, 16));
		if(Lvl==1){
			label_4.setText(EXP+"/100");
		}
		if(Lvl==2){
			label_4.setText(EXP+"/300");
		}
		if(Lvl==3){
			label_4.setText(EXP+"/600");
		}
		if(Lvl==4){
			label_4.setText(EXP+"/1000");
		}
		if(Lvl==5){
			label_4.setText(EXP+"/1500");
		}
		if(Lvl==6){
			label_4.setText(EXP+"/2100");
		}
		if(Lvl==7){
			label_4.setText(EXP+"/2800");
		}
		if(Lvl==8){
			label_4.setText(EXP+"/3600");
		}
		if(Lvl==9){
			label_4.setText(EXP+"/4500");
		}
		if(Lvl==10){
			label_4.setText("Livello massimo raggiunto");
		}
		label_4.setBounds(510, 318, 110, 29);
		frame.getContentPane().add(label_4);
		
		JPanel panel = new JPanel();
		panel.setBounds(40, 91, 432, 145);
		frame.getContentPane().add(panel);
		panel.setBorder(BorderFactory.createTitledBorder(
		BorderFactory.createEtchedBorder(), "ANAGRAFICA"));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(369, 273, 255, 145);
		frame.getContentPane().add(panel_1);
		panel_1.setBorder(BorderFactory.createTitledBorder(
		BorderFactory.createEtchedBorder(), "GAMING"));
		
		JLabel lblTimeline = new JLabel("Timeline");
		lblTimeline.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTimeline.setBounds(40, 260, 100, 29);
		frame.getContentPane().add(lblTimeline);
	}
}