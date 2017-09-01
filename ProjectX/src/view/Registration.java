package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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

import controller.RegistrationController;

import java.awt.Font;

public class Registration {

	private JFrame Registration;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
    
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
		Registration.setBounds(100, 100, 450, 425);
		Registration.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Registration.getContentPane().setLayout(new BoxLayout(Registration.getContentPane(), BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		Registration.getContentPane().add(panel);
		panel.setLayout(null);
		
	
		JLabel Valido = new JLabel("");
		Valido.setBounds(269, 20, 155, 23);
		panel.add(Valido);		
		
		JLabel campi = new JLabel("");
		campi.setBounds(307, 193, 114, 33);
		panel.add(campi);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		passwordField.setBounds(72, 96, 250, 23);
		panel.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		passwordField_1.setBounds(72, 147, 250, 23);
		panel.add(passwordField_1);
		
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
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		textField.setBounds(72, 51, 250, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton Registra = new JButton("Registra Account");
		Registra.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		Registra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username= textField.getText(), name=textField_1.getText(), surname=textField_2.getText();
				boolean presente = RegistrationController.verify(username);
				String pass1= passwordField.getText();
				String pass2= passwordField_1.getText();
				boolean uguale= RegistrationController.pass(pass1, pass2);
			    if (username.isEmpty() || pass1.isEmpty() || pass2.isEmpty() || name.isEmpty() || surname.isEmpty()){ 
			    	JOptionPane.showMessageDialog(null, "Errore, uno o pi� campi non sono compilati correttamente o sono vuoti.");}
			    else{
			    if (presente)
					JOptionPane.showMessageDialog(null, "Errore, l'username che stai usando non � disponibile, cambialo e controlla la sua disponibilit� con il tasto Verifica");
				else{
					if(uguale){
						try {
							RegistrationController.AddUser(username,pass1,name,surname);
						} catch (Exception e) {
							e.printStackTrace();
						}
						JOptionPane.showMessageDialog(null, "L'utente "+username+" � stato registrato");
					}
					else{ 
						JOptionPane.showMessageDialog(null, "Errore, le password inserite non corrispondono correggi e riprova");
					}
				}
			    }
			}
		});
		
		Registra.setBounds(96, 285, 201, 23);
		panel.add(Registra);
		
		JButton Verifica = new JButton("Verifica");
		Verifica.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		Verifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username=textField.getText();
				boolean presente = RegistrationController.verify(username);
				if(username.isEmpty()){
					JOptionPane.showMessageDialog(null, "Errore, inserisci un username");;
				}
				else{ if(presente) JOptionPane.showMessageDialog(null, "Errore, username non valido");
					  else JOptionPane.showMessageDialog(null, "Username valido, chiudi questo messaggio e procedi con la registrazione");;
				}
			}
		});
		Verifica.setBounds(335, 50, 89, 23);
		panel.add(Verifica);
		
		JButton SchermataPrincipale = new JButton("Schermata Principale");
		SchermataPrincipale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login.main(null);
				Registration.setVisible(false);
			}
		});
		SchermataPrincipale.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		SchermataPrincipale.setBounds(96, 325, 201, 23);
		panel.add(SchermataPrincipale);
		
		JLabel lblInserisciNome = new JLabel("Inserisci Nome");
		lblInserisciNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblInserisciNome.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblInserisciNome.setBounds(72, 181, 250, 14);
		panel.add(lblInserisciNome);
		
		JLabel lblInserisciCognome = new JLabel("Inserisci Cognome");
		lblInserisciCognome.setHorizontalAlignment(SwingConstants.CENTER);
		lblInserisciCognome.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblInserisciCognome.setBounds(72, 224, 250, 14);
		panel.add(lblInserisciCognome);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		textField_1.setColumns(10);
		textField_1.setBounds(72, 193, 250, 20);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		textField_2.setColumns(10);
		textField_2.setBounds(72, 237, 250, 20);
		panel.add(textField_2);
	}
}
