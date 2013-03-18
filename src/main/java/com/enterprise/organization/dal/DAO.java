package com.enterprise.organization.dal;

import org.hibernate.Session;

import com.enterprise.organization.dal.idal.IDAO;

public abstract class DAO implements IDAO {

	@Override
	public Session getSession() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void beginSession() {
		// TODO Auto-generated method stub

	}

	@Override
	public void commit() {
		// TODO Auto-generated method stub

	}

	@Override
	public void rollback() {
		// TODO Auto-generated method stub

	}

	@Override
	public void closeSession() {
		// TODO Auto-generated method stub

	}

}
