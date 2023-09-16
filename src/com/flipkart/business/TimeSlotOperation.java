package com.flipkart.business;

public class TimeSlotOperation implements TimeSlotInterface{

	private static TimeSlotInterface timeSlotServiceObj = null;

	private TimeSlotOperation() {
	}

	public static synchronized TimeSlotInterface getInstance() {
		if (timeSlotServiceObj == null)
			timeSlotServiceObj = new TimeSlotOperation();

		return timeSlotServiceObj;
	}

	@Override
	public boolean isAvailable(int slotID, int gymID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addSlot(int slotID, int gymID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateSlot(int slotID, int gymID) {
		// TODO Auto-generated method stub
		return false;
	}

}
