package model.dao;

import java.sql.ResultSet;
import model.Actor;

public interface Actor_DAO_Interface {
	
	public static void UpdatePassword(String newPass, String username) throws Exception{
	}
	
	public static ResultSet maxUser() throws Exception {
	}
	
	public static boolean verify(String username) throws Exception{
	}

	public static ResultSet selectUsers() throws Exception{
	}
	
	public static ResultSet selectUsers(String username, String password) throws Exception{
	}
	
	public static ResultSet selectUsername(int ID) throws Exception{
	}
	
	public static ResultSet maxTimeline() throws Exception {
	}

	public static ResultSet Degrade(String username) throws Exception{
	}
	
	public static ResultSet Upgrade(String username) throws Exception{
	}
	
	public static ResultSet getTimeline(Actor user) throws Exception{
	}
	
	public static ResultSet selectExp(Actor user) throws Exception{
	}
	
	public static ResultSet AggiungiExp(Actor user) throws Exception{
	}
	
	public static ResultSet AggiornaLivello(int i, Actor user) throws Exception{
	}
	
	public static ResultSet AggiungiTimeline(int IDtime, String Premio, String data, String id) throws Exception{
	}
	
	public static void AddUser(String username, String pass1, String name, String surname, String email, int level, int exp, String type) throws Exception{
	}
}