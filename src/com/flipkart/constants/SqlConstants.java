package com.flipkart.constants;

public class SqlConstants {

	// Customer
	public static final String TABLE_CUSTOMER = "CUSTOMER";
	public static final String SELECT_CUSTOMER = "SELECT * FROM " + TABLE_CUSTOMER;
	public static final String INSERT_CUSTOMER = "INSERT INTO " + TABLE_CUSTOMER
			+ " (ID, NAME, AGE, LOCATION) " + " VALUES (?, ?, ?, ?)";
	
	// GymOwner
	public static final String TABLE_GYM_OWNER = "GYMOWNER";
	public static final String SELECT_GYM_OWNER = "SELECT * FROM " + TABLE_GYM_OWNER;
	public static final String UPDATE_APPROVE_OR_REJECT_GYM_OWNER = "UPDATE " + TABLE_GYM_OWNER + " SET ISAPPROVED = ? ";
	public static final String INSERT_GYM_OWNER = "INSERT INTO " + TABLE_GYM_OWNER
			+ " (ID, AADHARCARD, PANCARD, GSTIN, ISAPPROVED) " + " VALUES (?, ?, ?, ?, ?)";
	public static final String JOIN_GYM_OWNER_USER = "SELECT GymOwner.ID, username, aadharcard, pancard, gstin, isApproved\n"
			+ "FROM GymOwner\n"
			+ "JOIN User\n"
			+ "ON GymOwner.ID = User.ID";

	// Gym
	public static final String TABLE_GYM = "GYM";
	public static final String SELECT_GYM = "SELECT * FROM " + TABLE_GYM;
	public static final String UPDATE_APPROVE_GYM = "UPDATE " + TABLE_GYM + " SET ISAPPROVED = ? ";
	public static final String INSERT_GYM = "INSERT INTO " + TABLE_GYM
			+ " (GYMNAME, GYMOWNERID, LOCATION, NOOFSEATS, ISAPPROVED) " + " VALUES (?, ?, ?, ?, ?)";
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
	public static final String UPDATE_NOTIFICATION = "UPDATE " + TABLE_NOTIFICATION + " SET ISVIEWED = 1";
	public static final String DELETE_NOTIFICATION = "DELETE FROM " + TABLE_NOTIFICATION;
	public static final String WHERE_NOT_VIEWED_NOTIFICATION = " WHERE USERID=(?) AND USERTYPE=(?) AND ISVIEWED=0";
	


	// common WHERE clauses
	public static final String WHERE_ID = " WHERE ID=(?)";
	public static final String WHERE_PENDING_APPROVAL_FALSE = " WHERE ISAPPROVED = FALSE";
	public static final String WHERE_APPROVAL_TRUE = " WHERE ISAPPROVED = TRUE";

}
