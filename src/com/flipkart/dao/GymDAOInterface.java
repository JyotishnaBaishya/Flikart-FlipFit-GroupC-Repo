/**
 * jyotishna.baishya
 */
package com.flipkart.dao;

import java.util.ArrayList;

import com.flipkart.bean.Gym;

/**
 * 
 */
public interface GymDAOInterface {
	public boolean addGymCentre(Gym gym);
	public ArrayList<Gym> getRegisteredGyms(int gymOwnerID); 
	public Gym viewGym(int gymID);
}
