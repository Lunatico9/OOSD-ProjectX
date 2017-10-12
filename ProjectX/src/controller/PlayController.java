package controller;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JOptionPane;

import database.DatabaseMySQL;
import model.Actor;

public class PlayController {
	static List<Integer> soglie = soglie();
		
	public static List<Integer> soglie(){
		soglie = new ArrayList<Integer>(100);
		soglie.add(0,100);
		for(int i = 1; i < 100; i++) {
			soglie.add(i, soglie.get(i-1) + ((i+1) * 100));
		}
		return soglie;
	}
	
	
	public static Actor Gioca(Actor user) throws Exception {
		
		Calendar today= Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy-hh:mm:ss");
		String data= formatter.format(today.getTime());
		String query2 = "UPDATE user SET exp = exp + 50 WHERE username = '" + user.getUsername() + "'";
		String query = "SELECT exp, idUser FROM user  WHERE username = '" + user.getUsername() + "'", qdu, qdu2;
		user.setExp(user.getExp()+50);
		ResultSet rst =DatabaseMySQL.SendQuery(query2); 
			rst = DatabaseMySQL.SendQuery(query);
			rst.next();
			int exp=rst.getInt("exp");
			String id=rst.getString("idUser");
			int IDtime=0;
			ResultSet result= DatabaseMySQL.maxTimeline();
			if(result.next()){
				IDtime=result.getInt(1)+1;
			}
			
			if(soglie.contains(exp)) {
				int i = soglie.indexOf(exp);
				String Premio = "Premio lv." + (i + 2);
					qdu="UPDATE user SET level=" + (i + 2) + " WHERE username = '" + user.getUsername() + "'";
					DatabaseMySQL.SendQuery(qdu);
					qdu2="INSERT INTO timeline (idTimeline, Premio, data, User_idUser) VALUES ('"+IDtime+"','"+Premio+"','"+data+"','"+id+"')";
					DatabaseMySQL.SendQuery(qdu2);
					JOptionPane.showMessageDialog(null, "Congratulazioni sei salito al Livello " + (i + 2) + "!");
					user.setLevel(user.getLevel()+1);		
			}
		else { 
			JOptionPane.showMessageDialog(null, "Hai giocato per un ora e ti sono stati aggiunti 50 punti exp!");		
		}
		return user;
	}

}