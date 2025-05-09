package com.springCore_JDBC_ORM.dao.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.springCore_JDBC_ORM.dao.UserDao;
import com.springCore_JDBC_ORM.entities.User;

public class UserDaoImpl implements UserDao {

	private HibernateTemplate hibernateTemplate;


	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional
	public int insertUser(User user) {

		int result = (Integer)this.hibernateTemplate.save(user);

		return result;
	}

	@Transactional
	public int updateUser(User user) {

		this.hibernateTemplate.update(user);
		return 1;
	}

	@Transactional
	public int deleteUser(int userId) {
		User user = this.hibernateTemplate.get(User.class,userId);
		if(user!=null) {
			this.hibernateTemplate.delete(user);
			return 1;
		}else return 0;
	}

	public User getSingleUser(int userId) {

		User user = this.hibernateTemplate.get(User.class, userId);

		return user;
	}

	public List<User> getAllUser() {
		 List<User> users = this.hibernateTemplate.loadAll(User.class);
		return users;
	}
}
