/**
 * 
 */
package com.flipkart.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.flipkart.bean.Customer;
import com.flipkart.bean.GymOwner;
import com.flipkart.business.AdminServiceInterface;

/**
 * 
 */
public class AdminDAOImplementation implements AdminDAOInterface{


	private static AdminDAOInterface adminDaoObj = null;

	private AdminDAOImplementation() {
	}

	public static synchronized AdminDAOInterface getInstance() {
		if (adminDaoObj == null)
			adminDaoObj = new AdminDAOImplementation();

		return adminDaoObj;
	}
		

	@Override
	public boolean approveGymOwner() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<GymOwner> getPendingGymOwnerApprovals() {
		return null;
		
	}

	@Override
	public boolean approveGymRegistrationRequest() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void getPendingGymLocationRegistrationRequests() {
		// TODO Auto-generated method stub
		
	}
	
	public void viewAllGymOwners() {
		
	}
	
	//driver
	public static void main(String args[]) {
		new AdminDAOImplementation().getPendingGymOwnerApprovals();
	}

}
