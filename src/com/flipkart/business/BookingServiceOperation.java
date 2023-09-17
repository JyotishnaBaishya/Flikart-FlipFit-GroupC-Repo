/**
 * jyotishna.baishya
 */
package com.flipkart.business;

import java.util.ArrayList;

import com.flipkart.bean.Booking;
import com.flipkart.dao.BookingDAOImplementation;
/**
 * 
 */
public class BookingServiceOperation implements BookingServiceInterface {

	private static BookingServiceInterface bookingServiceObj = null;

	public static synchronized BookingServiceInterface getInstance() {
		if (bookingServiceObj == null)
			bookingServiceObj = new BookingServiceOperation();

		return bookingServiceObj;
	}
	@Override
	public boolean addBooking(int slotID, int customerID) {
		// TODO Auto-generated method stub
		Booking booking = new Booking();
		booking.setSlotID(slotID);
		booking.setCustomerID(customerID);
		return BookingDAOImplementation.getInstance().insertBooking(booking);
	}

	@Override
	public boolean removeBooking(int slotID, int customerID) {
		// TODO Auto-generated method stub
		return BookingDAOImplementation.getInstance().removeBooking(slotID, customerID);
	}

	@Override
	public ArrayList<Booking> viewBookings(int customerID) {
		// TODO Auto-generated method stub
		return BookingDAOImplementation.getInstance().viewBookings(customerID);
	}

}
