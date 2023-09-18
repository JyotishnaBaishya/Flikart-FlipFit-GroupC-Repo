package com.flipkart.dao;

import java.util.ArrayList;

import com.flipkart.bean.GymOwner;
/**
 * @author jyotishna
 * 
 **/
public interface GymOwnerDAOInterface {
	int insert(GymOwner gymOwner);
	GymOwner viewProfile(String username, String password);
	boolean register(GymOwner gymowner);
	void delete(String id);
	void update(String id, GymOwner newGymOwner);
	int handleGymOwnerRequest(int gymOwnerId, int status);
	ArrayList<GymOwner> getPendingGymOwnerApprovals();
	void approveAllGymOwners();
}
