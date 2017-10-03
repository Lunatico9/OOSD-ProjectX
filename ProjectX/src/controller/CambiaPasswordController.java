package controller;

import database.DatabaseMySQL;
import model.Actor;

public class CambiaPasswordController {
	public static void Modify(Actor user, String oldPass, String newPass, String confirm){
		if(user.getPassword().equals(oldPass) && newPass.equals(confirm)) {
			
		}
	}
}