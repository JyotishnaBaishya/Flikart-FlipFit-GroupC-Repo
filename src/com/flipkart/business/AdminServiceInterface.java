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

	public int handleGymRegistrationRequest(int gymId, int status);

	public void approveAllGymRegistrationRequests();

	public ArrayList<Gym> getPendingGymRegistrationRequests();

	public void handleGymOwnerRequest(int gymOwnerId, int status);

	public void approveAllGymOwners();
}
