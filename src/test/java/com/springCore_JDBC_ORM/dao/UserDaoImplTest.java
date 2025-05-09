package com.springCore_JDBC_ORM.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.springCore_JDBC_ORM.config.TestConfig;
import com.springCore_JDBC_ORM.dao.Impl.UserDaoImpl;
import com.springCore_JDBC_ORM.entities.User;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfig.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserDaoImplTest {

	@Autowired
	private UserDao daoImpl;

	static int testUserId;

	@Test
	@Order(1)
	void testInsertUser() {
		User user = new User();
		user.setName("testing");
		user.setCity("hydrabad");
		user.setPincode(478698);

		 testUserId = daoImpl.insertUser(user);
		 assertTrue(testUserId>0);
	}

	@Test
	@Order(2)
	void testUpdateUser() {
		User user = daoImpl.getSingleUser(testUserId);
		user.setCity("UpdatedCity");

		int result = daoImpl.updateUser(user);
		assertEquals(1,result);

		User updated = daoImpl.getSingleUser(testUserId);
		assertEquals("UpdatedCity", updated.getCity());

	}

	@Test
	@Order(3)
	void testDeleteUser() {
		int result = daoImpl.deleteUser(testUserId);
		assertEquals(1, result);

		User user = daoImpl.getSingleUser(testUserId);
		assertNull(user);

	}

	@Test
	@Order(4)
	void testGetSingleUser() {
		User user = daoImpl.getSingleUser(testUserId);
		assertNotNull(user);
		assertEquals("TestUser",user.getName());
	}

	@Test
	@Order(5)
	void testGetAllUser() {
		List<User> users = daoImpl.getAllUser();
		assertFalse(users.isEmpty());
	}

}








