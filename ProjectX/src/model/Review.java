package model;

public class Review {
	private int idGioco;
	private String text;
	private int vote;
	private boolean approved;
	private int idUser;
	
	public Review(String text, int vote, int idGioco, boolean approved, int idUser) {
		this.setIdUser(idUser);
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

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	
}
