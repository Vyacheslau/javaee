package com.enterprise.organization.dal;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.enterprise.organization.dal.idal.IUserDAO;
import com.enterprise.organization.entities.User;

@Component
@Repository
@Transactional
public class UserDAO extends DAO implements IUserDAO {

	@Override
	public boolean checkCredantials(User user) {

		String login = user.getLogin();
		String password = user.getPassword();

		User user2 = (User) getSession().createCriteria(User.class)
				.add(Restrictions.eq("login", login))
				.add(Restrictions.eq("password", password)).uniqueResult();

		if (user2 != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void createUser(User user) {
		getSession().save(user);
	}

	@Override
	public void updateUser(User user) {
		getSession().update(user);
	}

	@Override
	public User getUserByLogin(String login) {
		User user = (User) getSession().createCriteria(User.class)
				.add(Restrictions.eq("login", login)).uniqueResult();
		return user;
	}

	@Override
	public boolean isExist(User user) {
		User user2 = (User) getSession().createCriteria(User.class)
				.add(Restrictions.eq("login", user.getLogin())).uniqueResult();
		if (user2 != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void deleteUser(User user) {
		getSession().delete(user);
	}
}
