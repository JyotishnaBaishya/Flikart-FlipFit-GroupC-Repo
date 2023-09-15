/**
 * 
 */
package com.flipkart.application;
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
			System.out.println("\n\n\033[1m***************** Welcome to FlipFit Gym Slot Booking Application *****************\033[0m");
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
				case 4:
					System.out.println("Exiting Application");
					break;
				default:
					System.out.println("Invalid Option Please try again!!");
					break;
					
			}
		}while(menuOption != 4);
		 // Create a Scanner object
	    
		in.close();

		

	}
	
	void login(Scanner in) {
//		System.out.println("\n\n ---------- Please enter the type of user ---------- ");
//	    System.out.println("1. Admin \n2. GymOwner \n3. Customer" + "\nEnter number between 1-3");
//	    
//	    UserServiceInterface userService = new UserServiceOperation();
//	   
//	    int userRole = in.nextInt();  // Read user input
//	    System.out.println("Please Enter the username");
//		String userName = in.next();
//		System.out.println("Please Enter the password");
//		String password = in.next();
//	    switch(userRole) {
//	    	case 1:
//	    		if(userService.login(userName, password,userRole)) {
//	    			new GymFlipFitAdminMenu().displayMenu(in);
//	    		}else {
//	    			System.out.println("Invalid Credentials");
//	    		}
//	    		break;
//	    	case 2:
//	    		if(userService.login(userName, password, userRole)) {
//	    			//new GymFlipFitGymOwnerMenu().displayMenu(userName, in);
//	    		}else {
//	    			System.out.println("Invalid Credentials");
//	    		}
//	    		break;
//	    	case 3:
//	    		if(userService.login(userName, password,userRole)) {
//	    			new GymFlipFitCustomerMenu().displayMenu(userName, in);
//	    		}else {
//	    			System.out.println("Invalid Credentials");
//	    		}
//	    		break;
//	    		
//	    }
//	    System.out.println("Exiting login Menu..");
	}

}
