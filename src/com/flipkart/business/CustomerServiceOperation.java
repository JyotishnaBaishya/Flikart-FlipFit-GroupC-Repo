package com.flipkart.business;

import java.util.ArrayList;

import com.flipkart.bean.Booking;

/**
 * @author karan.k2
 **/
public class CustomerServiceOperation implements CustomerServiceInterface {

	private static CustomerServiceInterface customerServiceObj = null;

	private CustomerServiceOperation() {
	}

	public static synchronized CustomerServiceInterface getInstance() {
		if (customerServiceObj == null)
			customerServiceObj = new CustomerServiceOperation();

		return customerServiceObj;
	}

	@Override
	public boolean bookSlot(String gymID, String slotID) {
		// TODO Auto-generated method stub
		System.out.println("You have succesfully booked a slot");
		return true;
	}

	@Override
	public boolean cancelSlot(String gymID, String slotID) {
		// TODO Auto-generated method stub
		System.out.println("You have succesfully cancelled your booking");
		return true;
	}

	@Override
	public ArrayList<Booking> viewMyBookings() {
		// TODO Auto-generated method stub
		System.out.println("Your bookings are as shown");
		return null;
	}

}
