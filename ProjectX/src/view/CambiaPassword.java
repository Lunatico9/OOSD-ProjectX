package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.CambiaPasswordController;
import model.Actor;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CambiaPassword {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private Actor user;
	/**
	 * Launch the application.
	 */
	public static void main(Actor user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CambiaPassword window = new CambiaPassword(user);
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
	public CambiaPassword(Actor user) {
		this.user=user;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblVecchiaPassword = new JLabel("Vecchia Password");
		lblVecchiaPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblVecchiaPassword.setBounds(54, 26, 289, 20);
		frame.getContentPane().add(lblVecchiaPassword);
		
		textField = new JTextField();
		textField.setBounds(54, 48, 289, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNuovaPassword = new JLabel("Nuova Password");
		lblNuovaPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuovaPassword.setBounds(54, 79, 289, 20);
		frame.getContentPane().add(lblNuovaPassword);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(54, 105, 289, 20);
		frame.getContentPane().add(textField_1);
		
		JLabel lblConfermaPassword = new JLabel("Conferma Password");
		lblConfermaPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfermaPassword.setBounds(54, 136, 289, 20);
		frame.getContentPane().add(lblConfermaPassword);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(54, 156, 289, 20);
		frame.getContentPane().add(textField_2);
		
		JButton btnCambiaPassword = new JButton("Cambia Password");
		btnCambiaPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					user.setPassword(CambiaPasswordController.Modify(user,textField.getText(),textField_1.getText(),textField_2.getText()));
			}
		});
		btnCambiaPassword.setBounds(285, 213, 117, 23);
		frame.getContentPane().add(btnCambiaPassword);
		
		JButton btnAnnulla = new JButton("Annulla");
		btnAnnulla.setBounds(25, 213, 117, 23);
		frame.getContentPane().add(btnAnnulla);
	}
}
