package com.flipkart.business;

public interface UserServiceInterface {
	public boolean registration();
	public boolean login(String userId, String password, int role);
}
