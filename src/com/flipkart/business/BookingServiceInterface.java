/**
 * jyotishna.baishya
 */
package com.flipkart.business;

import java.util.ArrayList;

import com.flipkart.bean.Booking;

/**
 * 
 */
public interface BookingServiceInterface {
	public boolean addBooking(int slotID, int customerID);
	public boolean removeBooking(int slotID, int customerID);
	public ArrayList<Booking> viewBookings(int customerID);
}
