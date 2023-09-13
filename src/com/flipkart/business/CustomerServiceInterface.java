/**
 * 
 */
package com.flipkart.business;

import java.util.ArrayList;

import com.flipkart.bean.Booking;

/**
 * @author karan.k2
 */
public interface CustomerServiceInterface {
	public boolean bookSlot(String gymID, String slotID);
	public boolean cancelSlot(String gymID, String slotID);
	public ArrayList<Booking> viewMyBookings();
}
