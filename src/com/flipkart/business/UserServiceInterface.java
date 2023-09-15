package com.flipkart.business;

public interface UserServiceInterface {
	public boolean registration(String username, String password, int role);
	public boolean login(String userId, String password, int role);
}
