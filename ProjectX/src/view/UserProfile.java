package view;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;

public class UserProfile {

	private JFrame frame;
	private String username;

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
		initialize();
		this.username = username;
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
		lblLivello.setBounds(395, 106, 100, 29);
		frame.getContentPane().add(lblLivello);
		
		JLabel lblPuntiEsperienza = new JLabel("Punti esperienza");
		lblPuntiEsperienza.setFont(new Font("Arial", Font.PLAIN, 16));
		lblPuntiEsperienza.setBounds(395, 136, 116, 29);
		frame.getContentPane().add(lblPuntiEsperienza);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel.setBounds(166, 106, 100, 29);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("New label");
		label.setFont(new Font("Arial", Font.PLAIN, 16));
		label.setBounds(166, 136, 100, 29);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("New label");
		label_1.setFont(new Font("Arial", Font.PLAIN, 16));
		label_1.setBounds(166, 164, 100, 29);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("New label");
		label_2.setFont(new Font("Arial", Font.PLAIN, 16));
		label_2.setBounds(166, 193, 100, 29);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("New label");
		label_3.setFont(new Font("Arial", Font.PLAIN, 16));
		label_3.setBounds(540, 106, 100, 29);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("New label");
		label_4.setFont(new Font("Arial", Font.PLAIN, 16));
		label_4.setBounds(540, 136, 100, 29);
		frame.getContentPane().add(label_4);
		
		JPanel panel = new JPanel();
		panel.setBounds(40, 91, 255, 145);
		frame.getContentPane().add(panel);
		panel.setBorder(BorderFactory.createTitledBorder(
		BorderFactory.createEtchedBorder(), "ANAGRAFICA"));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(380, 91, 255, 145);
		frame.getContentPane().add(panel_1);
		panel_1.setBorder(BorderFactory.createTitledBorder(
		BorderFactory.createEtchedBorder(), "GAMING"));
		
		JLabel lblTimeline = new JLabel("Timeline");
		lblTimeline.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTimeline.setBounds(40, 260, 100, 29);
		frame.getContentPane().add(lblTimeline);
	}
}
