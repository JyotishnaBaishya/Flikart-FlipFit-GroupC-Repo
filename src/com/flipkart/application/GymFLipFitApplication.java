/**
 * 
 */
package com.flipkart.application;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.business.UserServiceInterface;
import com.flipkart.business.UserServiceOperation;

import java.util.Scanner;

/**
 * 
 */
public class GymFLipFitApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); 
		int menuOption = 1;
		do {
			System.out.println("\n\n***************** Welcome to FlipFit Gym Slot Booking Application *****************");
			System.out.println("Menu Options: \n1. Login \n2. Register \n3. Update Password \n4. Exit");
			System.out.println("\nEnter number between 1-4");
			menuOption = in.nextInt();
			switch(menuOption) {
				case 1:
					new GymFLipFitApplication().login(in);
					break;
				case 2:
					break;
				case 3:
					break;
				default:
					System.out.println("Exiting Application");
					break;
					
			}
		}while(menuOption > 0 && menuOption < 4);
		 // Create a Scanner object
	    
		
		GymOwner owner = new GymOwner();
		owner.setUserID("owner1");
		owner.setAadharCard("Aadhaar Proof");
		owner.setGymOwnerName("First Owner");
		owner.setPassword("strongPassword");
		

	}
	
	void login(Scanner in) {
		System.out.println("Please enter the type of user ");
	    System.out.println("\n1. Admin \n2. GymOwner \n3. Customer" + "\n Enter number between 1-3");
	    
	    UserServiceInterface userService = new UserServiceOperation();
	    
	    int userRole = in.nextInt();  // Read user input
	    switch(userRole) {
	    	case 1:
	    		System.out.println("Please Enter the username");
	    		String userID = in.next();
	    		System.out.println("Please Enter the password");
	    		String password = in.next();
	    		
	    		if(userService.login(userID, password)) {
	    			new GymFlipFitAdminMenu().displayMenu(in);
	    		}
	    		
	    		break;
	    	case 2:
	    		
	    		break;
	    	case 3:
	    		
	    		
	    		break;
	    	default:
	    		System.out.println("");
	    }
	    System.out.println("Exiting login Menu..");
	}

}
