package com.app.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.app.dao.UnitDao;
import com.app.dao.XtjsDao;
import com.app.entity.Unit;
import com.app.entity.Staff;
import com.app.entity.Subindex;
import com.app.entity.Xtjs;
/**
 * 
 * @author 邢昭武
 *  
 * 单位Dao实现类
 *
 */
public class UnitDaoImpl extends HibernateDaoSupport implements UnitDao{

	/**
	 * 根据id查询单位信息
	 * 
	 * @param id
	 *            主键
	 * @return 员工实体
	 */
	public Unit get(Integer id) {
		return getHibernateTemplate().get(Unit.class, id);
	}
	
	@Override
	public List<Unit> findAllUnit() {
		return (List<Unit>)getHibernateTemplate()
				.find("from Unit");
	}
	
	@Override
	public Integer save(Unit unit) {
		return (Integer)getHibernateTemplate().save(unit);
	}

	
	@Override
	public Integer delete(int id) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(get(id));
		return id; 
	}
	public Integer delete(String ids){
		String idarr[] = ids.split(",");
		int count = 0;
		for(int i=0; i<idarr.length; i++){
			getHibernateTemplate().delete(get(Integer.parseInt(idarr[i])));
			count ++;
		}
		return count;
	}
	
	@Override
	public Integer update(Unit unit) {
		getHibernateTemplate().update(unit);
		return unit.getId();
	}

	@Override
	public List<Unit> findAllUnitByPage(int pageNo, int pageSize) {
		if (pageNo < 1) {
			return null;
		}
		int offset = (pageNo - 1) * pageSize;
		List list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				List result = session.createQuery("from Unit").setFirstResult(offset).setMaxResults(pageSize).list();
				return result;
			}
		});
		return list;
	}

	@Override
	public int getUnitCount() {
		List listUnit = this.getHibernateTemplate().find("from Unit");
		return listUnit.size();
	}

	@Override
	public Unit findById(int id) {
		return getHibernateTemplate().get(Unit.class, id);
	}
	
}
