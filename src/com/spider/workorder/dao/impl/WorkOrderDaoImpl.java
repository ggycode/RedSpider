package com.spider.workorder.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spider.dao.impl.HibernateGenericDaoImpl;
import com.spider.workorder.dao.WorkOrderDao;
import com.spider.workorder.model.WorkOrderBo;
import com.spider.workorder.model.WorkOrderPropertyBo;

@Repository("workOrderDao")
public class WorkOrderDaoImpl extends HibernateGenericDaoImpl<WorkOrderDaoImpl> implements WorkOrderDao {

	@SuppressWarnings("unchecked")
	@Override
	public String getSequence() {
		List<String> ret = this.getSession().createSQLQuery("select _nextval()").list();
		if(ret != null && ret.size() > 0){
			return ret.get(0);
		}
		return null;
	}

	@Override
	public void insertWorkOrder(WorkOrderBo workOrderBo) {
		getHibernateTemplate().save(workOrderBo);
	}

	@Override
	public List selectWorkOrders() {
		return getHibernateTemplate().find("from WorkOrderBo");
	}

	@Override
	public void insertWorkOrderProperty(WorkOrderPropertyBo workOrderPropertyBo) {
		getHibernateTemplate().save(workOrderPropertyBo);
	}

}
