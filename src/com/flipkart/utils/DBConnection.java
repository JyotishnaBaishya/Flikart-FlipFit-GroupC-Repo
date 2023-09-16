package com.flipkart.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * 
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 
 */
public class DBConnection {
	private static Connection connection = null;

	public static Connection getConnection() {
		try {
			if (isValid()) {
				return connection;
			} else {
				try {
					Properties prop = new Properties(); // Properties is used to read files
					InputStream inputStream = DBConnection.class.getClassLoader()
							.getResourceAsStream("./config.properties");
					prop.load(inputStream);
					String driver = prop.getProperty("driver");
					String url = prop.getProperty("url");
					String user = prop.getProperty("user");
					String password = prop.getProperty("password");
					Class.forName(driver);
					connection = DriverManager.getConnection(url, user, password);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;

	}

	public static boolean isValid() throws SQLException {
		return connection != null && !connection.isClosed();
	}
}

//public class DBConnection {
//	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//	static final String DB_URL = "jdbc:mysql://localhost/Flipfit";
//
//	static final String USER = "root";
//
//	static final String PASS = "password";
//	
//	public static int executeDMLQuery(PreparedStatement statement) {
//		if(statement != null) {
//			try {
//				//System.out.println("Executing Query " + statement);
//				return statement.executeUpdate();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		return 0;
//	}
//	
//	public static ResultSet executeQuery(PreparedStatement statement) {
//		ResultSet rs=null;
//		try {
//			rs = statement.executeQuery();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return rs;
//	}
//
//	public static Connection getConnection() {
//		Connection conn = null;
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//
//			System.out.println("Connecting to database...");
//			conn = DriverManager.getConnection(DB_URL, USER, PASS);
//		} catch (Exception e) {
//			System.out.println("Database could not be connected");
//		}
//		return conn;
//
//	}
//}
