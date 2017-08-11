package view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

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
		lblUsername.setBounds(89, 119, 100, 29);
		frmLogin.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 20));
		lblPassword.setBounds(89, 205, 100, 29);
		frmLogin.getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(220, 122, 322, 27);
		frmLogin.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(220, 208, 322, 27);
		frmLogin.getContentPane().add(passwordField);
		
		JButton btnAccedi = new JButton("Accedi");
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