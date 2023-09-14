/**
 * 
 */
package com.flipkart.application;

import java.util.Scanner;

import com.flipkart.bean.Gym;
import com.flipkart.business.GymOwnerServiceInterface;
import com.flipkart.business.GymOwnerServiceOperation;

/**
 * 
 */
public class GymFlipFitGymOwnerMenu {
	GymOwnerServiceInterface gymService = new GymOwnerServiceOperation();
	public void displayMenu(String userID, Scanner in) {
		int menuOption = 1;
		do {
			System.out.println("\n\n ------ Gym Owner Menu Options ------ " + "\n1. Add a new gym Centre"
					+ "\n2. View Registered Gyms "+"\n3. Quit" + "\nEnter number between 1-3");
			menuOption = in.nextInt();
			switch (menuOption) {
				case 1:
					Gym newGym = new Gym();
					newGym.setGymOwnerID(userID);
					System.out.println("Please Enter the name for the gym");
					String gymId = in.next();
					newGym.setGymID(gymId);
					System.out.println("Please Enter the location for the gym");
					String location = in.next();
					newGym.setLocation(location);
					System.out.println("Please Enter the total number of seats available in the gym");
					int noOfSeats = in.nextInt();
					newGym.setNoOfSeats(noOfSeats);
					gymService.addGymCentre(newGym);
					break;
				case 2:
					gymService.viewRegisteredGyms();
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
