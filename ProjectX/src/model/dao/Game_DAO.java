package model.dao;

import java.sql.ResultSet;

import database.DatabaseMySQL;

public class Game_DAO {
	public static ResultSet selectIDgame(String name) throws Exception{
		String query0= "SELECT idGame FROM game WHERE name='"+ name + "'";
		return DatabaseMySQL.SendQuery(query0);
	}
}
