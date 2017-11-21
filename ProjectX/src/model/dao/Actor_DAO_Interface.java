package model.dao;

import model.Actor;

public interface Actor_DAO_Interface {
	
	public static void UpdatePassword(String newPass, String username)throws Exception{};
	
	public static void maxUser()throws Exception{};
	
	public static void verify(String username)throws Exception{};

	public static void selectUsers()throws Exception{};
	
	public static void selectUser(String username, String password)throws Exception{};
	
	public static void selectUsername(int ID)throws Exception{};
	
	public static void maxTimeline()throws Exception{};

	public static void Degrade(String username)throws Exception{};
	
	public static void Upgrade(String username)throws Exception{};
	
	public static void getTimeline(Actor user)throws Exception{};
	
	public static void selectExp(Actor user)throws Exception{};
	
	public static void AggiungiExp(Actor user)throws Exception{};
	
	public static void AggiornaLivello(int i, Actor user)throws Exception{};
	
	public static void AggiungiTimeline(int IDtime, String Premio, String data, String id)throws Exception{};
	
	public static void AddUser(String username, String pass1, String name, String surname, String email, int level, int exp, String type) throws Exception{};
}