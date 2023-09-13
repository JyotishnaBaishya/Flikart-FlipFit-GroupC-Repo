package com.flipkart.bean;

import java.util.Date;

public class TimeSlot {
	private String slotID;
	private String gymID;
	private int availableSeats;
	private Date day;
	
	public String getSlotID() {
		return slotID;
	}
	public void setSlotID(String slotID) {
		this.slotID = slotID;
	}
	public String getGymID() {
		return gymID;
	}
	public void setGymID(String gymID) {
		this.gymID = gymID;
	}
	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	public Date getDay() {
		return day;
	}
	public void setDay(Date day) {
		this.day = day;
	}
}
