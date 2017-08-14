package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.AddGameController;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class AddGame {

	private JFrame frame;
	private JTextField textTitle;
	private JTextField txtData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddGame window = new AddGame();
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
	public AddGame() {
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
		
		JLabel lbl = new JLabel("Titolo:");
		lbl.setBounds(95, 110, 45, 21);
		frame.getContentPane().add(lbl);
		
		JLabel lblTitle = new JLabel("Inserisci nuovo gioco");
		lblTitle.setBounds(151, 23, 150, 21);
		frame.getContentPane().add(lblTitle);
		
		txtData = new JTextField();
		txtData.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
					txtData.setText("");
			}
		});
		txtData.setText("dd/mm/aaaa");
		txtData.setToolTipText("dd/mm/aaaa");
		txtData.setBounds(150, 170, 121, 22);
		frame.getContentPane().add(txtData);
		txtData.setColumns(10);
		
		JComboBox<String> comboBoxGenere = new JComboBox<String>();
		comboBoxGenere.setModel(new DefaultComboBoxModel<String>(new String[] {"Azione", "Avventura", "MMO", "RPG", "Simulazione", "Sparatutto", "Sport", "Strategico"}));
		comboBoxGenere.setBounds(151, 141, 106, 18);
		frame.getContentPane().add(comboBoxGenere);
		
		textTitle = new JTextField();
		textTitle.setBounds(150, 110, 121, 21);
		frame.getContentPane().add(textTitle);
		textTitle.setColumns(10);
		
		JButton btnNewButton = new JButton("Aggiungi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					AddGameController.AddGame(textTitle.getText(), (String)comboBoxGenere.getSelectedItem() , txtData.getText());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(151, 211, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblGenere = new JLabel("Genere:");
		lblGenere.setBounds(95, 142, 46, 21);
		frame.getContentPane().add(lblGenere);
		
		
		
		JLabel lblDataDiUscita = new JLabel("Data di uscita:");
		lblDataDiUscita.setBounds(52, 174, 89, 18);
		frame.getContentPane().add(lblDataDiUscita);
		
		
	}
}
