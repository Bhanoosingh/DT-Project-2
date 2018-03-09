package com.niit.test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.BlogDAO;
import com.niit.model.Blog;

public class BlogDAOTest {

	static Blog blog;
	static BlogDAO blogDao;
	@BeforeClass
	public static void init() {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		blog =new Blog();
		blogDao = (BlogDAO) context.getBean("blogDAO");
	} 
	
	/*@Test
	public void addBlogTest() throws ParseException {
		SimpleDateFormat textFormat = new SimpleDateFormat("yyyy-MM-dd");
		blog.setBlogName("Shailendra");
		blog.setUserName("shailendra91");
		blog.setBlogContent("Code blog");
		blog.setCreateDate(textFormat.parse("2017-06-18"));
		blog.setStatus("NA");
		assertEquals("Successfully added blog into the table", true, blogDao.addBlog(blog));
		
		System.out.println("<-----------Successfully added into blog-------->");
	}*/

	/*@Test
	public void updateBlogTest() {
		
		blog.setBlogId(3);
		blog.setStatus("A");
		assertEquals("Successfully updated status of blog", true, blogDao.updateBlog(blog));
		
		System.out.println("<-----------Successfully updated into blog-------->");
	}*/
	
	/*@Test
	public void deleteBlogTest() {
		
		blog.setBlogId(4);
		assertEquals("Successfully deleted blog", true, blogDao.deleteBlog(blog));
		
		System.out.println("<-----------Successfully deleted blog-------->");
	}*/

}
