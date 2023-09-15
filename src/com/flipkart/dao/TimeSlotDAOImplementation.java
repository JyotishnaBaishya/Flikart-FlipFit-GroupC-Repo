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

/**
 * 
 */
public class TimeSlotDAOImplementation implements TimeSlotDAOInterface {

	static final String TABLE_TIMESLOT = "TimeSlot";

	static final String INSERT_TIMESLOT = "INSERT INTO " + TABLE_TIMESLOT
			+ " (slotID, gymID, availableSeats, day) " + " VALUES (?, ?, ?, ?)";
	
	static final String CHECK_TIMESLOT_AVAILABILITY = "SELECT availableSeats FROM " + TABLE_TIMESLOT + " WHERE slotID = (?) AND gymID = (?)";
	
	static final String UPDATE_TIMESLOT_AVAILABILITY = "UPDATE " + TABLE_TIMESLOT + " SET availableSeats = availableSeats + (?) WHERE slotID = (?) AND gymID = (?)";
	
	@Override
	public int insert(TimeSlot slot) {
		// TODO Auto-generated method stub
		
		int rowsUpdated = 0;
		Connection connection = DBConnection.getConnection();
		if (connection != null) {
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TIMESLOT);
				prepareStatement(preparedStatement, slot);
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
	public int isAvailable(int slotID, int gymID) {
		// TODO Auto-generated method stub
		ResultSet resultSet = null;
		int availableSeats = 0;
		Connection connection = DBConnection.getConnection();
		if (connection != null) {
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(CHECK_TIMESLOT_AVAILABILITY);
				preparedStatement.setInt(1, slotID);
				preparedStatement.setInt(2, gymID);
				resultSet = DBConnection.executeQuery(preparedStatement);
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
	public int update(int slotID, int gymID, int changeInSeats) {
		// TODO Auto-generated method stub
		int rowsUpdated = 0;
		Connection connection = DBConnection.getConnection();
		
		if (connection != null) {
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TIMESLOT_AVAILABILITY);
				preparedStatement.setInt(1, changeInSeats);
				preparedStatement.setInt(2, slotID);
				preparedStatement.setInt(3, gymID);
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

	/**
	 * @param preparedStatement
	 * @param slot
	 */
	private void prepareStatement(PreparedStatement preparedStatement, TimeSlot slot) {
		// TODO Auto-generated method stub
		try {
			preparedStatement.setInt(1, slot.getSlotID());
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
//			TimeSlot slot = new TimeSlot();
//			slot.setSlotID(2);
//			slot.setGymID(1);
//			slot.setAvailableSeats(20);
//			slot.setDay(java.time.LocalDate.now());
//			
			System.out.println(timeSlotDAO.update(1, 1, -2));
		}

	
}