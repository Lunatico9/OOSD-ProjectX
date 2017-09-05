package controller;

import java.sql.ResultSet;

import database.DatabaseMySQL;

public class AcceptReviewController {
	
	public static void Accetta(int idReview, String text, int vote) throws Exception{
		String query= "SELECT idReview FROM review WHERE idReview='"+idReview+"' text='"+text+"' AND vote='"+vote+"' ";
		ResultSet rst= DatabaseMySQL.SendQuery(query);
		if(rst.next()){
		}
		String query2= "INSERT INTO review (idReview, text, vote, approved) VALUES ('"+idReview+"', '"+text+"', '"+vote+"', '1')";
		ResultSet rst2= DatabaseMySQL.SendQuery(query2);
	}

}
