package view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class MainUser {

	private JFrame frame;
	private Actor user;
	private ResultSet rst0, rstM, rst2 ;
	private int Media=0, Count=0, num=0;
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
		frame.setBounds(100, 100, 577, 564);
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
		
		//Recensione
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(46, 328, 500, 156);
		frame.getContentPane().add(lblNewLabel);
				
		//Recensito da:
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(46, 283, 185, 33);
		frame.getContentPane().add(lblNewLabel_1);
			
		//Voto
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(290, 283, 237, 33);
		frame.getContentPane().add(lblNewLabel_2);
		
		//Media
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(416, 0, 131, 33);
		frame.getContentPane().add(lblNewLabel_3);
				
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(46, 38, 500, 200);
		frame.getContentPane().add(scrollPane);
		
		JButton btnRecensioneSuccessiva = new JButton("Recensione Successiva");
		
		JButton btnNewButton_2 = new JButton("Recensione Precedente");
		if(num==0) btnNewButton_2.setVisible(false);
		else btnNewButton_2.setVisible(true);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					num=num-1;
					btnRecensioneSuccessiva.setVisible(true);
					if(num==1) btnNewButton_2.setVisible(false);
					else btnNewButton_2.setVisible(true);
					if(rst0.previous()){
						String query2= "Select username From user WHERE idUser='"+rst0.getString("user_iduser") +"'";
						rst2 = DatabaseMySQL.SendQuery(query2);
						lblNewLabel.setText(rst0.getString("text"));
						lblNewLabel_2.setText("Voto: " + rst0.getString("vote"));
						if(rst2.next())
						lblNewLabel_1.setText("Recensione di: "+ rst2.getString("username"));
						}
					
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} 
		});
		btnNewButton_2.setBounds(46, 491, 175, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		//Recensione Successiva
		if(Count<=num){
			btnRecensioneSuccessiva.setVisible(false);
		}
		else btnRecensioneSuccessiva.setVisible(true);
		btnRecensioneSuccessiva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					num=num+1;
					btnNewButton_2.setVisible(true);
					if(Count>num){
						btnRecensioneSuccessiva.setVisible(true);
					}
					else btnRecensioneSuccessiva.setVisible(false);
					if(num<=Count){
					if(rst0.next()){
						String query2= "Select username From user WHERE idUser='"+rst0.getString("user_iduser") +"'";
						ResultSet rst2= DatabaseMySQL.SendQuery(query2);
						rst2.next();
						lblNewLabel.setText(rst0.getString("text"));
						lblNewLabel_2.setText("Voto: " + rst0.getString("vote"));
						lblNewLabel_1.setText("Recensione di: "+ rst2.getString("username"));		
					}
					}
					if(Count==num){
						btnRecensioneSuccessiva.setVisible(false);
					}
					else btnRecensioneSuccessiva.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}	
		});
		btnRecensioneSuccessiva.setBounds(371, 491, 175, 23);
		frame.getContentPane().add(btnRecensioneSuccessiva);
	
		
		JList list = new JList();
		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				num=1;
				Media=0;
				Count=0;
				for (Game game : gamesObject){
					String gioco = (String) list.getSelectedValue();
					if(game.getName().equals(gioco)) {
						String query12="SELECT * From review Where'"+ game.getId()  + "'=Game_idGame AND Approved=1 ORDER BY idReview";
						try {
							rst0= DatabaseMySQL.SendQuery(query12);
							rstM= DatabaseMySQL.SendQuery(query12);
							}
						catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
				try {
					while(rstM.next()){
						Media = Media + rstM.getInt("vote");
						System.out.println(Media);
						Count=Count+1;
						System.out.println(Count);
					}
					if(Count != 0){
						Media /=  Count;
						lblNewLabel_3.setText("Media Voto: "+Media);
					}
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
					try {
						if(rst0.next()){
							String query2= "Select username From user WHERE idUser='"+rst0.getString("user_iduser") +"'";
							ResultSet rst2= DatabaseMySQL.SendQuery(query2);
							rst2.next();
							lblNewLabel.setText(rst0.getString("text"));
							lblNewLabel_2.setText("Voto: " + rst0.getString("vote"));
							lblNewLabel_1.setText("Recensione di:"+ rst2.getString("username"));
						}
						else{
							lblNewLabel.setText("Questo gioco non è ancora stato recensito!");
							lblNewLabel_2.setText("");
							lblNewLabel_1.setText("");
							lblNewLabel_3.setText("");
						}
					} 
					catch (Exception e) {
						e.printStackTrace();
					}
					
			if(Count>num){
				btnRecensioneSuccessiva.setVisible(true);
			}
			else btnRecensioneSuccessiva.setVisible(false);
			}
		});

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
		list.addKeyListener(new KeyAdapter(){
			  public void keyPressed(KeyEvent ke){
			    if(ke.getKeyCode() == KeyEvent.VK_DOWN || ke.getKeyCode() == KeyEvent.VK_UP)
			    {
			      ke.consume();
			    }}});
		
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