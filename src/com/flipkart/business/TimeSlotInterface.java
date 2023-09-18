package com.flipkart.business;

import java.util.ArrayList;

import com.flipkart.bean.TimeSlot;
/**
 * @author jyotishna
 * 
 **/
public interface TimeSlotInterface {
	
	public TimeSlot findSlot(int slotHour, int gymID);

	public boolean addSlot(int slotHour, int gymID, int availableSeats);

	public boolean updateSlot(int slotHour, int gymID, int changeInSeats);
	
	public ArrayList<TimeSlot> getAllAvailableSlots();
	
}
