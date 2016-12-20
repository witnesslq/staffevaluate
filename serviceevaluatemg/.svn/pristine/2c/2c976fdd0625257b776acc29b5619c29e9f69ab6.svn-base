package com.app.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.app.dao.PostDao;
import com.app.dao.XtjsDao;
import com.app.entity.Post;
import com.app.entity.Staff;
import com.app.entity.Xtjs;
/**
 * 
 * @author 邢昭武
 *  
 * 岗位Dao实现类
 *
 */
public class PostDaoImpl extends HibernateDaoSupport implements PostDao{

	@Override
	public List<Post> findAllPost() {
		// TODO Auto-generated method stub
		return (List<Post>)getHibernateTemplate()
				.find("from Post");
	}

	@Override
	public Integer save(Post post) {
		// TODO Auto-generated method stub
		return (Integer) getHibernateTemplate().save(post);
	}
	
}
