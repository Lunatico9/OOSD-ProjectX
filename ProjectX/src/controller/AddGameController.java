package controller;

import java.sql.ResultSet;

import database.DatabaseMySQL;
import model.Game;

public class AddGameController {
	public static void AddGame(String title, String genere, String data) throws Exception {
		Game a = new Game(title, data, genere);
		System.out.println("Gioco " + title + " uscito nel " + data + " aggiunto" );
		String sqlQuery = "INSERT INTO `game` (`idGame`, `name`, `points`) VALUES ('13', '" + title + "' , '10')";
		ResultSet rst = DatabaseMySQL.SendQuery(sqlQuery);	
	}
}
