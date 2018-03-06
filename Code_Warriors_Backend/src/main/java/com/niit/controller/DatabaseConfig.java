package com.niit.controller;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.dao.BlogDAO;
import com.niit.daoimpl.BlogDAOImpl;
import com.niit.model.Blog;

@Configuration
@ComponentScan("con.niit")
@EnableTransactionManagement
public class DatabaseConfig {

	private static final String DATABASE_DRIVER_CLASS="oracle.jdbc.driver.OracleDriver";
	private static final String DATABASE_URL="jdbc:oracle:thin:@localhost:1521:XE";
	private static final String DATABASE_USER="hr";
	private static final String DATABASE_PASSWORD="hr";
	private static final String HBMDDL="hibernate.hbmddl2.auto";
	private static final String HIBERNATE_DIALECT="org.hibernate.dialect.Oracle10gDialect";
	
	public DataSource getDataSource() {
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(DATABASE_DRIVER_CLASS);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USER);
		dataSource.setPassword(DATABASE_PASSWORD);
		return dataSource;
	}
	
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory() {
		
		Properties properties = new Properties();
		properties.put(HBMDDL, "update");
		properties.put("hibernate.dialect",HIBERNATE_DIALECT);
		properties.put("hibernate.show_sql", "true");
		
		LocalSessionFactoryBuilder localSessionFactoryBuider = new LocalSessionFactoryBuilder(getDataSource());
		localSessionFactoryBuider.addProperties(properties);
		
		localSessionFactoryBuider.addAnnotatedClass(Blog.class);
		
		SessionFactory sessionFectory = localSessionFactoryBuider.buildSessionFactory(); 
		System.out.println("===Tables Created===");
		return sessionFectory;
		
	}
	
	
	
	@Bean(name="blogDAO")
	public BlogDAO getBlogDAO() {
		
		return new BlogDAOImpl();
	}
	
	@Bean(name="transactionManager")
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory) {
		
		return new HibernateTransactionManager(sessionFactory);
	}
}
