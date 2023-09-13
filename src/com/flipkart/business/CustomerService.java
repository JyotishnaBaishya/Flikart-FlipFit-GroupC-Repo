package com.flipkart.business;

import java.util.ArrayList;

import com.flipkart.bean.Booking;

public class CustomerService {
	
	public boolean bookSlot(String gymID, String slotID) {
		System.out.println("Booking confirmed");
		return true;
	}
	
	public boolean cancelSlot(String gymID, String slotID) {
		System.out.println("Booking cancelled");
		return true;
	}
	
	public ArrayList<Booking> viewMyBookings() {
		System.out.println("Booking confirmed");
		return null;
	}
	
}
