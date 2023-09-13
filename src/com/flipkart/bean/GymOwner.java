package com.flipkart.bean;

import java.util.ArrayList;

public class GymOwner {
	private String gymOwnerID;
	private String gymOwnerName;
	private String password;
	private String aadharCard;
	private ArrayList<Gym>	gymList;
	public String getGymOwnerID() {
		return gymOwnerID;
	}
	public void setGymOwnerID(String gymOwnerID) {
		this.gymOwnerID = gymOwnerID;
	}
	public String getGymOwnerName() {
		return gymOwnerName;
	}
	public void setGymOwnerName(String gymOwnerName) {
		this.gymOwnerName = gymOwnerName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAadharCard() {
		return aadharCard;
	}
	public void setAadharCard(String aadharCard) {
		this.aadharCard = aadharCard;
	}
	public ArrayList<Gym> getGymList() {
		return gymList;
	}
	public void setGymList(ArrayList<Gym> gymList) {
		this.gymList = gymList;
	}
	
	
}
