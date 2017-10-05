package model.dao;

import java.sql.ResultSet;

import database.DatabaseMySQL;

public class Actor_DAO {
	
	public static void UpdatePassword(String newPass, String username) throws Exception{
		String query = "UPDATE user SET password = '" + newPass + "' WHERE username = '" + username + "'";
		ResultSet rst = DatabaseMySQL.SendQuery(query);
	}
	
}
