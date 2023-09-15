/**
 * 
 */
package com.flipkart.business;

import java.util.ArrayList;

import com.flipkart.bean.Gym;

/**
 * @author karan.k2
 */
public interface GymOwnerServiceInterface {
	public boolean addGymCentre(Gym newGym);
	public ArrayList<Gym> viewRegisteredGyms(int gymOwnerID) ;
}
