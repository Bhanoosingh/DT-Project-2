package com.niit.test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

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
	
/*	@Test
	public void addBlogTest() throws ParseException {
		SimpleDateFormat textFormat = new SimpleDateFormat("dd-MM-yyyy");
		blog.setBlogName("Hibernate");
		blog.setUserName("shailendra91");
		blog.setBlogContent("Hibernate Content");
		blog.setCreateDate(textFormat.parse("21-06-2018"));
		blog.setStatus("NA");
		blog.setLikes(4);
		assertEquals("Problem in inserting blog table", true, blogDao.addBlog(blog));
		
		System.out.println("<-----------Successfully added into blog-------->");
	}*/

	/*@Test
	public void updateBlogTest() {
		
		blog.setBlogId(3);
		blog.setStatus("A");
		assertEquals("Problem in updating status of blog", true, blogDao.updateBlog(blog));
		
		System.out.println("<-----------Successfully updated into blog-------->");
	}*/
	
	/*@Test
	public void deleteBlogTest() {
		
		blog.setBlogId(4);
		assertEquals("Problem in deleting blog", true, blogDao.deleteBlog(blog));
		
		System.out.println("<-----------Successfully deleted blog-------->");
	}*/
	
	@Test
	public void listBlogTest() {
		
		List<Blog> list = blogDao.listBlog("shailendra91");
		assertTrue("Problem in listing blog",list.size()>0);
		for(Blog b:list) {
			
			System.out.print(b.getBlogId()+"::");
			System.out.print(b.getBlogName()+"::");
			System.out.print(b.getBlogContent()+"::");
			System.out.print(b.getUserName()+"::");
		}
	}

}
