package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JList;
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
	
	private String review;
	private int vote,id,idgioco,idutente;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AcceptReview window = new AcceptReview();
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
	public AcceptReview() throws Exception {
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
		
		//COMMENTO
		JLabel label = new JLabel("");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		String queryTOT= "Select text, idReview, Game_idGame, user_iduser, vote From review WHERE approved=0";
		ResultSet rst= DatabaseMySQL.SendQuery(queryTOT);
		if(rst.next()){
		review= rst.getString("text");
		id=rst.getInt("idReview");
		vote=rst.getInt("vote");
		idgioco=rst.getInt("Game_idGame");
		idutente=rst.getInt("user_iduser");
		}
		else label.setText("Non ci sono review in attesa");
		label.setText(review);
		label.setBounds(10, 26, 414, 159);
		frame.getContentPane().add(label);
		
		//VOTO
		JLabel lblVoto = new JLabel("");
		lblVoto.setHorizontalAlignment(SwingConstants.CENTER);
		lblVoto.setBounds(334, 149, 90, 37);
		lblVoto.setText("Voto:"+ vote);
		frame.getContentPane().add(lblVoto);
		
		//UTENTE
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		String Nome="SELECT username FROM user WHERE idUser='"+idutente+"'";
		ResultSet nome= DatabaseMySQL.SendQuery(Nome);
		nome.next();
		lblNewLabel.setText("Recensione di: " + nome.getString(1) );
		lblNewLabel.setBounds(212, 26, 212, 23);
		frame.getContentPane().add(lblNewLabel);
		
		//GIOCO
		JLabel label_1 = new JLabel("");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		String GIOCO="SELECT name FROM game WHERE idGame='"+idgioco+"'";
		ResultSet gioco= DatabaseMySQL.SendQuery(GIOCO);
		gioco.next();
		label_1.setText("Gioco: " + gioco.getString(1));
		label_1.setBounds(10, 26, 174, 28);
		frame.getContentPane().add(label_1);
		
		//RIFIUTA
		JButton Rifiuta = new JButton("Rifiuta Review");
		Rifiuta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
								
			}
		});
		Rifiuta.setBounds(255, 193, 126, 23);
		frame.getContentPane().add(Rifiuta);
		
		//ACCETTA
		JButton Accetta = new JButton("Accetta Review");
		Accetta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String text=label.getText();
				int ID=id;
				int voto=vote;
				int gioco=idgioco;
				int user=idutente;
				try {
					AcceptReviewController.Accetta(ID, text, gioco, user, voto);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		Accetta.setBounds(46, 193, 138, 23);
		frame.getContentPane().add(Accetta);
		
		//MENU
		JButton Menù = new JButton("Menù");
		Menù.setBounds(173, 227, 89, 23);
		frame.getContentPane().add(Menù);	

	}
}
