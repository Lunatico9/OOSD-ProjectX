package database;
import java.sql.*;
public class DatabaseMySQL {
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/Gaming";
	private static String user = "root";
	private static String psw = "";
	public static Connection Connection() throws Exception {
		Connection con  = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection (url, user, psw);
			System.out.println(con);
			Statement stt = con.createStatement();
			stt.execute("SELECT * FROM People");
			ResultSet rst = stt.getResultSet();
			while(rst.next()) {
			System.out.println(rst.getString(1));
			}
		}catch(SQLException e) {
			e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				}
		return con;
		
	}
}
