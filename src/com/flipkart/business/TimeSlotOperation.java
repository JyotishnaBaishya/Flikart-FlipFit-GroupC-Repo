package com.flipkart.business;

import java.time.LocalDate;

import com.flipkart.bean.TimeSlot;
import com.flipkart.dao.TimeSlotDAOImplementation;


public class TimeSlotOperation implements TimeSlotInterface {

	private static TimeSlotInterface timeSlotServiceObj = null;

	public static synchronized TimeSlotInterface getInstance() {
		if (timeSlotServiceObj == null)
			timeSlotServiceObj = new TimeSlotOperation();

		return timeSlotServiceObj;
	}

	@Override
	public boolean isAvailable(int slotHour, int gymID) {
		// TODO Auto-generated method stub
		int availableSeats = TimeSlotDAOImplementation.getInstance().isAvailable(slotHour, gymID);
		if(availableSeats > 0) return true;
		return false;
	}

	@Override
	public boolean addSlot(int slotHour, int gymID, int availableSeats) {
		// TODO Auto-generated method stub
		TimeSlot slot = new TimeSlot();
		
		slot.setSlotHour(slotHour);
		slot.setGymID(gymID);
		slot.setAvailableSeats(availableSeats);
		slot.setDay(java.time.LocalDate.now());
		
		boolean isAdded = TimeSlotDAOImplementation.getInstance().insertSlot(slot);
		return isAdded;
	}

	@Override
	public boolean updateSlot(int slotHour, int gymID, LocalDate day) {
		// TODO Auto-generated method stub
		return false;
	}

}
