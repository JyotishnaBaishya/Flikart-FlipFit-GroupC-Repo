/**
 * jyotishna.baishya
 */
package com.flipkart.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.flipkart.bean.TimeSlot;
import com.flipkart.constants.SqlConstants;
import com.flipkart.utils.DBConnection;

/**
 * 
 */
public class TimeSlotDAOImplementation implements TimeSlotDAOInterface {


	private static TimeSlotDAOInterface timeSlotDaoObj = null;

	private TimeSlotDAOImplementation() {
	}

	public static synchronized TimeSlotDAOInterface getInstance() {
		if (timeSlotDaoObj == null)
			timeSlotDaoObj = new TimeSlotDAOImplementation();

		return timeSlotDaoObj;
	}
	
	@Override
	public boolean insertSlot(TimeSlot slot) {
		// TODO Auto-generated method stub
		
		int rowsUpdated = 0;
		Connection connection = DBConnection.getConnection();
		if (connection != null) {
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(SqlConstants.INSERT_TIMESLOT);
				prepareStatement(preparedStatement, slot);
				rowsUpdated = preparedStatement.executeUpdate();
				if(rowsUpdated > 0) return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	@Override
	public TimeSlot findSlot(int slotHour, int gymID) {
		// TODO Auto-generated method stub
		ResultSet resultSet = null;
		Connection connection = DBConnection.getConnection();
		if (connection != null) {
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(SqlConstants.FIND_TIMESLOT);
				preparedStatement.setInt(1, slotHour);
				preparedStatement.setInt(2, gymID);
				resultSet = preparedStatement.executeQuery();
				if (resultSet != null) {
					while(resultSet.next()) {
						TimeSlot slot = new TimeSlot();
						slot.setSlotID(resultSet.getInt(1));
						slot.setSlotHour(resultSet.getInt(2));
						slot.setGymID(resultSet.getInt(3));
						slot.setAvailableSeats(resultSet.getInt(4));
						return slot;
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
		return null;
	}
	
	@Override
	public boolean updateSlot(int slotHour, int gymID, int changeInSeats) {
		// TODO Auto-generated method stub
		int rowsUpdated = 0;
		Connection connection = DBConnection.getConnection();
		
		if (connection != null) {
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(SqlConstants.UPDATE_TIMESLOT_AVAILABILITY);
				preparedStatement.setInt(1, changeInSeats);
				preparedStatement.setInt(2, slotHour);
				preparedStatement.setInt(3, gymID);
				rowsUpdated = preparedStatement.executeUpdate();
				if(rowsUpdated > 0) return true;
				
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
		return false;
	}

	/**
	 * @param preparedStatement
	 * @param slot
	 */
	private void prepareStatement(PreparedStatement preparedStatement, TimeSlot slot) {
		// TODO Auto-generated method stub
		try {
			preparedStatement.setInt(1, slot.getSlotHour());
			preparedStatement.setInt(2, slot.getGymID());
			preparedStatement.setInt(3, slot.getAvailableSeats());
			preparedStatement.setDate(4, Date.valueOf(slot.getDay()));;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// Driver
		public static void main(String args[]) {
			TimeSlotDAOInterface timeSlotDAO = new TimeSlotDAOImplementation();
			
			TimeSlot slot = timeSlotDAO.findSlot(2, 1);
			System.out.println(slot.getSlotID());
		}
	
}
