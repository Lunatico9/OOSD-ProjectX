package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.PromotionDemotionModeratorController;
import database.DatabaseMySQL;
import model.Actor;

import java.awt.Font;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
			ResultSet rst=DatabaseMySQL.selectUsers();
			Actor user1;
			while(rst.next()) {
				user1 = new Actor(rst.getString("username"), rst.getString("type"));
				if(!(rst.getString("username").equals(user.getUsername()))){
				usersList.add(user1);
				}
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
		frame.setBounds(100, 100, 700, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setOpaque(false);
		scrollPane.setBounds(316, 145, 300, 224);
		frame.getContentPane().add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("Clicca una cella della tabella");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setBounds(64, 219, 204, 29);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Clicca una cella della tabella");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(64, 308, 204, 29);
		frame.getContentPane().add(lblNewLabel_1);
		
		table = new JTable() {public boolean isCellEditable(int rowIndex, int mColIndex) {return false; }};
		table.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent ke) {
					    if(ke.getKeyCode() == KeyEvent.VK_DOWN || ke.getKeyCode() == KeyEvent.VK_UP)
					    {
					      ke.consume();
					    };
			}
		});
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
		table.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		
		btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(table.getSelectedRow()!=-1){
					try {
						PromotionDemotionModeratorController.Update(lblNewLabel_1.getText(), table.getSelectedRow(), usernameSelected);
					} catch (Exception e) {
						e.printStackTrace();
					}
					if(lblNewLabel_1.getText().equals("moderatore")) {
				    	table.getModel().setValueAt("giocatore", table.getSelectedRow(), 1);
				    	lblNewLabel_1.setText("giocatore");
				    	}
				    	else {
				    	table.getModel().setValueAt("moderatore", table.getSelectedRow(), 1);
				    	lblNewLabel_1.setText("moderatore");
				    	}
				}
				
			}
		});
		btnUpdate.setBounds(508, 487, 132, 48);
		frame.getContentPane().add(btnUpdate);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblUsername.setBounds(64, 179, 100, 29);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblType = new JLabel("Type");
		lblType.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblType.setBounds(64, 271, 100, 29);
		frame.getContentPane().add(lblType);
		
		panel = new JPanel();
		panel.setOpaque(false);
		panel.setBounds(36, 75, 605, 379);
		frame.getContentPane().add(panel);
		panel.setBorder(BorderFactory.createTitledBorder(
		BorderFactory.createEtchedBorder(), "PROMUOVI O DEGRADA"));
		show_user();
		
		ImageIcon Menu= new ImageIcon("src/Immagini/menu.png");
		Image scaledMenu = Menu.getImage().getScaledInstance(122, 40, Image.SCALE_DEFAULT);
		Menu.setImage(scaledMenu);
		
		JButton mntmNewMenuItem = new JButton(Menu);
		mntmNewMenuItem.setOpaque(false);
		mntmNewMenuItem.setContentAreaFilled(false);
		mntmNewMenuItem.setBorderPainted(false);
		mntmNewMenuItem.setFont(new Font("Times New Roman", Font.BOLD, 18));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				MainModerator.main(user);
		}
		});
		mntmNewMenuItem.setBounds(6, 11, 122, 40);
		frame.getContentPane().add(mntmNewMenuItem);
		
		ImageIcon Logout= new ImageIcon("src/Immagini/logout.png");
		Image scaledLogout = Logout.getImage().getScaledInstance(122, 40, Image.SCALE_DEFAULT);
		Logout.setImage(scaledLogout);
		
		JButton mntmNewMenuItem_1 = new JButton(Logout);
		mntmNewMenuItem_1.setBorderPainted(false);
		mntmNewMenuItem_1.setOpaque(false);
		mntmNewMenuItem_1.setContentAreaFilled(false);
		mntmNewMenuItem_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.main(null);
				frame.dispose();
			}
		});
		mntmNewMenuItem_1.setBounds(137, 11, 122, 40);
		frame.getContentPane().add(mntmNewMenuItem_1);
		
		ImageIcon Sfondo= new ImageIcon("src/Immagini/Sfondo.jpg");
		Image scaledImage = Sfondo.getImage().getScaledInstance(700, 600, Image.SCALE_DEFAULT);
		Sfondo.setImage(scaledImage);
		JLabel lblNewLabel_5 = new JLabel(Sfondo);
		lblNewLabel_5.setBounds(0, 0, 684, 561);
		frame.getContentPane().add(lblNewLabel_5);
	}
}
