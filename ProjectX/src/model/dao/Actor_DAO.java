package model.dao;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JOptionPane;

import database.DatabaseMySQL;
import model.Actor;

public class Actor_DAO implements Actor_DAO_Interface {
	
	public static void UpdatePassword(String newPass, String username) throws Exception{
		String query = "UPDATE user SET password = '" + newPass + "' WHERE username = '" + username + "'";
		ResultSet rst = DatabaseMySQL.SendQuery(query);
	}
	
	public static ResultSet maxUser() throws Exception {
		String query= "SELECT MAX(idUser) FROM user";
		return DatabaseMySQL.SendQuery(query);
	}
	
	public static boolean verify(String username) throws Exception{
		String sqlQuery = "SELECT username FROM user WHERE username='"+ username + "'";
		ResultSet rst= DatabaseMySQL.SendQuery(sqlQuery);
		return rst.next();
	}

	public static ResultSet selectUsers() throws Exception{
		String query="SELECT * FROM user";
		return DatabaseMySQL.SendQuery(query);
	}
	
	public static ResultSet selectUser(String username, String password) throws Exception{
		String query = "SELECT * FROM user WHERE username='"+username+"' AND password='"+password+"'";
		return DatabaseMySQL.SendQuery(query);
	}
	
	public static ResultSet selectUsername(int ID) throws Exception{
		String query = "SELECT username FROM user WHERE idUser='" + ID + "'";
		return DatabaseMySQL.SendQuery(query);
	}
	
	public static ResultSet maxTimeline() throws Exception {
		String timeline= "SELECT MAX(idTimeline) FROM timeline";
		return DatabaseMySQL.SendQuery(timeline);
	}

	public static ResultSet Degrade(String username) throws Exception{
		String query = "UPDATE user SET type = '" + "giocatore" + "' WHERE username = '" + username + "'";
		return DatabaseMySQL.SendQuery(query);
	}
	
	public static ResultSet Upgrade(String username) throws Exception{
		String query = "UPDATE user SET type = '" + "moderatore" + "' WHERE username = '" + username + "'";
		return DatabaseMySQL.SendQuery(query);
	}
	
	public static ResultSet getTimeline(Actor user) throws Exception{
		String query2="Select * From timeline Where User_idUser='"+ user.getId() +"' Order By idTimeline";
		return DatabaseMySQL.SendQuery(query2); 
	}
	
	public static ResultSet selectExp(Actor user) throws Exception{
		String query = "SELECT exp, idUser FROM user  WHERE username = '" + user.getUsername() + "'";
		return DatabaseMySQL.SendQuery(query);
	}
	
	public static ResultSet AggiungiExp(Actor user) throws Exception{
		String query2 = "UPDATE user SET exp = exp + 50 WHERE username = '" + user.getUsername() + "'";
		return DatabaseMySQL.SendQuery(query2);
	}
	
	public static ResultSet AggiornaLivello(int i, Actor user) throws Exception{
		String qdu="UPDATE user SET level=" + (i + 2) + " WHERE username = '" + user.getUsername() + "'";
		return DatabaseMySQL.SendQuery(qdu);
	}
	
	public static ResultSet AggiungiTimeline(int IDtime, String Premio, String data, String id) throws Exception{
		String qdu2="INSERT INTO timeline (idTimeline, Premio, data, User_idUser) VALUES ('"+IDtime+"','"+Premio+"','"+data+"','"+id+"')";
		return DatabaseMySQL.SendQuery(qdu2);
	}
	
	public static void AddUser(String username, String pass1, String name, String surname, String email, int level, int exp, String type) throws Exception{
		String Tipo= "giocatore";
		int IDuser=1, IDtime=1;
		Calendar today=Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy-hh:mm:ss");
		String data= formatter.format(today.getTime());
		String Premio1="Premio di Benvenuto Lvl.1";
		String query= "SELECT MAX(idUser) FROM user";
		String timeline= "SELECT MAX(idTimeline) FROM timeline"; 
		ResultSet pr= DatabaseMySQL.SendQuery(timeline);
		if(pr.next()){
			IDtime=pr.getInt(1)+1;
		}
		ResultSet result= DatabaseMySQL.SendQuery(query);
		if(result.next()){
		 IDuser=result.getInt(1)+1;
		}
		String time= "INSERT INTO timeline (idTimeline, Premio, data, User_idUser) VALUES ('"+IDtime+"','"+Premio1+"','"+data+"','"+IDuser+"')";
		String sqlQuery = "INSERT INTO `user` (`username`, `password`, `type`,`name`,`surname`,`email`,`idUser`,`exp`,`level` ) VALUES ('" + username + "', '" + pass1 + "', '"+ Tipo +"', '"+ name +"', '"+ surname +"', '"+ email +"', '"+ IDuser +"', '"+exp+"','"+level+"')";
		ResultSet rst = DatabaseMySQL.SendQuery(sqlQuery);
		ResultSet rst2=DatabaseMySQL.SendQuery(time);
		JOptionPane.showMessageDialog(null, "L'utente "+username+" è stato registrato");
		}
}
