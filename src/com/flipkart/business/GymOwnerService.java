package com.flipkart.business;

import java.util.ArrayList;

import com.flipkart.bean.Gym;

public class GymOwnerService {
	public boolean addGymCentre(Gym newGym){
		System.out.println("New Gym registration requested");
		return true;
	}
	
	public ArrayList<Gym> viewRegisteredGyms() {
		System.out.println("GymList found");
		return null;
	}
	
}
