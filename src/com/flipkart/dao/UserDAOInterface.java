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


	public int updatePassword(User user, String newPassword);
	
	public User loginUser(String username, String password);
}
