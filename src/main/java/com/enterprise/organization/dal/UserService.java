package com.enterprise.organization.dal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.enterprise.organization.entities.User;

@Repository
public class UserService implements IUserService {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public void createUser(User user) {
		currentSession().saveOrUpdate(user);
	}
	
	@Transactional
	public boolean checkLogin(User user) {
		String login = user.getLogin();
		
		return currentSession().contains(user);		
	}

	@Transactional
	public boolean checkPassword(User user) {
		String password = user.getPassword();
		
		return currentSession().contains(password);
	}

	private Session currentSession() {
		Session currentSession = sessionFactory.getCurrentSession();		
		//Session currentSession = sessionFactory.openSession();
		return currentSession;
	}
}
