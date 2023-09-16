/**
 * 
 */
package com.flipkart.application;
import com.flipkart.bean.User;
import com.flipkart.business.UserServiceInterface;
import com.flipkart.business.UserServiceOperation;
import com.flipkart.constants.Constants;

import java.util.Scanner;

/**
 * 
 */
public class GymFlipFitApplication {

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
					new GymFlipFitApplication().login(in);
					break;
				case 2:
					new GymFlipFitApplication().register(in);
					break;
				case 3:
					new GymFlipFitApplication().updatePassword(in);
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
		
	    System.out.println("Please Enter the username");
		String userName = in.next();
		System.out.println("Please Enter the password");
		String password = in.next();
		System.out.println("\n\n \033[1m  --------------- Please enter the type of user ---------------\033[0m ");
	    System.out.println("1. Admin \n2. GymOwner \n3. Customer" + "\nEnter number between 1-3");
	    
	    UserServiceInterface userService = UserServiceOperation.getInstance();
	    int userRole = in.nextInt();
	    while(userRole < 1 || userRole > 3) {
	    	System.out.println("Invalid type please try again!!");
	    	userRole = in.nextInt();
	    }
		User loggedInUser;
	    switch(userRole) {
	    	case 1:
	    		loggedInUser = userService.login(userName, password);
	    		if(loggedInUser!=null) {
	    			System.out.println("Logged In Successfully!!");
	    			new GymFlipFitAdminMenu().displayMenu(loggedInUser,in);
	    		}else {
	    			System.out.println("Invalid Credentials");
	    		}
	    		break;
	    	case 2:
	    		loggedInUser = userService.login(userName, password);
	    		if(loggedInUser!=null) {
	    			System.out.println("Logged In Successfully!!");
	    			new GymFlipFitGymOwnerMenu().displayMenu(loggedInUser, in);
	    		}else {
	    			System.out.println("Invalid Credentials");
	    		}
	    		break;
	    	case 3:
	    		loggedInUser = userService.login(userName, password);
	    		if(loggedInUser!=null) {
	    			System.out.println("Logged In Successfully!!");
	    			new GymFlipFitCustomerMenu().displayMenu(loggedInUser, in);
	    		}else {
	    			System.out.println("Invalid Credentials");
	    		}
	    		break;
	    		
	    		
	    }
	    System.out.println("Exiting login Menu..");
	}
	void register(Scanner in) {
		System.out.println("\n\n ---------- Please enter the type of user ---------- ");
	    System.out.println("1. Customer \n2. GymOwner" + "\nEnter number between 1-2");
	    
	    UserServiceInterface userService = UserServiceOperation.getInstance();
	    int userRole = in.nextInt();
	    while(userRole < 1 || userRole > 2) {
	    	System.out.println("Invalid type please try again!!");
	    	userRole = in.nextInt();
	    }
	    System.out.println("Please Enter the username");
		String userName = in.next();
		System.out.println("Please Enter the password");
		String password = in.next();
		String role = userRole == 1? Constants.ROLE_CUSTOMER:Constants.ROLE_GYMOWNER;
		if(userService.registration(userName, password, role)){
			System.out.println("User Registered successfully!!");
		}else {
			System.out.println("Please try again!!");
		}
		System.out.println("Exiting register menu");
	    
	}
	void updatePassword(Scanner in) {
		System.out.println("Please enter the username!!");
		String userName = in.next();
		System.out.println("Please enter your old password");
		String password = in.next();
		UserServiceInterface userService = UserServiceOperation.getInstance();
		User oldUser = userService.login(userName, password);
		if(oldUser != null) {
			System.out.println("Please enter your new Password!!");
			String newPassword = in.next();
			if(userService.updatePassword(oldUser,newPassword) != 0) {
				System.out.println("Password Updated successfully!!");
			}else {
				System.out.println("Please try again!!");
			}
		}
	}

}
