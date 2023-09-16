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
	
	public ArrayList<GymOwner> getPendingGymOwnerApprovals();
	
	public void approveGymRegistrationRequest(int gymId);
	
	public void approveAllGymRegistrationRequests();
	
	public ArrayList<Gym> getPendingGymRegistrationRequests();

	public void approveGymOwner(int gymOwnerId);
	
	public void approveAllGymOwners();
}
