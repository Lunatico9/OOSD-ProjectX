package model;

public class Actor {
	private String username;
	private String password;
	private int level;
	private int xP;
	private String name;
	private String surname;
	private enum usertype { user, moderator, administrator};
	
	public Actor(String user, String pass, String name, String surname) {
		this.username = user;
		this.password = pass;
		this.name = name;
		this.surname= surname;
		this.level = 0;
		this.xP = 0;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getxP() {
		return xP;
	}
	public void setxP(int xP) {
		this.xP = xP;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCognome() {
		return surname;
	}
	public void setCognome(String cognome) {
		this.surname = cognome;
	}
}
