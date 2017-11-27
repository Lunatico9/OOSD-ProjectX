package model.dao;

import java.sql.ResultSet;

import database.DatabaseMySQL;

public class Game_DAO {
/**
 * Trova il gioco nel db basandosi sul nome
 * @param name nome del gioco
 * @return a Game Object
 * @throws Exception
 */
	public static ResultSet selectIDgame(String name) throws Exception{
		String query0= "SELECT idGame FROM game WHERE name='"+ name + "'";
		return DatabaseMySQL.SendQuery(query0);
	}
	
	public static ResultSet selectGame(int ID) throws Exception{
		String GIOCO="SELECT name FROM game WHERE idGame='"+ID+"'";
		return DatabaseMySQL.SendQuery(GIOCO);
	}
}
