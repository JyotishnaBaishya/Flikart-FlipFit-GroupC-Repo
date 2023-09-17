/**
 * jyotishna.baishya
 */
package com.flipkart.dao;

import com.flipkart.bean.TimeSlot;

/**
 * 
 */
public interface TimeSlotDAOInterface {
	public boolean insertSlot(TimeSlot slot);
	public TimeSlot findSlot(int slotHour, int gymID);
	public boolean updateSlot(int slotHour, int gymID, int changeInSeats);
}
