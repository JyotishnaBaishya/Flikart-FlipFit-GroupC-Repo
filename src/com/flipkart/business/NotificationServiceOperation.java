/**
 * 
 */
package com.flipkart.business;

import java.util.List;

import com.flipkart.bean.Notification;
import com.flipkart.bean.User;

/**
 * 
 */
public class NotificationServiceOperation implements NotificationServiceInterface {

	private static NotificationServiceInterface notificationServiceObj = null;

	private NotificationServiceOperation() {
	}

	public static synchronized NotificationServiceInterface getInstance() {
		if (notificationServiceObj == null)
			notificationServiceObj = new NotificationServiceOperation();

		return notificationServiceObj;
	}

	@Override
	public void addNotification(Notification notification) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Notification> viewMyNotifications(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
