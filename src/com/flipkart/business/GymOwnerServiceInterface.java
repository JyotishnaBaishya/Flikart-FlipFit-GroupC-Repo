/**
 * 
 */
package com.flipkart.business;

import java.util.ArrayList;
import java.util.Scanner;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;

/**
 * @author karan.k2
 */
public interface GymOwnerServiceInterface {
	public boolean addGymCentre(Gym newGym);
	public ArrayList<Gym> getRegisteredGyms(int gymOwnerID);
	public void addGymSlot(int gymOwnerID, Scanner sc);
	public GymOwner viewProfile(User user);
}
