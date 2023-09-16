package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.flipkart.bean.Customer;
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
	public int insert(Customer customer) {
		int rowsUpdated = 0;
		Connection connection = DBConnection.getConnection();
		if (connection != null) {
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(SqlConstants.INSERT_USER);
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
		System.out.println("# of DB Rows successfully updated: " + rowsUpdated);
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
			preparedStatement.setString(1, customer.getUserName());
			preparedStatement.setString(2, customer.getPassword());
			preparedStatement.setString(3, customer.getRole());
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
