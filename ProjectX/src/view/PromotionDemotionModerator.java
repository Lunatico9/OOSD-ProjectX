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
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PromotionDemotionModerator {

	private JFrame frame;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnUpdate;

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
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(297, 94, 300, 224);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int a = table.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				textField.setText(model.getValueAt(a,0).toString());
				textField_1.setText(model.getValueAt(a,1).toString());
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
				"username", "type"
			}
		));
		table.setFont(new Font("Arial", Font.PLAIN, 16));
		
		textField = new JTextField();
		textField.setBounds(48, 99, 116, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(48, 161, 116, 22);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String query = "UPDATE user SET username = '" + textField.getText() + "', type = '" + textField_1.getText() + "'";
			    try {
					ResultSet rst = DatabaseMySQL.SendQuery(query);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnUpdate.setBounds(56, 380, 97, 25);
		frame.getContentPane().add(btnUpdate);
		show_user();
	}
}
