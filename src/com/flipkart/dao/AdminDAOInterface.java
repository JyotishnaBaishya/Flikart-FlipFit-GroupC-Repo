package com.flipkart.dao;

import java.util.ArrayList;

import com.flipkart.bean.GymOwner;

public interface AdminDAOInterface {

	public boolean approveGymOwner();
	
	public ArrayList<GymOwner> getPendingGymOwnerApprovals();
	
	public boolean approveGymRegistrationRequest();
	
	public void getPendingGymLocationRegistrationRequests();
}
