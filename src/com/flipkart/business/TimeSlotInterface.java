package com.flipkart.business;

public interface TimeSlotInterface {
	public boolean isAvailable(int slotID, int gymID);

	public boolean addSlot(int slotID, int gymID);

	public boolean updateSlot(int slotID, int gymID);
}
