package database;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import model.Actor;
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
		ResultSet result= DatabaseMySQL.SendQuery(query);
		return result;
	}
	
	public static ResultSet maxTimeline() throws Exception {
		String timeline= "SELECT MAX(idTimeline) FROM timeline";
		ResultSet pr= DatabaseMySQL.SendQuery(timeline);
		return pr;
	}
	
	public static ResultSet AddUser(String Username, String Password, String Name, String Surname, String Email, int level, int exp, String tipo) throws Exception {
		String Tipo= "User";
		int IDuser=1;
		String sqlQuery = "INSERT INTO `user` (`username`, `password`, `type`,`name`,`surname`,`email`,`idUser`,`exp`,`level` ) VALUES ('" + Username + "', '" + Password + "', '"+ Tipo +"', '"+ Name +"', '"+ Surname +"', '"+ Email +"', '"+ IDuser +"', '"+exp+"','"+level+"')";
		ResultSet rst = DatabaseMySQL.SendQuery(sqlQuery);
		return rst;
	}
	
	public static ResultSet insertTimeline() throws Exception {
		int IDuser=1, IDtime=1;
		Calendar today=Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy-hh:mm:ss");
		String data= formatter.format(today.getTime());
		String Premio1="Premio di Benvenuto Lvl.1";
		String time= "INSERT INTO timeline (idTimeline, Premio, data, User_idUser) VALUES ('"+IDtime+"','"+Premio1+"','"+data+"','"+IDuser+"')";
		ResultSet rst2=DatabaseMySQL.SendQuery(time);
		return rst2;
	}
	
	public static ResultSet Degrade(String username) throws Exception{
		String query = "UPDATE user SET type = '" + "giocatore" + "' WHERE username = '" + username + "'";
		ResultSet rst = DatabaseMySQL.SendQuery(query);
		return rst;
	}
	
	public static ResultSet Upgrade(String username) throws Exception{
		String query = "UPDATE user SET type = '" + "moderatore" + "' WHERE username = '" + username + "'";
		ResultSet rst = DatabaseMySQL.SendQuery(query);
		return rst;
	}
	
	public static ResultSet getTimeline(Actor user) throws Exception{
	String query2="Select * From timeline Where User_idUser='"+ user.getId() +"' Order By idTimeline";
	ResultSet rs= DatabaseMySQL.SendQuery(query2);
	return rs;
	}
	
	
	
	public static boolean verify(String username) throws Exception{
		String sqlQuery = "SELECT username FROM user WHERE username='"+ username + "'";
		ResultSet rst= DatabaseMySQL.SendQuery(sqlQuery);
		if(rst.next()){
			 return true; 
				}
		else{
			return false;
		}
	}

	public static ResultSet select(String username) throws Exception{
		String query = "SELECT * FROM user";
		ResultSet rst = DatabaseMySQL.SendQuery(query);
		return rst;
	}
}
