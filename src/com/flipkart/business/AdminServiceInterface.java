/**
 * 
 */
package com.flipkart.business;

/**
 * @author rohit.r10
 */
public interface AdminServiceInterface {
	public boolean approveGymOwner();
	
	public void getPendingOwnerApprovals();
	
	public boolean approveGymLocation(int gymId);
	
	public void getPendingGymLocationApproval();
}
