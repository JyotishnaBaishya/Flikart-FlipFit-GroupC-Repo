/**
 * 
 */
package com.flipkart.application;

import java.util.Scanner;

import com.flipkart.bean.Booking;
import com.flipkart.bean.Gym;
import com.flipkart.bean.User;
import com.flipkart.business.CustomerServiceInterface;
import com.flipkart.business.CustomerServiceOperation;
import com.flipkart.business.GymServiceInterface;
import com.flipkart.business.GymServiceOperation;

/**
 * 
 */
public class GymFlipFitCustomerMenu {
	CustomerServiceInterface customerService = CustomerServiceOperation.getInstance();
	GymServiceInterface gymService = GymServiceOperation.getInstance();

	public void displayMenu(User user, Scanner in) {
		int menuOption = 1;
		do {
			System.out.println("\n\n ------ Customer Menu Options ------ " +"\n1. View available gyms"+"\n2. Book a slot" + "\n3. Cancel Booking "
					+ "\n4. View my bookings" +"\n5. View Profile" +"\n6. Quit" + "\nEnter number between 1-6");
			menuOption = in.nextInt();
			switch (menuOption) {
				case 1:
					System.out.println("GymID\tGymName\t\tLocation");
					System.out.println("-----------------------------------------------------------");
					for (Gym gym : gymService.viewGymList()) {
						System.out.println(gym.getGymID() + "\t" + gym.getGymName() + "\t\t"
								+ gym.getLocation());
					}
					break;
				case 2:
					System.out.println("Please enter the gymID");
					int gymID = in.nextInt();
					System.out.println("Please enter you slot number");
					int slotHour = in.nextInt();
					System.out.println(gymID+slotHour);
					customerService.bookSlot(gymID, slotHour, user.getUserID());
					break;
				case 3:
					System.out.println("Please enter the gymID");
					gymID = in.nextInt();
					System.out.println("Please enter you slot number");
					slotHour = in.nextInt();
					customerService.cancelSlot(gymID, slotHour, user.getUserID());
					break;
				case 4:
					System.out.println("Your bookings: ");
					System.out.println("SlotID\tCustomerID");
					System.out.println("-----------------------------------------------------------");
					for(Booking booking: customerService.viewMyBookings(user.getUserID())) {
						System.out.println(booking.getSlotID() + "\t" + booking.getCustomerID());
					}
					break;
				case 5:
					customerService.viewProfile(user).display();
					break;
				case 6:
					System.out.println("You have exited the customer menu");
					break;
				default:
					System.out.println("You have selected invalid option please try again!!");
					break;
			}
		} while (menuOption != 6);
	}

}
