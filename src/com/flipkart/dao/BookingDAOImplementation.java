/**
 * jyotishna.baishya
 */
package com.flipkart.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.flipkart.bean.Booking;
import com.flipkart.bean.GymOwner;
import com.flipkart.constants.Constants;
import com.flipkart.constants.SqlConstants;

/**
 * 
 */
public class BookingDAOImplementation implements BookingDAOInterface {

	static final String TABLE_BOOKING = "Booking";

	static final String INSERT_BOOKING = "INSERT INTO " + TABLE_BOOKING
			+ " (slotID, customerID) " + " VALUES (?, ?)";
	
	static final String DELETE_BOOKING = "DELETE FROM " + TABLE_BOOKING + " WHERE bookingID = ?";
	
	static final String SELECT_BOOKING = "SELECT * FROM " + TABLE_BOOKING + " WHERE customerID = ?";
	
	@Override
	public int insertBooking(Booking booking) {
		// TODO Auto-generated method stub
		
		int rowsUpdated = 0;
		Connection connection = DBConnection.getConnection();
		if (connection != null) {
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOKING);
				preparedStatement.setInt(1, booking.getSlotID());
				preparedStatement.setInt(2, booking.getCustomerID());
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
	public int removeBooking(int bookingID) {
		// TODO Auto-generated method stub
		
		int rowsUpdated = 0;
		Connection connection = DBConnection.getConnection();
		if (connection != null) {
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BOOKING);
				preparedStatement.setInt(1, bookingID);
				
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
		System.out.println("# of DB Rows successfully deleted: " + rowsUpdated);
		return rowsUpdated;
	}
	
	@Override
	public ArrayList<Booking> viewBookings(int customerID) {
		// TODO Auto-generated method stub
		
		ResultSet resultSet = null;
		ArrayList<Booking> bookingList = new ArrayList<>();
		Connection connection = DBConnection.getConnection();
		if (connection != null) {
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOKING);
				preparedStatement.setInt(1, 1);
				resultSet = DBConnection.executeQuery(preparedStatement);
				if (resultSet != null) {

					try {
						while (resultSet.next()) {
							Booking booking = new Booking();
							booking.setBookingID(resultSet.getInt(1));
							booking.setSlotID(resultSet.getInt(2));
							booking.setCustomerID(resultSet.getInt(3));
							bookingList.add(booking);
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
					return bookingList;
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
		return bookingList;
	}
	
	// Driver
	public static void main(String args[]) {
		
		BookingDAOInterface bookingDAO = new BookingDAOImplementation();
		
//		Booking booking = new Booking();
		
//		booking.setCustomerID(1);
//		booking.setSlotID(2);
		System.out.println(bookingDAO.viewBookings(1).size());
//		bookingDAO.removeBooking(1);
		
//		ArrayList<Booking> bL = bookingDAO.viewBookings(1);
//		System.out.println(bL.size());
//		
//		for(Booking booking : bL) {
//			System.out.println(booking.getBookingID());
//			System.out.println(booking.getCustomerID());
//			System.out.println(booking.getSlotID());
//		}
		
	}
	
}

