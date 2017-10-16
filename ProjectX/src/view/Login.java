package view;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;

import controller.LoginController;
import database.DatabaseMySQL;
import model.Actor;

import javax.swing.JPasswordField;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frmLogin;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 700, 600);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(Color.BLACK);
		lblUsername.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblUsername.setBounds(89, 192, 100, 29);
		frmLogin.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblPassword.setBounds(89, 262, 100, 29);
		frmLogin.getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textField.setBounds(220, 192, 322, 27);
		frmLogin.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		passwordField.setBounds(220, 262, 322, 27);
		frmLogin.getContentPane().add(passwordField);
		
		ImageIcon Login= new ImageIcon("src/Immagini/login.png");
		Image scaledLogin = Login.getImage().getScaledInstance(132, 48, Image.SCALE_DEFAULT);
		Login.setImage(scaledLogin);
		
		JButton btnAccedi = new JButton(Login);
		btnAccedi.setBorderPainted(false);
		btnAccedi.setContentAreaFilled(false);
		btnAccedi.setOpaque(false);
		btnAccedi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textField.getText();
			    String password = passwordField.getText();
			    if(username.isEmpty() || password.isEmpty()) {
			    	JOptionPane.showMessageDialog(null, "Errore, un campo o entrambi non sono stati riempiti.");
			    }
			    else {
			    	try {
			    		String queryuser= "Select * From user WHERE username='"+username+"' AND password='"+password+"'";
			    		ResultSet User = DatabaseMySQL.SendQuery(queryuser);
			    		if(User.next()){
			    			Actor user = new Actor(User.getInt("idUser"),User.getString("username"),User.getString("password"), User.getString("name"),User.getString("surname"), User.getString("email"), User.getInt("level"), User.getInt("exp"), User.getString("type"));
			    			
			    		LoginController.Accedi(user);
			    		frmLogin.setVisible(false);
			    		}
			    		else{
			    			JOptionPane.showMessageDialog(null, "Errore, username o password errati.");
			    		}
			    	} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			    }
		}});
		btnAccedi.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnAccedi.setBounds(220, 332, 132, 48);
		frmLogin.getContentPane().add(btnAccedi);
		
		ImageIcon Register= new ImageIcon("src/Immagini/register.png");
		Image scaledReg = Register.getImage().getScaledInstance(132, 30, Image.SCALE_DEFAULT);
		Register.setImage(scaledReg);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBounds(65, 112, 550, 310);
		frmLogin.getContentPane().add(panel);
		panel.setBorder(BorderFactory.createTitledBorder(
        BorderFactory.createEtchedBorder(), "ACCEDI O REGISTRATI"));
		panel.setLayout(null);
		
		JButton btnRegistrati = new JButton(Register);
		btnRegistrati.setBounds(338, 228, 132, 30);
		panel.add(btnRegistrati);
		btnRegistrati.setOpaque(false);
		btnRegistrati.setContentAreaFilled(false);
		btnRegistrati.setBorderPainted(false);
		btnRegistrati.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Registration.main(null);
				frmLogin.setVisible(false);
			}
		});
		btnRegistrati.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		ImageIcon Sfondo= new ImageIcon("src/Immagini/Sfondo.jpg");
		Image scaledImage = Sfondo.getImage().getScaledInstance(700, 600, Image.SCALE_DEFAULT);
		Sfondo.setImage(scaledImage);	
		
		JLabel lblNewLabel_5 = new JLabel(Sfondo);
		lblNewLabel_5.setBounds(0, 0, 684, 561);
		frmLogin.getContentPane().add(lblNewLabel_5);
	}
}