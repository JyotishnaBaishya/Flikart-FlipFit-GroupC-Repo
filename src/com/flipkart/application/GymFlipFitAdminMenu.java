/**
 * 
 */
package com.flipkart.application;

import java.util.*;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Notification;
import com.flipkart.bean.User;
import com.flipkart.business.AdminServiceInterface;
import com.flipkart.business.AdminServiceOperation;
import com.flipkart.business.NotificationServiceInterface;
import com.flipkart.business.NotificationServiceOperation;
import com.flipkart.constants.Constants;

/**
 * 
 */
public class GymFlipFitAdminMenu {

	AdminServiceInterface adminService = AdminServiceOperation.getInstance();
	NotificationServiceInterface notificationService = NotificationServiceOperation.getInstance();
	List<GymOwner> pendingGymOwnerApprovals = new ArrayList<GymOwner>();

	public void displayMenu(User user, Scanner in) {
		int menuOption = 1;
		ArrayList<GymOwner> gymOwnerList = new ArrayList();
		ArrayList<Gym> gymList = new ArrayList();
		do {
			System.out.println("\n\n \033[1m  --------------- Admin Menu Options ---------------\033[0m "
					+ "\nGym Owner Options:\n\t1. View Pending Registration Request" + "\n\t2. Approve/Reject Registration"
					+ "\n\t3. Approve ALL Pending Registration Requests"
					+ "\nGym Options: \n\t4. View Pending Gym Registration" + "\n\t5. Approve/Reject Gym Registration"
					+ "\n\t6. Approve ALL Gym Registration Requests" +"\n7. Quit" + "\nEnter number between 1-7");
			menuOption = in.nextInt();
			switch (menuOption) {
			case 1:
				gymOwnerList = adminService.getPendingGymOwnerApprovals();
				System.out.println("UserID\tUsername\tAadhar Card #\tGSTIN#");
				System.out.println("-----------------------------------------------------------");
				for (GymOwner gymOwner : gymOwnerList) {
					System.out.println(gymOwner.getUserID() + "\t" + gymOwner.getUserName() + "\t\t"
							+ gymOwner.getAadharCard() + "\t" + gymOwner.getGstIN());
				}

				break;
			case 2:
				System.out.println("Enter gym owner user id");
				int gymId = in.nextInt();
				System.out.println("1. Approve\n2. Reject\nEnter number between 1-2");				
				int newStatus = in.nextInt();
				adminService.handleGymOwnerRequest(gymId, newStatus);
				break;
			case 3:
				adminService.approveAllGymOwners();
				break;
			case 4:
				gymList = adminService.getPendingGymRegistrationRequests();
				System.out.println("GymID\tName\tLocation\t# of seats");
				System.out.println("-----------------------------------------------------------");
				for (Gym gym : gymList) {
					System.out.println(gym.getGymID() + "\t" + gym.getGymName()+ "\t" + gym.getLocation() + "\t\t" + gym.getNoOfSeats());
				}
				break;
			case 5:
				System.out.println("Enter gym id");
				gymId = in.nextInt();
				System.out.println("1. Approve\n2. Reject\nEnter number between 1-2");
				newStatus = in.nextInt();
				int success = adminService.handleGymRegistrationRequest(gymId, newStatus);
				if(success > 0) {
					for(Gym gym : gymList) {
						if(gym.getGymID() == gymId) {
							String message = (newStatus == Constants.APPROVED ? Constants.NOTIFICATION_APPROVED : Constants.NOTIFICATION_REJECTED )+ gym.getGymName();
							notificationService.addNotification(new Notification(gym.getGymOwnerID(), Constants.ROLE_GYMOWNER, message, false));
							System.out.println("Notification Sent to the Gym Owner!");
							break;
						}
					}
					
				}
				break;
			case 6:
				adminService.approveAllGymRegistrationRequests();
				break;

			case 7:
				System.out.println("Exiting Admin Menu..");
				break;
			default:
				System.out.println("You have selected invalid option please try again!!");
				break;
			}
		} while (menuOption != 7);

	}

}
