package controller;

import model.Actor;
import view.MainUser;

public class LoginController {
	/**
	 * Va al menu principale
	 * @param user username
	 * @throws Exception
	 */
	public static void Accedi(Actor user) throws Exception {
           MainUser.main(user);
   }
}

