package controller;

import database.DatabaseMySQL;

public class PromotionDemotionModeratorController {
	public static void Update(String Type, int i, String username) throws Exception{
		if (Type.equals("moderatore")) {
			 DatabaseMySQL.Degrade(username);
		}
		else {
			DatabaseMySQL.Upgrade(username);
		}
	}
}
