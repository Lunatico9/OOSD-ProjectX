package controller;

import java.sql.Date;

import model.Game;

public class AddGameController {
	public static void AddGame(String title, String genere, String data) {
		Game a = new Game(title, data, genere);
		System.out.println("Gioco " + title + " uscito nel " + data + " aggiunto" );
	}
}
