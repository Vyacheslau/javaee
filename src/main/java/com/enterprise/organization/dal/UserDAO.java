package com.enterprise.organization.dal;

import com.enterprise.organization.dal.idal.IUserDAO;
import com.enterprise.organization.entities.User;

public class UserDAO extends DAO implements IUserDAO {

	@Override
	public boolean checkLogin(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkPassword(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void createUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		
	}
}
