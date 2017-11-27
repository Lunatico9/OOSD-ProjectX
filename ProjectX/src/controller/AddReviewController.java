package controller;

import java.sql.ResultSet;
import model.Review;
import model.dao.Review_DAO;
import model.Actor;
import view.MainUser;

public class AddReviewController {
	/**
	 * Aggiunge una recensione
	 * @param review a Review Object
	 * @throws Exception
	 */
	public static void AddReview(Review review) throws Exception {
		ResultSet id= Review_DAO.maxReview();
		int ID=0;
		if(id.next()){
			 ID=id.getInt(1)+1;
		}
		Review_DAO.inserisciReview(ID, review);	
	}
	
	/**
	 * Torna al menu principale
	 * @param user username
	 */
	public static void Annulla(Actor user){
		MainUser.main(user);
	}
}
