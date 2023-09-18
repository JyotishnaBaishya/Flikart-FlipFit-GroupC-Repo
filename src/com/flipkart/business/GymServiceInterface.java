package com.flipkart.business;

import java.util.ArrayList;

import com.flipkart.bean.Gym;
/**
 * @author jyotishna
 * 
 **/
public interface GymServiceInterface {

	public Gym viewGym(int gymId);

	public ArrayList<Gym> viewGymList();

}
