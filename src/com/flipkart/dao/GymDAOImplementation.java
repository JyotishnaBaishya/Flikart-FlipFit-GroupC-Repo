/**
 * jyotishna.baishya
 */
package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;

/**
 * 
 */
public class GymDAOImplementation implements GymDAOInterface {
	
	static final String TABLE_GYM = "GYM";

	static final String INSERT_GYM = "INSERT INTO " + TABLE_GYM
			+ " (gymOwnerID, location, noOfSeats, isApproved) " + " VALUES (?, ?, ?, ?)";
	static final String SELECT_GYM = "SELECT * FROM " + TABLE_GYM;
	
	static final String VIEW_REGISTERED_GYM = SELECT_GYM + " WHERE gymOwnerID=(?)";

	@Override
	public int insert(Gym gym) {
		// TODO Auto-generated method stub
		int rowsUpdated = 0;
		Connection connection = DBConnection.getConnection();
		if (connection != null) {
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_GYM);
				prepareStatement(preparedStatement, gym);
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

	@Override
	public ArrayList<Gym> viewRegisteredGyms(int gymOwnerID) {
		// TODO Auto-generated method stub
		
		Connection connection = DBConnection.getConnection();
		
		if(connection != null) {
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(VIEW_REGISTERED_GYM);
				preparedStatement.setInt(gymOwnerID, gymOwnerID);
				System.out.println(preparedStatement);
				ResultSet output = preparedStatement.executeQuery();
			    System.out.println("\tID\tGymOwnerId\tLocation\tSeats\tApproved");
			    while(output.next()) {
			    	System.out.println("\t"+output.getString(1) + "\t " + output.getString(2) + "\t " + output.getString(3) + "\t " + output.getString(4) + "\t " + output.getString(5));
			    }
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			try {
				connection.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	private void prepareStatement(PreparedStatement preparedStatement, Gym gym) {
		try {
			preparedStatement.setInt(1, gym.getGymOwnerID());
			preparedStatement.setString(2, gym.getLocation());
			preparedStatement.setInt(3, gym.getNoOfSeats());
			preparedStatement.setBoolean(4, gym.isApproved());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	// Driver
		public static void main(String args[]) {
			GymDAOInterface gymDAO = new GymDAOImplementation();
//			Gym gym = new Gym();
//			gym.setGymOwnerID(1);
//			gym.setLocation("loc1");
//			gym.setNoOfSeats(20);
//			gym.setApproved(false);
//			gymDAO.insert(gym);
			
			gymDAO.viewRegisteredGyms(1);

		}
	
}
