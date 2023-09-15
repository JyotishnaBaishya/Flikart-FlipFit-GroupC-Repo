package com.flipkart.bean;

public class Gym {
	private int gymID;
	private int gymOwnerID;
	private String location;
	private int noOfSeats;
	private boolean isApproved = false;
	
	public int getGymID() {
		return gymID;
	}
	public void setGymID(int gymID) {
		this.gymID = gymID;
	}
	public int getGymOwnerID() {
		return gymOwnerID;
	}
	public void setGymOwnerID(int gymOwnerID) {
		this.gymOwnerID = gymOwnerID;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	public boolean isApproved() {
		return isApproved;
	}
	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}
	
	
	
}
