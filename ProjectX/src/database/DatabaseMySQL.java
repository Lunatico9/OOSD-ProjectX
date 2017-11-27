package database;
import java.sql.*;
import javax.swing.JOptionPane;
import model.Actor;

public class DatabaseMySQL {
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/gaming";
	private static String user = "root";
	private static String psw = "";
	/**
	 * Stabilisce una connessione con il database
	 * @return a database Connection
	 * @throws Exception
	 */
	public static Connection Connection() throws Exception {
		Connection con  = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection (url, user, psw);
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Errore nella connessione con il database");
			e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				}
		return con;
	}
	/**
	 * Manda una query al database e ritorna un ResultSet
	 * @param query La query da eseguire sul database
	 * @return a ResultSet
	 * @throws Exception
	 */
	public static ResultSet SendQuery(String query) throws Exception {
		Connection con = Connection();
		Statement stt = con.createStatement();
		stt.execute(query);
		ResultSet rst = stt.getResultSet();
		return rst;
	}
}
