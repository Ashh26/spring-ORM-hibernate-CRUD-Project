package com.springCore_JDBC_ORM.dao;

import java.util.List;

import com.springCore_JDBC_ORM.entities.User;

public interface UserDao {

	public int insertUser(User user);

	public int updateUser(User user);

	public int deleteUser(int userId);

	public User getSingleUser(int userId);

	public List<User> getAllUser();

}
