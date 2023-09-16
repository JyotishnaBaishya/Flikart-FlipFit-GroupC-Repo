/**
 * 
 */
package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.constants.Constants;
import com.flipkart.constants.SqlConstants;
import com.flipkart.utils.DBConnection;

/**
 * 
 */
public class GymOwnerDAOImplementation implements GymOwnerDAOInterface {

	private static GymOwnerDAOImplementation gymOwnerDaoObj = null;

	private GymOwnerDAOImplementation() {
	}

	public static synchronized GymOwnerDAOImplementation getInstance() {
		if (gymOwnerDaoObj == null)
			gymOwnerDaoObj = new GymOwnerDAOImplementation();

		return gymOwnerDaoObj;
	}

	@Override
	public int insert(GymOwner gymOwner) {
		int rowsUpdated = 0;
		Connection connection = DBConnection.getConnection();
		if (connection != null) {
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(SqlConstants.INSERT_GYM_OWNER);
				prepareStatement(preparedStatement, gymOwner);
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

	public int approveGymOwner(int gymUserId) {
		int rowsUpdated = 0;
		Connection connection = DBConnection.getConnection();
		if (connection != null) {
			try {
				PreparedStatement preparedStatement = connection
						.prepareStatement(SqlConstants.UPDATE_APPROVE_GYM_OWNER);
				preparedStatement.setInt(1, gymUserId);
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
		System.out.println("# of DB Rows successfully updated: " + rowsUpdated);
		return rowsUpdated;
	}

	public ArrayList<GymOwner> getPendingGymOwnerApprovals() {
		ResultSet resultSet = null;
		ArrayList<GymOwner> pendingGymOwnerList = new ArrayList<>();
		Connection connection = DBConnection.getConnection();
		if (connection != null) {
			try {
				PreparedStatement preparedStatement = connection
						.prepareStatement(SqlConstants.SELECT_GYM_OWNER + SqlConstants.WHERE_PENDING_APPROVAL);
				resultSet = preparedStatement.executeQuery();
				if (resultSet != null) {

					try {
						while (resultSet.next()) {
							GymOwner gymOwner = new GymOwner();
							gymOwner.setUserID(resultSet.getInt(1));
							gymOwner.setUserName(resultSet.getString(2));
							gymOwner.setPassword(resultSet.getString(3));
							gymOwner.setAadharCard(resultSet.getString(4));
							gymOwner.setGstIN(resultSet.getString(5));
							gymOwner.setApproved(resultSet.getBoolean(6));
							gymOwner.setRole(Constants.ROLE_GYMOWNER);
							pendingGymOwnerList.add(gymOwner);
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
		return pendingGymOwnerList;
	}

	// Driver
	public static void main(String args[]) {
		GymOwnerDAOInterface gymDAO = GymOwnerDAOImplementation.getInstance();
		GymOwner gymOwner = new GymOwner();
		gymOwner.setUserName("GymOwner2");
		gymOwner.setPassword("pass2");
		gymOwner.setAadharCard("1234-2345-1233");
		gymOwner.setGstIN("22AAAAA0000A1Z6");

		gymDAO.insert(gymOwner);

	}

}
