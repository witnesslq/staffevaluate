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
		/*这种方法调用的session是最原始的session,
		 * 要手动关闭不能享有spring的声明式事务管理，
		 * 以后会出大问题。
		 *  要用template的回调函数，HibernateCallback中的session，
		 *  他可以不用手动去关闭
		 */
//		Session session = this.getSession();
//		String hql="from Czzn order by id desc ";
//		Query q = session.createQuery(hql);
//		q.setFirstResult(0);
//		q.setMaxResults(1);
//		return (Czzn)q.list().get(0);
		/*
		 * 像这种用回调函数就没事，
		 */
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
	
}
