package model;

import java.sql.Date;

public class Game {
	private int id;
	private String name;
	private float average;
	private int votes;
	private String dataDiUscita;
	private String genere;
	
	public Game(String name, String dataDiUscita, String genere) {
		this.id = 0;
		this.name = name;
		this.average = 0;
		this.setVotes(0);
		this.setGenere(genere);
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
	public String getDataDiUscita() {
		return dataDiUscita;
	}
	public void setDataDiUscita(String dataDiUscita) {
		this.dataDiUscita = dataDiUscita;
	}
	public String getGenere() {
		return genere;
	}
	public void setGenere(String genere) {
		this.genere = genere;
	}
}
