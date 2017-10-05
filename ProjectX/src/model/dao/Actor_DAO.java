package model.dao;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JOptionPane;

import database.DatabaseMySQL;

public class Actor_DAO {
	
	public static void UpdatePassword(String newPass, String username) throws Exception{
		String query = "UPDATE user SET password = '" + newPass + "' WHERE username = '" + username + "'";
		ResultSet rst = DatabaseMySQL.SendQuery(query);
	}
	
	public static void AddUser(String username, String pass1, String name, String surname, String email, int level, int exp, String type) throws Exception{
		String Tipo= "User";
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
