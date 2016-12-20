package com.app.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.app.dao.UserEvaluateDao;
import com.app.entity.UserEvaluate;

public class UserEvaluateDaoImpl extends HibernateDaoSupport implements UserEvaluateDao {

	public Integer save(UserEvaluate userEvaluate) {
		// ����һ�����ۼ�¼
		System.out.println(userEvaluate);
		return (Integer) getHibernateTemplate().save(userEvaluate);
	}

	@Override
	public List<UserEvaluate> findAll() {

		return (List<UserEvaluate>) getHibernateTemplate().find("from UserEvaluate");
	}

	@Override
	public Integer getAllCount() {
		Integer x = ((Integer) getHibernateTemplate().iterate("select count(*) from UserEvaluate as userevaluate")
				.next()).intValue();
		System.out.println(x);
		return x;
	}

	@Override
	public UserEvaluate get(Integer id) {
		return getHibernateTemplate().get(UserEvaluate.class, id);
	}

	public int getAllRowCount() {
		
		String hql = "select count(*) from  UserEvaluate";
		List list = getHibernateTemplate().find(hql);
		
		return Integer.parseInt(list.get(0).toString());
	}

	/**
	 * 分页查询
	 * 
	 * @param hql
	 *            查询条件
	 * @param offset
	 *            开始记录
	 * @param length
	 *            一次查询几条记录
	 * @return 查询的记录集合
	 */
	@SuppressWarnings("unchecked")
	public List<UserEvaluate> queryForPage(final int offset, final int length) {
		/*
		 * getHibernateTemplate()的execute返回一个Object的对象，需要强转
		 * 而executeFind直接返回一个list
		 */
		List list = (List)getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				String hql="from UserEvaluate";
				Query q = session.createQuery(hql);
				q.setFirstResult(offset);
				q.setMaxResults(length);
				List<UserEvaluate> list = q.list();
				return list;
			}
			
		});
		return list;
				//下面这种获取的session必须手动的关闭，不然会和快耗尽数据库连接 线程
//		Session session = this.getSession();
//		Query q = session.createQuery("from UserEvaluate");
//		q.setFirstResult(offset);
//		q.setMaxResults(length);
//		List<UserEvaluate> list = q.list();
//		// System.out.println(list.size());
//		// session.close(); 千万别在这关闭，无法使用opensessioninview了
//		return list;
	}

	@Override
	public List<UserEvaluate> queryForPage1(int offset, int length, String sat) {
		List list = getHibernateTemplate().executeFind(new HibernateCallback(){
			   public Object doInHibernate(Session session)
			     throws HibernateException, SQLException {
			    List result=session.createQuery("from UserEvaluate where satisfaction='" + sat + "'").setFirstResult(offset).setMaxResults(length).list();
			    return result;
			     }
			  }
			 );
			 return list;
//		Session session = this.getSession();
//
//		Query q = session.createQuery("from UserEvaluate where satisfaction='" + sat + "'");
//		System.out.println("123123123123" + sat);
//		q.setFirstResult(offset);
//		q.setMaxResults(length);
//		List<UserEvaluate> list = q.list();
		// System.out.println(list.size());
		// session.close(); 千万别在这关闭，无法使用opensessioninview了
	//	return list;
	}

	@Override
	public int getAllRowCount1(String sat) {
		// Session session=this.getSession();
		// String hql="select count(*) from UserEvaluate where satisfaction=?";
		// System.out.println(sat);
		// Query query=session.createQuery(hql);
		// int count = ((Long) query.iterate().next()).intValue();
		
	//	Session session = this.getSession();
		//System.out.println("123123123123" + sat);
	//	Query q = session.createQuery("from UserEvaluate where satisfaction='" + sat + "'");

	//	List<UserEvaluate> list = q.list();
	//	return list.size();
		// System.out.println("------------------------123-----------");
		// List list=this.getHibernateTemplate().find("from UserEvaluate where
		// satisfaction="+sat);
		// return list.size();
		String hql = "select count(*) from UserEvaluate where satisfaction='" + sat + "'";
		List list = getHibernateTemplate().find(hql);
//		String hql = "select count(*) from UserEvaluate where satisfaction=?";
//		Object[] params = {sat};
//		List list = getHibernateTemplate().find(hql,params);
		return Integer.parseInt(list.get(0).toString());
	}

}
