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
import model.Actor;
import model.Game;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MainUser {

	private JFrame frame;
	private Actor user;
	/**
	 * Launch the application.
	 */
	public static void main(Actor user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainUser window = new MainUser(user);
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
	public MainUser(Actor user) throws Exception {
		this.user = user;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize() throws Exception {
		frame = new JFrame();
		frame.setBounds(100, 100, 577, 320);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		ArrayList<Game> gamesObject = new ArrayList<Game>();
		ArrayList<String> games = new ArrayList<String>();
		String query = "SELECT * FROM game";
		ResultSet rst = DatabaseMySQL.SendQuery(query);
		while(rst.next()) {
			Game a = new Game(rst.getInt("idGame"), rst.getString("name"), 0);
			gamesObject.add(a);
			games.add(rst.getString("name"));
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(46, 38, 500, 200);
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
				if(!list.isSelectionEmpty()) {
					String gioco = (String) list.getSelectedValue();
					for (Game game : gamesObject) {
						if(game.getName().equals(gioco)) {
							Play.main(user, game);
							frame.dispose();
						}
					}
				}
				else JOptionPane.showMessageDialog(null, "Seleziona un gioco dalla lista!");
			}
		});
		btnGioca.setBounds(82, 249, 89, 23);
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
				if(list.isSelectionEmpty()){
					JOptionPane.showMessageDialog(null, "Seleziona un gioco dalla lista!");	
				}
				if(!list.isSelectionEmpty()) {
					String gioco = (String) list.getSelectedValue();
					try {
						if(!MainUserController.Recensisci(user,gioco)){
						for (Game game : gamesObject) {
							if(game.getName().equals(gioco)) {
								frame.dispose();
								AddReview.main(user, game);
							}
						}
						}
					}
					catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setBounds(245, 249, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Funzioni moderatore ");
		mntmNewMenuItem.setVisible(false);
		if(user.getType().equals("moderatore"))
			mntmNewMenuItem.setVisible(true);
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				MainModerator.main(user);
			}
		});
		mntmNewMenuItem.setBounds(82, 0, 144, 22);
		frame.getContentPane().add(mntmNewMenuItem);
		
		JButton btnNewButton_1 = new JButton("Profilo Personale");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainUserController.Profilo(user);
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(416, 249, 123, 23);
		frame.getContentPane().add(btnNewButton_1);
	}
}
