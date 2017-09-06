package controller;

import java.sql.ResultSet;

import database.DatabaseMySQL;

public class AcceptReviewController {
	
	public static void Accetta(int idReview, String text, int game, int user, int vote) throws Exception{
		String aggiungi= "UPDATE `review` SET `Approved` = '1' WHERE idReview = '"+idReview+"'";
		ResultSet add=DatabaseMySQL.SendQuery(aggiungi);
	}
	
	public static void Rifiuta(int idReview, String text, int game, int user, int vote) throws Exception{
		String nega= "UPDATE `review` SET `Approved` = '2' WHERE idReview = '"+idReview+"'";
		ResultSet add=DatabaseMySQL.SendQuery(nega);
	}
}
