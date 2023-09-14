package com.flipkart.bean;

public class Gym {
	private String gymID;
	private String gymOwnerID;
	private String location;
	private int noOfSeats;
	private boolean isApproved = false;
	
	public String getGymID() {
		return gymID;
	}
	public void setGymID(String gymID) {
		this.gymID = gymID;
	}
	public String getGymOwnerID() {
		return gymOwnerID;
	}
	public void setGymOwnerID(String gymOwnerID) {
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
