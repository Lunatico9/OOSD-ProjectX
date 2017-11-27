package controller;

import model.dao.Actor_DAO;

public class PromotionDemotionModeratorController {
	/**
	 * Cambia il tipo di un utente
	 * @param Type nuovo tipo
	 * @param i ??
	 * @param username username
	 * @throws Exception
	 */
	public static void Update(String Type, int i, String username) throws Exception{
		if (Type.equals("moderatore")) {
			Actor_DAO.Degrade(username);
		}
		else {
			Actor_DAO.Upgrade(username);
		}
	}
}
