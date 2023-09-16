/**
 * 
 */
package com.flipkart.business;

import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.dao.AdminDAOImplementation;
import com.flipkart.dao.GymDAOImplementation;
import com.flipkart.dao.GymOwnerDAOImplementation;

/**
 * @author avantika.kala
 */
public class AdminServiceOperation implements AdminServiceInterface{
	
	List<Gym> pendingGymApprovals = new ArrayList<Gym>();
	List<GymOwner> pendingGymOwnerApprovals = new ArrayList<GymOwner>();
	
	private static AdminServiceInterface adminServiceObj = null;

	private AdminServiceOperation() {
	}

	public static synchronized AdminServiceInterface getInstance() {
		if (adminServiceObj == null)
			adminServiceObj = new AdminServiceOperation();

		return adminServiceObj;
	}

	@Override
	public boolean approveAllGymOwners() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void approveGymOwner(int gymOwnerId) {
		for(GymOwner owner: getPendingGymOwnerApprovals()) {
			if(owner.getUserID() == gymOwnerId){
				int flag = GymOwnerDAOImplementation.getInstance().approveGymOwner(gymOwnerId);
				if(flag > 0) {
					System.out.println("Gym Owner ID " + gymOwnerId + " approved");
				} else {
					System.out.println("Gym Owner ID " + gymOwnerId + " could not be approved");
				}
				break;
			}
		}
	}

	@Override
	public ArrayList<GymOwner> getPendingGymOwnerApprovals() {
		return GymOwnerDAOImplementation.getInstance().getPendingGymOwnerApprovals();
		
	}

	@Override
	public void approveGymRegistrationRequest(int gymId) {
		for(Gym gym: getPendingGymRegistrationRequests()) {
			if(gym.getGymID() == gymId){
				int flag = GymDAOImplementation.approveGym(gymId);
				if(flag > 0) {
					System.out.println("Gym ID " + gymId + " approved");
				} else {
					System.out.println("Gym ID " + gymId + " could not be approved");
				}
				break;
			}
		}
	}

	@Override
	public ArrayList<Gym> getPendingGymRegistrationRequests() {
		return GymDAOImplementation.getPendingGymRegistrationRequests();
		
		}

}
