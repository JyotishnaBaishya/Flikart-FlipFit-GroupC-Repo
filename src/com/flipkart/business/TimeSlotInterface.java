package com.flipkart.business;

import java.time.LocalDate;

public interface TimeSlotInterface {
	public boolean isAvailable(int slotHour, int gymID);

	public boolean addSlot(int slotHour, int gymID, int availableSeats);

	public boolean updateSlot(int slotHour, int gymID);
	
}
