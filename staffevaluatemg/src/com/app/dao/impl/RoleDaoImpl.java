package com.app.dao.impl;

import java.sql.SQLException;
import java.util.List;

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

	
	
}
