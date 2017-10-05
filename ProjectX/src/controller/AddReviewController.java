package controller;

import java.sql.ResultSet;

import database.DatabaseMySQL;
import model.Review;
import model.Actor;
import view.MainUser;

public class AddReviewController {
	public static void AddReview(Review review) throws Exception {
		String QueryID = "SELECT MAX(idReview) FROM review";
		ResultSet id= DatabaseMySQL.SendQuery(QueryID);
		int ID=0;
		if(id.next()){
			 ID=id.getInt(1)+1;
		}
		String sqlQuery = "INSERT INTO `review` (`idReview`,`Text`,`Approved` ,`Game_idGame`, `user_iduser`, `vote`) VALUES ('" + ID + "','" + review.getText() + "', '" + review.isApproved() + "', '" + review.getIdGioco() + "', '" + review.getIdUser() + "', '" + review.getVote() + "')";
	
		ResultSet rst = DatabaseMySQL.SendQuery(sqlQuery);	
	}
	
	public static void Annulla(Actor user){
		MainUser.main(user);
	}
}
