package model;

public class Actor {
	private  String username;
	private  String password = null;
	private  int level;
	private  int exp;
	private  String name;
	private  String surname;
	private  String type;
	
	public Actor(String username, String password, String name, String surname, int lvl, int exp, String type) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.surname= surname;
		this.level = level;
		this.exp = exp;
		this.type= type;
	}
	
	public Actor(String user, String type) {
		this.username = user;
		this.type = type;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String user) {
		username = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String pass) {
		password = pass;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int lvl) {
		level = lvl;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int XP) {
		exp = XP;
	}
	public String getName() {
		return name;
	}
	public void setName(String nome) {
		name = nome;
	}
	public String getCognome() {
		return surname;
	}
	public void setCognome(String cognome) {
		surname = cognome;
	}
	public String getType() {
		return type;
	}
	public void setType(String tipo) {
		type = tipo;
	}
}
