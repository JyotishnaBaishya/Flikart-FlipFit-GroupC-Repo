package com.flipkart.dao;

import java.util.ArrayList;

import com.flipkart.bean.TimeSlot;

/**
 * @author jyotishna
 * 
 **/
public interface TimeSlotDAOInterface {
	public boolean insertSlot(TimeSlot slot);
	public TimeSlot findSlot(int slotHour, int gymID);
	public boolean updateSlot(int slotHour, int gymID, int changeInSeats);
	public ArrayList<TimeSlot> getAllAvailableSlots();
	public TimeSlot getSlotByID(int slotID);
}
