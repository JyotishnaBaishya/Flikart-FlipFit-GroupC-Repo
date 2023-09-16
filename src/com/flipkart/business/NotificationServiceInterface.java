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
public interface NotificationServiceInterface {

	public void addNotification(Notification notification);

	public List<Notification> viewMyNotifications(User user);
}
