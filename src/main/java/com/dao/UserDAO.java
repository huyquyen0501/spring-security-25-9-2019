package com.dao;

import java.util.ArrayList;

import com.entity.User;

public interface UserDAO {
	 User findByUserName(String username);
	ArrayList<User> getAll();
	User registerUser(String name, String sex, String address, String username, String password);
	int updateUser(String name,  String address,String username);
	int deactiveUser(String username, boolean enable);
	int deleteUser(String username);
	
}
