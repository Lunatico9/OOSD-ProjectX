package model;

public class Actor {
	private String username;
	private String password;
	private int level;
	private int xP;
	private String name;
	private String cognome;
	private enum usertype { user, moderator, administrator};
	
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
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
}
