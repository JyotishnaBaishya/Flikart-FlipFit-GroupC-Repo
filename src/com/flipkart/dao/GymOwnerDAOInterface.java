package com.flipkart.dao;

import com.flipkart.bean.GymOwner;

public interface GymOwnerDAOInterface {
	int insert(GymOwner gymOwner);
	void delete(String id);
	void update(String id, GymOwner newGymOwner);
}
