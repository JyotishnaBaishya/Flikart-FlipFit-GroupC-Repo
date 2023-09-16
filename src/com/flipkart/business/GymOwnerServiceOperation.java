package com.flipkart.business;

/**
 * @author karan.k2
 */

import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Gym;
import com.flipkart.constants.Constants;
import com.flipkart.dao.GymDAOImplementation;
import com.flipkart.dao.GymDAOInterface;

public class GymOwnerServiceOperation implements GymOwnerServiceInterface {

	private static GymOwnerServiceInterface gymOwnerServiceObj = null;

	private GymOwnerServiceOperation() {
	}

	public static synchronized GymOwnerServiceInterface getInstance() {
		if (gymOwnerServiceObj == null)
			gymOwnerServiceObj = new GymOwnerServiceOperation();

		return gymOwnerServiceObj;
	}

	List<Gym> gymList = new ArrayList<Gym>();

	@Override
	public boolean addGymCentre(Gym newGym) {
		// TODO Auto-generated method stub
		boolean isAdded = GymDAOImplementation.getInstance().addGymCentre(newGym);
		if (isAdded) {
			gymList.add(newGym);
		}
		System.out.println("Added");
		return isAdded;
	}

	@Override
	public ArrayList<Gym> viewRegisteredGyms(int gymOwnerID) {
		// TODO Auto-generated method stub
		ArrayList<Gym> registeredGyms = GymDAOImplementation.getInstance().getRegisteredGymsForGymID(gymOwnerID);
		return registeredGyms;

	}

	public static void main(String[] args) {

		Gym currGym = new Gym();
		currGym.setGymID(1);
		currGym.setApprovalStatus(Constants.APPROVED);
		currGym.setGymOwnerID(2);
		currGym.setLocation("korea");
		currGym.setNoOfSeats(40);
		GymOwnerServiceOperation service = new GymOwnerServiceOperation();
		service.addGymCentre(currGym);
		ArrayList<Gym> registeredGyms = service.viewRegisteredGyms(2);
		int n = registeredGyms.size();
		if (n > 0) {
			System.out.println("Displaying registered gyms ");
			for (Gym gym : registeredGyms) {
				if (gym != null) {
					System.out.println(gym.getGymID() + " " + gym.getGymOwnerID() + " " + gym.getLocation() + " "
							+ gym.getNoOfSeats());
				}

			}
		} else {
			System.out.println("No Gyms registered");
		}
	}

}