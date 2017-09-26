package model;

public class Actor {
	private static String username;
	private static String password;
	private static int level;
	private static int exp;
	private static String name;
	private static String surname;
	private static String type;
	
	public Actor(String user, String pass, String nome, String cognome, int lvl, int XP, String tipo) {
		username = user;
		password = pass;
		name = nome;
		surname= cognome;
		level = lvl;
		exp = XP;
		type= tipo;
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
