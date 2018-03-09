package com.niit.daoimpl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.UserDAO;
import com.niit.model.Blog;
import com.niit.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public boolean addUser(User user) {
		
		try {
			sessionFactory.getCurrentSession().save(user);
			return true;
		}catch(Exception exception) {
			return false;
		}
	}

	@Transactional
	@Override
	public boolean updateUser(User user) {
		
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		}catch(Exception exception) {
			return false;
		}
	}

	@Transactional
	@Override
	public boolean deleteUser(User user) {
		
		try {
			sessionFactory.getCurrentSession().delete(user);
			return true;
		}catch(Exception exception) {
			return false;
		}
	}

	@Override
	public User getUser(String userId) {
		
		try {
			Session session = sessionFactory.openSession();
			User user = session.get(User.class, userId);
			return user;
		}catch(Exception exception) {
			return null;
		}
	}

}
