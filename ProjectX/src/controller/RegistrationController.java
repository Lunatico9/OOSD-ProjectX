package controller;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

import database.DatabaseMySQL;
import model.Actor;

public class RegistrationController {
	
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
	
	public static boolean pass(String pass1, String pass2){
		if (pass1.equals(pass2)) return true;
		else return false;
	}
	
	public static void AddUser(String Username, String Password, String Name, String Surname, String Email) throws Exception{
		Actor x = new Actor(Username,Password,Name,Surname);
		String Tipo= "User";
		int IDuser=0;
		String query= "SELECT MAX(idUser) FROM user";
		ResultSet result= DatabaseMySQL.SendQuery(query);
		if(result.next()){
		 IDuser=result.getInt(1)+1;
		}
		String sqlQuery = "INSERT INTO `user` (`username`, `password`, `type`,`name`,`surname`,`email`,`idUser` ) VALUES ('" + Username + "', '" + Password + "', '"+ Tipo +"', '"+ Name +"', '"+ Surname +"', '"+ Email +"', '"+ IDuser +"')";
		ResultSet rst = DatabaseMySQL.SendQuery(sqlQuery);
		JOptionPane.showMessageDialog(null, "L'utente "+Username+" è stato registrato");
		}
	}
