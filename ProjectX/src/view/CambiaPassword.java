package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import controller.CambiaPasswordController;
import javafx.stage.WindowEvent;
import model.Actor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Image;

public class CambiaPassword {

	private JFrame frame;
	private JPasswordField textField;
	private JPasswordField textField_1;
	private JPasswordField textField_2;
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
		frame.setTitle("Change password");
		frame.setBounds(100, 100, 700, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblVecchiaPassword = new JLabel("Vecchia password");
		lblVecchiaPassword.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblVecchiaPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblVecchiaPassword.setBounds(181, 78, 289, 20);
		frame.getContentPane().add(lblVecchiaPassword);
		
		textField = new JPasswordField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField.setBounds(181, 123, 290, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNuovaPassword = new JLabel("Nuova password");
		lblNuovaPassword.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNuovaPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuovaPassword.setBounds(182, 190, 289, 20);
		frame.getContentPane().add(lblNuovaPassword);
		
		textField_1 = new JPasswordField();
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(182, 232, 290, 30);
		frame.getContentPane().add(textField_1);
		
		JLabel lblConfermaPassword = new JLabel("Conferma password");
		lblConfermaPassword.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblConfermaPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfermaPassword.setBounds(182, 297, 289, 20);
		frame.getContentPane().add(lblConfermaPassword);
		
		textField_2 = new JPasswordField();
		textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_2.setColumns(10);
		textField_2.setBounds(181, 338, 290, 30);
		frame.getContentPane().add(textField_2);
		
		
		ImageIcon Conf= new ImageIcon("src/Immagini/Conferma.png");
		Image scaledConf = Conf.getImage().getScaledInstance(170, 40, Image.SCALE_DEFAULT);
		Conf.setImage(scaledConf);
		
		JButton btnCambiaPassword = new JButton(Conf);
		btnCambiaPassword.setBorderPainted(false);
		btnCambiaPassword.setContentAreaFilled(false);
		btnCambiaPassword.setOpaque(false);
		btnCambiaPassword.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnCambiaPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {
						if(!textField.getText().equals("") && !textField_1.getText().equals("") && !textField_2.getText().equals("")){
							String P= textField_1.getText();
								if(P.length()>6 && P.length()<18){
									if(!CambiaPasswordController.Modify(user,textField.getText(),textField_1.getText(),textField_2.getText()).equals(textField.getText())){
										user.setPassword(CambiaPasswordController.Modify(user,textField.getText(),textField_1.getText(),textField_2.getText()));
										JOptionPane.showMessageDialog(null, "Password modificata con successo!");
										frame.dispose();
										UserProfile.main(user);
									
									}
									else JOptionPane.showMessageDialog(null, "Digita una password diversa dalla precedente o controlla di aver confermato correttamente la nuova password!");
								}
								else JOptionPane.showMessageDialog(null, "La nuova password deve essere lunga almeno 6 caratteri ma non più di 18 caratteri");
						}
						else JOptionPane.showMessageDialog(null, "Compila correttamente i campi!");
					} 
					catch (Exception e1) {
						e1.printStackTrace();
					}
			}
		});
		btnCambiaPassword.setBounds(465, 430, 170, 40);
		frame.getContentPane().add(btnCambiaPassword);
		
		ImageIcon Canc= new ImageIcon("src/Immagini/Annulla.png");
		Image scaledCanc = Canc.getImage().getScaledInstance(170, 40, Image.SCALE_DEFAULT);
		Canc.setImage(scaledCanc);
		
		JButton btnAnnulla = new JButton(Canc);
		btnAnnulla.setOpaque(false);
		btnAnnulla.setContentAreaFilled(false);
		btnAnnulla.setBorderPainted(false);
		btnAnnulla.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				UserProfile.main(user);
			}
		});
		btnAnnulla.setBounds(47, 430, 170, 40);
		frame.getContentPane().add(btnAnnulla);
		
		ImageIcon Sfondo= new ImageIcon("src/Immagini/Sfondo.jpg");
		Image scaledImage = Sfondo.getImage().getScaledInstance(700, 600, Image.SCALE_DEFAULT);
		Sfondo.setImage(scaledImage);
		JLabel lblNewLabel_5 = new JLabel(Sfondo);
		lblNewLabel_5.setBounds(0, 0, 684, 561);
		frame.getContentPane().add(lblNewLabel_5);
	}
}
