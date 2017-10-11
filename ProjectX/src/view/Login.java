package view;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import controller.LoginController;
import database.DatabaseMySQL;
import model.Actor;

import javax.swing.JPasswordField;
import java.awt.Color;

import javax.swing.BorderFactory;
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
		lblUsername.setFont(new Font("Arial", Font.PLAIN, 20));
		lblUsername.setBounds(89, 192, 100, 29);
		frmLogin.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 20));
		lblPassword.setBounds(89, 262, 100, 29);
		frmLogin.getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(220, 192, 322, 27);
		frmLogin.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(220, 262, 322, 27);
		frmLogin.getContentPane().add(passwordField);
		
		JButton btnAccedi = new JButton("Accedi");
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
		btnAccedi.setFont(new Font("Arial", Font.PLAIN, 20));
		btnAccedi.setBounds(220, 332, 132, 48);
		frmLogin.getContentPane().add(btnAccedi);
		
		JButton btnRegistrati = new JButton("Registrati");
		btnRegistrati.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Registration.main(null);
				frmLogin.setVisible(false);
			}
		});
		btnRegistrati.setFont(new Font("Arial", Font.PLAIN, 20));
		btnRegistrati.setBounds(410, 332, 132, 48);
		frmLogin.getContentPane().add(btnRegistrati);
		
		JPanel panel = new JPanel();
		panel.setBounds(65, 112, 550, 310);
		frmLogin.getContentPane().add(panel);
		panel.setBorder(BorderFactory.createTitledBorder(
        BorderFactory.createEtchedBorder(), "ACCEDI O REGISTRATI"));
	}
}