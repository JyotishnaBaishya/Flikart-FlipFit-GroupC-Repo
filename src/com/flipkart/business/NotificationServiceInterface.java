/**
 * 
 */
package com.flipkart.business;

import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Notification;
import com.flipkart.bean.User;

/**
 * 
 */
public interface NotificationServiceInterface {

	public void addNotification(Notification notification);

	ArrayList<Notification> viewMyNotifications(User user, String userType);
}
