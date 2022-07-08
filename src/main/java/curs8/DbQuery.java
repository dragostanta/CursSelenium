package curs8;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DbQuery {
	
	
	public static List<String> dbSelectQuery (Connection conn, String query) {
		List<String> resultList =  new ArrayList<String>();
		
		try {
			Statement statement =  conn.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
				resultList.add(resultSet.getString(2));
			}
			
		} catch (SQLException e) {
				System.out.println("Nu am putut sa execut query!");
				e.printStackTrace();
		}
		return resultList;
	
	}
	
	public static void dbUpdateQuery(Connection conn, String query) {
		
		try {
			Statement statement =  conn.createStatement();
			statement.executeUpdate(query);

			
		} catch (SQLException e) {
				System.out.println("Nu am putut sa execut update query!");
				e.printStackTrace();
		}
		
	}
	

}
