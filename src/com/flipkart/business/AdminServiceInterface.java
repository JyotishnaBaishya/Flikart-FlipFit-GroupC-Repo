/**
 * 
 */
package com.flipkart.business;

/**
 * @author rohit.r10
 */
public interface AdminServiceInterface {
	public boolean approveGymOwner();
	
	public void getPendingGymOwnerApprovals();
	
	public boolean approveGymRegistrationRequest(String gymId);
	
	public void getPendingGymLocationRegistrationRequests();
}
