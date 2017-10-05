package controller;

import model.Actor;
import view.MainModerator;
import view.MainUser;

public class LoginController {
	public static void Accedi(Actor user) throws Exception {
        if("moderatore".equals(user.getType())) {
        	MainModerator.main(user);
        } 
        else
           MainUser.main(user);
   }
}

