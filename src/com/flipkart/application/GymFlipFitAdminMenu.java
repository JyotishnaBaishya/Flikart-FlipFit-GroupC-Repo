/**
 * 
 */
package com.flipkart.application;

import java.util.*;

import com.flipkart.bean.GymOwner;
import com.flipkart.business.AdminServiceInterface;
import com.flipkart.business.AdminServiceOperation;

/**
 * 
 */
public class GymFlipFitAdminMenu {

	AdminServiceInterface adminService = new AdminServiceOperation();
	List<GymOwner> pendingGymOwnerApprovals = new ArrayList<GymOwner>();

	public void displayMenu(Scanner in) {
		int menuOption = 1;
		do {
			System.out.println("\n\n ------ Admin Menu Options ------ " + "\n1. Approve Gym Owner Registration"
					+ "\n2. View Pending Gym Owner Registration Request" + "\n3. Approve Gem Registeration(s)"
					+ "\n4. View Pending Gym Registeration(s)" + "\n5. Quit" + "\nEnter number between 1-5");
			menuOption = in.nextInt();
			
			switch (menuOption) {
				case 1:
					System.out.println("Enter gym owner user id");					
					adminService.approveGymOwner(in.next());
					break;
				case 2:
					ArrayList<GymOwner> gymOwnerList = adminService.getPendingGymOwnerApprovals();
					System.out.println("UserID\tUsername\tAadhar Card #\tGSTIN#");
					System.out.println("-----------------------------------------------------------");
					for(GymOwner gymOwner : gymOwnerList) {
						System.out.println(gymOwner.getUserID()+"\t"+gymOwner.getUserName()+"\t"+gymOwner.getAadharCard()+"\t"+gymOwner.getGstIN());
					}
					
					break;
				case 3:
					adminService.approveGymRegistrationRequest();
					break;
				case 4:
					adminService.getPendingGymLocationRegistrationRequests();
					break;
				case 5:
					System.out.println("Exiting Admin Menu..");
					break;
				default:
					System.out.println("You have selected invalid option please try again!!");
					break;
			}
		} while (menuOption != 5);
		
	}
	
	
	
}
