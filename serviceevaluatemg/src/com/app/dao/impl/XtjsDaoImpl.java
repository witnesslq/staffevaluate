package com.app.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.app.dao.XtjsDao;
import com.app.entity.Xtjs;
/**
 * 
 * @author 邢昭武
 *  
 * 系统介绍Dao实现类
 *
 */
public class XtjsDaoImpl extends HibernateDaoSupport implements XtjsDao{

	public Xtjs getLast() {
		List list =  getHibernateTemplate().executeFind(new HibernateCallback(){

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				String hql = "from Xtjs order by id desc ";
				Query q = session.createQuery(hql);
				return q.list();
			}
		});
		return (Xtjs)list.get(0);
	}
	public Integer save(Xtjs xtjs) {
		return (Integer)getHibernateTemplate().save(xtjs);
	}
	
}
