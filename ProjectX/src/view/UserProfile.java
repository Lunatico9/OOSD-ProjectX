package view;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import database.DatabaseMySQL;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JList;

public class UserProfile {

	private JFrame frame;
	private String type, username, Nome, Cognome, Password, Email, UserId, Lvl;
	private int EXP;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String username, String type) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserProfile window = new UserProfile(username, type);
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
	public UserProfile(String username, String type) {
		this.username = username;
		this.type=type;
		initialize();
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
		
		String query= "Select idUser, name, surname, email, password, exp, level FROM user WHERE username='"+username+"'"; 
		ResultSet rst;
		
		try {
			rst = DatabaseMySQL.SendQuery(query);
			if(rst.next()){
				 UserId=rst.getString("idUser");
				 Nome= rst.getString("name");
				 Cognome= rst.getString("surname");
				 Email = rst.getString("email");
				 Password= rst.getString("password");
				 EXP=rst.getInt("exp");
				 Lvl=rst.getString("level");
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNome.setBounds(39, 106, 100, 29);
		frame.getContentPane().add(lblNome);
		
		JLabel lblCognome = new JLabel("Cognome");
		lblCognome.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCognome.setBounds(39, 136, 100, 29);
		frame.getContentPane().add(lblCognome);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 16));
		lblEmail.setBounds(39, 164, 100, 29);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 16));
		lblPassword.setBounds(39, 193, 100, 29);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblLivello = new JLabel("Livello");
		lblLivello.setFont(new Font("Arial", Font.PLAIN, 16));
		lblLivello.setBounds(418, 106, 100, 29);
		frame.getContentPane().add(lblLivello);
		
		JLabel lblPuntiEsperienza = new JLabel("Punti esperienza");
		lblPuntiEsperienza.setFont(new Font("Arial", Font.PLAIN, 16));
		lblPuntiEsperienza.setBounds(418, 136, 116, 29);
		frame.getContentPane().add(lblPuntiEsperienza);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel.setText(Nome);
		lblNewLabel.setBounds(151, 106, 220, 29);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("Cognome");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Arial", Font.PLAIN, 16));
		label.setText(Cognome);
		label.setBounds(151, 136, 220, 29);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Email");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Arial", Font.PLAIN, 16));
		label_1.setText(Email);
		label_1.setBounds(151, 164, 220, 29);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Password");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Arial", Font.PLAIN, 16));
		label_2.setText(Password);
		label_2.setBounds(151, 193, 220, 29);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Livello");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Arial", Font.PLAIN, 16));
		label_3.setText(Lvl);
		label_3.setBounds(544, 106, 110, 29);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Punti esperienza");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Arial", Font.PLAIN, 16));
		if(Lvl.equals("1")){
			label_4.setText(EXP+"/100");
		}
		if(Lvl.equals("2")){
			label_4.setText(EXP+"/300");
		}
		if(Lvl.equals("3")){
			label_4.setText(EXP+"/600");
		}
		if(Lvl.equals("4")){
			label_4.setText(EXP+"/1000");
		}
		if(Lvl.equals("5")){
			label_4.setText(EXP+"/1500");
		}
		if(Lvl.equals("6")){
			label_4.setText(EXP+"/2100");
		}
		if(Lvl.equals("7")){
			label_4.setText(EXP+"/2800");
		}
		if(Lvl.equals("8")){
			label_4.setText(EXP+"/3600");
		}
		if(Lvl.equals("9")){
			label_4.setText(EXP+"/4500");
		}
		if(Lvl.equals("10")){
			label_4.setText("Livello massimo raggiunto");
		}
		label_4.setBounds(544, 136, 110, 29);
		frame.getContentPane().add(label_4);
		
		JPanel panel = new JPanel();
		panel.setBounds(25, 91, 366, 145);
		frame.getContentPane().add(panel);
		panel.setBorder(BorderFactory.createTitledBorder(
		BorderFactory.createEtchedBorder(), "ANAGRAFICA"));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(403, 91, 255, 145);
		frame.getContentPane().add(panel_1);
		panel_1.setBorder(BorderFactory.createTitledBorder(
		BorderFactory.createEtchedBorder(), "GAMING"));
		
		JLabel lblTimeline = new JLabel("Timeline");
		lblTimeline.setFont(new Font("Arial", Font.PLAIN, 18));
		lblTimeline.setBounds(27, 254, 100, 29);
		frame.getContentPane().add(lblTimeline);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 300, 300, 140);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Date", "Award"
			}
		));
		table.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Menu");
		mntmNewMenuItem.setFont(new Font("Arial", Font.PLAIN, 18));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				MainUser.main(username, type);
		}
		});
		mntmNewMenuItem.setBounds(-7, 41, 100, 37);
		frame.getContentPane().add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Logout");
		mntmNewMenuItem_1.setFont(new Font("Arial", Font.PLAIN, 18));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.main(null);
				frame.dispose();
			}
		});
		mntmNewMenuItem_1.setBounds(90, 41, 100, 37);
		frame.getContentPane().add(mntmNewMenuItem_1);
	}
}