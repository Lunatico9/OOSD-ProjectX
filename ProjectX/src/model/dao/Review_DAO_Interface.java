package model.dao;

import model.Actor;
import model.Game;
import model.Review;

public interface Review_DAO_Interface {
	
	public static void maxReview() throws Exception{};
	
	public static void AwardsList(Actor user) throws Exception{};
	
	public static void inserisciReview(int ID, Review review) throws Exception{};
	
	public static void selezionaReview(int IDuser, int IDgame) throws Exception{};
	
	public static void ReviewDaValutare() throws Exception{};
	
	public static void getGameReviews(Game game) throws Exception{};
	
	public static void AccettaReview(int idReview) throws Exception{};
	
	public static void RifiutaReview(int idReview) throws Exception{};
}