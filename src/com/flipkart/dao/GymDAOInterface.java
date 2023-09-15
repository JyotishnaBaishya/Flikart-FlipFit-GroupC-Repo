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
	public int insert(Gym gym);
	public ArrayList<Gym> viewRegisteredGyms(String gymOwnerID); 
}
