package com.app.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.app.dao.CzznDao;
import com.app.entity.Czzn;

public class CzznDaoImpl extends HibernateDaoSupport implements CzznDao{

	public Czzn getLast() {
		
		List list =  getHibernateTemplate().executeFind(new HibernateCallback(){

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				String hql = "from Czzn order by id desc ";
				Query q = session.createQuery(hql);
				return q.list();
			}
		});
		return (Czzn)list.get(0);
	}

	public Integer save(Czzn czzn) {
		return (Integer)getHibernateTemplate().save(czzn);
	}

	@Override
	public Integer update(Czzn czzn) {
		getHibernateTemplate().update(czzn);
		return czzn.getId();
	}
	
}
