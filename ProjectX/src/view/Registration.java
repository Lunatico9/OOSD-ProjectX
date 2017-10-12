package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import controller.RegistrationController;
import database.DatabaseMySQL;
import model.dao.Actor_DAO;
import java.awt.Font;

public class Registration {
	
	private JFrame Registration;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
    
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
		Registration.setBounds(100, 100, 700, 600);
		Registration.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Registration.getContentPane().setLayout(new BoxLayout(Registration.getContentPane(), BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		Registration.getContentPane().add(panel);
		panel.setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Arial", Font.PLAIN, 16));
		passwordField.setBounds(204, 166, 250, 25);
		panel.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Arial", Font.PLAIN, 16));
		passwordField_1.setBounds(204, 238, 250, 25);
		panel.add(passwordField_1);
		
		JLabel lblNewLabel = new JLabel("Inserisci Username");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(204, 58, 250, 25);
		panel.add(lblNewLabel);
		
		JLabel lblInserisciPassword = new JLabel("Inserisci Password");
		lblInserisciPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblInserisciPassword.setFont(new Font("Arial", Font.PLAIN, 16));
		lblInserisciPassword.setBounds(204, 130, 250, 25);
		panel.add(lblInserisciPassword);
		
		JLabel lblConfermaPassword = new JLabel("Conferma Password");
		lblConfermaPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfermaPassword.setFont(new Font("Arial", Font.PLAIN, 16));
		lblConfermaPassword.setBounds(204, 202, 250, 25);
		panel.add(lblConfermaPassword);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 16));
		textField.setBounds(204, 94, 250, 25);
		panel.add(textField);
		textField.setColumns(10);

		JButton Registra = new JButton("Registrati");
		Registra.setFont(new Font("Arial", Font.PLAIN, 16));
		Registra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username= textField.getText(), name=textField_1.getText(), surname=textField_2.getText(), email=textField_3.getText();
				boolean presente;
				@SuppressWarnings("deprecation")
				String pass1= passwordField.getText();
				@SuppressWarnings("deprecation")
				String pass2= passwordField_1.getText();
				
				try {
					if(username.isEmpty()){
						JOptionPane.showMessageDialog(null, "Errore, inserisci un username");;
					}
					else{
						presente =DatabaseMySQL.verify(username);
						if(presente) JOptionPane.showMessageDialog(null, "Errore, username non valido");
						}
				} catch (Exception e1) {
					e1.printStackTrace();
				}				
				try {	
					boolean uguale= RegistrationController.pass(pass1, pass2);
				    if (pass1.isEmpty() || pass2.isEmpty() || name.isEmpty() || surname.isEmpty() || !email.contains("@") || !email.contains(".")){ 
				    	JOptionPane.showMessageDialog(null, "Errore, uno o più campi non sono compilati correttamente o sono vuoti.");
				    	}
				    else{
				    	presente = DatabaseMySQL.verify(username);
				    	if (!presente)
				    		if(pass1.length()>6 && pass1.length()<18){
				    			if(uguale){
				    				try {
				    					int level = 1, exp = 0;
				    					String type = "giocatore";
				    					Actor_DAO.AddUser(username,pass1,name,surname,email, level, exp, type);
				    				} 
				    				catch (Exception e) {
				    					e.printStackTrace();
				    				}	
				    			}
				    			else JOptionPane.showMessageDialog(null, "Errore, le password inserite non corrispondono correggi e riprova");
				    		}
				    		else JOptionPane.showMessageDialog(null, "Errore, la password deve essere lunga almeno 6 caratteri e non più di 18");
						}
				    }
				 	catch (Exception e1) {
				 		e1.printStackTrace();
				 	}
				}
			});
		
		Registra.setBounds(386, 510, 130, 40);
		panel.add(Registra);
		
		JButton SchermataPrincipale = new JButton("Annulla");
		SchermataPrincipale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login.main(null);
				Registration.setVisible(false);
			}
		});
		SchermataPrincipale.setFont(new Font("Arial", Font.PLAIN, 16));
		SchermataPrincipale.setBounds(144, 510, 130, 40);
		panel.add(SchermataPrincipale);
		
		JLabel lblInserisciNome = new JLabel("Inserisci Nome");
		lblInserisciNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblInserisciNome.setFont(new Font("Arial", Font.PLAIN, 16));
		lblInserisciNome.setBounds(204, 274, 250, 25);
		panel.add(lblInserisciNome);
		
		JLabel lblInserisciCognome = new JLabel("Inserisci Cognome");
		lblInserisciCognome.setHorizontalAlignment(SwingConstants.CENTER);
		lblInserisciCognome.setFont(new Font("Arial", Font.PLAIN, 16));
		lblInserisciCognome.setBounds(204, 346, 250, 25);
		panel.add(lblInserisciCognome);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Arial", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(204, 310, 250, 25);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Arial", Font.PLAIN, 16));
		textField_2.setColumns(10);
		textField_2.setBounds(204, 382, 250, 25);
		panel.add(textField_2);
		
		JLabel lblInserisciEmail = new JLabel("Inserisci Email");
		lblInserisciEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblInserisciEmail.setFont(new Font("Arial", Font.PLAIN, 16));
		lblInserisciEmail.setBounds(204, 418, 250, 25);
		panel.add(lblInserisciEmail);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Arial", Font.PLAIN, 16));
		textField_3.setColumns(10);
		textField_3.setBounds(204, 454, 250, 25);
		panel.add(textField_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(142, 33, 377, 466);
		panel.add(panel_1);
		panel_1.setBorder(BorderFactory.createTitledBorder(
		BorderFactory.createEtchedBorder(), "REGISTRAZIONE"));
	}
}