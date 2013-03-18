package com.enterprise.organization.dal.idal;

import com.enterprise.organization.entities.User;

public interface IUserDAO extends IDAO {

	boolean checkLogin(User user);

	boolean checkPassword(User user);

	void createUser(User user);

	void updateUser(User user);

	void deleteUser(User user);

}
