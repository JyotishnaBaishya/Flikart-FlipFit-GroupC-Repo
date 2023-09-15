/**
 * 
 */
package com.flipkart.dao;

import com.flipkart.bean.User;

/**
 * 
 */
public interface UserDAOInterface {
	public int register(User user);


	public void delete(String id);


	public void update(String id, User user);
	
	public User loginUser(String username, String password);
}
