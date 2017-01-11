package com.skillsmanagement.dao;

import java.util.List;

import com.skillsmanagement.model.User;

public interface UserDao {
	List<User> getUserList();

	User getUserByUsername(String username);

	void addUser(User user);

	void editUser(User user);

	void deleteUser(User user);

	User getUserById(int id);
}
