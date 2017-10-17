 package controller;

import java.sql.ResultSet;

import database.DatabaseMySQL;
import model.dao.Review_DAO;

public class AcceptReviewController {
	
	public static void Accetta(int idReview, String text, int game, int user, int vote) throws Exception{
		ResultSet add=Review_DAO.AccettaReview(idReview);
	}
	
	public static void Rifiuta(int idReview, String text, int game, int user, int vote) throws Exception{
		ResultSet add=Review_DAO.RifiutaReview(idReview);
	}
}
