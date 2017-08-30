package controller;

public class RegistrationController {
	
	public static boolean verify(String username){
		String sqlQuery = "SELECT username FROM user";
		if(username == sqlQuery){ 
			 return true; 
				}
		else return false;
	}
	
	

}
