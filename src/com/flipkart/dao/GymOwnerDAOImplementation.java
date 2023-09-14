/**
 * 
 */
package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.flipkart.bean.GymOwner;
/**
 * 
 */
public class GymOwnerDAOImplementation implements GymOwnerDAOInterface {
	static final String TABLE_GYM_OWNER = "GYMOWNER";

	static final String INSERT_GYM_OWNER = "INSERT INTO " + TABLE_GYM_OWNER + " (username, password, aadharcard, gstin, isApproved) "
			+ " VALUES (?, ?, ?, ?, ?)";
	@Override
	public int insert(GymOwner gymOwner) {
		int rowsUpdated = 0;
		Connection connection = DBConnection.getConnection();
		if (connection != null) {
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_GYM_OWNER);
				prepareStatement(preparedStatement, gymOwner);
				rowsUpdated = DBConnection.executeDMLQuery(connection, preparedStatement);
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

	private void prepareStatement(PreparedStatement preparedStatement, GymOwner gymOwner) {
		try {
			preparedStatement.setString(1, gymOwner.getUserName());
			preparedStatement.setString(2, gymOwner.getPassword());
			preparedStatement.setString(3, gymOwner.getAadharCard());
			preparedStatement.setString(4, gymOwner.getGstIN());
			preparedStatement.setBoolean(5, false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(String id, GymOwner newGymOwner) {
		// TODO Auto-generated method stub
		
	}
	
	// Driver
	public static void main(String args[]) {
		GymOwnerDAOInterface custDAO = new GymOwnerDAOImplementation();
		GymOwner gymOwner = new GymOwner();
		gymOwner.setUserName("GymOwner1");
		gymOwner.setPassword("pass");
		gymOwner.setAadharCard("1234-2345-1234");
		gymOwner.setGstIN("22AAAAA0000A1Z5");
		
		custDAO.insert(gymOwner);
	}
	
}
