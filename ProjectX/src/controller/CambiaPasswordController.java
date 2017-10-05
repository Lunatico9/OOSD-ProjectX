package controller;

import model.Actor;
import model.dao.Actor_DAO;

public class CambiaPasswordController {
	public static String Modify(Actor user, String oldPass, String newPass, String confirm) throws Exception{
		if(user.getPassword().equals(oldPass) && newPass.equals(confirm)) {
			Actor_DAO.UpdatePassword(newPass, user.getUsername());
			return newPass;
		}
		else
			return oldPass;
	}
}