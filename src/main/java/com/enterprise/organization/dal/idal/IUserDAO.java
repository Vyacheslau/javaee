package com.enterprise.organization.dal.idal;

import com.enterprise.organization.entities.User;

public interface IUserDAO extends IDAO {

	boolean checkCredantials(User user);

	void createUser(User user);

	void updateUser(User user);

	void deleteUser(User user);

}
