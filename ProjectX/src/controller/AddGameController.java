package controller;

import database.DatabaseMySQL;
import model.Game;

public class AddGameController {
	public static void AddGame(String title, String genere, String data) throws Exception {
		Game a = new Game(title, data, genere);
		System.out.println("Gioco " + title + " uscito nel " + data + " aggiunto" );
		DatabaseMySQL.Connection();
	}
}
