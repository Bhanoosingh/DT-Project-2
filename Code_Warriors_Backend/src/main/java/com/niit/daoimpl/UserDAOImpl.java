package com.niit.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.UserDAO;
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

	@Override
	public boolean checkLogin(User user) {
		try{
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from UserRecord where email=:email and password=:password");
			query.setParameter("email",user.getEmail());
			query.setParameter("password",user.getPassword());
			User userDetails=(User)query.list().get(0);
			session.close();
			if(userDetails==null){
				return false;
			}else
			{
			 return true;
			}
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateOnlineStatus(String status, User user) {
		try {
			user.setIsOnline(status);
			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<User> listUsers() {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			List<User> userList = new ArrayList<User>();
			Query query = session.createQuery("FROM User");
			userList = query.list();
			return userList;
		} catch (Exception e) {
			return null;
		}
	}

}
