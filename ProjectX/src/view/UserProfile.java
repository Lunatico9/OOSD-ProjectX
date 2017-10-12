package view;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import database.DatabaseMySQL;
import model.Actor;
import model.dao.Review_DAO;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import controller.UserProfileController;

import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Color;

public class UserProfile {

	private JFrame frame;
	private JTable table;
	private Actor user;
	/**
	 * Launch the application.
	 */
	public static void main(Actor user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserProfile window = new UserProfile(user);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public UserProfile(Actor user) throws Exception {
		this.user = user;
		initialize();
	}

	
	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize() throws Exception {
		frame = new JFrame();
		frame.setTitle("User profile");
		frame.setBounds(100, 100, 700, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		int[] x = {100, 300, 600, 1000, 1500, 2100, 2800, 3600, 4500, 5500, 6600, 7800, 9100, 10500, 12000, 13600, 15300, 17100, 19000, 21000, 23100, 25300, 27600, 30000, 32500, 35100, 37800, 40600, 43500, 46500, 49600, 52800, 56100, 59500, 63000, 66600, 70300, 74100, 78000, 82000, 86100, 90300, 94600, 99000, 103500, 108100, 112800, 117600, 122500, 127500, 132600, 137800, 143100, 148500, 154000, 159600, 165300, 171100, 177000, 183000, 189100, 195300, 201600, 208000, 214500, 221100, 227800, 234600, 241500, 248500, 255600, 262800, 270100, 277500, 285000, 292600, 300300, 308100, 316000, 324000, 332100, 340300, 348600, 357000, 365500, 374100, 382800, 391600, 400500, 409500, 418600, 427800, 437100, 446500, 456000, 465600, 475300, 485100, 495000, 505000};
			
			int j = user.getLevel() - 1;
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBounds(21, 47, 372, 156);
		frame.getContentPane().add(panel);
		panel.setBorder(BorderFactory.createTitledBorder(
		BorderFactory.createEtchedBorder(), "ANAGRAFICA"));
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Modifica Password");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserProfileController.CambiaPassword(user);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(129, 115, 180, 30);
		panel.add(btnNewButton);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 79, 75, 30);
		panel.add(lblEmail);
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JLabel label_1 = new JLabel("Email");
		label_1.setBounds(84, 79, 275, 30);
		panel.add(label_1);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Arial", Font.PLAIN, 16));
		label_1.setText(user.getEmail());
		
		JLabel lblCognome = new JLabel("Cognome");
		lblCognome.setBounds(10, 50, 75, 30);
		panel.add(lblCognome);
		lblCognome.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JLabel label = new JLabel("Cognome");
		label.setBounds(84, 50, 275, 30);
		panel.add(label);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Arial", Font.PLAIN, 16));
		label.setText(user.getCognome());
		
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 22, 75, 30);
		panel.add(lblNome);
		lblNome.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(84, 22, 275, 30);
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel.setText(user.getName());
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel_1.setBounds(405, 47, 255, 156);
		frame.getContentPane().add(panel_1);
		panel_1.setBorder(BorderFactory.createTitledBorder(
		BorderFactory.createEtchedBorder(), "GAMING"));
		panel_1.setLayout(null);
		
		JLabel lblPuntiEsperienza = new JLabel("Punti esperienza");
		lblPuntiEsperienza.setBounds(70, 87, 116, 29);
		panel_1.add(lblPuntiEsperienza);
		lblPuntiEsperienza.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(73, 116, 110, 29);
		panel_1.add(label_4);
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Arial", Font.PLAIN, 16));
		label_4.setText(user.getExp() + "/" + x[j]);
		
		JLabel label_3 = new JLabel("Livello");
		label_3.setBounds(70, 52, 110, 29);
		panel_1.add(label_3);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Arial", Font.PLAIN, 16));
		label_3.setText("" + user.getLevel());
		
		JLabel lblLivello = new JLabel("Livello");
		lblLivello.setHorizontalAlignment(SwingConstants.CENTER);
		lblLivello.setBounds(76, 23, 100, 29);
		panel_1.add(lblLivello);
		lblLivello.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JLabel lblTimeline = new JLabel("Timeline");
		lblTimeline.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTimeline.setBounds(22, 207, 100, 30);
		frame.getContentPane().add(lblTimeline);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setOpaque(false);

		scrollPane.setBounds(21, 243, 639, 268);
		frame.getContentPane().add(scrollPane);
		try {
			ResultSet rs = DatabaseMySQL.getTimeline(user);
		table = new JTable(){public boolean isCellEditable(int rowIndex, int mColIndex) {return false; }};
		table.setOpaque(false);
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
			},
			new String[] {
				"Date", "Award"
			}
		));
		table.setFont(new Font("Arial", Font.PLAIN, 16));
		while (rs.next()){
			ArrayList<String[]> list = Review_DAO.AwardsList(user);
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			Object[] row = new Object[2];
			for (int j1 = 0; j1 < list.size(); j1++) {
				row[0] = list.get(j1)[0];
				row[1] = list.get(j1)[1];
				model.setRowCount(j1);
				model.addRow(row);	
			}
		}	
	}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Menu");
		mntmNewMenuItem.setHorizontalAlignment(SwingConstants.LEFT);
		mntmNewMenuItem.setFont(new Font("Arial", Font.PLAIN, 16));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				MainUser.main(user);
		}
		});
		mntmNewMenuItem.setBounds(22, 0, 75, 30);
		frame.getContentPane().add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Logout");
		mntmNewMenuItem_1.setFont(new Font("Arial", Font.PLAIN, 16));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.main(null);
				frame.dispose();
			}
		});
		mntmNewMenuItem_1.setBounds(106, 0, 84, 30);
		frame.getContentPane().add(mntmNewMenuItem_1);
		
		ImageIcon Sfondo= new ImageIcon("src/Immagini/Sfondo.jpg");
		Image scaledImage = Sfondo.getImage().getScaledInstance(700, 600, Image.SCALE_DEFAULT);
		Sfondo.setImage(scaledImage);
		JLabel lblNewLabel_5 = new JLabel(Sfondo);
		lblNewLabel_5.setBounds(0, 0, 684, 561);
		frame.getContentPane().add(lblNewLabel_5);
		
	}
	}
