package controller;

import java.sql.ResultSet;

import database.DatabaseMySQL;
import model.Review;

public class AddReviewController {
	public static void AddReview(String text, int vote) throws Exception {
		Review r = new Review(text, vote);
		System.out.println("Recensione: " + text + " con voto: " + vote + " aggiunta");
		String sqlQuery = "INSERT INTO `review` (`text`, `vote`) VALUES (text, vote)";
		ResultSet rst = DatabaseMySQL.SendQuery(sqlQuery);	
	}
}
