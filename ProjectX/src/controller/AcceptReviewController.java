 package controller;

import java.sql.ResultSet;

import database.DatabaseMySQL;
import model.dao.Review_DAO;

public class AcceptReviewController {
	/**
	 * Accetta la recensione
	 * @param idReview id della recensione
	 * @param text testo della recensione
	 * @param game gioco recensito
	 * @param user id dell'utente che recensisce
	 * @param vote voto (da 1 a 10)
	 * @throws Exception
	 */
	public static void Accetta(int idReview, String text, int game, int user, int vote) throws Exception{
		ResultSet add=Review_DAO.AccettaReview(idReview);
	}
	/**
	 * Rifiuta la recensione
	 * @param idReview id della recensione
	 * @param text testo della recensione
	 * @param game gioco recensito
	 * @param user id dell'utente che recensisce
	 * @param vote voto (da 1 a 10)
	 * @throws Exception
	 */
	public static void Rifiuta(int idReview, String text, int game, int user, int vote) throws Exception{
		ResultSet add=Review_DAO.RifiutaReview(idReview);
	}
}
