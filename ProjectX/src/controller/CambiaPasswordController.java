package controller;

import java.sql.ResultSet;

import database.DatabaseMySQL;
import model.Actor;

public class CambiaPasswordController {
	public static String Modify(Actor user, String oldPass, String newPass, String confirm) throws Exception{
		if(user.getPassword().equals(oldPass) && newPass.equals(confirm)) {
			String query = "UPDATE user SET password = '" + newPass + "' WHERE username = '" + user.getUsername() + "'";
			ResultSet rst = DatabaseMySQL.SendQuery(query);
			return newPass;
		}
		else
			return oldPass;
	}
}