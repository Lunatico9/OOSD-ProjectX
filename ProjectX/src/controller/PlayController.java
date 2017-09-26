package controller;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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
		List<Integer> soglie = new ArrayList<Integer>(100);
		soglie.add(0,100);
		for(int i = 1; i < 100; i++) {
			soglie.add(i, soglie.get(i-1) + ((i+1) * 100));
		}

	
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
			
			
			if(soglie.contains(exp)) {
				int i = soglie.indexOf(exp);
				String Premio = "Premio lv." + (i + 2);
					qdu="UPDATE user SET level=" + (i + 2) + " WHERE username = '" + username + "'";
					DatabaseMySQL.SendQuery(qdu);
					qdu2="INSERT INTO timeline (idTimeline, Premio, data, User_idUser) VALUES ('"+IDtime+"','"+Premio+"','"+data+"','"+id+"')";
					DatabaseMySQL.SendQuery(qdu2);
					JOptionPane.showMessageDialog(null, "Congratulazioni sei salito al Livello " + (i + 2) + "!");
			}
		else JOptionPane.showMessageDialog(null, "Hai giocato per un ora e ti sono stati aggiunti 50 punti exp!");
		}
	}
}