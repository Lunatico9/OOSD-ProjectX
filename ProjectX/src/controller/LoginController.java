package controller;

import java.sql.ResultSet;

import database.DatabaseMySQL;
import view.MainUser;

public class LoginController {
	public static void Accedi(String username, String password) throws Exception {
    String query = "SELECT username, password, type FROM user WHERE username = '" + username + "' and password = '" + password + "'";
    ResultSet rst = DatabaseMySQL.SendQuery(query);
    if(rst.next()) {
    	String type = rst.getString("type");
        if("amministratore".equals(type)) {
            //redirect to admin page
        	MainUser.main(null);
        } 
        else if("moderatore".equals(type)) {
           //redirect to mod page
           MainUser.main(null);
        }
        else {
        	//redirect to user page
			MainUser.main(null);
			}
        }
	}
}
