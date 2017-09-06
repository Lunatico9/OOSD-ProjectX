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
import javax.swing.JPanel;

public class PromotionDemotionModerator {

	private JFrame frame;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnUpdate;
	private JPanel panel;

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
				"Username", "Type"
			}
		));
		table.setFont(new Font("Arial", Font.PLAIN, 16));
		
		textField = new JTextField();
		textField.setBounds(72, 158, 163, 27);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(72, 251, 163, 27);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Arial", Font.PLAIN, 18));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					String query = "UPDATE user SET type = '" + textField_1.getText() + "' WHERE username = '" + textField.getText() + "'";
			    try {
			    	String a = textField_1.getText();
			    	int i= table.getSelectedRow();
			    	table.getModel().setValueAt(a, i, 1);
					ResultSet rst = DatabaseMySQL.SendQuery(query);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnUpdate.setBounds(39, 381, 132, 48);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnModeratore = new JButton("Main");
		btnModeratore.setFont(new Font("Arial", Font.PLAIN, 18));
		btnModeratore.setBounds(509, 381, 132, 48);
		frame.getContentPane().add(btnModeratore);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Arial", Font.PLAIN, 18));
		lblUsername.setBounds(72, 116, 100, 29);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblType = new JLabel("Type");
		lblType.setFont(new Font("Arial", Font.PLAIN, 18));
		lblType.setBounds(72, 213, 100, 29);
		frame.getContentPane().add(lblType);
		
		panel = new JPanel();
		panel.setBounds(38, 63, 605, 293);
		frame.getContentPane().add(panel);
		panel.setBorder(BorderFactory.createTitledBorder(
		BorderFactory.createEtchedBorder(), "PROMUOVI O DEGRADA"));
		show_user();
	}
}
