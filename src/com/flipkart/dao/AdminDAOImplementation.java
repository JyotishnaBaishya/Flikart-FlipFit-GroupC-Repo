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

	static final String TABLE_USER = "USER";

	static final String INSERT_USER = "INSERT INTO " + TABLE_USER + " (username, password, role) "
			+ " VALUES (?, ?, ?)";
	
	

	@Override
	public boolean approveGymOwner() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<GymOwner> getPendingGymOwnerApprovals() {
		return new GymOwnerDAOImplementation().getPendingGymOwnerApprovals(" WHERE isApproved = false");
		
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
