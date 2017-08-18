package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JEditorPane;
import java.awt.CardLayout;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.TextField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Registration {

	private JFrame Registration;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration window = new Registration();
					window.Registration.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Registration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Registration = new JFrame();
		Registration.setTitle("Registration");
		Registration.setBounds(100, 100, 450, 300);
		Registration.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Registration.getContentPane().setLayout(new BoxLayout(Registration.getContentPane(), BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		Registration.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Registra Account");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(96, 193, 201, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Verifica");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(335, 50, 89, 23);
		panel.add(btnNewButton_1);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		passwordField.setBounds(72, 96, 250, 23);
		panel.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		passwordField_1.setBounds(72, 147, 250, 23);
		panel.add(passwordField_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		textField.setBounds(72, 51, 250, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Inserisci Username");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(72, 29, 250, 14);
		panel.add(lblNewLabel);
		
		JLabel lblInserisciPassword = new JLabel("Inserisci Password");
		lblInserisciPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblInserisciPassword.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblInserisciPassword.setBounds(72, 82, 250, 14);
		panel.add(lblInserisciPassword);
		
		JLabel lblConfermaPassword = new JLabel("Conferma Password");
		lblConfermaPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfermaPassword.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblConfermaPassword.setBounds(72, 130, 250, 14);
		panel.add(lblConfermaPassword);
		
		JButton btnNewButton_2 = new JButton("Login");
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton_2.setBounds(96, 227, 201, 23);
		panel.add(btnNewButton_2);
	}
}
