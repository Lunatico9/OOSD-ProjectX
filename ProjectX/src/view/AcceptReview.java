package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
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

import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;

import controller.AcceptReviewController;

import java.awt.Font;

public class AcceptReview {
	
	private boolean x=false;
	private String review, nomegioco, nomeutente;
	private int vote,id,idgioco,idutente;
	private JFrame frame;
	private String username;
	
	 
	/**
	 * Launch the application.
	 */
	public static void main(String username) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AcceptReview window = new AcceptReview(username);
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
	public AcceptReview(String username) throws Exception {
		this.username = username;
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
		
		String queryTOTALE= "Select text, idReview, Game_idGame, user_iduser, vote From review WHERE approved=0";
		ResultSet result= DatabaseMySQL.SendQuery(queryTOTALE);
		if(result.next()){
			x=true;
			review=result.getString("text");
			id=result.getInt("idReview");
			vote=result.getInt("vote");
			idgioco=result.getInt("Game_idGame");
			idutente=result.getInt("user_iduser");
		}
		
		//VOTO
		JLabel Voto = new JLabel("");
		Voto.setHorizontalAlignment(SwingConstants.CENTER);
		Voto.setBounds(334, 149, 90, 37);
		if(x){
		Voto.setText("Voto:"+ vote);
		}
		else Voto.setText("Voto:");
		frame.getContentPane().add(Voto);
				
		//UTENTE
		JLabel Utente = new JLabel("");
		Utente.setHorizontalAlignment(SwingConstants.CENTER);
		if(x){
			String Nome="SELECT username FROM user WHERE idUser='"+idutente+"'";
			ResultSet nome= DatabaseMySQL.SendQuery(Nome);
			if(nome.next()){
				nomeutente=nome.getString(1);
				Utente.setText("Recensione di: " + nome.getString(1) );
			 }
			}
		else Utente.setText("Recensione di: ");
		Utente.setBounds(212, 26, 212, 23);
		frame.getContentPane().add(Utente);
				
		//GIOCO
		JLabel Gioco = new JLabel("");
		Gioco.setHorizontalAlignment(SwingConstants.CENTER);
		if(x){
			String GIOCO="SELECT name FROM game WHERE idGame='"+idgioco+"'";
			ResultSet gioco= DatabaseMySQL.SendQuery(GIOCO);
			if(gioco.next()){
			nomegioco= gioco.getString(1);
			}
		}
		else Gioco.setText("Gioco: ");
		Gioco.setBounds(10, 26, 174, 28);
		frame.getContentPane().add(Gioco);
		
		//COMMENTO
		JLabel Commento = new JLabel("");
		Commento.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		Commento.setHorizontalAlignment(SwingConstants.CENTER);
		String queryTOT= "Select text, idReview, Game_idGame, user_iduser, vote From review WHERE approved=0";
		ResultSet rst= DatabaseMySQL.SendQuery(queryTOT);
		if(rst.next()){
		review= rst.getString("text");
		id=rst.getInt("idReview");
		vote=rst.getInt("vote");
		idgioco=rst.getInt("Game_idGame");
		idutente=rst.getInt("user_iduser");
		Commento.setText(review);
		Gioco.setText("Gioco:" + nomegioco);
		Utente.setText("Recensione di:" + nomeutente);
		Voto.setText("Voto:" + vote);
		}
		else{ 
			Commento.setText("Non ci sono recensioni da confermare");
			Gioco.setText("Gioco: ");
			Utente.setText("Recensione di: ");
			Voto.setText("Voto: ");
		}
		Commento.setBounds(10, 26, 414, 159);
		frame.getContentPane().add(Commento);
		
		//RIFIUTA
		JButton Rifiuta = new JButton("Rifiuta Review");
		Rifiuta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String text=Commento.getText();
				int ID=id;
				int voto=vote;
				int gioco=idgioco;
				int user=idutente;
				try {
					AcceptReviewController.Rifiuta(ID, text, gioco, user, voto);
					if(rst.next()){
						review= rst.getString("text");
						id=rst.getInt("idReview");
						vote=rst.getInt("vote");
						idgioco=rst.getInt("Game_idGame");
						idutente=rst.getInt("user_iduser");
						Commento.setText(rst.getString("text"));
						String GIOCO="SELECT name FROM game WHERE idGame='"+idgioco+"'";
						ResultSet gioco2= DatabaseMySQL.SendQuery(GIOCO);
						gioco2.next();
						Gioco.setText("Gioco: " + gioco2.getString(1));
						Voto.setText("Voto:"+ vote);
						String Nome="SELECT username FROM user WHERE idUser='"+idutente+"'";
						ResultSet nome= DatabaseMySQL.SendQuery(Nome);
						nome.next();
						Utente.setText("Recensione di: " + nome.getString(1));
					}
					else{
						Commento.setText("Non ci sono recensioni da confermare");
						Gioco.setText("Gioco: ");
						Utente.setText("Recensione di: ");
						Voto.setText("Voto: ");
					}
				}
				catch (Exception e) {
					e.printStackTrace();
				}				
			}
		});
		Rifiuta.setBounds(255, 193, 126, 23);
		frame.getContentPane().add(Rifiuta);
		
		//ACCETTA
		JButton Accetta = new JButton("Accetta Review");
		Accetta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String text=Commento.getText();
				int ID=id;
				int voto=vote;
				int gioco=idgioco;
				int user=idutente;
				try {
					AcceptReviewController.Accetta(ID, text, gioco, user, voto);
					if(rst.next()){
						review= rst.getString("text");
						id=rst.getInt("idReview");
						vote=rst.getInt("vote");
						idgioco=rst.getInt("Game_idGame");
						idutente=rst.getInt("user_iduser");
						Commento.setText(rst.getString("text"));
						String GIOCO="SELECT name FROM game WHERE idGame='"+idgioco+"'";
						ResultSet gioco2= DatabaseMySQL.SendQuery(GIOCO);
						gioco2.next();
						Gioco.setText("Gioco: " + gioco2.getString(1));
						Voto.setText("Voto:"+ vote);
						String Nome="SELECT username FROM user WHERE idUser='"+idutente+"'";
						ResultSet nome= DatabaseMySQL.SendQuery(Nome);
						nome.next();
						Utente.setText("Recensione di: " + nome.getString(1));
					}
					else{
						Commento.setText("Non ci sono recensioni da confermare");
						Gioco.setText("Gioco: ");
						Utente.setText("Recensione di: ");
						Voto.setText("Voto: ");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		Accetta.setBounds(46, 193, 138, 23);
		frame.getContentPane().add(Accetta);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Menu");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				String type = "user";
				if(type.equals("user"))
					MainModerator.main(username);
		}
		});
		mntmNewMenuItem.setBounds(0, 0, 70, 22);
		frame.getContentPane().add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Logout");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.main(null);
				frame.dispose();
			}
		});
		mntmNewMenuItem_1.setBounds(69, 0, 81, 22);
		frame.getContentPane().add(mntmNewMenuItem_1);
	}
}