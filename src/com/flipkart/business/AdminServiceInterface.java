/**
 * 
 */
package com.flipkart.business;

import java.util.ArrayList;

import com.flipkart.bean.GymOwner;

/**
 * @author rohit.r10
 */
public interface AdminServiceInterface {
	public boolean approveAllGymOwners();
	
	public ArrayList<GymOwner> getPendingGymOwnerApprovals();
	
	public boolean approveGymRegistrationRequest();
	
	public void getPendingGymLocationRegistrationRequests();

	void approveGymOwner(int gymOwnerId);
}
