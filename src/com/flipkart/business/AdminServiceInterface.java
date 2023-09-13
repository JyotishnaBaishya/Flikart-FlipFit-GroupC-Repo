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
	
	public boolean approveGymRegistrationRequest(int gymId);
	
	public void getPendingGymLocationRegistrationRequests();
}
