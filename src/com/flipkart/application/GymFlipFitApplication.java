/**
 * 
 */
package com.flipkart.application;

import com.flipkart.bean.Customer;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;
import com.flipkart.business.GymOwnerServiceInterface;
import com.flipkart.business.GymOwnerServiceOperation;
import com.flipkart.business.UserServiceInterface;
import com.flipkart.business.UserServiceOperation;
import com.flipkart.constants.Constants;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author rohit.r10
 */
public class GymFlipFitApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int menuOption = 1;
		do {
			System.out.println(
					"\n\n\033[1m***************** Welcome to FlipFit Gym Slot Booking Application *****************\033[0m");
			System.out.println("Menu Options: \nPress 1. Login \nPress 2. Register \nPress 3. Update Password \nPress 4. Exit");
			try {
				menuOption = in.nextInt();

				switch (menuOption) {
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
					System.out.println("\033[1mExiting Application\033[0m");
					break;
				default:
					System.out.println("\\033[1mInvalid Option Please try again!!\\033[0m");
					break;

				}
			} catch (InputMismatchException ex) {
				System.out.println("Incorrect Input");
				System.exit(0);
			}
		} while (menuOption != 4);
		// Create a Scanner object

		in.close();

	}

	void login(Scanner in) {

		System.out.println("Please Enter the username");
		String userName = in.next();
		System.out.println("Please Enter the password");
		String password = in.next();

		UserServiceInterface userService = UserServiceOperation.getInstance();
		User loggedInUser = userService.login(userName, password);
		if(loggedInUser != null) {
			String userRole = loggedInUser.getRole();
			switch (userRole) {
				case Constants.ROLE_ADMIN:
					System.out.println("Logged In Successfully!!");
					new GymFlipFitAdminMenu().displayMenu(loggedInUser, in);
					break;
				case Constants.ROLE_GYMOWNER:
					System.out.println("Logged In Successfully!!");
					GymOwnerServiceInterface gymOwnerServiceOperation = GymOwnerServiceOperation.getInstance();
					int isApproved = gymOwnerServiceOperation.viewProfile(loggedInUser).getApprovalStatus();
					if(isApproved == Constants.APPROVED) {
						new GymFlipFitGymOwnerMenu().displayMenu(loggedInUser, in);
					}else {
						System.out.println("\033[1mGym Owner not Approved\033[0m");
					}
					
					break;
				case Constants.ROLE_CUSTOMER:
					System.out.println("Logged In Successfully!!");
					new GymFlipFitCustomerMenu().displayMenu(loggedInUser, in);
					break;
	
			}
		} else {
			System.out.println("\033[1mCouldn't login please try again!!\033[0m");
		}
		System.out.println("\033[1mExiting login Menu..\\033[0m");
	}

	void register(Scanner in) {
		System.out.println("\n\n ---------- Please enter the type of user ---------- ");
		System.out.println("Press 1. Customer \nPress 2. GymOwner");

		int userRole = in.nextInt();
		while (userRole < 1 || userRole > 2) {
			System.out.println("\033[1mInvalid type please try again!!\033[0m");
			userRole = in.nextInt();
		}
		System.out.println("Please Enter the username");
		String userName = in.next();
		System.out.println("Please Enter the password");
		String password = in.next();
		String role = userRole == 1 ? Constants.ROLE_CUSTOMER : Constants.ROLE_GYMOWNER;
		UserServiceInterface userService = UserServiceOperation.getInstance();
		switch(role) {
			case Constants.ROLE_CUSTOMER:
				Customer customer = new Customer();
				customer.setUserName(userName);
				customer.setPassword(password);
				customer.setRole(Constants.ROLE_CUSTOMER);
				System.out.println("Please Enter you full name");
				String name = in.next();
				customer.setName(name);
				System.out.println("Please Enter your age");
				int age = in.nextInt();
				customer.setAge(age);
				System.out.println("Please enter your location");
				String location = in.next();
				customer.setLocation(location);
				if(userService.customerRegistration(customer)) {
					System.out.println("Registration complete");
				} else {
					System.out.println("Please try again!!");
				}
				break;
			case Constants.ROLE_GYMOWNER:
				
				GymOwner newGymOwner = new GymOwner();
				newGymOwner.setUserName(userName);
				newGymOwner.setPassword(password);
				newGymOwner.setRole(Constants.ROLE_GYMOWNER);
				System.out.println("Please Enter your panCard number");
				String panCard = in.next();
				newGymOwner.setPanCard(panCard);
				System.out.println("Please Enter your aadharCard number");
				String aadharCard = in.next();
				newGymOwner.setAadharCard(aadharCard);
				System.out.println("Please Enter your GstIn number");
				String GstIn = in.next();
				newGymOwner.setGstIN(GstIn);
				if (userService.gymOwnerRegistration(newGymOwner)) {
					System.out.println("Registration complete");
				} else {
					System.out.println("Please try again!!");
				}
				break;
		}
		
		System.out.println("\033[1mExiting register menu\033[0m");

	}

	void updatePassword(Scanner in) {
		System.out.println("Please enter the username!!");
		String userName = in.next();
		System.out.println("Please enter your old password");
		String password = in.next();
		UserServiceInterface userService = UserServiceOperation.getInstance();
		User oldUser = userService.login(userName, password);
		if (oldUser != null) {
			System.out.println("Please enter your new Password!!");
			String newPassword = in.next();
			if (userService.updatePassword(oldUser, newPassword) != 0) {
				System.out.println("\033[1mPassword Updated successfully!!\033[0m");
			} else {
				System.out.println("Please try again!!");
			}
		} else {
			System.out.println("\033[1mInvalid Credentials Please try again!!\033[0m");
		}
	}

}
