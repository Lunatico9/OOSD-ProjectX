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
import javax.swing.ListSelectionModel;

public class PromotionDemotionModerator {

	private JFrame frame;
	private JTable table;
	private JButton btnUpdate;
	private JPanel panel;
	private Actor user;
	private String usernameSelected;

	/**
	 * Launch the application.
	 */
	public static void main(Actor user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PromotionDemotionModerator window = new PromotionDemotionModerator(user);
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
	public PromotionDemotionModerator(Actor user) throws Exception {
		this.user = user;
		initialize(user);
		
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
	private void initialize(Actor user) throws Exception {
		frame = new JFrame();
		frame.setTitle("Promotion or demotion");
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(323, 98, 300, 224);
		frame.getContentPane().add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("Clicca una cella della tabella");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel.setBounds(71, 177, 196, 29);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Clicca una cella della tabella");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(71, 266, 196, 29);
		frame.getContentPane().add(lblNewLabel_1);
		
		table = new JTable() {public boolean isCellEditable(int rowIndex, int mColIndex) {return false; }};
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
					String query;
					if (lblNewLabel_1.getText().equals("moderatore")) {
						 query = "UPDATE user SET type = '" + "giocatore" + "' WHERE username = '" + usernameSelected + "'";
					}
					else {
						 query = "UPDATE user SET type = '" + "moderatore" + "' WHERE username = '" + usernameSelected + "'";
					}
			    try {
			    	String a = lblNewLabel_1.getText();
			    	int i= table.getSelectedRow();
			    	if(a.equals("moderatore")) {
			    	table.getModel().setValueAt("giocatore", i, 1);
			    	lblNewLabel_1.setText("giocatore");
			    	}
			    	else {
			    	table.getModel().setValueAt("moderatore", i, 1);
			    	lblNewLabel_1.setText("moderatore");
			    	}
					ResultSet rst = DatabaseMySQL.SendQuery(query);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnUpdate.setBounds(509, 378, 132, 48);
		frame.getContentPane().add(btnUpdate);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Arial", Font.PLAIN, 18));
		lblUsername.setBounds(71, 137, 100, 29);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblType = new JLabel("Type");
		lblType.setFont(new Font("Arial", Font.PLAIN, 18));
		lblType.setBounds(71, 229, 100, 29);
		frame.getContentPane().add(lblType);
		
		panel = new JPanel();
		panel.setBounds(38, 63, 605, 293);
		frame.getContentPane().add(panel);
		panel.setBorder(BorderFactory.createTitledBorder(
		BorderFactory.createEtchedBorder(), "PROMUOVI O DEGRADA"));
		show_user();
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Menu");
		mntmNewMenuItem.setFont(new Font("Arial", Font.PLAIN, 18));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				MainModerator.main(user);
		}
		});
		mntmNewMenuItem.setBounds(6, 13, 78, 37);
		frame.getContentPane().add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Logout");
		mntmNewMenuItem_1.setFont(new Font("Arial", Font.PLAIN, 18));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.main(null);
				frame.dispose();
			}
		});
		mntmNewMenuItem_1.setBounds(90, 13, 100, 37);
		frame.getContentPane().add(mntmNewMenuItem_1);
	}
}
