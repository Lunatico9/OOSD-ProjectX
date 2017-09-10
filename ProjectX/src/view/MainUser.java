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

import controller.MainUserController;
import database.DatabaseMySQL;
import javax.swing.JMenuItem;

public class MainUser {

	private JFrame frame;
	private String username;
	private String type;
	/**
	 * Launch the application.
	 */
	public static void main(String username, String type) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainUser window = new MainUser(username, type);
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
	public MainUser(String username, String type) throws Exception {
		this.username = username;
		this.type = type;
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
				Play.main(username, game, type);
				frame.dispose();
			}
		});
		btnGioca.setBounds(122, 227, 89, 23);
		frame.getContentPane().add(btnGioca);
		
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Logout");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.main(null);
				frame.dispose();
			}
		});
		mntmNewMenuItem_1.setBounds(0, 0, 72, 22);
		frame.getContentPane().add(mntmNewMenuItem_1);
		
		JButton btnNewButton = new JButton("Recensisci");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AddReview.main(username, list.getSelectedValue().toString());
			}
		});
		btnNewButton.setBounds(227, 227, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Funzioni moderatore ");
		mntmNewMenuItem.setVisible(false);
		String a = "moderatore";
		if(type.equals(a))
			mntmNewMenuItem.setVisible(true);
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				MainModerator.main(username);
			}
		});
		mntmNewMenuItem.setBounds(82, 0, 144, 22);
		frame.getContentPane().add(mntmNewMenuItem);
		
		JButton btnNewButton_1 = new JButton("Profilo Personale");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainUserController.Profilo(username);
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(301, 168, 123, 23);
		frame.getContentPane().add(btnNewButton_1);
	}
}
