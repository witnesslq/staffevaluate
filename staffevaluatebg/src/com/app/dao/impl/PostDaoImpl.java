package com.app.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.catalina.tribes.util.Arrays;
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
		return (List<Post>)getHibernateTemplate()
				.find("from Post");
	}

	@Override
	public Integer save(Post post) {
		return (Integer) getHibernateTemplate().save(post);
	}




	@Override
	public void delete(int id) {
		getHibernateTemplate().delete(get(id));
	}

	@Override
	public void update(Post post) {
		getHibernateTemplate().update(post);
	}

	@Override
	public Post get(int id) {
		return getHibernateTemplate().get(Post.class, id);
	}

	@Override
	public List<Post> findAllByPage(int pageNo, int pageSize) {
		if (pageNo < 1) {
			return null;
		}
		int offset = (pageNo - 1) * pageSize;
		List<Post> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				List<Post> result = session.createQuery("from Post").setFirstResult(offset).setMaxResults(pageSize).list();
				return result;
			}
		});
		return list;
	}

	@Override
	public int getPostCount() {
		List<Post> list = this.getHibernateTemplate().find("from Post");
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
