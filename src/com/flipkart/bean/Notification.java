/**
 * 
 */
package com.flipkart.bean;

import java.util.Date;

/**
 * 
 */
public class Notification {
	String notifID;
	String userID;
	String content;
	Boolean isViewed = false;
	Date createdAt;

	public Boolean getIsViewed() {
		return isViewed;
	}

	public void setIsViewed(Boolean isViewed) {
		this.isViewed = isViewed;
	}

	public String getNotifID() {
		return notifID;
	}

	public void setNotifID(String notifID) {
		this.notifID = notifID;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return createdAt;
	}

	public void setDate(Date date) {
		this.createdAt = date;
	}
}
