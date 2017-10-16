package model.dao;

import java.sql.ResultSet;

import database.DatabaseMySQL;

public class Game_DAO {
	public static ResultSet selectIDgame(String name) throws Exception{
		String query0= "SELECT idGame FROM game WHERE name='"+ name + "'";
		return DatabaseMySQL.SendQuery(query0);
	}
	
	public static ResultSet selectGame(int ID) throws Exception{
		String GIOCO="SELECT name FROM game WHERE idGame='"+ID+"'";
		return DatabaseMySQL.SendQuery(GIOCO);
	}
}
