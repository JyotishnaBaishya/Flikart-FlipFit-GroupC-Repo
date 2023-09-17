/**
 * jyotishna.baishya
 */
package com.flipkart.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

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
	public int isAvailable(int slotHour, int gymID) {
		// TODO Auto-generated method stub
		ResultSet resultSet = null;
		int availableSeats = 0;
		Connection connection = DBConnection.getConnection();
		if (connection != null) {
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(SqlConstants.CHECK_TIMESLOT_AVAILABILITY);
				preparedStatement.setInt(1, slotHour);
				preparedStatement.setInt(2, gymID);
				resultSet = preparedStatement.executeQuery();
				if (resultSet != null) {
					while(resultSet.next()) {
						availableSeats = resultSet.getInt(1);
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
		return availableSeats;
	}
	
	@Override
	public int updateSlot(int slotHour, int gymID, int changeInSeats) {
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
			TimeSlot slot = new TimeSlot();
			slot.setSlotHour(2);
			slot.setGymID(1);
			slot.setAvailableSeats(20);
			slot.setDay(java.time.LocalDate.now());
			timeSlotDAO.insertSlot(slot);
		}

	
}
