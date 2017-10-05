package controller;

import model.Actor;
import view.AcceptReview;
import view.MainUser;
import view.PromotionDemotionModerator;

public class MainModeratorController {
	
	public static void GestisciUser(Actor user){
		PromotionDemotionModerator.main(user);
	}
	
	public static void GestisciRec(Actor user){
		AcceptReview.main(user);
	}
	
	public static void Utente(Actor user){
		MainUser.main(user);
	}
}
