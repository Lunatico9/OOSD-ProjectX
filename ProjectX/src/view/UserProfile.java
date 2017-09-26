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
	private String type, username, Nome, Cognome, Password, Email, UserId;
	private int EXP,lvl;
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
				 lvl=rst.getInt("level");
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNome.setBounds(35, 62, 100, 29);
		frame.getContentPane().add(lblNome);
		
		JLabel lblCognome = new JLabel("Cognome");
		lblCognome.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCognome.setBounds(35, 92, 100, 29);
		frame.getContentPane().add(lblCognome);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 16));
		lblEmail.setBounds(35, 120, 100, 29);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 16));
		lblPassword.setBounds(35, 149, 100, 29);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblLivello = new JLabel("Livello");
		lblLivello.setFont(new Font("Arial", Font.PLAIN, 16));
		lblLivello.setBounds(420, 62, 100, 29);
		frame.getContentPane().add(lblLivello);
		
		JLabel lblPuntiEsperienza = new JLabel("Punti esperienza");
		lblPuntiEsperienza.setFont(new Font("Arial", Font.PLAIN, 16));
		lblPuntiEsperienza.setBounds(420, 92, 116, 29);
		frame.getContentPane().add(lblPuntiEsperienza);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel.setText(Nome);
		lblNewLabel.setBounds(147, 62, 237, 29);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("Cognome");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Arial", Font.PLAIN, 16));
		label.setText(Cognome);
		label.setBounds(147, 92, 237, 29);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Email");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Arial", Font.PLAIN, 16));
		label_1.setText(Email);
		label_1.setBounds(104, 120, 280, 29);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Password");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Arial", Font.PLAIN, 16));
		label_2.setText(Password);
		label_2.setBounds(147, 149, 237, 29);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Livello");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Arial", Font.PLAIN, 16));
		label_3.setText("" + lvl);
		label_3.setBounds(546, 62, 110, 29);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Arial", Font.PLAIN, 16));
		
		int[] x = {100, 300, 600, 1000, 1500, 2100, 2800, 3600, 4500, 5500, 6600, 7800, 9100, 10500, 12000, 13600, 15300, 17100, 19000, 21000, 23100, 25300, 27600, 30000, 32500, 35100, 37800, 40600, 43500, 46500, 49600, 52800, 56100, 59500, 63000, 66600, 70300, 74100, 78000, 82000, 86100, 90300, 94600, 99000, 103500, 108100, 112800, 117600, 122500, 127500, 132600, 137800, 143100, 148500, 154000, 159600, 165300, 171100, 177000, 183000, 189100, 195300, 201600, 208000, 214500, 221100, 227800, 234600, 241500, 248500, 255600, 262800, 270100, 277500, 285000, 292600, 300300, 308100, 316000, 324000, 332100, 340300, 348600, 357000, 365500, 374100, 382800, 391600, 400500, 409500, 418600, 427800, 437100, 446500, 456000, 465600, 475300, 485100, 495000, 505000};
			int j = lvl - 1;
			label_4.setText(EXP + "/" + x[j]);
		
		label_4.setBounds(546, 92, 110, 29);
		frame.getContentPane().add(label_4);
		
		JPanel panel = new JPanel();
		panel.setBounds(21, 47, 372, 145);
		frame.getContentPane().add(panel);
		panel.setBorder(BorderFactory.createTitledBorder(
		BorderFactory.createEtchedBorder(), "ANAGRAFICA"));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(405, 47, 255, 145);
		frame.getContentPane().add(panel_1);
		panel_1.setBorder(BorderFactory.createTitledBorder(
		BorderFactory.createEtchedBorder(), "GAMING"));
		
		JLabel lblTimeline = new JLabel("Timeline");
		lblTimeline.setFont(new Font("Arial", Font.PLAIN, 18));
		lblTimeline.setBounds(31, 203, 100, 29);
		frame.getContentPane().add(lblTimeline);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 243, 437, 140);
		frame.getContentPane().add(scrollPane);
		String riga1="",riga2="",riga3="",riga4="",riga5="",riga6="",riga7="",riga8="",riga9="",riga10="";
		String riga11="",riga12="",riga13="",riga14="",riga15="",riga16="",riga17="",riga18="",riga19="",riga20="";
		try {
			String query2="Select data,Premio From timeline Where User_idUser='"+UserId+"' Order By idTimeline";
			ResultSet rs= DatabaseMySQL.SendQuery(query2);
			int i =1;
			while (rs.next()){
				if(i==1){
					riga1=rs.getString("data");
					riga11=rs.getString("Premio");
				}
				if(i==2){
					riga2=rs.getString("data");
					riga12=rs.getString("Premio");
				}
				if(i==3){
					riga3=rs.getString("data");
					riga13=rs.getString("Premio");
				}
				if(i==4){
					riga4=rs.getString("data");
					riga14=rs.getString("Premio");
				}
				if(i==5){
					riga5=rs.getString("data");
					riga15=rs.getString("Premio");
				}
				if(i==6){
					riga6=rs.getString("data");
					riga16=rs.getString("Premio");
				}
				if(i==7){
					riga7=rs.getString("data");
					riga17=rs.getString("Premio");
				}
				if(i==8){
					riga8=rs.getString("data");
					riga18=rs.getString("Premio");
				}
				if(i==9){
					riga9=rs.getString("data");
					riga19=rs.getString("Premio");
				}
				if(i==10){
					riga10=rs.getString("data");
					riga20=rs.getString("Premio");
				}
				i++;
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{riga1, riga11},
				{riga2, riga12},
				{riga3, riga13},
				{riga4, riga14},
				{riga5, riga15},
				{riga6, riga16},
				{riga7, riga17},
				{riga8, riga18},
				{riga9, riga19},
				{riga10, riga20},
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
		mntmNewMenuItem.setBounds(0, 0, 93, 22);
		frame.getContentPane().add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Logout");
		mntmNewMenuItem_1.setFont(new Font("Arial", Font.PLAIN, 18));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.main(null);
				frame.dispose();
			}
		});
		mntmNewMenuItem_1.setBounds(86, 0, 110, 22);
		frame.getContentPane().add(mntmNewMenuItem_1);
	}
}