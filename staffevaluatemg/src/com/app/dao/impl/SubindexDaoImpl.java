package com.app.dao.impl;

import java.util.List;

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
		if(ids.length()>=1){
		return (List<Subindex>)getHibernateTemplate()
				.find("from Subindex s where s.id in ("+ids+")" );
		}
		return null;
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

}
