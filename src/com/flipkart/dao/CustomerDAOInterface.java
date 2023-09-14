package com.flipkart.dao;

import com.flipkart.bean.Customer;
import com.flipkart.bean.GymOwner;

public interface CustomerDAOInterface {


	public int insert(Customer customer);


	public void delete(String id);


	public void update(String id, Customer newCustomer);
}
