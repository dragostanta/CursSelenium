package curs8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConn {
	
	
	public static Connection openDbConnection (String hostname, String username, String pass) {
		
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(hostname, username, pass);
			System.out.println("Conexiune cu succes!");
		} catch (SQLException e) {
			System.out.println("Nu am putut face conexiunea!");
			e.printStackTrace();
		}
		return conn;
		
	}
	
	public static void closeDbConnection(Connection conn) {
		
		try {
			System.out.println("Incerc sa inchid conexiune!");
			conn.close();
			System.out.println("Am inchis conexiunea!");
		} catch (SQLException e) {

			System.out.println("Nu am resusit sa inchid conexiunea!");
			e.printStackTrace();
		}
		
	}

}
