package com.flipkart.dao;

import java.util.ArrayList;

import com.flipkart.bean.Notification;

public interface NotificationDAOInterface {
	public int insert(Notification notification);
	public ArrayList<Notification> getNotifications(int userId, String userType);
}
