package com.niit.controller;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.dao.BlogDAO;
import com.niit.dao.ForumDAO;
import com.niit.dao.JobDAO;
import com.niit.dao.ProfilePicDAO;
import com.niit.dao.UserDAO;
import com.niit.daoimpl.BlogDAOImpl;
import com.niit.daoimpl.ForumDAOImpl;
import com.niit.daoimpl.JobDAOImpl;
import com.niit.daoimpl.ProfilePicDAOImpl;
import com.niit.daoimpl.UserDAOImpl;
import com.niit.model.Blog;
import com.niit.model.BlogComment;
import com.niit.model.Forum;
import com.niit.model.ForumComment;
import com.niit.model.Job;
import com.niit.model.ProfilePicture;
import com.niit.model.User;

@Configuration
@ComponentScan("com.niit.*")
@EnableTransactionManagement
public class DatabaseConfig {

	private static final String DATABASE_DRIVER_CLASS="oracle.jdbc.driver.OracleDriver";
	private static final String DATABASE_URL="jdbc:oracle:thin:@localhost:1521:xe";
	private static final String DATABASE_USER="CodeWarriors";
	private static final String DATABASE_PASSWORD="123";
	private static final String HBMDDL="update";
	private static final String HIBERNATE_DIALECT="org.hibernate.dialect.Oracle10gDialect";
	
	@Autowired
	@Bean(name="dataSource")
	public DataSource getDataSource() {
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(DATABASE_DRIVER_CLASS);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USER);
		dataSource.setPassword(DATABASE_PASSWORD);
		System.out.println("Oracle connected");
		return dataSource;
	}
	
	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory() {
		
		Properties properties = new Properties();
		properties.put("hibernate.hbm2ddl.auto", HBMDDL);
		properties.put("hibernate.dialect",HIBERNATE_DIALECT);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		
		LocalSessionFactoryBuilder localSessionFactoryBuider = new LocalSessionFactoryBuilder(getDataSource());
		localSessionFactoryBuider.addProperties(properties);
		
		localSessionFactoryBuider.addAnnotatedClass(Blog.class);
		localSessionFactoryBuider.addAnnotatedClass(Forum.class);
		localSessionFactoryBuider.addAnnotatedClass(Job.class);
		localSessionFactoryBuider.addAnnotatedClass(User.class);
		localSessionFactoryBuider.addAnnotatedClass(BlogComment.class);
		localSessionFactoryBuider.addAnnotatedClass(ForumComment.class);
		localSessionFactoryBuider.addAnnotatedClass(ProfilePicture.class);
		System.out.println("=== Tables Created ===");
		SessionFactory sessionFectory = localSessionFactoryBuider.buildSessionFactory(); 
		
		return sessionFectory;
		
	}	
	
	@Bean(name="blogDAO")
	public BlogDAO getBlogDAO(SessionFactory sessionFactory) {
		
		return new BlogDAOImpl(sessionFactory);
	}
	
	@Bean(name="forumDAO")
	public ForumDAO getForumDAO() {
		
		return new ForumDAOImpl();
	}
	
	@Bean(name="jobDAO")
	public JobDAO getjobDAO() {
		
		return new JobDAOImpl();
	}
	
	@Bean(name="userDAO")
	public UserDAO getUserDAO() {
		
		return new UserDAOImpl();
	}
	
	@Bean(name = "profileDAO")
	public ProfilePicDAO getProfilePictureDAO() {
		return new ProfilePicDAOImpl();
	}
	@Bean
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory) {
		
		return new HibernateTransactionManager(sessionFactory);
	}
}
