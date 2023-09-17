package com.flipkart.dao;

import com.flipkart.bean.Customer;

public interface CustomerDAOInterface {


	public int insert(Customer customer);
	
	public Customer viewProfile(String username, String password);
	
	public boolean register(Customer customer);

	public void delete(String id);

	public void update(String id, Customer newCustomer);
}
