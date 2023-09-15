/**
 * jyotishna.baishya
 */
package com.flipkart.dao;

import com.flipkart.bean.TimeSlot;

/**
 * 
 */
public interface TimeSlotDAOInterface {
	public int insert(TimeSlot slot);
	public int isAvailable(int slotID, int gymID);
	public int update(int slotID, int gymID, int changeInSeats);
}
