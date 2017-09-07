package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import database.DatabaseMySQL;
import model.Actor;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class PromotionDemotionModerator {

	private JFrame frame;
	private JTable table;
	private JButton btnUpdate;
	private JPanel panel;
	private String usernameSelected;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PromotionDemotionModerator window = new PromotionDemotionModerator();
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
	public PromotionDemotionModerator() throws Exception {
		initialize();
		
	}

	public ArrayList<Actor> userList() throws Exception {
		ArrayList<Actor> usersList = new ArrayList<Actor>();
		try {
			String query = "SELECT * FROM user";
			ResultSet rst = DatabaseMySQL.SendQuery(query);
			Actor user;
			while(rst.next()) {
				user = new Actor(rst.getString("username"), rst.getString("type"));
				usersList.add(user);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return usersList;
	}
	
	public void show_user() throws Exception {
		ArrayList<Actor> list = userList();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object[] row = new Object[2];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getUsername();
			row[1] = list.get(i).getType();
			model.setRowCount(i);
			model.addRow(row);		
		}
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws Exception {
		frame = new JFrame();
		frame.setTitle("Promotion or demotion");
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(323, 98, 300, 224);
		frame.getContentPane().add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel.setBounds(71, 177, 100, 29);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(71, 266, 100, 29);
		frame.getContentPane().add(lblNewLabel_1);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int a = table.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				lblNewLabel.setText(model.getValueAt(a,0).toString());
				lblNewLabel_1.setText(model.getValueAt(a,1).toString());
				usernameSelected = lblNewLabel.getText();
			}
		});
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
				"Username", "Type"
			}
		));
		table.setFont(new Font("Arial", Font.PLAIN, 16));
		
		btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Arial", Font.PLAIN, 18));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					String m = "moderatore";
					String b = "giocatore";
					String query;
					if (lblNewLabel_1.getText().equals(m)) {
						 query = "UPDATE user SET type = '" + b + "' WHERE username = '" + usernameSelected + "'";
					}
					else {
						 query = "UPDATE user SET type = '" + m + "' WHERE username = '" + usernameSelected + "'";
					}
			    try {
			    	String a = lblNewLabel_1.getText();
			    	int i= table.getSelectedRow();
			    	if(a.equals(m)) {
			    	table.getModel().setValueAt(b, i, 1);
			    	lblNewLabel_1.setText(b);
			    	}
			    	else {
			    	table.getModel().setValueAt(m, i, 1);
			    	lblNewLabel_1.setText(m);
			    	}
					ResultSet rst = DatabaseMySQL.SendQuery(query);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnUpdate.setBounds(39, 381, 132, 48);
		frame.getContentPane().add(btnUpdate);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Arial", Font.PLAIN, 18));
		lblUsername.setBounds(71, 137, 100, 29);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblType = new JLabel("Type");
		lblType.setFont(new Font("Arial", Font.PLAIN, 18));
		lblType.setBounds(71, 229, 100, 29);
		frame.getContentPane().add(lblType);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Logout");
		mntmNewMenuItem_1.setFont(new Font("Arial", Font.PLAIN, 20));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.main(null);
				frame.dispose();
			}
		});
		mntmNewMenuItem_1.setBounds(511, 381, 132, 48);
		frame.getContentPane().add(mntmNewMenuItem_1);
		
		panel = new JPanel();
		panel.setBounds(38, 63, 605, 293);
		frame.getContentPane().add(panel);
		panel.setBorder(BorderFactory.createTitledBorder(
		BorderFactory.createEtchedBorder(), "PROMUOVI O DEGRADA"));
		show_user();
	}
}
