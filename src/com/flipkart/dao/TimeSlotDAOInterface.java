/**
 * jyotishna.baishya
 */
package com.flipkart.dao;

import java.time.LocalDate;

import com.flipkart.bean.TimeSlot;

/**
 * 
 */
public interface TimeSlotDAOInterface {
	public int insertSlot(TimeSlot slot);
	public int isAvailable(int slotHour, int gymID);
	public int updateSlot(int slotHour, int gymID, int changeInSeats);
}
