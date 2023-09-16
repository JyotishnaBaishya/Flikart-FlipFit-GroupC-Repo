/**
 * 
 */
package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Notification;
import com.flipkart.constants.SqlConstants;
import com.flipkart.utils.DBConnection;

/**
 * 
 */
public class NotificationDAOImplementation implements NotificationDAOInterface{

	private static NotificationDAOInterface notificationDaoObj = null;

	private NotificationDAOImplementation() {
	}

	public static synchronized NotificationDAOInterface getInstance() {
		if (notificationDaoObj == null)
			notificationDaoObj = new NotificationDAOImplementation();

		return notificationDaoObj;
	}
	
	@Override
	public int insert(Notification notification) {
		int rowsUpdated = 0;
		Connection connection = DBConnection.getConnection();
		if (connection != null) {
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(SqlConstants.INSERT_NOTIFICATION);
				prepareStatement(preparedStatement, notification);
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
	
	private void prepareStatement(PreparedStatement preparedStatement, Notification notification) {
		try {
			preparedStatement.setInt(1, notification.getUserID());
			preparedStatement.setString(2, notification.getUserType());
			preparedStatement.setString(3, notification.getContent());
			preparedStatement.setBoolean(4, false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
		
	}

	/**
	 * driver
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
