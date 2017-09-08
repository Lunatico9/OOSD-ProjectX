package controller;

import java.sql.ResultSet;

import database.DatabaseMySQL;
import view.MainModerator;
import view.MainUser;

public class LoginController {
	public static void Accedi(String username, String password) throws Exception {
    String query = "SELECT username, password, type FROM user WHERE username = '" + username + "' and password = '" + password + "'";
    ResultSet rst = DatabaseMySQL.SendQuery(query);
    if(rst.next()) {
    	String type = rst.getString("type");
        if("moderatore".equals(type)) {
            //redirect to admin page
        	MainModerator.main(username);
        } 
        else
           MainUser.main(username, type);
        }
	}
}
