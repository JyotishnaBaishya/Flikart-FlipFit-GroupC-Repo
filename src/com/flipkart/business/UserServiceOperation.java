/**
 * 
 */
package com.flipkart.business;
import java.util.*;

import com.flipkart.bean.User;
import com.flipkart.dao.UserDAOImplementation;
import com.flipkart.dao.UserDAOInterface;
/**
 * 
 */
public class UserServiceOperation implements UserServiceInterface{
	
	@Override
	public boolean registration(String username, String password, String role) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setUserName(username);
		user.setPassword(password);
		user.setRole(role);
		return UserDAOImplementation.getInstance().register(user) != 0;
	}

	@Override
	public User login(String userName, String password) {
		User loggedInUser = UserDAOImplementation.getInstance().loginUser(userName, password);
		return loggedInUser;
	}
	
	public int updatePassword(User user, String newPassword) {
		return UserDAOImplementation.getInstance().updatePassword(user,newPassword);
	}
}
