package controller;

import model.dao.Actor_DAO;

public class PromotionDemotionModeratorController {
	public static void Update(String Type, int i, String username) throws Exception{
		if (Type.equals("moderatore")) {
			Actor_DAO.Degrade(username);
		}
		else {
			Actor_DAO.Upgrade(username);
		}
	}
}
