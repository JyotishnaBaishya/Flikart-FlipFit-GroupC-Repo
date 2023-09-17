/**
 * jyotishna.baishya
 */
package com.flipkart.dao;

import java.util.ArrayList;

import com.flipkart.bean.Gym;

/**
 * 
 */
public interface GymDAOInterface {
	public boolean addGymCentre(Gym gym);
	
	public ArrayList<Gym> getApprovedGymsList();

	public ArrayList<Gym> getRegisteredGymsForGymOwnerID(int gymOwnerID);

	public Gym getGym(int gymID);

	public void approveAllGymRegistrationRequests();

	public int handleGymRequest(int gymId, int status);

	public ArrayList<Gym> getPendingGymRegistrationRequests();
}
