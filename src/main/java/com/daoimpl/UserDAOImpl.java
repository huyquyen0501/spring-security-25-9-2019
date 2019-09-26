package com.daoimpl;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.UserDAO;
import com.entity.User;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {
	@Autowired
	private SessionFactory sessionFactory;
	String encoder(String password) {
		BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
		String encoded =encoder.encode(password);
		return encoded;
	}
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

	@Override
	public User registerUser(String name, String sex, String address, String username,
			String password) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String passwordencode=encoder(password);
		User user= new User();
		user.setName(name);
		user.setSex(sex);
		user.setAddress(address);
		user.setUsername(username);
		user.setPassword(passwordencode);
		session.save(user);
		session.getTransaction().commit();
		return user;
		
	}

	@Override
	public int updateUser(String name, String address,String username) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query= session.createQuery("update User set name = :name"+"address = :address"+"where username= :username")
		.setParameter(name, name)
		.setParameter(address, address)
		.setParameter(username, username);
		int result= query.executeUpdate();
		return result;
	}

	@Override
	public int deactiveUser(String username, boolean enable) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query= session.createQuery("update User set enable = false where username = :username").setParameter(0, username);
		int result= query.executeUpdate();
		return result;
	}

	@Override
	public int deleteUser(String username) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query= session.createQuery("delete User where username= :username")
		.setParameter(0, username);
		int result = query.executeUpdate();

		return result;
	}

}
