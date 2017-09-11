package controller;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

import database.DatabaseMySQL;

public class PlayController {
	
	public static void Gioca(String username) throws Exception {
		String query2 = "UPDATE user SET exp = exp + 50 WHERE username = '" + username + "'";
		ResultSet rst =DatabaseMySQL.SendQuery(query2); 
		String query = "SELECT exp FROM user  WHERE username = '" + username + "'", qdu;
		rst = DatabaseMySQL.SendQuery(query);
		if (rst.next()){
			int exp=rst.getInt("exp");
			if(exp==100||exp==300||exp==600||exp==1000||exp==1500||exp==2100||exp==2800||exp==3600||exp==4500){
				if(exp==100){
					qdu="UPDATE user SET level=2 WHERE username = '" + username + "'";
					ResultSet lvl= DatabaseMySQL.SendQuery(qdu);
					JOptionPane.showMessageDialog(null, "Congratulazioni sei salito al Livello 2!");
				}
				if(exp==300){
					qdu="UPDATE user SET level=3 WHERE username = '" + username + "'";
					ResultSet lvl= DatabaseMySQL.SendQuery(qdu);
					JOptionPane.showMessageDialog(null, "Congratulazioni sei salito al Livello 3!");
				}
				if(exp==600){
					qdu="UPDATE user SET level=4 WHERE username = '" + username + "'";
					ResultSet lvl= DatabaseMySQL.SendQuery(qdu);
					JOptionPane.showMessageDialog(null, "Congratulazioni sei salito al Livello 4!");
				}
				if(exp==1000){
					qdu="UPDATE user SET level=5 WHERE username = '" + username + "'";
					ResultSet lvl= DatabaseMySQL.SendQuery(qdu);
					JOptionPane.showMessageDialog(null, "Congratulazioni sei salito al Livello 5!");
				}
				if(exp==1500){
					qdu="UPDATE user SET level=6 WHERE username = '" + username + "'";
					ResultSet lvl= DatabaseMySQL.SendQuery(qdu);
					JOptionPane.showMessageDialog(null, "Congratulazioni sei salito al Livello 6!");
				}
				if(exp==2100){
					qdu="UPDATE user SET level=7 WHERE username = '" + username + "'";
					ResultSet lvl= DatabaseMySQL.SendQuery(qdu);
					JOptionPane.showMessageDialog(null, "Congratulazioni sei salito al Livello 7!");
				}
				if(exp==2800){
					qdu="UPDATE user SET level=8 WHERE username = '" + username + "'";
					ResultSet lvl= DatabaseMySQL.SendQuery(qdu);
					JOptionPane.showMessageDialog(null, "Congratulazioni sei salito al Livello 8!");
				}
				if(exp==3600){
					qdu="UPDATE user SET level=9 WHERE username = '" + username + "'";
					ResultSet lvl= DatabaseMySQL.SendQuery(qdu);
					JOptionPane.showMessageDialog(null, "Congratulazioni sei salito al Livello 9!");
				}
				if(exp==4500){
					qdu="UPDATE user SET level=10 WHERE username = '" + username + "'";
					ResultSet lvl= DatabaseMySQL.SendQuery(qdu);
					JOptionPane.showMessageDialog(null, "Congratulazioni sei salito al Livello 10!");
				}
			}
			else JOptionPane.showMessageDialog(null, "Hai giocato per un ora e ti sono stati aggiunti 50 punti exp!");
		}
	}
	}

