/**
 * jyotishna.baishya
 */
package com.flipkart.dao;

import java.util.ArrayList;

import com.flipkart.bean.Booking;

/**
 * 
 */
public interface BookingDAOInterface {
	public int insertBooking(Booking booking);
	public int removeBooking(int bookingID);
	public ArrayList<Booking> viewBookings(int customerID);
}
