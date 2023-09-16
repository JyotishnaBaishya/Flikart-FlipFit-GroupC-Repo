/**
 * 
 */
package com.flipkart.application;

import java.util.ArrayList;
import java.util.Scanner;

import com.flipkart.bean.Gym;
import com.flipkart.bean.User;
import com.flipkart.business.GymOwnerServiceInterface;
import com.flipkart.business.GymOwnerServiceOperation;

/**
 * 
 */
public class GymFlipFitGymOwnerMenu {
	GymOwnerServiceInterface gymService = GymOwnerServiceOperation.getInstance();
	public void displayMenu(User user, Scanner in) {
		int menuOption = 1;
		do {
			System.out.println("\n\n ------ Gym Owner Menu Options ------ " + "\n1. Add a new gym Centre"
					+ "\n2. View Registered Gyms "+"\n3. Quit" + "\nEnter number between 1-3");
			menuOption = in.nextInt();
			switch (menuOption) {
				case 1:
					Gym newGym = new Gym();
					newGym.setGymOwnerID(user.getUserID());
					System.out.println("Please Enter the name for the gym");
					int gymId = in.nextInt();
					newGym.setGymID(gymId);
					System.out.println("Please Enter the location for the gym");
					String location = in.next();
					newGym.setLocation(location);
					System.out.println("Please Enter the total number of seats available in the gym");
					int noOfSeats = in.nextInt();
					newGym.setNoOfSeats(noOfSeats);
					boolean res = gymService.addGymCentre(newGym);
					if(res) {
						System.out.println("Gym Request Successfully submitted");
					}else {
						System.out.println("Gym Request failed");
					}
					break;
				case 2:
					ArrayList<Gym>registeredGyms = gymService.viewRegisteredGyms(user.getUserID());
					int n = registeredGyms.size();
					if(n > 0) {
						System.out.println("Displaying registered gyms ");
						for(Gym gym : registeredGyms) {
							System.out.println(gym.getGymID() + " " + gym.getGymOwnerID() + " " + gym.getLocation() + " " + gym.getNoOfSeats());;
						}
					}else {
						System.out.println("No Gyms registered");
					}
					
					break;
				case 3:
					System.out.println("You have exited the gymOwner menu");
					break;
				default:
					System.out.println("You have selected invalid option please try again!!");
					break;

			}
		} while (menuOption != 3);
	}
}
