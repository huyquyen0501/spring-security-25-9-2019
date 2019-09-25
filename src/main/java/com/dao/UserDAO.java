package com.dao;

import java.util.ArrayList;

import com.entity.User;

public interface UserDAO {
	 User findByUserName(String username);
	ArrayList<User> getAll();
	
}
