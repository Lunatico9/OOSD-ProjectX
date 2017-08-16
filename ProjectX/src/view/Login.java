package view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import database.DatabaseMySQL;

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
		frmLogin.setBounds(100, 100, 700, 500);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(Color.BLACK);
		lblUsername.setFont(new Font("Arial", Font.PLAIN, 20));
		lblUsername.setBounds(89, 150, 100, 29);
		frmLogin.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 20));
		lblPassword.setBounds(89, 220, 100, 29);
		frmLogin.getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(220, 150, 322, 27);
		frmLogin.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(220, 220, 322, 27);
		frmLogin.getContentPane().add(passwordField);
		
		JButton btnAccedi = new JButton("Accedi");
		btnAccedi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textField.getText();
			    String password = passwordField.getText();
			    if(username.isEmpty() || password.isEmpty()) {
			    	JOptionPane.showMessageDialog(null, "Ma sei Mattia che non riesci a inserire il nome utente o la password?");
			    }
				//LoginController.Accedi(username, password);
			    String query = "SELECT username, password, type FROM user WHERE username = '" + username + "' and password = '" + password + "'";
			    ResultSet rst;
				try {
					rst = DatabaseMySQL.SendQuery(query);
					if(rst.next()) {
						String type = rst.getString("type");
					    if("amministratore".equals(type)) {
					    	//redirect to admin page
					    	
					     } 
					     else if("moderatore".equals(type)) {
					    	 //redirect to mod page
					     }      
					 }
					 else{
					      //redirect to user page
					 }
				 }
				 catch (Exception e1) {
					 // TODO Auto-generated catch block
					 e1.printStackTrace();
				 }
		}});
		btnAccedi.setFont(new Font("Arial", Font.PLAIN, 20));
		btnAccedi.setBounds(220, 290, 132, 48);
		frmLogin.getContentPane().add(btnAccedi);
		
		JButton btnRegistrati = new JButton("Registrati");
		btnRegistrati.setFont(new Font("Arial", Font.PLAIN, 20));
		btnRegistrati.setBounds(410, 290, 132, 48);
		frmLogin.getContentPane().add(btnRegistrati);
		
		JPanel panel = new JPanel();
		panel.setBounds(65, 70, 550, 310);
		frmLogin.getContentPane().add(panel);
		panel.setBorder(BorderFactory.createTitledBorder(
        BorderFactory.createEtchedBorder(), "ACCEDI O REGISTRATI"));
	}
}