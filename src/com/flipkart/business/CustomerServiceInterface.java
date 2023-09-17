/**
 * 
 */
package com.flipkart.business;

import java.util.ArrayList;

import com.flipkart.bean.Booking;
import com.flipkart.bean.Customer;
import com.flipkart.bean.User;

/**
 * @author karan.k2
 */
public interface CustomerServiceInterface {
	public boolean bookSlot(String gymID, String slotID);
	
	public Customer viewProfile(User user);

	public boolean cancelSlot(String gymID, String slotID);

	public ArrayList<Booking> viewMyBookings();
}
