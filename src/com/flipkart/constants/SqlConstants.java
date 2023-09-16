package com.flipkart.constants;

public class SqlConstants {

	// GymOwner
	public static final String TABLE_GYM_OWNER = "GYMOWNER";
	public static final String SELECT_GYM_OWNER = "SELECT * FROM " + TABLE_GYM_OWNER;
	public static final String UPDATE_APPROVE_GYM_OWNER = "UPDATE " + TABLE_GYM_OWNER + " SET ISAPPROVED = TRUE ";
	public static final String INSERT_GYM_OWNER = "INSERT INTO " + TABLE_GYM_OWNER
			+ " (USERNAME, PASSWORD, AADHARCARD, GSTIN, ISAPPROVED) " + " VALUES (?, ?, ?, ?, ?)";

	// Gym
	public static final String TABLE_GYM = "GYM";
	public static final String SELECT_GYM = "SELECT * FROM " + TABLE_GYM;
	public static final String UPDATE_APPROVE_GYM = "UPDATE " + TABLE_GYM + " SET ISAPPROVED = TRUE ";
	public static final String INSERT_GYM = "INSERT INTO " + TABLE_GYM
			+ " (GYMOWNERID, LOCATION, NOOFSEATS, ISAPPROVED) " + " VALUES (?, ?, ?, ?)";
	public static final String VIEW_REGISTERED_GYM = SELECT_GYM + " WHERE GYMOWNERID=(?)";

	// TimeSlot
	public static final String TABLE_TIMESLOT = "TimeSlot";

	public static final String INSERT_TIMESLOT = "INSERT INTO " + TABLE_TIMESLOT + " (SLOTID, GYMID, AVAILABLESEATS, DAY) "
			+ " VALUES (?, ?, ?, ?)";

	public static final String CHECK_TIMESLOT_AVAILABILITY = "SELECT AVAILABLESEATS FROM " + TABLE_TIMESLOT
			+ " WHERE SLOTID = (?) AND GYMID = (?)";

	public static final String UPDATE_TIMESLOT_AVAILABILITY = "UPDATE " + TABLE_TIMESLOT
			+ " SET AVAILABLESEATS = AVAILABLESEATS + (?) WHERE SLOTID = (?) AND GYMID = (?)";

	// User
	public static final String TABLE_USER = "USER";
	public static final String INSERT_USER = "INSERT INTO " + TABLE_USER + " (username, password, role) "
			+ " VALUES (?, ?, ?)";	
	public static final String SELECT_USER = "SELECT * FROM " + TABLE_USER;	
	public static final String WHERE_USERNAME = " WHERE username = ";
	public static final String UPDATE_USER_PASSWORD = "UPDATE " + TABLE_USER + " SET password = ? WHERE ID = ?";



	// common WHERE clauses
	public static final String WHERE_ID = " WHERE ID=(?)";
	public static final String WHERE_PENDING_APPROVAL = " WHERE ISAPPROVED = FALSE";

}
