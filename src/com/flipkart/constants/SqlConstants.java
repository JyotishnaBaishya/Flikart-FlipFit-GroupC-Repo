package com.flipkart.constants;

public class SqlConstants {
	public static final String TABLE_GYM_OWNER = "GYMOWNER";
	public static final String SELECT_GYM_OWNER = "SELECT * FROM " + TABLE_GYM_OWNER;
	public static final String UPDATE_APPROVE_GYM_OWNER = "UPDATE " + TABLE_GYM_OWNER + " SET ISAPPROVED = TRUE "
			+ " WHERE ID = (?)";

	public static final String WHERE_PENDING_APPROVAL = " WHERE isApproved = false";

}
