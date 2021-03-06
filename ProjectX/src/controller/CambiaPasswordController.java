package controller;

import model.Actor;
import model.dao.Actor_DAO;

public class CambiaPasswordController {
	/**
	 * Modifica la password dell'utente
	 * @param user username
	 * @param oldPass vecchia password
	 * @param newPass nuova password
	 * @param confirm nuova password
	 * @return a String
	 * @throws Exception
	 */
	public static String Modify(Actor user, String oldPass, String newPass, String confirm) throws Exception{
		if(user.getPassword().equals(oldPass) && newPass.equals(confirm)) {
			Actor_DAO.UpdatePassword(newPass, user.getUsername());
			return newPass;
		}
		else
			return oldPass;
	}
}