package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DatabaseMySQL;
import model.Actor;

public class Review_DAO implements Review_DAO_Interface {
	
	public static ArrayList<String[]> AwardsList(Actor user) throws Exception {
		ArrayList<String[]> AwardsList = new ArrayList<String[]>();
		try {
			String query = "SELECT * FROM timeline WHERE User_idUser = '" + user.getId() + "'";
			ResultSet rst = DatabaseMySQL.SendQuery(query);
			while(rst.next()) {
				String[] premio = {rst.getString(3),rst.getString(2)};
				AwardsList.add(premio);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return AwardsList;
	}
}
