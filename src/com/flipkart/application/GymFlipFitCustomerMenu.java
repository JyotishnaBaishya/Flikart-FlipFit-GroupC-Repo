/**
 * 
 */
package com.flipkart.application;

import java.util.Scanner;

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
			System.out.println("\n\n ------ Customer Menu Options ------ " + "\n1. Book a slot" + "\n2. Cancel Booking "
					+ "\n3. View my bookings" +"\n4. View Profile" +"\n5. Quit" + "\nEnter number between 1-5");
			menuOption = in.nextInt();
			switch (menuOption) {
			case 1:
				gymService.viewGymList();
				System.out.println("Please enter the gymID");
				String gymID = in.next();
				System.out.println("Please enter you slot number");
				String slotID = in.next();
				customerService.bookSlot(gymID, slotID);
				break;
			case 2:
				System.out.println("Please enter the gymID");
				gymID = in.next();
				System.out.println("Please enter you slot number");
				slotID = in.next();
				customerService.cancelSlot(gymID, slotID);
				break;
			case 3:
				customerService.viewMyBookings();
				break;
			case 4:
				customerService.viewProfile(user).display();
				break;
			case 5:
				System.out.println("You have exited the customer menu");
				break;
			default:
				System.out.println("You have selected invalid option please try again!!");
				break;

			}
		} while (menuOption != 5);
	}

}
