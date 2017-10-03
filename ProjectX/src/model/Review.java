package model;

public class Review {
	private int idGioco;
	private String text;
	private int vote;
	private int approved;
	private int idUser;
	
	public Review(String text, int vote, int idGioco, int approved, int idUser) {
		this.idUser = idUser;
		this.idGioco = idGioco;
		this.text = text;
		this.vote = vote;
		this.approved = approved;
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
	

	public int isApproved() {
		return approved;
	}

	public void setApproved(int approved) {
		this.approved = approved;
	}

	public int getVote() {
		return vote;
	}

	public void setVote(int vote) {
		this.vote = vote;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	
}
