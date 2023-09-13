/**
 * 
 */
package com.flipkart.application;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import java.util.Scanner;

/**
 * 
 */
public class GymFLipFitApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Welcome to FlipFit Gym Slot Booking Application");
		System.out.println("Menu Options: Login, Register, Update Password, Exit");
		System.out.println("Please enter a option: ");
		Scanner in = new Scanner(System.in); 
		String menuOption = "";
		boolean menuOpen = true;
		do {
			menuOption = in.next();
			switch(menuOption) {
				case "Login":
					break;
				case "Register":
					break;
				case "Update Password":
					break;
				case "Exit":
					menuOpen = false;
					System.out.println("You have exited the application!!");
					break;
				default:
					System.out.println("Invalid Menu Option please try again!!");
					
			}
		}while(menuOpen);
		 // Create a Scanner object
	    System.out.println("Please enter the type of user ");
	    System.out.println("options are Admin, GymOwner, Customer");
	    
	    String userRole = in.nextLine();  // Read user input
	    switch(userRole) {
	    	case "Admin":
	    		System.out.println("Please Enter the username");
	    		String userID = in.nextLine();
	    		System.out.println("Please Enter the password");
	    		String password = in.nextLine();
	    		
	    		
	    		break;
	    	case "GymOwner":
	    		
	    		break;
	    	case "Customer":
	    		
	    		
	    		break;
	    	default:
	    		System.out.println("Please Enter a valid Role!!!");
	    }
		
		GymOwner owner = new GymOwner();
		owner.setUserID("owner1");
		owner.setAadharCard("Aadhaar Proof");
		owner.setGymOwnerName("First Owner");
		owner.setPassword("strongPassword");
		

	}

}
