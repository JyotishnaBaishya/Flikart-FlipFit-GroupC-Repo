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
	public boolean insertBooking(Booking booking);
	public boolean removeBooking(int slotID, int customerID);
	public ArrayList<Booking> viewBookings(int customerID);
}
