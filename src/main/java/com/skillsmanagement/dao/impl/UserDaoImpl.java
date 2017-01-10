package com.skillsmanagement.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.skillsmanagement.dao.UserDao;
import com.skillsmanagement.model.Authorities;
import com.skillsmanagement.model.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	public List<User> getUserList() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User");
		@SuppressWarnings("unchecked")
		List<User> userList = query.list();
		session.flush();

		return userList;
	}

	public void addUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		user.setEnabled(true);

		Authorities newAuthority = new Authorities();
		newAuthority.setUsername(user.getUsername());
		newAuthority.setAuthority("ROLE_USER");
		session.saveOrUpdate(newAuthority);
		session.saveOrUpdate(user);
		session.flush();
		// auto login after registration
		SecurityContextHolder.getContext()
				.setAuthentication(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
	}

	public void editUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		Authorities authorities = new Authorities();
		authorities.setAuthoritiesId(user.getUserId());
		authorities.setAuthority("ROLE_USER");
		authorities.setUsername(user.getUsername());
		user.setEnabled(true);
		session.saveOrUpdate(user);
		session.saveOrUpdate(authorities);
		session.flush();
		// update security information
		SecurityContextHolder.getContext()
				.setAuthentication(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
	}

	public void deleteUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		Authorities authorities = new Authorities();
		authorities.setAuthoritiesId(user.getUserId());

		session.delete(authorities);
		session.delete(user);
		session.flush();
	}

	public User getUserByUsername(String username) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User where username = ?");
		query.setString(0, username);

		return (User) query.uniqueResult();
	}

	public User getUserById(int id) {
		Session session = sessionFactory.getCurrentSession();
		return (User) session.get(User.class, id);
	}

}
