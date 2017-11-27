package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DatabaseMySQL;
import model.Actor;
import model.Game;
import model.Review;

public class Review_DAO implements Review_DAO_Interface {
	/**
	 * Trova l'ultima review nel database
	 * @return a ResultSet
	 * @throws Exception
	 */
	public static ResultSet maxReview() throws Exception{
		String QueryID = "SELECT MAX(idReview) FROM review";
		return DatabaseMySQL.SendQuery(QueryID);
	}
	
	/**
	 * Trova la lista di Premi ottenuti dall'utente
	 * @param user username
	 * @return an ArrayList 
	 * @throws Exception
	 */
	public static ArrayList<String[]> AwardsList(Actor user) throws Exception {
		ArrayList<String[]> AwardsList = new ArrayList<String[]>();
		try {
			String query = "SELECT * FROM timeline WHERE User_idUser = '" + user.getId() + "'";
			ResultSet rst = DatabaseMySQL.SendQuery(query);
			while(rst.next()) {
				String[] premio = {rst.getString(3),rst.getString(2)};
				AwardsList.add(premio);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return AwardsList;
	}
	/**
	 * Inserisci una review
	 * @param ID ID review
	 * @param review a Review Object
	 * @return a ResultSet
	 * @throws Exception
	 */
	public static ResultSet inserisciReview(int ID, Review review) throws Exception{
		String sqlQuery = "INSERT INTO `review` (`idReview`,`Text`,`Approved` ,`Game_idGame`, `user_iduser`, `vote`) VALUES ('" + ID + "','" + review.getText() + "', '" + review.isApproved() + "', '" + review.getIdGioco() + "', '" + review.getIdUser() + "', '" + review.getVote() + "')";
		return DatabaseMySQL.SendQuery(sqlQuery);
	}
	/**
	 * Trova una review 
	 * @param IDuser Id utente
	 * @param IDgame Id gioco
	 * @return a ResultSet
	 * @throws Exception
	 */
	public static ResultSet selezionaReview(int IDuser, int IDgame) throws Exception{
		String query= "SELECT * FROM review WHERE user_iduser='" + IDuser + "' AND Game_idGame='"+ IDgame +"'";
		return DatabaseMySQL.SendQuery(query);
	}
	/**
	 * Trova le review da valutare
	 * @return a ResultSet
	 * @throws Exception
	 */
	public static ResultSet ReviewDaValutare() throws Exception{
		String queryTOTALE= "Select text, idReview, Game_idGame, user_iduser, vote From review WHERE approved=0";
		return DatabaseMySQL.SendQuery(queryTOTALE);
	}
	/**
	 * Trova le recensioni di un gioco
	 * @param game ID game
	 * @return a ResultSet
	 * @throws Exception
	 */
	public static ResultSet getGameReviews(Game game) throws Exception{
		String query12="SELECT * From review Where'"+ game.getId()  + "'=Game_idGame AND Approved=1 ORDER BY idReview";
		return DatabaseMySQL.SendQuery(query12);
	}
	/**
	 * Accetta una review
	 * @param idReview ID review
	 * @return a ResultSet
	 * @throws Exception
	 */
	public static ResultSet AccettaReview(int idReview) throws Exception{
		String aggiungi= "UPDATE `review` SET `Approved` = '1' WHERE idReview = '"+idReview+"'";
		return DatabaseMySQL.SendQuery(aggiungi);
	}
	/**
	 * Rifiuta una review
	 * @param idReview ID review
	 * @return a ResultSet
	 * @throws Exception
	 */
	public static ResultSet RifiutaReview(int idReview) throws Exception{
		String aggiungi= "UPDATE `review` SET `Approved` = '2' WHERE idReview = '"+idReview+"'";
		return DatabaseMySQL.SendQuery(aggiungi);
	}
}
