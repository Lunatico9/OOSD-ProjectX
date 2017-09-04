package view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.AbstractListModel;
import javax.swing.JScrollPane;

import database.DatabaseMySQL;

public class MainUser {

	private JFrame frame;
	private String username;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainUser window = new MainUser();
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
	public MainUser() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize() throws Exception {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		ArrayList<String> games = new ArrayList<String>();
		String query = "SELECT name FROM game";
		ResultSet rst = DatabaseMySQL.SendQuery(query);
		while(rst.next()) {
			games.add(rst.getString(1));
		}
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login logout = new Login();
				logout.main(null);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		btnLogout.setBounds(307, 227, 101, 23);
		frame.getContentPane().add(btnLogout);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(46, 38, 245, 153);
		frame.getContentPane().add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		list.setModel(new AbstractListModel() {
			ArrayList<String> values = games;
			public int getSize() {
				return values.size();
			}
			public Object getElementAt(int index) {
				return values.get(index);
			}
		});
		
		JButton btnGioca = new JButton("Gioca");
		btnGioca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String game = (String) list.getSelectedValue();
				Play.main(username, game);
				frame.dispose();
			}
		});
		btnGioca.setBounds(122, 227, 89, 23);
		frame.getContentPane().add(btnGioca);
	}

}
