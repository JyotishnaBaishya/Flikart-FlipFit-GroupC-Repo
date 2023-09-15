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

	UserDAOInterface userDAO = new UserDAOImplementation();
	@Override
	public boolean registration(String username, String password, String role) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setUserName(username);
		user.setPassword(password);
		user.setRole(role);
		return userDAO.register(user) != 0;
	}

	@Override
	public User login(String userName, String password) {
		User loggedInUser = userDAO.loginUser(userName, password);
		return loggedInUser;
	}

}
