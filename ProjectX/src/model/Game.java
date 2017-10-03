package model;

public class Game {
	private int id;
	private String name;
	private float average;
	
	public Game(int id,String name, float average) {
		this.id= id;
		this.name = name;
		this.average = average;
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
	public void setMedia(float average) {
		this.average = average;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
