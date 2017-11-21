package controller;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import model.Actor;
import model.dao.Actor_DAO;

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
		Actor_DAO.AggiungiExp(user);
		user.setExp(user.getExp()+50); 
			ResultSet rst = Actor_DAO.selectExp(user);
			rst.next();
			int exp=rst.getInt("exp");
			String id=rst.getString("idUser");
			int IDtime=0;
			ResultSet result= Actor_DAO.maxTimeline();
			if(result.next()){
				IDtime=result.getInt(1)+1;
			}
			
			if(soglie.contains(exp)) {
				int i = soglie.indexOf(exp);
				String Premio = "Premio lv." + (i + 2);
				Actor_DAO.AggiornaLivello(i,user);
				Actor_DAO.AggiungiTimeline(IDtime,Premio,data,id);
				JOptionPane.showMessageDialog(null, "Congratulazioni sei salito al Livello " + (i + 2) + "!");
				user.setLevel(user.getLevel()+1);		
			}
		else { 
			JOptionPane.showMessageDialog(null, "Hai giocato per un ora e ti sono stati aggiunti 50 punti exp!");		
		}
		return user;
	}

}