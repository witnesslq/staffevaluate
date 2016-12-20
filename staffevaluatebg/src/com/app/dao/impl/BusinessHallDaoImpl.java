package com.app.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.catalina.tribes.util.Arrays;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.app.dao.BusinessHallDao;
import com.app.entity.BusinessHall;
import com.app.entity.Staff;
/**
 * 
 * @author 邢昭武
 *  
 * 角色Dao实现类
 *
 */
public class BusinessHallDaoImpl extends HibernateDaoSupport implements BusinessHallDao{

	@Override
	public List<BusinessHall> findAllBusinessHall() {
		return (List<BusinessHall>)getHibernateTemplate()
				.find("from BusinessHall");
	}

	@Override
	public Integer save(BusinessHall businessHall) {
		
		return (Integer)getHibernateTemplate().save(businessHall);
	}

	@Override
	public List findAllByPage(int pageNo, int pageSize,int unitid) {

		if (pageNo < 1) {
			return null;
		}
		int offset = (pageNo - 1) * pageSize;
		List list =null;
		if(unitid<=0){
			list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					List result = session.createQuery("from BusinessHall ").setFirstResult(offset).setMaxResults(pageSize).list();
					return result;
				}
			});
		}else{
			list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					List result = session.createQuery("from BusinessHall where unit_id=" + unitid).setFirstResult(offset).setMaxResults(pageSize).list();
					return result;
				}
			});
		}
		return list;
	}

	@Override
	public Integer getBusinessHallCount(int unitid) {
		List listStudent;
		if(unitid<=0){
			listStudent = this.getHibernateTemplate().find("from BusinessHall");
		}else{
			listStudent = this.getHibernateTemplate().find("from BusinessHall where unit_id="+unitid);
		}
		return listStudent.size();
	}

	@Override
	public String getNewBusinessHallId() {
		List listStudent = this.getHibernateTemplate().find("from BusinessHall");
		String maxId;
		if (listStudent != null && !listStudent.isEmpty()) {

			maxId = ((Staff) listStudent.get(listStudent.size() - 1)).getStaff_no();
			String temp = maxId.substring(1);
			int i = Integer.parseInt(temp);
			i++;
			temp = String.valueOf(i);
			int len = temp.length();
			for (int j = 0; j < 7 - len; j++) {
				temp = "0" + temp;
			}
			maxId = "Y" + temp;
		} else {
			maxId = "Y0000001";
		}
		return maxId;
	}

	@Override
	public List findAllByPage(int pageNo, int pageSize, int unitid, String no, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(BusinessHall bh) {
		getHibernateTemplate().update(bh);
	}

	@Override
	public void deleteByIds(String ids) {
		String[] a = ids.split(",");
		System.out.println(Arrays.toString(a));
		for(int i=0;i<a.length;i++){
			//getHibernateTemplate().delete(findById(id));
			getHibernateTemplate().delete(this.selectById(Integer.parseInt(a[i])));
		}
	}

	@Override
	public BusinessHall selectById(int id) {
		return getHibernateTemplate().get(BusinessHall.class, id);
		
	}

	@Override
	public Integer getBusinessHallCount(int unitid, String no, String name) {
		// TODO Auto-generated method stub
		return null;
	}


	
	
}
