package com.flipkart.bean;

public class Booking {
	private String bookingID;
	private Customer customer;
	private Gym gym;
	private TimeSlot slot;
	
	public String getBookingID() {
		return bookingID;
	}
	public void setBookingID(String bookingID) {
		this.bookingID = bookingID;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Gym getGym() {
		return gym;
	}
	public void setGym(Gym gym) {
		this.gym = gym;
	}
	public TimeSlot getSlot() {
		return slot;
	}
	public void setSlot(TimeSlot slot) {
		this.slot = slot;
	}
	
}
