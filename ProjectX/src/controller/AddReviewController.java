package controller;

import java.sql.ResultSet;

import database.DatabaseMySQL;
import model.Review;
import model.Actor;
import view.MainUser;

public class AddReviewController {
	public static void AddReview(Review review) throws Exception {
		String sqlQuery = "INSERT INTO `review` (`text`, `vote`) VALUES ('" + review.getText() + "', '" + review.getVote() + "')";
		ResultSet rst = DatabaseMySQL.SendQuery(sqlQuery);	
	}
	
	public static void Annulla(Actor user){
		MainUser.main(user);
	}
}
