package com.flipkart.business;

/**
 * @author karan.k2
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.flipkart.bean.Customer;
import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;
import com.flipkart.constants.Constants;
import com.flipkart.dao.CutomerDAOImplementation;
import com.flipkart.dao.GymDAOImplementation;
import com.flipkart.dao.GymDAOInterface;
import com.flipkart.dao.GymOwnerDAOImplementation;

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
		return isAdded;
	}

	@Override
	public ArrayList<Gym> getRegisteredGyms(int gymOwnerID) {
		// TODO Auto-generated method stub
		ArrayList<Gym> registeredGyms = GymDAOImplementation.getInstance().getRegisteredGymsForGymOwnerID(gymOwnerID);
		return registeredGyms;

	}
	
	@Override
	public void addGymSlot(int gymOwnerID, Scanner sc) {
		ArrayList<Gym> registeredGyms = getRegisteredGyms(gymOwnerID);
		Gym gym  = null;
		System.out.println("Enter the GymID where to want to register slots");
		int gymID = sc.nextInt();
		for(Gym curr : registeredGyms) {
			if(curr.getGymID() == gymID) {
				gym = curr;
				break;
			}
		}
		if(gym != null) {
			System.out.println("Add the number of slots to be added");
			int numberOfSlots = sc.nextInt();
			TimeSlotOperation service = new TimeSlotOperation();
			while(numberOfSlots > 0) {
				System.out.println("\nEnter the slot hour ");
				int slotHour = sc.nextInt();
				boolean isAdded = service.addSlot(slotHour, gym.getGymID(), gym.getNoOfSeats());
				if(isAdded) {
					System.out.println("\nSlot Added Successfully");
				}
				numberOfSlots--;
			}
		}else {
			System.out.println("Gym not found");
		}
		
		System.out.println("Exiting slot adding menu");
		
	}
	
	@Override
	public GymOwner viewProfile(User user) {
		return GymOwnerDAOImplementation.getInstance().viewProfile(user.getUserName(), user.getPassword());
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
		ArrayList<Gym> registeredGyms = service.getRegisteredGyms(2);
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