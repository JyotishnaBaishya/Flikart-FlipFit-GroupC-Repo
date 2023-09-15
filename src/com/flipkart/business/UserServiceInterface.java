package com.flipkart.business;

import com.flipkart.bean.User;

public interface UserServiceInterface {
	public boolean registration(String username, String password, String role);
	public User login(String userId, String password);
}
