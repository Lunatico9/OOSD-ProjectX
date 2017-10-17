package database;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import model.Actor;
import model.Game;

public class DatabaseMySQL {
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/gaming";
	private static String user = "root";
	private static String psw = "";
	public static Connection Connection() throws Exception {
		Connection con  = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection (url, user, psw);
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Errore nella connessione con il database");
			e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				}
		return con;
	}
	
	public static ResultSet SendQuery(String query) throws Exception {
		Connection con = Connection();
		Statement stt = con.createStatement();
		stt.execute(query);
		ResultSet rst = stt.getResultSet();
		return rst;
	}
	
	public static ResultSet maxUser() throws Exception {
		String query= "SELECT MAX(idUser) FROM user";
		return SendQuery(query);
	}
	
	public static ResultSet maxTimeline() throws Exception {
		String timeline= "SELECT MAX(idTimeline) FROM timeline";
		return SendQuery(timeline);
	}

	public static ResultSet Degrade(String username) throws Exception{
		String query = "UPDATE user SET type = '" + "giocatore" + "' WHERE username = '" + username + "'";
		return SendQuery(query);
	}
	
	public static ResultSet Upgrade(String username) throws Exception{
		String query = "UPDATE user SET type = '" + "moderatore" + "' WHERE username = '" + username + "'";
		return SendQuery(query);
	}
	
	public static ResultSet getTimeline(Actor user) throws Exception{
		String query2="Select * From timeline Where User_idUser='"+ user.getId() +"' Order By idTimeline";
		return SendQuery(query2); 
	}
	
	public static boolean verify(String username) throws Exception{
		String sqlQuery = "SELECT username FROM user WHERE username='"+ username + "'";
		ResultSet rst= SendQuery(sqlQuery);
		return rst.next();
	}

	public static ResultSet selectUsers() throws Exception{
		String query = "SELECT * FROM user";
		return SendQuery(query);
	}
	
	public static ResultSet selectUsername(int ID) throws Exception{
		String query = "SELECT username FROM user WHERE idUser='" + ID + "'";
		return SendQuery(query);
	}
	
	public static ResultSet selectExp(Actor user) throws Exception{
		String query = "SELECT exp, idUser FROM user  WHERE username = '" + user.getUsername() + "'";
		return SendQuery(query);
	}
	
	public static ResultSet AggiungiExp(Actor user) throws Exception{
		String query2 = "UPDATE user SET exp = exp + 50 WHERE username = '" + user.getUsername() + "'";
		return SendQuery(query2);
	}
	
	public static ResultSet AggiornaLivello(int i, Actor user) throws Exception{
		String qdu="UPDATE user SET level=" + (i + 2) + " WHERE username = '" + user.getUsername() + "'";
		return SendQuery(qdu);
	}
	
	public static ResultSet AggiungiTimeline(int IDtime, String Premio, String data, String id) throws Exception{
		String qdu2="INSERT INTO timeline (idTimeline, Premio, data, User_idUser) VALUES ('"+IDtime+"','"+Premio+"','"+data+"','"+id+"')";
		return SendQuery(qdu2);
	}
}
