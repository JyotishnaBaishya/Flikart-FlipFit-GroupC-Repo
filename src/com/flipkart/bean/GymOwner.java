package com.flipkart.bean;

import java.util.ArrayList;

public class GymOwner extends User {
	private String aadharCard;
	private String panCard;
	private String gstIN;
	private boolean isApproved = false;
	private ArrayList<Gym> gymList;
	public String getPanCard() {
		return panCard;
	}

	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}

	public String getGstIN() {
		return gstIN;
	}

	public void setGstIN(String gstIN) {
		this.gstIN = gstIN;
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
	public boolean isApproved() {
		return isApproved;
	}
	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

}
