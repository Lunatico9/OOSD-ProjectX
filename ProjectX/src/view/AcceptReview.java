package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class AcceptReview {

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
	 */
	public AcceptReview() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
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
				
			}
		});
		Accetta.setBounds(46, 193, 138, 23);
		frame.getContentPane().add(Accetta);
		
		JButton Menù = new JButton("Menù");
		Menù.setBounds(173, 227, 89, 23);
		frame.getContentPane().add(Menù);
		
		JList listaReview = new JList();
		listaReview.setBounds(10, 11, 414, 171);
		frame.getContentPane().add(listaReview);
	}
}
