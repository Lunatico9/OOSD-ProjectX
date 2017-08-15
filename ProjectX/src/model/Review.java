package model;

import java.util.Calendar;

public class Review {
	private java.util.Date date;
	private int idGioco;
	private String text;
	private int vote;
	private boolean approved;
	
	public Review(String text, int vote) {
		Calendar today = Calendar.getInstance();
		this.date = today.getTime();
		this.idGioco = 0;
		this.text = text;
		this.vote = vote;
		this.approved = false;
	}
	

	public java.util.Date getData() {
		return date;
	}

	public void setData(java.util.Date data) {
		this.date = data;
	}

	public int getIdGioco() {
		return idGioco;
	}

	public void setIdGioco(int idGioco) {
		this.idGioco = idGioco;
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public int getVoto() {
		return vote;
	}

	public void setVoto(int voto) {
		this.vote = voto;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public int getVote() {
		return vote;
	}

	public void setVote(int vote) {
		this.vote = vote;
	}

	public java.util.Date getDate() {
		return date;
	}

	public void setDate(java.util.Date date) {
		this.date = date;
	}
}
