package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import model.Actor;
import model.Game;
import model.dao.Actor_DAO;

public class PlayController {
	static List<Integer> soglie = soglie();

	/**
	 * Stabilisce le soglie di exp per passare di livello
	 * 
	 * @return a List of integer
	 */
	public static List<Integer> soglie() {
		soglie = new ArrayList<Integer>(100);
		soglie.add(0, 100);
		for (int i = 1; i < 100; i++) {
			soglie.add(i, soglie.get(i - 1) + ((i + 1) * 100));
		}
		return soglie;
	}

	/**
	 * Esegue le varie operazioni relative all'esperienza dell'utente che ha
	 * appena giocato
	 * 
	 * @param user
	 *            username
	 * @return an Actor
	 * @throws Exception
	 */
	public static Actor Gioca(Actor user, int experience) throws Exception {

		Calendar today = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy-hh:mm:ss");
		String data = formatter.format(today.getTime());
		Actor_DAO.AggiungiExp(user);
		user.setExp(user.getExp() + experience);
		ResultSet rst = Actor_DAO.selectExp(user);
		rst.next();
		int exp = rst.getInt("exp");
		String id = rst.getString("idUser");
		int IDtime = 0;
		ResultSet result = Actor_DAO.maxTimeline();
		if (result.next()) {
			IDtime = result.getInt(1) + 1;
		}

		if (soglie.contains(exp)) {
			int i = soglie.indexOf(exp);
			String Premio = "Premio lv." + (i + 2);
			Actor_DAO.AggiornaLivello(i, user);
			Actor_DAO.AggiungiTimeline(IDtime, Premio, data, id);
			JOptionPane.showMessageDialog(null, "Congratulazioni sei salito al Livello " + (i + 2) + "!");
			user.setLevel(user.getLevel() + 1);
		} else {
			int ore= experience/50;
			if(ore==1){
				JOptionPane.showMessageDialog(null,
						"Hai giocato per un ora e ti sono stati aggiunti " + experience + " punti exp!");
			
			}
			else{
				JOptionPane.showMessageDialog(null,
						"Hai giocato per "+ore+" ore e ti sono stati aggiunti " + experience + " punti exp!");
			}
			}
		return user;
	}

	public static void lanciaGioco(Game game, Actor user) throws Exception {
		String name2 = game.getName();
		String name = name2.replaceAll(" {1,}", "");
		BufferedReader b;
		Process proc = Runtime.getRuntime().exec("java -jar " + name + ".jar");
		b = new BufferedReader(new InputStreamReader(proc.getInputStream()));
		proc.waitFor();
		String line = b.readLine();
		int exp = 0;
		while (line != null) {
			if (line.substring(0, 4).equals("exp:")) {
				exp = Integer.parseInt(line.substring(4));
				Gioca(user, exp);
			}
			line = b.readLine();
		}
	}

}