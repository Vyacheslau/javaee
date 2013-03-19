package com.enterprise.organization.dal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.enterprise.organization.dal.idal.IDAO;

@Repository
@Transactional
public abstract class DAO implements IDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Session getSession() {
		Session currentSession = sessionFactory.getCurrentSession();		
		return currentSession;
	}

	@Override
	public void beginSession() {
		getSession().beginTransaction();

	}

	@Override
	public void commit() {
		getSession().getTransaction().commit();
	}

	@Override
	public void rollback() {
		getSession().getTransaction().rollback();

	}

	@Override
	public void closeSession() {
		getSession().close();

	}

}
