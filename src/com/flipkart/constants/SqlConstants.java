package com.flipkart.constants;

public class SqlConstants {

	// GymOwner
	public static final String TABLE_GYM_OWNER = "GYMOWNER";
	public static final String SELECT_GYM_OWNER = "SELECT * FROM " + TABLE_GYM_OWNER;
	public static final String UPDATE_APPROVE_OR_REJECT_GYM_OWNER = "UPDATE " + TABLE_GYM_OWNER + " SET ISAPPROVED = ? ";
	public static final String INSERT_GYM_OWNER = "INSERT INTO " + TABLE_GYM_OWNER
			+ " (USERNAME, PASSWORD, AADHARCARD, GSTIN, ISAPPROVED) " + " VALUES (?, ?, ?, ?, ?)";

	// Gym
	public static final String TABLE_GYM = "GYM";
	public static final String SELECT_GYM = "SELECT * FROM " + TABLE_GYM;
	public static final String UPDATE_APPROVE_GYM = "UPDATE " + TABLE_GYM + " SET ISAPPROVED = ? ";
	public static final String INSERT_GYM = "INSERT INTO " + TABLE_GYM
			+ " (GYMOWNERID, GYMNAME, LOCATION, NOOFSEATS, ISAPPROVED) " + " VALUES (?, ?, ?, ?, ?)";
	public static final String WHERE_GYM_OWNER = SELECT_GYM + " WHERE GYMOWNERID=(?)";

	// TimeSlot
	public static final String TABLE_TIMESLOT = "TIMESLOT";

	public static final String INSERT_TIMESLOT = "INSERT INTO " + TABLE_TIMESLOT + " (SLOTHOUR, GYMID, AVAILABLESEATS, DAY) "
			+ " VALUES (?, ?, ?, ?)";

	public static final String CHECK_TIMESLOT_AVAILABILITY = "SELECT AVAILABLESEATS FROM " + TABLE_TIMESLOT
			+ " WHERE SLOTHOUR = (?) AND GYMID = (?)";

	public static final String UPDATE_TIMESLOT_AVAILABILITY = "UPDATE " + TABLE_TIMESLOT
			+ " SET AVAILABLESEATS = AVAILABLESEATS + (?) WHERE SLOTHOUR = (?) AND GYMID = (?)";

	// User
	public static final String TABLE_USER = "USER";
	public static final String INSERT_USER = "INSERT INTO " + TABLE_USER + " (username, password, role) "
			+ " VALUES (?, ?, ?)";	
	public static final String SELECT_USER = "SELECT * FROM " + TABLE_USER;	
	public static final String WHERE_USERNAME = " WHERE username = ";
	public static final String UPDATE_USER_PASSWORD = "UPDATE " + TABLE_USER + " SET password = ? WHERE ID = ?";

	// Notification
	public static final String TABLE_NOTIFICATION = "NOTIFICATION";
	public static final String INSERT_NOTIFICATION = "INSERT INTO " + TABLE_NOTIFICATION + " (userid, usertype, content, isViewed) "
			+ " VALUES (?, ?, ?, ?)";	
	public static final String SELECT_NOTIFICATION = "SELECT * FROM " + TABLE_NOTIFICATION;	
	public static final String WHERE__NOT_VIEWED_NOTIFICATION = " WHERE USERID=(?) AND USERTYPE=(?) AND ISVIEWED=0";


	// common WHERE clauses
	public static final String WHERE_ID = " WHERE ID=(?)";
	public static final String WHERE_PENDING_APPROVAL_FALSE = " WHERE ISAPPROVED = FALSE";
	public static final String WHERE_APPROVAL_TRUE = " WHERE ISAPPROVED = TRUE";

}
