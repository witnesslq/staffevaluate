package com.app.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.catalina.tribes.util.Arrays;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.app.dao.SubindexDao;
import com.app.entity.Post;
import com.app.entity.Staff;
import com.app.entity.Subindex;
/**
 * 分项指标的DAO实现类
 * 
 * @author 邢昭武
 *
 */
public class SubindexDaoImpl extends HibernateDaoSupport implements SubindexDao{

	@Override
	public List<Subindex> getByIds(String ids) {
		
		return (List<Subindex>)getHibernateTemplate()
				.find("from Subindex s where s.id in ("+ids+")" );
	
	}

	@Override
	public List<Subindex> findAllSubindex() {
		
		return (List<Subindex>)getHibernateTemplate()
				.find("from Subindex");
	}

	@Override
	public Integer save(Subindex subindex) {
		// TODO Auto-generated method stub
		return (Integer) getHibernateTemplate().save(subindex);
	}


	@Override
	public void delete(int id) {
		getHibernateTemplate().delete(get(id));
	}

	@Override
	public void update(Subindex subindex) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(subindex);
	}

	@Override
	public List<Subindex> findAllByPage(int pageNo, int pageSize) {
		if (pageNo < 1) {
			return null;
		}
		int offset = (pageNo - 1) * pageSize;
		List<Subindex> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				List<Subindex> result = session.createQuery("from Subindex").setFirstResult(offset).setMaxResults(pageSize).list();
				return result;
			}
		});
		return list;
	}

	@Override
	public int getSubindexCount() {
		List<Subindex> list = this.getHibernateTemplate().find("from Subindex");
		return list.size();
	}

	@Override
	public Subindex get(int id) {
		System.out.println("find");
		return this.getHibernateTemplate().get(Subindex.class, id);
	}

	@Override
	public void deleteByIds(String ids) {
			System.out.println("进入dao deletebyids");
			String[] a = ids.split(",");
			System.out.println(Arrays.toString(a));
			for(int i=0;i<a.length;i++){
				//getHibernateTemplate().delete(findById(id));
				System.out.println("delete..........");
				getHibernateTemplate().delete(this.get(Integer.parseInt(a[i])));
				System.out.println("delete.............end");
			}
	}


}
