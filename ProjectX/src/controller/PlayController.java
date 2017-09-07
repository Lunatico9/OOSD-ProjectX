package controller;

import java.sql.ResultSet;

import database.DatabaseMySQL;

public class PlayController {
	public static void Gioca(String username) throws Exception {
		String query2 = "UPDATE user SET exp = exp + 50 WHERE username = '" + username + "'";
		ResultSet rst =DatabaseMySQL.SendQuery(query2); 
		String query = "SELECT exp FROM user  WHERE username = '" + username + "'";
		rst = DatabaseMySQL.SendQuery(query);
		if (rst.next())
			System.out.println(rst.getInt(1));
	}
	}

