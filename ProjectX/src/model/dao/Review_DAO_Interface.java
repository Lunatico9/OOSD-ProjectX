package model.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import model.Actor;
import model.Game;
import model.Review;

public interface Review_DAO_Interface {
	
	public static ResultSet maxReview() throws Exception{
	}
	
	
	public static ArrayList<String[]> AwardsList(Actor user) throws Exception {
	}
	
	public static ResultSet inserisciReview(int ID, Review review) throws Exception{
	}
	
	public static ResultSet selezionaReview(int IDuser, int IDgame) throws Exception{
	}
	
	public static ResultSet ReviewDaValutare() throws Exception{
	}
	
	public static ResultSet getGameReviews(Game game) throws Exception{
	}
	
	public static ResultSet AccettaReview(int idReview) throws Exception{
	}
	
	public static ResultSet RifiutaReview(int idReview) throws Exception{
	}
}