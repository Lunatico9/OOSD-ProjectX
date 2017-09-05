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
		
		JLabel label = new JLabel("");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		String query= "Select text From review WHERE approved=0";
		ResultSet rst= DatabaseMySQL.SendQuery(query);
		if(rst.next()){
		review= rst.getString(1);
		}
		else label.setText("Non ci sono review in attesa");
		label.setText(review);
		label.setBounds(10, 26, 414, 159);
		frame.getContentPane().add(label);
		
		JButton Rifiuta = new JButton("Rifiuta Review");
		Rifiuta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		Rifiuta.setBounds(255, 193, 126, 23);
		frame.getContentPane().add(Rifiuta);
		
		JButton Accetta = new JButton("Accetta Review");
		Accetta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String text=label.getText(), query="SELECT idReview FROM review WHERE text="+text+"";
				ResultSet rst;
				try {
					rst = DatabaseMySQL.SendQuery(query);
					if(rst.next()){
						AcceptReviewController.Accetta(rst.getInt(1));
						}
					}
					catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		Accetta.setBounds(46, 193, 138, 23);
		frame.getContentPane().add(Accetta);
		
		JButton Menù = new JButton("Menù");
		Menù.setBounds(173, 227, 89, 23);
		frame.getContentPane().add(Menù);	
		
	}
}
