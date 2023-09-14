package com.flipkart.business;
/**
 * @author karan.k2
 */

import java.util.ArrayList;

import com.flipkart.bean.Gym;

public class GymOwnerServiceOperation implements GymOwnerServiceInterface{

	@Override
	public boolean addGymCentre(Gym newGym) {
		// TODO Auto-generated method stub
		System.out.println("Added Gym centre");
		return false;
	}

	@Override
	public ArrayList<Gym> viewRegisteredGyms() {
		// TODO Auto-generated method stub
		System.out.println("List of registered gyms");
		return null;
	}
		
}