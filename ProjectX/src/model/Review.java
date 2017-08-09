package model;

import java.util.Calendar;

public class Review {
	private java.util.Date date;
	private int idGioco;
	private String usernameActor;
	private int vote;
	private boolean approved;
	
	public Review(int idGioco, String usernameActor, int vote) {
		Calendar today = Calendar.getInstance();
		today.clear(Calendar.HOUR); today.clear(Calendar.MINUTE); today.clear(Calendar.SECOND);
		this.date = today.getTime();
		this.idGioco = idGioco;
		this.usernameActor = usernameActor;
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

	public String getUsernameActor() {
		return usernameActor;
	}

	public void setUsernameActor(String usernameActor) {
		this.usernameActor = usernameActor;
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
