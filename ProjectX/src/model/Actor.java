package model;

public class Actor {
	private  int id;
	private  String username;
	private  String password = null;
	private  int level;
	private  int exp;
	private  String email;
	private  String name;
	private  String surname;
	private  String type;
	
	public Actor(int id,String username, String password, String name, String surname, String email, int level, int exp, String type) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.surname= surname;
		this.setEmail(email);
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
