package model;

import java.sql.Date;

public class Review {
	private Date date;
	private int idGioco;
	private String usernameActor;
	private int vote;
	private boolean approved = false;
	

	public Date getData() {
		return date;
	}

	public void setData(Date data) {
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
