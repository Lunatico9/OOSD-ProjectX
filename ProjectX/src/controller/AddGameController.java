package controller;

import model.Game;

public class AddGameController {
	public static void AddGame(String title) {
		Game a = new Game(0, title);
		System.out.println("Gioco " + title + " aggiunto");
	}
}
