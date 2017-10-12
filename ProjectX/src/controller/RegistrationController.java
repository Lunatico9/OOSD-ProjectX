package controller;

public class RegistrationController {
	
	public static boolean pass(String pass1, String pass2){
		if (pass1.equals(pass2)) return true;
		else return false;
	}
}
	
	