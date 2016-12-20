package com.app.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.app.dao.ZcfgDao;
import com.app.entity.Zcfg;
/**
 * 政策法规的DAO实现类
 * @author 吴雨桐
 *
 */
public class ZcfgDaoImpl extends HibernateDaoSupport implements ZcfgDao {

	public Zcfg getLast() {

		List list = getHibernateTemplate().executeFind(new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				String hql = "from Zcfg order by id desc ";
				Query q = session.createQuery(hql);
				return q.list();
			}
		});
		return (Zcfg) list.get(0);
	}

	public Integer save(Zcfg zcfg) {
		return (Integer) getHibernateTemplate().save(zcfg);
	}

}
