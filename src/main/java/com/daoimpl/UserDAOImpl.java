package com.daoimpl;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.UserDAO;
import com.entity.User;

@Repository

public class UserDAOImpl implements UserDAO {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public User findByUserName(String username) {
		String hql="form User where username= :username";
		Session session= sessionFactory.getCurrentSession();
		ArrayList<User> user= (ArrayList<User>) session.createQuery(hql).setParameter(0, username).list();
		if(user.size()>0) {
			return user.get(0);
		}else {
			return null;
		}
	}

	@Override
	public ArrayList<User> getAll() {
		Session session= sessionFactory.getCurrentSession();
		ArrayList<User> list= (ArrayList<User>) session.createQuery("form User").list();
	
		return list;
	}

}
