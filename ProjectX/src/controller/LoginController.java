package controller;

import java.sql.ResultSet;

import database.DatabaseMySQL;

public class LoginController {
	public static void Accedi(String username, String password) throws Exception {
    String query = "SELECT username, password, type FROM user WHERE username = '" + username + "' and password = '" + password + "'";
    ResultSet rst = DatabaseMySQL.SendQuery(query);
    if(rst.next()) {
        String type = rst.getString("type");
        if("amministratore".equals(type)){
            //redirect to admin page
       } 
       else if("moderatore".equals(type)){
           //redirect to mod page
       }
        
 }
 else{
      //redirect to user page
 }
	}
}
