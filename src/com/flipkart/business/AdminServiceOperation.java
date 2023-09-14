/**
 * 
 */
package com.flipkart.business;

import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;

/**
 * 
 */
public class AdminServiceOperation implements AdminServiceInterface{
	
	List<Gym> pendingGymApprovals = new ArrayList<Gym>();
	List<GymOwner> pendingGymOwnerApprovals = new ArrayList<GymOwner>();
	
	public AdminServiceOperation() {
		this.populateGymList();
		this.populateGymOwnerList();
	}
	@Override
	public boolean approveGymOwner() {
		for(GymOwner owner: pendingGymOwnerApprovals) {
			owner.setApproved(true);
		}
		pendingGymOwnerApprovals.clear();
		System.out.println("Gym Owner approval completed!");
		return true;
	}

	@Override
	public void getPendingGymOwnerApprovals() {
		System.out.println("Pending Gym Owner Approvals:");
		for(GymOwner owner: pendingGymOwnerApprovals) {
			System.out.println("Gym Owner Name: "+owner.getGymOwnerName());
		}
		
	}

	@Override
	public boolean approveGymRegistrationRequest() {
		for(Gym gym: pendingGymApprovals) {
			gym.setApproved(true);
		}
		pendingGymApprovals.clear();
		System.out.println("Gym approval completed!");
		return true;
	}

	@Override
	public void getPendingGymLocationRegistrationRequests() {
		System.out.println("Pending Gym Location Registration List");
		for(Gym gym: pendingGymApprovals) {
			System.out.println("Gym details -> Gym name: "+gym.getGymID()+" Gym Owner: "+gym.getGymOwnerID());
		}
		
	}
	private void populateGymOwnerList() {
		GymOwner owner = new GymOwner();
		owner.setUserID("owner1");
		owner.setAadharCard("Aadhaar Proof");
		owner.setGymOwnerName("First Owner");
		owner.setPassword("strongPassword");
		
		GymOwner owner1 = new GymOwner();
		owner1.setUserID("owner2");
		owner1.setAadharCard("Aadhaar Proof");
		owner1.setGymOwnerName("First Owner");
		owner1.setPassword("strongPassword");
		
		GymOwner owner2 = new GymOwner();
		owner2.setUserID("owner3");
		owner2.setAadharCard("Aadhaar Proof");
		owner2.setGymOwnerName("First Owner");
		owner2.setPassword("strongPassword");
		
		pendingGymOwnerApprovals.add(owner);
		pendingGymOwnerApprovals.add(owner1);
		pendingGymOwnerApprovals.add(owner2);
		
	}
	
	private void populateGymList() {
		Gym gym = new Gym();
		gym.setGymID("o1gym1");
		gym.setGymOwnerID("owner1");
		gym.setLocation("Loc1");
		gym.setNoOfSeats(20);
		
		Gym gym1 = new Gym();
		gym1.setGymID("o1gym2");
		gym1.setGymOwnerID("owner1");
		gym1.setLocation("Loc2");
		gym1.setNoOfSeats(20);
		
		Gym gym2 = new Gym();
		gym2.setGymID("o2gym1");
		gym2.setGymOwnerID("owner2");
		gym2.setLocation("Loc1");
		gym2.setNoOfSeats(20);
		
		Gym gym3 = new Gym();
		gym3.setGymID("o2gym1");
		gym3.setGymOwnerID("owner2");
		gym3.setLocation("Loc2");
		gym3.setNoOfSeats(20);
		
		Gym gym4 = new Gym();
		gym4.setGymID("o3gym1");
		gym4.setGymOwnerID("owner3");
		gym4.setLocation("Loc1");
		gym4.setNoOfSeats(20);
		
		Gym gym5 = new Gym();
		gym5.setGymID("o3gym1");
		gym5.setGymOwnerID("owner3");
		gym5.setLocation("Loc2");
		gym5.setNoOfSeats(20);
		
		pendingGymApprovals.add(gym);
		pendingGymApprovals.add(gym1);
		pendingGymApprovals.add(gym2);
		pendingGymApprovals.add(gym3);
		pendingGymApprovals.add(gym4);
		pendingGymApprovals.add(gym5);
		
	}

}
