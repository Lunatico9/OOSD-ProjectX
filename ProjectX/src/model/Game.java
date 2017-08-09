package model;

public class Game {
	private int id;
	private String name;
	private float average;
	private int votes;
	
	public Game(int id, String name) {
		this.id = id;
		this.name = name;
		this.average = 0;
		this.setVotes(0);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getMedia() {
		return average;
	}
	public void setMedia(float media) {
		this.average = media;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getVotes() {
		return votes;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}
}
