/**
 * jyotishna.baishya
 */
package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	static final String VIEW_GYM_BY_GYMID = SELECT_GYM + " WHERE ID=(?)";

	@Override
	public boolean addGymCentre(Gym gym) {
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
				return false;
			}

			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		System.out.println("# of DB Rows successfully updated: " + rowsUpdated);
		return true;
	}

	@Override
	public ArrayList<Gym> getRegisteredGyms(int gymOwnerID) {
		// TODO Auto-generated method stub
		
		Connection connection = DBConnection.getConnection();
		ArrayList<Gym> registeredGyms = new ArrayList<Gym>();
		if(connection != null) {
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(VIEW_REGISTERED_GYM);
				preparedStatement.setInt(1, gymOwnerID);
				ResultSet output = preparedStatement.executeQuery();
			    while(output.next()) {
			    	int ID = output.getInt(1);
			    	String location = output.getString(3);
			    	int numberOfSeats = output.getInt(4);
			    	boolean isApproved= output.getBoolean(5);
			    	if(isApproved) {
			    		Gym currGym = new Gym();
			    		currGym.setGymID(ID);
			    		currGym.setApproved(isApproved);
			    		currGym.setGymOwnerID(gymOwnerID);
			    		currGym.setLocation(location);
			    		currGym.setNoOfSeats(numberOfSeats);
			    		registeredGyms.add(currGym);
			    	}
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
		
		return registeredGyms;
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
	
	@Override
	public Gym viewGym(int gymID) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(VIEW_GYM_BY_GYMID);
				preparedStatement.setInt(gymID, gymID);
				System.out.println(preparedStatement);
				ResultSet output = preparedStatement.executeQuery();
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
			
		return null;
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
		

		}

		
	
}
