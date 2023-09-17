/**
 * 
 */
package com.flipkart.application;

import java.util.ArrayList;
import java.util.Scanner;

import com.flipkart.bean.Gym;
import com.flipkart.bean.Notification;
import com.flipkart.bean.TimeSlot;
import com.flipkart.bean.User;
import com.flipkart.business.GymOwnerServiceInterface;
import com.flipkart.business.GymOwnerServiceOperation;
import com.flipkart.business.NotificationServiceInterface;
import com.flipkart.business.NotificationServiceOperation;
import com.flipkart.business.TimeSlotOperation;
import com.flipkart.constants.Constants;

/**
 * @author karan.k2
 */
public class GymFlipFitGymOwnerMenu {
	GymOwnerServiceInterface gymOwnerService = GymOwnerServiceOperation.getInstance();
	NotificationServiceInterface notificationSerice = NotificationServiceOperation.getInstance();
	
	public void displayMenu(User user, Scanner in) {
		displayNotifications(user);
		int menuOption = 1;
		do {
			System.out.println("\n\n ------ Gym Owner Menu Options ------ " + "\n1. Add a new gym Centre"
					+ "\n2. View Registered Gyms " + "\n3. Register Time Slots " + "\n4. View Profile" +"\n5. Quit");
			menuOption = in.nextInt();
			switch (menuOption) {
			case 1:
				Gym newGym = new Gym();
				newGym.setGymOwnerID(user.getUserID());
				System.out.println("Please Enter the name for the gym");
				String gymName = in.next();
				newGym.setGymName(gymName);
				System.out.println("Please Enter the location for the gym");
				String location = in.next();
				newGym.setLocation(location);
				System.out.println("Please Enter the total number of seats available in the gym");
				int noOfSeats = in.nextInt();
				newGym.setNoOfSeats(noOfSeats);
				boolean res = gymOwnerService.addGymCentre(newGym);
				if (res) {
					System.out.println("Gym Request Successfully submitted");
				} else {
					System.out.println("Gym Request failed");
				}
				break;
			case 2:
				ArrayList<Gym> registeredGyms = gymOwnerService.getRegisteredGyms(user.getUserID());
				int n = registeredGyms.size();
				if (n > 0) {
					System.out.println("Displaying registered gyms ");
					for (Gym gym : registeredGyms) {
						System.out.println(gym.getGymID() + " " + gym.getGymOwnerID() + " " + gym.getLocation() + " "
								+ gym.getNoOfSeats());
						;
					}
				} else {
					System.out.println("No Gyms registered");
				}

				break;
			case 3:
				break;
			case 4:
				gymOwnerService.viewProfile(user).display();
				break;
			case 5 :
				System.out.println("You have exited the gymOwner menu");
				break;
			default:
				System.out.println("You have selected invalid option please try again!!");
				break;

			}
		} while (menuOption != 5);
	}
	
	
	
	private void displayNotifications(User user) {
	
		 ArrayList<Notification> notificationList = notificationSerice.viewMyNotifications(user, Constants.ROLE_GYMOWNER);
		 if(notificationList != null && !notificationList.isEmpty()) {
			 System.out.println(
						"\n\n\033[1m ~~~~~~~~ New Notifications ~~~~~~~~ \033[0m");
			 for(Notification notification : notificationList) {
				 System.out.println("  - " + notification.getContent());
			 }
		 }		
	}
	
	public static void main(String args[]) {
		User u = new User();
		u.setUserID(2);
	}
}
