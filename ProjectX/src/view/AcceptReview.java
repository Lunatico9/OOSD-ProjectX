package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextPane;

import database.DatabaseMySQL;
import model.Actor;
import model.dao.Game_DAO;
import model.dao.Review_DAO;

import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;

import controller.AcceptReviewController;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.JProgressBar;

public class AcceptReview {
	
	private boolean x=false;
	private String review, nomegioco, nomeutente;
	private int vote,id,idgioco,idutente;
	private JFrame frame;
	private Actor user;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(Actor user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AcceptReview window = new AcceptReview(user);
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
	public AcceptReview(Actor user) throws Exception {
		this.user = user;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize() throws Exception {
		frame = new JFrame();
		frame.setTitle("Accept review");
		frame.setBounds(100, 100, 700, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		ResultSet result= Review_DAO.ReviewDaValutare();
		if(result.next()){
			x=true;
			review=result.getString("text");
			id=result.getInt("idReview");
			vote=result.getInt("vote");
			idgioco=result.getInt("Game_idGame");
			idutente=result.getInt("user_iduser");
		}
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		if(x){
			lblNewLabel.setText(vote+"/10");
		}
		else lblNewLabel.setText("0/10");
		lblNewLabel.setBounds(452, 106, 180, 30);
		frame.getContentPane().add(lblNewLabel);
		
		//VOTO
		JLabel Voto = new JLabel("");
		Voto.setFont(new Font("Times New Roman", Font.BOLD, 16));
		Voto.setHorizontalAlignment(SwingConstants.CENTER);
		Voto.setBounds(452, 68, 180, 40);
		Voto.setText("Voto");
		frame.getContentPane().add(Voto);
		
        //Barra Voto
		JProgressBar progressBar = new JProgressBar(0,10);
		if(x){
			progressBar.setValue(vote);
			}
		else progressBar.setValue(0);
		if(vote <= 3){
			progressBar.setForeground(Color.RED);
		}
		else if(vote>3 && vote<=6){
			progressBar.setForeground(Color.YELLOW);
		}
		else progressBar.setForeground(Color.GREEN);
		progressBar.setBounds(452, 106, 180, 30);
		frame.getContentPane().add(progressBar);
				
		//UTENTE
		JLabel Utente = new JLabel("");
		Utente.setFont(new Font("Times New Roman", Font.BOLD, 16));
		Utente.setHorizontalAlignment(SwingConstants.CENTER);
		if(x){
			ResultSet nome= DatabaseMySQL.selectUsername(idutente);
			if(nome.next()){
				nomeutente=nome.getString(1);
				Utente.setText("Recensione di: " + nome.getString(1) );
			 }
			}
		else Utente.setText("Recensione di: ");
		Utente.setBounds(237, 96, 180, 40);
		frame.getContentPane().add(Utente);
				
		//GIOCO
		JLabel Gioco = new JLabel("");
		Gioco.setBackground(Color.WHITE);
		Gioco.setFont(new Font("Times New Roman", Font.BOLD, 16));
		Gioco.setHorizontalAlignment(SwingConstants.LEFT);
		if(x){
			ResultSet gioco= Game_DAO.selectGame(idgioco);
			if(gioco.next()){
			nomegioco= gioco.getString(1);
			Gioco.setText("Gioco: "+nomegioco);
			}
		}
		else Gioco.setText("Gioco: ");
		Gioco.setBounds(10, 96, 180, 40);
		frame.getContentPane().add(Gioco);
		
		//COMMENTO
		JTextArea Commento = new JTextArea("");
		Commento.setBorder(BorderFactory.createLineBorder(Color.black));
		Commento.setLineWrap(true);
		Commento.setEditable(false);
		Commento.setWrapStyleWord(true);
		Commento.setBackground(Color.WHITE);
		Commento.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		Commento.setText(review);
		Commento.setBounds(77, 203, 529, 227);
		frame.getContentPane().add(Commento);
		
		//RIFIUTA
		JButton Rifiuta = new JButton("Rifiuta Review");
		Rifiuta.setFont(new Font("Times New Roman", Font.BOLD, 16));
		if(!x){
			Rifiuta.setVisible(false);
		}
		Rifiuta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String text=Commento.getText();
				int ID=id;
				int voto=vote;
				int gioco=idgioco;
				int users=idutente;
				try {
					AcceptReviewController.Rifiuta(ID, text, gioco, users, voto);
					if(result.next()){
						review= result.getString("text");
						id=result.getInt("idReview");
						vote=result.getInt("vote");
						idgioco=result.getInt("Game_idGame");
						idutente=result.getInt("user_iduser");
						Commento.setText(result.getString("text"));
						ResultSet gioco2= Game_DAO.selectGame(idgioco);
						if(gioco2.next()){
							lblNewLabel.setText(vote+"/10");
							progressBar.setValue(vote);
							if(vote <= 3){
								progressBar.setForeground(Color.RED);
							}
							else if(vote>3 && vote<=6){
								progressBar.setForeground(Color.YELLOW);
							}
							else progressBar.setForeground(Color.GREEN);
							Gioco.setText("Gioco: " + gioco2.getString(1));
							Voto.setText("Voto");
							ResultSet nome= DatabaseMySQL.selectUsername(idutente);
							nome.next();
							Utente.setText("Recensione di: " + nome.getString(1));
						}
					}
					else{
						Commento.setText("");
						Gioco.setText("Gioco: ");
						Utente.setText("Recensione di: ");
						Voto.setText("Voto");
						lblNewLabel.setText("0/10");
						progressBar.setValue(0);
						JOptionPane.showMessageDialog(null, "Non ci sono altre recensioni da confermare");
						MainModerator.main(user);
						frame.dispose();
					}
				}
				catch (Exception e) {
					e.printStackTrace();
				}				
			}
		});
		Rifiuta.setBounds(456, 479, 150, 48);
		frame.getContentPane().add(Rifiuta);
		
		//ACCETTA
		JButton Accetta = new JButton("Accetta Review");
		Accetta.setFont(new Font("Times New Roman", Font.BOLD, 16));
		if(!x){
			Accetta.setVisible(false);
		}
		Accetta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String text=Commento.getText();
				int ID=id;
				int voto=vote;
				int gioco=idgioco;
				int users=idutente;
				try {
					AcceptReviewController.Accetta(ID, text, gioco, users, voto);
					if(result.next()){
						review= result.getString("text");
						id=result.getInt("idReview");
						vote=result.getInt("vote");
						idgioco=result.getInt("Game_idGame");
						idutente=result.getInt("user_iduser");
						Commento.setText(result.getString("text"));
						ResultSet gioco2= Game_DAO.selectGame(idgioco);
						if(gioco2.next()){
							lblNewLabel.setText(vote+"/10");
							progressBar.setValue(vote);
							if(vote <= 3){
								progressBar.setForeground(Color.RED);
							}
							else if(vote>3 && vote<=6){
								progressBar.setForeground(Color.YELLOW);
							}
							else progressBar.setForeground(Color.GREEN);
							Gioco.setText("Gioco: " + gioco2.getString(1));
							Voto.setText("Voto");
							ResultSet nome= DatabaseMySQL.selectUsername(idutente);
							nome.next();
							Utente.setText("Recensione di: " + nome.getString(1));
						}
					}
					else{
						Commento.setText("");
						Gioco.setText("Gioco: ");
						Utente.setText("Recensione di: ");
						Voto.setText("Voto");
						lblNewLabel.setText("0/10");
						progressBar.setValue(0);
						JOptionPane.showMessageDialog(null, "Non ci sono altre recensioni da confermare");
						MainModerator.main(user);
						frame.dispose();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		Accetta.setBounds(77, 479, 150, 48);
		frame.getContentPane().add(Accetta);
		
		ImageIcon Menu= new ImageIcon("src/Immagini/menu.png");
		Image scaledMenu = Menu.getImage().getScaledInstance(122, 40, Image.SCALE_DEFAULT);
		Menu.setImage(scaledMenu);
		
		JButton mntmNewMenuItem = new JButton(Menu);
		mntmNewMenuItem.setOpaque(false);
		mntmNewMenuItem.setContentAreaFilled(false);
		mntmNewMenuItem.setBorderPainted(false);
		mntmNewMenuItem.setFont(new Font("Times New Roman", Font.BOLD, 16));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				String type = "user";
				if(type.equals("user"))
					MainModerator.main(user);
		}
		});
		mntmNewMenuItem.setBounds(10, 11, 122, 40);
		frame.getContentPane().add(mntmNewMenuItem);
		
		
		ImageIcon Logout= new ImageIcon("src/Immagini/logout.png");
		Image scaledLogout = Logout.getImage().getScaledInstance(122, 40, Image.SCALE_DEFAULT);
		Logout.setImage(scaledLogout);
		
		JButton mntmNewMenuItem_1 = new JButton(Logout);
		mntmNewMenuItem_1.setBorderPainted(false);
		mntmNewMenuItem_1.setContentAreaFilled(false);
		mntmNewMenuItem_1.setOpaque(false);
		mntmNewMenuItem_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.main(null);
				frame.dispose();
			}
		});
		mntmNewMenuItem_1.setBounds(155, 11, 122, 40);
		frame.getContentPane().add(mntmNewMenuItem_1);
		
		ImageIcon Sfondo= new ImageIcon("src/Immagini/Sfondo.jpg");
		Image scaledImage = Sfondo.getImage().getScaledInstance(700, 600, Image.SCALE_DEFAULT);
		Sfondo.setImage(scaledImage);
		JLabel lblNewLabel_5 = new JLabel(Sfondo);
		lblNewLabel_5.setBounds(0, 0, 684, 561);
		frame.getContentPane().add(lblNewLabel_5);
		
	}
}