package com.niit.dao;

import com.niit.model.User;

public interface UserDAO {

	public boolean addUser(User user);
	public boolean updateUser(User user);
	public boolean deleteUser(User user);
	public User getUser(String userId);
}
