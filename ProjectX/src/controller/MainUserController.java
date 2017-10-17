package controller;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

import database.DatabaseMySQL;
import model.Actor;
import model.dao.Game_DAO;
import model.dao.Review_DAO;
import view.AcceptReview;
import view.PromotionDemotionModerator;
import view.UserProfile;

public class MainUserController {
	
	public static void Profilo(Actor user){
		UserProfile.main(user);
	}
	
	public static void GestisciRec(Actor user){
		AcceptReview.main(user);
	}
	
	public static void GestisciUser(Actor user){
		PromotionDemotionModerator.main(user);
	}

	public static boolean Recensisci(Actor user, String gioco) throws Exception {
		int idGame;
			ResultSet rst= Game_DAO.selectIDgame(gioco);
			rst.next();
			idGame=rst.getInt(1);
			ResultSet rst2= Review_DAO.selezionaReview(user.getId(), idGame);
			if(rst2.next()){
				JOptionPane.showMessageDialog(null, "Hai già recensito questo gioco!");
				return true;
			}
			else return false;
	}
	
	public static ResultSet selezionaUsername(int ID) throws Exception{
		return DatabaseMySQL.selectUsername(ID);	
	}
}
