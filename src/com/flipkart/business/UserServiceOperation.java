/**
 * 
 */
package com.flipkart.business;

/**
 * 
 */
public class UserServiceOperation implements UserServiceInterface{

	@Override
	public boolean registration() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean login(String userId, String password, int role) {
		if(userId.equalsIgnoreCase("admin") && password.equalsIgnoreCase("pass") && role == 1) {	 // Tmp condition, needs to be updated
			return true;
		} else if(userId.equalsIgnoreCase("gymowner") && password.equalsIgnoreCase("pass") && role == 2) {	 // Tmp condition, needs to be updated
			return true;
		} else if(userId.equalsIgnoreCase("customer") && password.equalsIgnoreCase("pass") && role == 3) {	 // Tmp condition, needs to be updated
			return true;
		} else {
			System.out.println("Incorrect ID/Password");
			return false;
		}
		
	}

}
