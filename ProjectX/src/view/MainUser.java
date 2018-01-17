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
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import controller.MainUserController;
import controller.PlayController;
import database.DatabaseMySQL;
import model.Actor;
import model.Game;
import model.dao.Review_DAO;
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
import java.io.File;
import java.io.IOException;
import java.beans.PropertyChangeEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Component;

import javax.swing.UIManager;
import java.awt.Font;
import java.awt.Image;

public class MainUser {

	private JFrame frame;
	private Actor user;
	private ResultSet rst0;
	private int Count = 0, num = 0;
	private Double Media = 0.0;
	private JLabel lblNewLabel_4;
	private List<String> result = new ArrayList<String>();
	private File[] files = new File("C:/Users/Win10/git/OOSD-ProjectX/ProjectX").listFiles();

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
	 * 
	 * @throws Exception
	 */
	public MainUser(Actor user) throws Exception {
		this.user = user;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Exception
	 */
	private void initialize() throws Exception {

		frame = new JFrame();
		frame.setTitle("Main user");
		frame.setBounds(100, 100, 700, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		ArrayList<Game> gamesObject = new ArrayList<Game>();
		ArrayList<String> games = new ArrayList<String>();
		String query = "SELECT * FROM game";
		ResultSet rst = DatabaseMySQL.SendQuery(query);
		while (rst.next()) {
			Game a = new Game(rst.getInt("idGame"), rst.getString("name"), 0);
			gamesObject.add(a);
			games.add(rst.getString("name"));
		}

		for (File file : files) {
			if (file.isFile()) {
				result.add(file.getName());
			}
		}

		lblNewLabel_4 = new JLabel();
		lblNewLabel_4.setBounds(453, 54, 200, 200);
		frame.getContentPane().add(lblNewLabel_4);

		// Recensione
		JTextArea lblNewLabel = new JTextArea("");
		lblNewLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setEditable(false);
		lblNewLabel.setWrapStyleWord(true);
		lblNewLabel.setLineWrap(true);
		lblNewLabel.setBounds(32, 372, 621, 127);
		frame.getContentPane().add(lblNewLabel);

		// Recensito da:
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(32, 328, 185, 33);
		frame.getContentPane().add(lblNewLabel_1);

		// Voto
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(416, 328, 237, 33);
		frame.getContentPane().add(lblNewLabel_2);

		// Media
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_3.setBounds(507, 13, 167, 30);
		frame.getContentPane().add(lblNewLabel_3);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 54, 391, 200);
		frame.getContentPane().add(scrollPane);

		ImageIcon Next = new ImageIcon("src/Immagini/Successivo.png");

		JButton btnRecensioneSuccessiva = new JButton(Next);
		btnRecensioneSuccessiva.setBorderPainted(false);
		btnRecensioneSuccessiva.setContentAreaFilled(false);
		btnRecensioneSuccessiva.setOpaque(false);
		btnRecensioneSuccessiva.setFont(new Font("Times New Roman", Font.BOLD, 18));

		ImageIcon Previous = new ImageIcon("src/Immagini/Precedente.png");

		JButton btnNewButton_2 = new JButton(Previous);
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setOpaque(false);
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		if (num == 0)
			btnNewButton_2.setVisible(false);
		else
			btnNewButton_2.setVisible(true);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					num = num - 1;
					btnRecensioneSuccessiva.setVisible(true);
					if (num == 1)
						btnNewButton_2.setVisible(false);
					else
						btnNewButton_2.setVisible(true);
					if (rst0.previous()) {
						ResultSet rst2 = MainUserController.selezionaUsername(rst0.getInt("user_iduser"));
						rst2.next();
						lblNewLabel.setText(rst0.getString("text"));
						lblNewLabel_2.setText("Voto: " + rst0.getString("vote") + "/10");
						lblNewLabel_1.setText("Recensione di: " + rst2.getString("username"));
					}

				} catch (SQLException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(89, 510, 150, 40);
		frame.getContentPane().add(btnNewButton_2);

		// Recensione Successiva
		if (Count <= num) {
			btnRecensioneSuccessiva.setVisible(false);
		} else
			btnRecensioneSuccessiva.setVisible(true);
		btnRecensioneSuccessiva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					num = num + 1;
					btnNewButton_2.setVisible(true);
					if (Count > num) {
						btnRecensioneSuccessiva.setVisible(true);
					} else
						btnRecensioneSuccessiva.setVisible(false);
					if (num <= Count) {
						if (rst0.next()) {
							ResultSet rst2 = MainUserController.selezionaUsername(rst0.getInt("user_iduser"));
							rst2.next();
							lblNewLabel.setText(rst0.getString("text"));
							lblNewLabel_2.setText("Voto: " + rst0.getString("vote") + "/10");
							lblNewLabel_1.setText("Recensione di: " + rst2.getString("username"));
						}
					}
					if (Count == num) {
						btnRecensioneSuccessiva.setVisible(false);
					} else
						btnRecensioneSuccessiva.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnRecensioneSuccessiva.setBounds(453, 510, 150, 40);
		frame.getContentPane().add(btnRecensioneSuccessiva);

		ImageIcon Com = new ImageIcon("src/Immagini/Commento.png");
		JButton btnNewButton = new JButton(Com);

		ImageIcon Gioca = new ImageIcon("src/Immagini/PlayNow.png");
		ImageIcon Scarica = new ImageIcon("src/Immagini/Scarica.png");
		JButton btnGioca = new JButton();
		btnGioca.setEnabled(false);

		JList list = new JList();
		list.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				num = 1;
				Media = 0.0;
				Count = 0;
				for (Game game : gamesObject) {

					String gioco2 = (String) list.getSelectedValue();
					String gioco=gioco2.replaceAll(" {1,}", "");
					System.out.println(gioco);
					if (result.contains(gioco + ".jar")) {
						btnGioca.setIcon(Gioca);
						btnGioca.setEnabled(true);
					} else {
						btnGioca.setIcon(Scarica);
						btnGioca.setEnabled(false);
					}
					if (game.getName().equals(gioco2)) {
						try {
							ResultSet rst1 = Review_DAO.selezionaReview(user.getId(), game.getId());
							if (rst1.next()) {
								btnNewButton.setEnabled(false);
							} else
								btnNewButton.setEnabled(true);
							rst0 = Review_DAO.getGameReviews(game);
							ImageIcon Icona = new ImageIcon("src/Immagini/" + game.getName() + ".jpg");
							Image scaledImage = Icona.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
							Icona.setImage(scaledImage);
							lblNewLabel_4.setBorder(BorderFactory.createLineBorder(Color.black));
							lblNewLabel_4.setIcon(Icona);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
				try {
					while (rst0.next()) {
						Media = Media + rst0.getInt("vote");
						Count = Count + 1;
					}
					if (Count != 0) {
						Media /= Count;
						lblNewLabel_3.setText("Media Voto: " + String.format("%.1f", Media));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					if (rst0.first()) {
						ResultSet rst2 = MainUserController.selezionaUsername(rst0.getInt("user_iduser"));
						rst2.next();
						lblNewLabel.setText(rst0.getString("text"));
						lblNewLabel_2.setText("Voto: " + rst0.getString("vote") + "/10");
						lblNewLabel_1.setText("Recensione di: " + rst2.getString("username"));
					} else {
						lblNewLabel.setText("Questo gioco non è ancora stato recensito!");
						lblNewLabel_2.setText("");
						lblNewLabel_1.setText("");
						lblNewLabel_3.setText("");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

				if (Count > num) {
					btnRecensioneSuccessiva.setVisible(true);
				} else
					btnRecensioneSuccessiva.setVisible(false);
				btnNewButton_2.setVisible(false);
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
		list.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyCode() == KeyEvent.VK_DOWN || ke.getKeyCode() == KeyEvent.VK_UP) {
					ke.consume();
				}
			}
		});

		btnNewButton.setBorderPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setOpaque(false);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (list.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null, "Seleziona un gioco dalla lista!");
				}
				if (!list.isSelectionEmpty()) {
					String gioco = (String) list.getSelectedValue();
					try {
						if (!MainUserController.Recensisci(user, gioco)) {
							for (Game game : gamesObject) {
								if (game.getName().equals(gioco)) {
									frame.dispose();
									AddReview.main(user, game);
								}
							}
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setBounds(223, 277, 150, 40);
		frame.getContentPane().add(btnNewButton);

		btnGioca.setContentAreaFilled(false);
		btnGioca.setBorderPainted(false);
		btnGioca.setOpaque(false);
		btnGioca.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnGioca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!list.isSelectionEmpty()) {
					if (btnGioca.getIcon().equals(Gioca)) {
						String gioco = (String) list.getSelectedValue();
						for (Game game : gamesObject) {
							if (game.getName().equals(gioco)) {
								try {
									PlayController.lanciaGioco(game, user);
								} catch (Exception e1) {
									e1.printStackTrace();
								}
							}
						}
					} else
						JOptionPane.showMessageDialog(null, "Devi prima scaricare il gioco");
				}
			}
		});
		btnGioca.setBounds(32, 277, 150, 40);
		frame.getContentPane().add(btnGioca);

		ImageIcon Logout = new ImageIcon("src/Immagini/logout.png");

		JButton mntmNewMenuItem_1 = new JButton(Logout);
		mntmNewMenuItem_1.setFocusable(false);
		mntmNewMenuItem_1.setBorderPainted(false);
		mntmNewMenuItem_1.setContentAreaFilled(false);
		mntmNewMenuItem_1.setOpaque(false);
		mntmNewMenuItem_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.main(null);
				frame.dispose();
			}
		});
		mntmNewMenuItem_1.setBounds(32, 11, 150, 40);
		frame.getContentPane().add(mntmNewMenuItem_1);

		ImageIcon Profile = new ImageIcon("src/Immagini/Profilo.png");
		JButton btnNewButton_1 = new JButton(Profile);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainUserController.Profilo(user);
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(418, 277, 150, 40);
		frame.getContentPane().add(btnNewButton_1);

		ImageIcon Sfondo = new ImageIcon("src/Immagini/Sfondo.jpg");
		Image scaledImage = Sfondo.getImage().getScaledInstance(700, 600, Image.SCALE_DEFAULT);
		Sfondo.setImage(scaledImage);

		ImageIcon U = new ImageIcon("src/Immagini/Utenti.png");
		JButton btnNewButton1 = new JButton(U);
		btnNewButton1.setFocusable(false);
		btnNewButton1.setOpaque(false);
		btnNewButton1.setContentAreaFilled(false);
		btnNewButton1.setBorderPainted(false);
		btnNewButton1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainUserController.GestisciUser(user);
				frame.dispose();
			}
		});
		btnNewButton1.setBounds(192, 11, 150, 40);
		frame.getContentPane().add(btnNewButton1);

		ImageIcon Rev = new ImageIcon("src/Immagini/Review.png");
		JButton btnGestisciNuoveRecensioni = new JButton(Rev);
		btnGestisciNuoveRecensioni.setOpaque(false);
		btnGestisciNuoveRecensioni.setContentAreaFilled(false);
		btnGestisciNuoveRecensioni.setBorderPainted(false);
		btnGestisciNuoveRecensioni.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnGestisciNuoveRecensioni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainUserController.GestisciRec(user);
				frame.dispose();
			}
		});
		btnGestisciNuoveRecensioni.setBounds(352, 11, 150, 40);
		frame.getContentPane().add(btnGestisciNuoveRecensioni);
		JLabel lblNewLabel_5 = new JLabel(Sfondo);
		lblNewLabel_5.setBounds(0, 0, 684, 561);
		frame.getContentPane().add(lblNewLabel_5);
		ResultSet rst11 = Review_DAO.ReviewDaValutare();
		if (rst11.next()) {
			btnGestisciNuoveRecensioni.setEnabled(true);
		} else
			btnGestisciNuoveRecensioni.setEnabled(false);

		if (!user.getType().equals("moderatore")) {
			btnGestisciNuoveRecensioni.setVisible(false);
			btnNewButton1.setVisible(false);
		}
	}
}