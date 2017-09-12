package controller;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JOptionPane;

import database.DatabaseMySQL;

public class PlayController {
	
	public static void Gioca(String username) throws Exception {
		Calendar today= Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy-hh:mm:ss");
		String data= formatter.format(today.getTime());
		String query2 = "UPDATE user SET exp = exp + 50 WHERE username = '" + username + "'";
		ResultSet rst =DatabaseMySQL.SendQuery(query2); 
		String query = "SELECT exp, idUser FROM user  WHERE username = '" + username + "'", qdu, qdu2;
		String Premio2="Premio Lvl.2";
		String Premio3="Premio Lvl.3";
		String Premio4="Premio Lvl.4";
		String Premio5="Premio Lvl.5";
		String Premio6="Premio Lvl.6";
		String Premio7="Premio Lvl.7";
		String Premio8="Premio Lvl.8";
		String Premio9="Premio Lvl.9";
		String Premio10="Premio Lvl.10";
		rst = DatabaseMySQL.SendQuery(query);
		if (rst.next()){
			int exp=rst.getInt("exp");
			String id=rst.getString("idUser");
			int IDtime=0;
			String controllo="SELECT MAX(idTimeline) FROM timeline";
			ResultSet result= DatabaseMySQL.SendQuery(controllo);
			if(result.next()){
				IDtime=result.getInt(1)+1;
			}
			if(exp==100||exp==300||exp==600||exp==1000||exp==1500||exp==2100||exp==2800||exp==3600||exp==4500){
				if(exp==100){
					qdu="UPDATE user SET level=2 WHERE username = '" + username + "'";
					ResultSet lvl= DatabaseMySQL.SendQuery(qdu);
					qdu2="INSERT INTO timeline (idTimeline, Premio, data, User_idUser) VALUES ('"+IDtime+"','"+Premio2+"','"+data+"','"+id+"')";
					ResultSet pr=DatabaseMySQL.SendQuery(qdu2);
					JOptionPane.showMessageDialog(null, "Congratulazioni sei salito al Livello 2!");
				}
				if(exp==300){
					qdu="UPDATE user SET level=3 WHERE username = '" + username + "'";
					ResultSet lvl= DatabaseMySQL.SendQuery(qdu);
					qdu2="INSERT INTO timeline (idTimeline, Premio, data, User_idUser) VALUES ('"+IDtime+"','"+Premio3+"','"+data+"','"+id+"')";
					ResultSet pr=DatabaseMySQL.SendQuery(qdu2);
					JOptionPane.showMessageDialog(null, "Congratulazioni sei salito al Livello 3!");
				}
				if(exp==600){
					qdu="UPDATE user SET level=4 WHERE username = '" + username + "'";
					ResultSet lvl= DatabaseMySQL.SendQuery(qdu);
					qdu2="INSERT INTO timeline (idTimeline, Premio, data, User_idUser) VALUES ('"+IDtime+"','"+Premio4+"','"+data+"','"+id+"')";
					ResultSet pr=DatabaseMySQL.SendQuery(qdu2);
					JOptionPane.showMessageDialog(null, "Congratulazioni sei salito al Livello 4!");
				}
				if(exp==1000){
					qdu="UPDATE user SET level=5 WHERE username = '" + username + "'";
					ResultSet lvl= DatabaseMySQL.SendQuery(qdu);
					qdu2="INSERT INTO timeline (idTimeline, Premio, data, User_idUser) VALUES ('"+IDtime+"','"+Premio5+"','"+data+"','"+id+"')";
					ResultSet pr=DatabaseMySQL.SendQuery(qdu2);
					JOptionPane.showMessageDialog(null, "Congratulazioni sei salito al Livello 5!");
				}
				if(exp==1500){
					qdu="UPDATE user SET level=6 WHERE username = '" + username + "'";
					ResultSet lvl= DatabaseMySQL.SendQuery(qdu);
					qdu2="INSERT INTO timeline (idTimeline, Premio, data, User_idUser) VALUES ('"+IDtime+"','"+Premio6+"','"+data+"','"+id+"')";
					ResultSet pr=DatabaseMySQL.SendQuery(qdu2);
					JOptionPane.showMessageDialog(null, "Congratulazioni sei salito al Livello 6!");
				}
				if(exp==2100){
					qdu="UPDATE user SET level=7 WHERE username = '" + username + "'";
					ResultSet lvl= DatabaseMySQL.SendQuery(qdu);
					qdu2="INSERT INTO timeline (idTimeline, Premio, data, User_idUser) VALUES ('"+IDtime+"','"+Premio7+"','"+data+"','"+id+"')";
					ResultSet pr=DatabaseMySQL.SendQuery(qdu2);
					JOptionPane.showMessageDialog(null, "Congratulazioni sei salito al Livello 7!");
				}
				if(exp==2800){
					qdu="UPDATE user SET level=8 WHERE username = '" + username + "'";
					ResultSet lvl= DatabaseMySQL.SendQuery(qdu);
					qdu2="INSERT INTO timeline (idTimeline, Premio, data, User_idUser) VALUES ('"+IDtime+"','"+Premio8+"','"+data+"','"+id+"')";
					ResultSet pr=DatabaseMySQL.SendQuery(qdu2);
					JOptionPane.showMessageDialog(null, "Congratulazioni sei salito al Livello 8!");
				}
				if(exp==3600){
					qdu="UPDATE user SET level=9 WHERE username = '" + username + "'";
					ResultSet lvl= DatabaseMySQL.SendQuery(qdu);
					qdu2="INSERT INTO timeline (idTimeline, Premio, data, User_idUser) VALUES ('"+IDtime+"','"+Premio9+"','"+data+"','"+id+"')";
					ResultSet pr=DatabaseMySQL.SendQuery(qdu2);
					JOptionPane.showMessageDialog(null, "Congratulazioni sei salito al Livello 9!");
				}
				if(exp==4500){
					qdu="UPDATE user SET level=10 WHERE username = '" + username + "'";
					ResultSet lvl= DatabaseMySQL.SendQuery(qdu);
					qdu2="INSERT INTO timeline (idTimeline, Premio, data, User_idUser) VALUES ('"+IDtime+"','"+Premio10+"','"+data+"','"+id+"')";
					ResultSet pr=DatabaseMySQL.SendQuery(qdu2);
					JOptionPane.showMessageDialog(null, "Congratulazioni sei salito al Livello 10, il massimo!");
				}
			}
			else JOptionPane.showMessageDialog(null, "Hai giocato per un ora e ti sono stati aggiunti 50 punti exp!");
		}
	}
}