package com.app.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.apache.catalina.tribes.util.Arrays;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import com.app.dao.StaffDao;
import com.app.entity.Staff;

/**
 * StaffDAO实现类
 * 
 * @author 邢昭武
 *
 */
public class StaffDaoImpl extends HibernateDaoSupport implements StaffDao {
	/**
	 * 根据id查询员工详细信息
	 * 
	 * @param id
	 *            主键
	 * @return 员工实体
	 */
	public Staff get(Integer id) {
		return getHibernateTemplate().get(Staff.class, id);
	}

	/**
	 * 保存员工信息
	 * 
	 * @param Staff
	 *            员工实体
	 * @return int 大于0添加成功
	 */
	public Integer save(Staff staff) {
		return (Integer) getHibernateTemplate().save(staff);
	}

	/**
	 * 更新员工信息
	 * 
	 * @param Staff
	 *            员工实体
	 * @return 
	 */
	public Integer update(Staff staff) {
		getHibernateTemplate().update(staff);
		return staff.getId();
	}

	/**
	 * 根据id删除指定员工信息
	 * 
	 * @param id
	 *            主键
	 * @return 
	 */
	public Integer delete(Integer id) {
		getHibernateTemplate().delete(id);
		return id;
	}

	/**
	 * 根绝员工信息删除指定员工信息
	 * 
	 * @param Staff
	 *            员工实体
	 * @return 
	 */
	public Integer delete(Staff Staff) {
		getHibernateTemplate().delete(Staff);
		return Staff.getId();
	}

	/**
	 * 通过用户用户名查询员工列表信息
	 * 
	 * @param username
	 *            用户名
	 * @return 员工信息列表
	 */
	public List<Staff> findByName(String username) {
		return (List<Staff>) getHibernateTemplate().find("from Staff p where p.username=?", username);
	}
	
	/**
	 * 通过用户姓名查询员工列表信息
	 * 
	 * @param username
	 *            用户名
	 * @return 员工信息列表
	 */
	public List<Staff> findByName1(String name) {
		return (List<Staff>) getHibernateTemplate().find("from Staff p where p.name=?", name);
	}

	/**
	 * 查询所有员工信息
	 * 
	 * @return 员工信息列表
	 */
	public List<Staff> findAllStaff() {
		return (List<Staff>) getHibernateTemplate().find("from Staff");
	}

	/**
	 * 根据用户名和密码查询所有员工列表信息
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @return 员工信息列表
	 */
	@Override
	public List<Staff> findByNameAndPassword(String username, String password) {
		Object values[] = new Object[] { username, password };
		return (List<Staff>) getHibernateTemplate().find("from Staff p where p.username=? and p.password=?", values);
	}

	/**
	 * 分页查询所有员工信息
	 * 
	 * @param pageNo
	 *            当前页是第几页
	 * @param pageSize
	 *            页面大小
	 * @return 员工信息列表
	 */
	@Override
	public List findAllByPage(int pageNo, int pageSize) {

		if (pageNo < 1) {
			return null;
		}
		int offset = (pageNo - 1) * pageSize;
		List list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				List result = session.createQuery("from Staff").setFirstResult(offset).setMaxResults(pageSize).list();
				return result;
			}
		});
		return list;
	}

	/**
	 * 查询员工总数
	 * 
	 * @return int 员工总数
	 */
	@Override
	public int getStaffCount() {
		List listStudent = this.getHibernateTemplate().find("from Staff");
		return listStudent.size();
	}

	/**
	 * 生成员工编号
	 */
	public String getNewStaffId() {
		List listStudent = this.getHibernateTemplate().find("from Staff");
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
			maxId = "S" + temp;
		} else {
			maxId = "S0000001";
		}
		return maxId;
	}

	/**
	 * 分页带条件查询
	 */
	@Override
	public List findAllByPage(int pageNo, int pageSize, String name, int businessHallId) {
		if (pageNo < 1) {
			return null;
		}
		int offset = (pageNo - 1) * pageSize;
		if(!("".equals(name))&&name.trim().length()!=0&&businessHallId>0){
			List list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					List result = session.createQuery("from Staff where name = '"+name+"' and businesshall_id = '"+businessHallId+"'").setFirstResult(offset).setMaxResults(pageSize).list();
					return result;
				}
			});
			return list;
		}else if(!("".equals(name))&&name.trim().length()!=0&&businessHallId==0){
			List list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					List result = session.createQuery("from Staff where name = '"+name+"'").setFirstResult(offset).setMaxResults(pageSize).list();
					return result;
				}
			});
			return list;
		}else if("".equals(name)&&name.trim().length()==0&&businessHallId>0){
			List list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					List result = session.createQuery("from Staff where businesshall_id = '"+businessHallId+"'").setFirstResult(offset).setMaxResults(pageSize).list();
					return result;
				}
			});
			return list;
		}else if("".equals(name)&&name.trim().length()==0&&businessHallId==0){
			List list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					List result = session.createQuery("from Staff").setFirstResult(offset).setMaxResults(pageSize).list();
					return result;
				}
			});
			return list;
		}
		return null;
	}

	@Override
	public int getStaffCountByParam(String no, String name, int businessHallId) {
		return 0;
	}

	/**
	 * 通过员工号查找
	 */
	@Override
	public List<Staff> findByNo(String no) {
		return (List<Staff>) getHibernateTemplate().find("from Staff where staff_no = ?",no);
	}

	@Override
	public List<Staff> findByBusinessHallId(Integer BusinessHalllid) {
		return (List<Staff>)getHibernateTemplate().find("from Staff where businesshall_id = ?",BusinessHalllid);
	}

	@Override
	public List<Staff> getStaffByP(String name, int BusinessHallid) {
		List<Staff> list = (List<Staff>)getHibernateTemplate().find("from Staff where name = ? and businesshall_id = ?",name,BusinessHallid);
		return list;
	}
	
	/**
	 * 根据id批量删除员工
	 */
	@Override
	public void deleteByIds(String ids) {
		String[] a = ids.split(",");
		System.out.println(Arrays.toString(a));
		for(int i=0;i<a.length;i++){
			//getHibernateTemplate().delete(findById(id));
			getHibernateTemplate().delete(this.get((Integer.parseInt(a[i]))));
		}
	}




}