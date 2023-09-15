/**
 * 
 */
package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.flipkart.bean.User;
import com.flipkart.constants.Constants;

/**
 * 
 */
public class UserDAOImplementation implements UserDAOInterface{

	static final String TABLE_USER = "USER";

	static final String INSERT_USER = "INSERT INTO " + TABLE_USER + " (username, password, role) "
			+ " VALUES (?, ?, ?)";
	
	static final String SELECT_USER = "SELECT * FROM " + TABLE_USER;
	
	static final String WHERE_USERNAME = " WHERE username = ";

	@Override
	public int register(User user) {
		int rowsUpdated = 0;
		Connection connection = DBConnection.getConnection();
		if (connection != null) {
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER);
				prepareStatement(preparedStatement, user);
				rowsUpdated = DBConnection.executeDMLQuery(preparedStatement);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("# of DB Rows successfully updated: " + rowsUpdated);
		return rowsUpdated;

	}
	
	public User loginUser(String username, String password) {
		User user = null;
		Connection connection = DBConnection.getConnection();
		String generatedColumns[] = { "ID" };
		if (connection != null) {
			try {
				String selectQuery = SELECT_USER + WHERE_USERNAME + "'"+username+"'";
				PreparedStatement preparedStatement = connection.prepareStatement(selectQuery, generatedColumns);
				ResultSet rs = preparedStatement.executeQuery();
				while(rs.next()){
					 //Retrieve by column name
					 int userID  = rs.getInt("ID");
					 String usernameRecieved = rs.getString("username");
					 String passwordRecieved = rs.getString("password");
					 String roleRecieved = rs.getString("role");
					 
					 if(password != passwordRecieved) {
						 System.out.println("Wrong username or password please try again!!");
					 }else {
						 user = new User();
						 user.setUserID(userID);
						 user.setPassword(passwordRecieved);
						 user.setRole(roleRecieved);
						 user.setUserName(usernameRecieved);
						 
						 System.out.println(userID);
						 System.out.println(passwordRecieved);
						 System.out.println(roleRecieved);
						 System.out.println(usernameRecieved + "1");
						 
					 }
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
	}
	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(String id, User user) {
		// TODO Auto-generated method stub

	}

	private void prepareStatement(PreparedStatement preparedStatement, User user) {
		try {
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getRole());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Driver
	public static void main(String[] args) {
		UserDAOInterface userDAO = new UserDAOImplementation();
		User user = new User();
		user.setUserName("gymown2");
		user.setPassword("pass");
		user.setRole(Constants.ROLE_GYMOWNER);
		
		userDAO.register(user);
		User loggedIn = userDAO.loginUser("gymown2","pass");
		
		
//		User user2 = new User();
//		user.setUserName("gymowner2");
//		user.setPassword("pass2");
//		user.setRole(Constants.ROLE_GYMOWNER);
	}


}
