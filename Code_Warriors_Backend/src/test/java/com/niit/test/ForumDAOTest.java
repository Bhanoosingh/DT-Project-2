package com.niit.test;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.ForumDAO;
import com.niit.model.Forum;

public class ForumDAOTest {

	static Forum forum;
	static ForumDAO forumDao;
	@BeforeClass
	public static void init() {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		forum =new Forum();
		forumDao = (ForumDAO) context.getBean("forumDAO");
	} 
	
	/*@Test
	public void addForumTest() throws ParseException {
		SimpleDateFormat textFormat = new SimpleDateFormat("yyyy-MM-dd");
		forum.setForumName("Forum-Demo");
		forum.setUserName("shailendra91");
		forum.setForumContent("Code forum");
		forum.setCreatedDate(textFormat.parse("2017-06-18"));
		assertEquals("Problem in adding forum into the table", true, forumDao.addForum(forum));
		
		System.out.println("<-----------Successfully added into forum-------->");
	}*/

	/*@Test
	public void updateForumTest() {
		
		forum.setForumId(5);
		forum.setForumName("Forum-Demo");
		forum.setUserName("shailendra91");
		forum.setForumContent("This is forum content");
		assertEquals("Problem in updating status of forum", true, forumDao.updateForum(forum));
		
		System.out.println("<-----------Successfully updated into forum-------->");
	}*/
	
	/*@Test
	public void deleteForumTest() {
		
		forum.setForumId(5);
		assertEquals("Problem in deleting forum", true, forumDao.deleteForum(forum));
		
		System.out.println("<-----------Successfully deleted forum-------->");
	}*/
}
