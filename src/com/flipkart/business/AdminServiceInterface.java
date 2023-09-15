/**
 * 
 */
package com.flipkart.business;

import java.util.ArrayList;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;

/**
 * @author rohit.r10
 */
public interface AdminServiceInterface {
	public boolean approveAllGymOwners();
	
	public ArrayList<GymOwner> getPendingGymOwnerApprovals();
	
	public void approveGymRegistrationRequest(int gymId);
	
	public ArrayList<Gym> getPendingGymRegistrationRequests();

	void approveGymOwner(int gymOwnerId);
}
