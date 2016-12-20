package com.app.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import com.app.dao.StaffDao;
import com.app.entity.Staff;
public class StaffDaoImpl extends HibernateDaoSupport implements StaffDao
{
/**
 * 根据id查询员工详细信息
 * @param id 主键
 * @return 员工实体
 */ 
public Staff get(Integer id)
{	
	return getHibernateTemplate()
		.get(Staff.class, id); 
}

/**
 * 保存员工信息
 * @param Staff 员工实体
 * @return int 大于0添加成功
 */   
public Integer save(Staff Staff)
{
	return (Integer)getHibernateTemplate()
		.save(Staff);
}

/**
 * 更新员工信息
 * @param Staff 员工实体
 */
public void update(Staff Staff)
{
	getHibernateTemplate().update(Staff);
}

/**
 * 根据id删除指定员工信息
 * @param id 主键
 */
public void delete(Integer id)
{
	getHibernateTemplate().delete(get(id));
}

/**
 * 根绝员工信息删除指定员工信息
 * @param Staff 员工实体
 */
public void delete(Staff Staff)
{
	getHibernateTemplate().delete(Staff);
}

/**
 * 通过用户行查询员工列表信息
 * @param username 用户名
 * @return 员工信息列表
 */
public List<Staff> findByName(String username)
{
	return (List<Staff>)getHibernateTemplate()
		.find("from Staff p where p.username like ?" , username);
}

/**
 * 查询所有员工信息
 * @return 员工信息列表
 */
public List<Staff> findAllStaff()
{
	return (List<Staff>)getHibernateTemplate()
		.find("from Staff");
}
/**
 * 根据用户名和密码查询所有员工列表信息
 * @param username 用户名
 * @param password 密码
 * @return 员工信息列表
 */
@Override
public List<Staff> findByNameAndPassword(String username, String password) {
	Object values[] = new Object[]{username,password};
	return (List<Staff>)getHibernateTemplate()
			.find("from Staff p where p.username=? and p.password=?" , values);
}
/**
 * 分页查询所有员工信息
 * @param pageNo 当前页是第几页
 * @param pageSize 页面大小
 * @return 员工信息列表
 */
@Override
public List findAllByPage(int pageNo, int pageSize) {
	
	if(pageNo<1){
		   return null;
		  }
	int offset=(pageNo-1)*pageSize;
//	  return findByPage("from Staff", offset, pageSize);
	List list=this.getHibernateTemplate().executeFind(new HibernateCallback(){
	   public Object doInHibernate(Session session)
	     throws HibernateException, SQLException {
	    List result=session.createQuery("from Staff").setFirstResult(offset).setMaxResults(pageSize).list();
	    return result;
	     }
	  }
	 );
	 return list;

}
/**
 * 查询员工总数
 * @return int 员工总数
 */
@Override
public int getStaffCount() {
	List listStudent=this.getHibernateTemplate().find("from Staff");
	return listStudent.size();
	}

/**
 * 生成员工编号
 */
public String getNewStaffId(){
	List listStudent=this.getHibernateTemplate().find("from Staff");
	String maxId;
	if(listStudent !=null && !listStudent.isEmpty()){
		
		maxId = ((Staff)listStudent.get(listStudent.size()-1)).getStaff_no();
		String temp = maxId.substring(1);
		int i = Integer.parseInt(temp);
		i++;
		temp = String.valueOf(i);
		int len = temp.length();
		for(int j=0; j<7-len;j++){
			temp = "0"+temp;
		}
		maxId = "S"+temp;
	}else{
		maxId = "S0000001";
	}
	return maxId;
//	  return ((String)getHibernateTemplate().iterate(hql).next()).intValue();
}

}