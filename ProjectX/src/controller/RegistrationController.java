package controller;

public class RegistrationController {
	
	public static boolean verify(String username){
		String sqlQuery = "SELECT username FROM user";
		if(username.equals(sqlQuery)){ 
			 return true; 
				}
		else return false;
	}
	
	public static boolean pass(String pass1, String pass2){
		if (pass1.equals(pass2)) return true;
		else return false;
	}
	
	public static void AddUser(String Username, String Password){
		
	}
}
