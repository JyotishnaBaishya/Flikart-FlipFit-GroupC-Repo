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
	
	public Customer viewProfile(User user);
	
	public boolean bookSlot(int gymID, int slotHour, int customerID);

	public boolean cancelSlot(int gymID, int slotHour, int customerID);

	public ArrayList<Booking> viewMyBookings(int customerID);
}
