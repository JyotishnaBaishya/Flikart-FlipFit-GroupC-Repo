/**
 * 
 */
package com.flipkart.business;
import java.util.*;

import com.flipkart.bean.User;
/**
 * 
 */
public class UserServiceOperation implements UserServiceInterface{

	List<User> loggedInUsers = new ArrayList<User>();
	List<User> registeredUsers = new ArrayList<User>();
	@Override
	public boolean registration(String username, String password, int role) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setUserID(1);
		user.setPassword(password);
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
