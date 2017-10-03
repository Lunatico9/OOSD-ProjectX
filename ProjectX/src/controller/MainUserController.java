package controller;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

import database.DatabaseMySQL;
import model.Actor;
import view.UserProfile;

public class MainUserController {
	
	public static void Profilo(Actor user){
		UserProfile.main(user);
	}

	public static boolean Recensisci(Actor user, String gioco) throws Exception {
		int idGame;
		String query0= "SELECT idGame FROM game WHERE name='"+ gioco + "'";
		ResultSet rst= DatabaseMySQL.SendQuery(query0);
			rst.next();
			idGame=rst.getInt(1);
			String query= "SELECT * FROM review WHERE user_iduser='" + user.getId() + "' AND Game_idGame='"+ idGame +"'";
			ResultSet rst2= DatabaseMySQL.SendQuery(query);
			if(rst2.next()){
				JOptionPane.showMessageDialog(null, "Hai già recensito questo gioco!");
				return true;
			}
			else return false;
	}
}
