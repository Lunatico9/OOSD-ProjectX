package controller;

import java.sql.ResultSet;

import database.DatabaseMySQL;
import model.Review;
import model.dao.Review_DAO;
import model.Actor;
import view.MainUser;

public class AddReviewController {
	public static void AddReview(Review review) throws Exception {
		ResultSet id= DatabaseMySQL.maxReview();
		int ID=0;
		if(id.next()){
			 ID=id.getInt(1)+1;
		}
		Review_DAO.inserisciReview(ID, review);	
	}
	
	public static void Annulla(Actor user){
		MainUser.main(user);
	}
}
