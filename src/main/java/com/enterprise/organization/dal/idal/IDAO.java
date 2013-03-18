package com.enterprise.organization.dal.idal;

import org.hibernate.Session;

public interface IDAO {
	
	Session getSession();
	
	void beginSession();
	
	void commit();
	
	void rollback();
	
	void closeSession();

}
