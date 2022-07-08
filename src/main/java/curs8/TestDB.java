package curs8;

import java.sql.Connection;

public class TestDB {
	
	static String URL = "jdbc:mysql:...";
	static String USER = "";
	static String PASS = "";
	

	public static void main(String[] args) {

		Connection conn =  DbConn.openDbConnection(URL, USER, PASS);
		
		String select = "select * from customers;";
		System.out.println(DbQuery.dbSelectQuery(conn, select));
		
		String update = "update customers set CustomerName = 'Nimic' where CustomerName='Dragos'";
		DbQuery.dbUpdateQuery(conn, update);
		System.out.println(DbQuery.dbSelectQuery(conn, select));
		DbConn.closeDbConnection(conn);
	
	}

}
