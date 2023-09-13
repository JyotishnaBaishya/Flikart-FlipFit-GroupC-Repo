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
	public boolean login(String userId, String password) {
		if(userId.equalsIgnoreCase("user") && password.equalsIgnoreCase("pass")) {	 //TODO Tmp condition, needs to be updated
			return true;
		} else {
			System.out.println("Incorrect ID/Password");
			return false;
		}
		
	}

}
