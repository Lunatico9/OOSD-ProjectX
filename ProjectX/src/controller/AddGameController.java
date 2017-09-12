package controller;

import java.sql.ResultSet;

import database.DatabaseMySQL;
import model.Game;

public class AddGameController {
	public static void AddGame(String title, String genere, String data) throws Exception {
		Game a = new Game(title, data, genere);
		System.out.println("Gioco " + title + " uscito nel " + data + " aggiunto" );
		int IDGAME=0;
		String sql="SELECT MAX(idGame) FROM game";
		String sqlQuery = "INSERT INTO `game` (`idGame`, `name`) VALUES ('"+IDGAME+"','" + title + "')";
		ResultSet rs= DatabaseMySQL.SendQuery(sql);
		if(rs.next()){
			IDGAME=rs.getInt("idGame")+1;
		}
		ResultSet rst = DatabaseMySQL.SendQuery(sqlQuery);	
	}
}
