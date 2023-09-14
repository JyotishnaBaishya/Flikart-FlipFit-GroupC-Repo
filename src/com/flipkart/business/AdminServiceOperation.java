/**
 * 
 */
package com.flipkart.business;

/**
 * 
 */
public class AdminServiceOperation implements AdminServiceInterface{

	@Override
	public boolean approveGymOwner() {
		System.out.println("Gym membership approved");
		return true;
	}

	@Override
	public void getPendingGymOwnerApprovals() {
		System.out.println("Pending Gym Owner Approvals");
		
	}

	@Override
	public boolean approveGymRegistrationRequest(String gymId) {
		System.out.println("Gym Registration Requests approved");
		return true;
	}

	@Override
	public void getPendingGymLocationRegistrationRequests() {
		System.out.println("Pending Gym Location Registration List");
		
	}
	

}
