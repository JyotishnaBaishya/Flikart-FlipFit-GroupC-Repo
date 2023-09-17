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
					+ "\n2. View Registered Gyms " + "\n3. Register Time Slots " + "\n4. Quit");
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
				
			case 4 :
				System.out.println("You have exited the gymOwner menu");
				break;
			default:
				System.out.println("You have selected invalid option please try again!!");
				break;

			}
		} while (menuOption != 3);
	}
	
	public void addGymSlot(int gymOwnerID, Scanner sc) {
		ArrayList<Gym> registeredGyms = gymOwnerService.getRegisteredGyms(gymOwnerID);
		Gym gym  = null;
		for(Gym curr : registeredGyms) {
			if(curr.getGymOwnerID() == gymOwnerID) {
				gym = curr;
				break;
			}
		}
		if(gym != null) {
			System.out.println("\n\n ------ Add the number of slots to be added ------");
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
		
		System.out.println("\n\n ------ Exiting slot adding menu ------- ");
		
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
		Scanner sc = new Scanner(System.in);
		new GymFlipFitGymOwnerMenu().addGymSlot(2,sc);
	}
}
