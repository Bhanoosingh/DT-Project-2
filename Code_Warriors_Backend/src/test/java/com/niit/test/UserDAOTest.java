package com.niit.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.UserDAO;
import com.niit.model.User;

public class UserDAOTest {

	static User user;
	static UserDAO userDao;
	@BeforeClass
	public static void init() {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		user =new User();
		userDao = (UserDAO) context.getBean("userDAO");
	} 
	
	/*@Test
	public void addUserTest(){
		user.setName("Shailendra");
		user.setPassword("@123");
		user.setEmail("shailendra@niit.com");
		user.setRole("Admin");
		user.setAddress("Agra");
		user.setPhone("9898989889");
		assertEquals("Successfully added user into the table", true, userDao.addUser(user));
		
		System.out.println("<-----------Successfully added into user-------->");
	}*/

	/*@Test
	public void updateUserTest() {
		
		user.setName("Shailendra");
		user.setPassword("@123");
		user.setEmail("shailendra@niit.com");
		user.setRole("Admin");
		user.setAddress("Agra");
		user.setPhone("9898989889");
		user.setEnabled(true);
		assertEquals("Successfully updated status of forum", true, userDao.updateUser(user));
		
		System.out.println("<-----------Successfully updated into user-------->");
	}*/
	
	/*@Test
	public void deleteForumTest() {
		
		user.setEmail("shailendra@niit.com");
		assertEquals("Successfully deleted job", true, userDao.deleteUser(user));
		
		System.out.println("<-----------Successfully deleted user-------->");
	}*/
}
