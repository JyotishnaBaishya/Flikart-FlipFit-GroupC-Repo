/**
 * 
 */
package com.flipkart.business;

import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.dao.GymOwnerDAOImplementation;

/**
 * @author avantika.kala
 */
public class AdminServiceOperation implements AdminServiceInterface{
	
	List<Gym> pendingGymApprovals = new ArrayList<Gym>();
	List<GymOwner> pendingGymOwnerApprovals = new ArrayList<GymOwner>();
	
	public AdminServiceOperation() {

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
				int flag = GymOwnerDAOImplementation.approveGymOwner(gymOwnerId);
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
		return GymOwnerDAOImplementation.getPendingGymOwnerApprovals();
		
	}

	@Override
	public void approveGymRegistrationRequest(int gymId) {
		for(Gym gym: getPendingGymRegistrationRequests()) {
			if(gym.getGymID() == gymId){
				int flag = GymOwnerDAOImplementation.approveGymOwner(gymId);
				if(flag > 0) {
					System.out.println("Gym Owner ID " + gymId + " approved");
				} else {
					System.out.println("Gym Owner ID " + gymId + " could not be approved");
				}
				break;
			}
		}
	}

	@Override
	public ArrayList<Gym> getPendingGymRegistrationRequests() {
		System.out.println("Pending Gym Location Registration List");
		for(Gym gym: pendingGymApprovals) {
			System.out.println("Gym details -> Gym name: "+gym.getGymID()+" Gym Owner: "+gym.getGymOwnerID());
		}
		return null;
		
	}

}
