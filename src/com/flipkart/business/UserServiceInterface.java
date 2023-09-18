package com.flipkart.business;

import com.flipkart.bean.Customer;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;
/**
 * @author rohit.r10
 */
public interface UserServiceInterface {
	public boolean customerRegistration(Customer customer);
	
	public boolean gymOwnerRegistration(GymOwner gymOwner);
	
	public boolean registration(String username, String password, String role);

	public User login(String userId, String password);

	public int updatePassword(User user, String newPassword);
}
