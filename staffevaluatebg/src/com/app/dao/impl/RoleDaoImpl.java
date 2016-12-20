package com.app.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.catalina.tribes.util.Arrays;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.app.dao.RoleDao;
import com.app.dao.XtjsDao;
import com.app.entity.Role;
import com.app.entity.Staff;
import com.app.entity.Xtjs;
/**
 * 
 * @author 邢昭武
 *  
 * 角色Dao实现类
 *
 */
public class RoleDaoImpl extends HibernateDaoSupport implements RoleDao{

	@Override
	public List<Role> findAllRole() {
		return (List<Role>)getHibernateTemplate()
				.find("from Role");
	}

	@Override
	public Integer save(Role role) {
		return (Integer)getHibernateTemplate().save(role);
	}


	@Override
	public void delete(int id) {
		 getHibernateTemplate().delete(get(id));
	}

	@Override
	public void update(Role role) {
		 getHibernateTemplate().bulkUpdate("update Role r set r.name = ? where r.role_id = ?", role.getName(),role.getRole_id());
		// getHibernateTemplate().update(role);
	}

	@Override
	public Role get(int id) {
		return getHibernateTemplate().get(Role.class, id);
	}

	@Override
	public List<Role> findAllByPage(int pageNo, int pageSize) {
		if (pageNo < 1) {
			return null;
		}
		int offset = (pageNo - 1) * pageSize;
		List<Role> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				List<Role> result = session.createQuery("from Role").setFirstResult(offset).setMaxResults(pageSize).list();
				return result;
			}
		});
		return list;
	}

	@Override
	public int getRoleCount() {
		List<Role> list = this.getHibernateTemplate().find("from Role");
		return list.size();
	}

	@Override
	public void deleteByIds(String ids) {
		String[] a = ids.split(",");
		System.out.println(Arrays.toString(a));
		for(int i=0;i<a.length;i++){
			//getHibernateTemplate().delete(findById(id));
			getHibernateTemplate().delete(this.get(Integer.parseInt(a[i])));
		}
	}
}
