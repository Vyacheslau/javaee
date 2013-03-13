package com.enterprise.organization.dal;

import com.enterprise.organization.entities.User;

public interface IUserService {

	boolean checkLogin(User user);

	boolean checkPassword(User user);

	void createUser(User user);

}
