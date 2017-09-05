package controller;

import java.sql.ResultSet;

import database.DatabaseMySQL;

public class AcceptReviewController {
	
	public static void Accetta(int idReview, String text, int game, int user, int vote) throws Exception{
		String elimina= "DELETE FROM review WHERE idReview='"+idReview+"'";
		ResultSet delete= DatabaseMySQL.SendQuery(elimina);
		String aggiungi= "INSERT INTO review (idReview, text, approved, Game_idGame, user_iduser, vote) VALUES ('"+idReview+"', '"+text+"', '1', '"+game+"','"+user+"','"+vote+"')";
		ResultSet add=DatabaseMySQL.SendQuery(aggiungi);
	}
}
