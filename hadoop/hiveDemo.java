package org.hadoop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.hive.jdbc.HiveDriver;

public class hiveDemo {
	private static String driverName = "org.apache.hive.jdbc.HiveDriver";
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName(driverName);
		Connection conn = DriverManager.getConnection("jdbc:hive://localhost:10000/default","","");
		Statement stmt = conn.createStatement();
		stmt.executeQuery("CREATE DATABASE userdb");
		System.out.println("Database userdb created successfully.");
		conn.close();
	}

}
