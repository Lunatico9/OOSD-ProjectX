package controller;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

import model.Actor;
import model.dao.Actor_DAO;
import model.dao.Game_DAO;
import model.dao.Review_DAO;
import view.AcceptReview;
import view.PromotionDemotionModerator;
import view.UserProfile;

public class MainUserController {
	/**
	 * Va alla pagina del profilo
	 * @param user username
	 */
	public static void Profilo(Actor user){
		UserProfile.main(user);
	}
	/**
	 * Va alla pagina delle recensioni
	 * @param user username
	 */
	public static void GestisciRec(Actor user){
		AcceptReview.main(user);
	}
	/**
	 * Va alla pagina degli utenti
	 * @param user
	 */
	public static void GestisciUser(Actor user){
		PromotionDemotionModerator.main(user);
	}
	/**
	 * Pubblica una recensione
	 * @param user Actor Object
	 * @param gioco Id del gioco
	 * @return a boolean
	 * @throws Exception
	 */
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
	/**
	 * Seleziona username
	 * @param ID ID of user
	 * @return a ResultSet
	 * @throws Exception
	 */
	public static ResultSet selezionaUsername(int ID) throws Exception{
		return Actor_DAO.selectUsername(ID);	
	}
}
