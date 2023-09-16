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
import com.flipkart.constants.Constants;
import com.flipkart.constants.SqlConstants;
import com.flipkart.utils.DBConnection;

/**
 * 
 */
public class GymDAOImplementation implements GymDAOInterface {

	private static GymDAOInterface gymDaoObj = null;

	private GymDAOImplementation() {
	}

	public static synchronized GymDAOInterface getInstance() {
		if (gymDaoObj == null)
			gymDaoObj = new GymDAOImplementation();

		return gymDaoObj;
	}

	@Override
	public boolean addGymCentre(Gym gym) {
		// TODO Auto-generated method stub
		int rowsUpdated = 0;
		Connection connection = DBConnection.getConnection();
		if (connection != null) {
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(SqlConstants.INSERT_GYM);
				prepareStatement(preparedStatement, gym);
				rowsUpdated = preparedStatement.executeUpdate();
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
		
		Connection connection = DBConnection.getConnection();
		ArrayList<Gym> registeredGyms = new ArrayList<Gym>();
		if (connection != null) {
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(SqlConstants.VIEW_REGISTERED_GYM);
				preparedStatement.setInt(1, gymOwnerID);
				ResultSet output = preparedStatement.executeQuery();
				while (output.next()) {
					int ID = output.getInt(1);
					String location = output.getString(3);
					int numberOfSeats = output.getInt(4);
					boolean isApproved = output.getBoolean(5);
					if (isApproved) {
						Gym currGym = new Gym();
						currGym.setGymID(ID);
						currGym.setApproved(isApproved);
						currGym.setGymOwnerID(gymOwnerID);
						currGym.setLocation(location);
						currGym.setNoOfSeats(numberOfSeats);
						registeredGyms.add(currGym);
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

	public ArrayList<Gym> getPendingGymRegistrationRequests() {
		ResultSet resultSet = null;
		ArrayList<Gym> pendingGymList = new ArrayList<>();
		Connection connection = DBConnection.getConnection();
		if (connection != null) {
			try {
				PreparedStatement preparedStatement = connection
						.prepareStatement(SqlConstants.SELECT_GYM + SqlConstants.WHERE_PENDING_APPROVAL);
				resultSet = preparedStatement.executeQuery();
				if (resultSet != null) {

					try {
						while (resultSet.next()) {
							Gym gym = new Gym();
							gym.setGymID(resultSet.getInt(1));
							gym.setGymOwnerID(resultSet.getInt(2));
							gym.setLocation(resultSet.getString(3));
							gym.setNoOfSeats(resultSet.getInt(4));
							pendingGymList.add(gym);
						}
					} catch (SQLException e) {
						e.printStackTrace();
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
		return pendingGymList;
	}

	public int approveGym(int gymId) {

		int rowsUpdated = 0;
		Connection connection = DBConnection.getConnection();
		if (connection != null) {
			try {
				PreparedStatement preparedStatement = connection
						.prepareStatement(SqlConstants.UPDATE_APPROVE_GYM + SqlConstants.WHERE_ID);
				preparedStatement.setInt(1, gymId);
				rowsUpdated = preparedStatement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rowsUpdated;

	}
	


	@Override
	public void approveAllGymRegistrationRequests() {

		int rowsUpdated = 0;
		Connection connection = DBConnection.getConnection();
		if (connection != null) {
			try {
				PreparedStatement preparedStatement = connection
						.prepareStatement(SqlConstants.UPDATE_APPROVE_GYM + SqlConstants.WHERE_PENDING_APPROVAL);
				rowsUpdated = preparedStatement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(rowsUpdated > 0) {
			System.out.println("All gyms approved!");
		} else {
			System.out.println("All gyms could not be approved!");
		}


	}

	@Override
	public Gym viewGym(int gymID) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SqlConstants.WHERE_ID);
			preparedStatement.setInt(gymID, gymID);
			System.out.println(preparedStatement);
			ResultSet output = preparedStatement.executeQuery();
			while (output.next()) {
				System.out.println("\t" + output.getString(1) + "\t " + output.getString(2) + "\t "
						+ output.getString(3) + "\t " + output.getString(4) + "\t " + output.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	// Driver
	public static void main(String args[]) {
		GymDAOInterface gymDAO = new GymDAOImplementation();
		Gym gym = new Gym();
		gym.setGymOwnerID(55);
		gym.setLocation("loc5");
		gym.setNoOfSeats(20);
		gym.setApproved(false);
		gymDAO.addGymCentre(gym);

	}

}
