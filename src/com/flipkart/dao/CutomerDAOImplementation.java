package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.flipkart.bean.Customer;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;
import com.flipkart.business.UserServiceInterface;
import com.flipkart.business.UserServiceOperation;
import com.flipkart.constants.Constants;
import com.flipkart.constants.SqlConstants;
import com.flipkart.utils.DBConnection;

public class CutomerDAOImplementation implements CustomerDAOInterface {
	

	private static CustomerDAOInterface customerDaoObj = null;

	private CutomerDAOImplementation() {
	}

	public static synchronized CustomerDAOInterface getInstance() {
		if (customerDaoObj == null)
			customerDaoObj = new CutomerDAOImplementation();

		return customerDaoObj;
	}

	@Override
	public Customer viewProfile(String username, String password) {
		UserDAOInterface userDAO = UserDAOImplementation.getInstance();
		User loggedInUser = userDAO.loginUser(username, password);
		if(loggedInUser!=null){
			Customer customer = new Customer();
			customer.setUserID(loggedInUser.getUserID());
			customer.setUserName(loggedInUser.getUserName());
			customer.setPassword(loggedInUser.getPassword());
			Connection connection = DBConnection.getConnection();
			if (connection != null) {
				try {
					String selectQuery = SqlConstants.SELECT_CUSTOMER + SqlConstants.WHERE_ID;
					PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
					preparedStatement.setInt(1,customer.getUserID());
					ResultSet rs = preparedStatement.executeQuery();
					while(rs.next()){
						 //Retrieve by column name
						 rs.getInt("ID");
						 String name = rs.getString("name");
						 customer.setName(name);
						 int age = rs.getInt("age");
						 customer.setAge(age);
						 String location = rs.getString("location");
						 customer.setLocation(location);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return customer;
		}
		return null;
	}

	@Override
	public boolean register(Customer customer) {
		UserDAOInterface userDAO = UserDAOImplementation.getInstance();
		if(userDAO.register(customer) > 0) {
			User user  = userDAO.loginUser(customer.getUserName(), customer.getPassword());
			customer.setUserID(user.getUserID());
			
			if(insert(customer) > 0) {
				System.out.println("Customer has been registered successfully");
				return true;
			}else {
				return false;
			}
		}
		return false;
	}
	@Override
	public int insert(Customer customer) {
		int rowsUpdated = 0;
		Connection connection = DBConnection.getConnection();
		if (connection != null) {
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(SqlConstants.INSERT_CUSTOMER);
				prepareStatement(preparedStatement, customer);
				rowsUpdated = preparedStatement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rowsUpdated;

	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(String id, Customer newCustomer) {
		// TODO Auto-generated method stub

	}

	private void prepareStatement(PreparedStatement preparedStatement, Customer customer) {
		try {
			preparedStatement.setInt(1, customer.getUserID());
			preparedStatement.setString(2, customer.getName());
			preparedStatement.setInt(3, customer.getAge());
			preparedStatement.setString(4, customer.getLocation());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Driver
	public static void main(String args[]) {
		CustomerDAOInterface custDAO = new CutomerDAOImplementation();
		Customer customer = new Customer();
		customer.setUserName("customer4");
		customer.setPassword("pass");
		customer.setRole(Constants.ROLE_CUSTOMER);
		
		custDAO.insert(customer);
	}


}
