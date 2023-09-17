package com.flipkart.business;

import java.util.ArrayList;

import com.flipkart.bean.Customer;
import com.flipkart.bean.User;
import com.flipkart.dao.CustomerDAOImplementation;
import com.flipkart.bean.TimeSlot;
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
	public Customer viewProfile(User user) {
		return CustomerDAOImplementation.getInstance().viewProfile(user.getUserName(), user.getPassword());
	}
	@Override
	public boolean bookSlot(int gymID, int slotHour, int customerID) {
		// TODO Auto-generated method stub
		TimeSlot slot = TimeSlotOperation.getInstance().findSlot(slotHour, gymID);
		if(slot!=null) {
			if(!(BookingServiceOperation.getInstance().removeBooking(slot.getSlotID(), customerID))) {
				TimeSlotOperation.getInstance().updateSlot(slotHour, gymID, -1);
			}
			BookingServiceOperation.getInstance().addBooking(slot.getSlotID(), customerID);
			System.out.println("You have succesfully booked your slot.");
			return true;
		}
		System.out.println("Slot Unavailable!");
		return false;
	}

	@Override
	public boolean cancelSlot(int gymID, int slotHour, int customerID) {
		// TODO Auto-generated method stub
		TimeSlot slot = TimeSlotOperation.getInstance().findSlot(slotHour, gymID);
		if(slot!=null) {
			if(BookingServiceOperation.getInstance().removeBooking(slot.getSlotID(), customerID)) {
				TimeSlotOperation.getInstance().updateSlot(slotHour, gymID, 1);
				System.out.println("You have succesfully cancelled your booking.");
				return true;
			}
			else {
				System.out.println("Booking not found.");
				return false;
			}
		}
		return false;
	}

}
