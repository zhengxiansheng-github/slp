package com.slp.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.slp.bean.Services;
import com.slp.dao.ServicesDao;
import com.slp.util.Tool;
import com.sun.org.apache.regexp.internal.recompile;
@Repository("servicesDao")
public class ServicesDaoImpl extends Tool implements ServicesDao {
	
	/**
	 * 获取所有服务信息
	 * @return List<Services>
	 */
	public List<Services> findAllServices() {
		return (List<Services>) this.getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(Services.class));
	}
	/**
	 * 查询服务总条数
	 * @return int
	 */ 
	public int totalCount(){
		return this.getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			public Integer doInHibernate(Session session) throws HibernateException {
				String hql = "select count(services) from Services as services";
				Query query = session.createQuery(hql);
				return Integer.parseInt(query.uniqueResult().toString());
			}
		});
	}
	/**
	 * 后台显示服务 列表
	 * @param start
	 * @param pageSize
	 * @return List<Services>
	 */ 
	public List<Services> findServicesList(int start, int pageSize){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Services.class);
		return (List<Services>) this.getHibernateTemplate().findByCriteria(detachedCriteria, start, pageSize);
	}
	/**
	 * 模糊查询 查询之后显示列表
	 * @param services 对象
	 * @param start 开始条数
	 * @param pageSize 每页显示条数
	 * @return List<Services>
	 */
	public List<Services> searchServicesList(Services services, int start, int pageSize){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Services.class);
		detachedCriteria.add(Restrictions.like("serviceName", services.getServiceName(), MatchMode.ANYWHERE));
		detachedCriteria.addOrder(Order.asc("id"));
		return (List<Services>) this.getHibernateTemplate().findByCriteria(detachedCriteria, start, pageSize);
	}
	/**
	 * 模糊查询 查询之后的总条数
	 * @param services
	 * @return
	 */
	public int totalCount(Services services){
		return this.getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			public Integer doInHibernate(Session session) throws HibernateException {
				String hql = "select count(services) from Services as services where services.serviceName like '%"+services.getServiceName()+"%'";
				Query query = session.createQuery(hql);
				return Integer.parseInt(query.uniqueResult().toString());
			}
		});
	}
	/**
	 * 添加服务
	 * @param services
	 */
	public void addServices(Services services){
		this.getHibernateTemplate().save(services);
	}
	/**
	 * 修改前根据id查询 并 跳转到修改界面
	 * @param services
	 * @return Services
	 */
	public Services findServicesById(Services services){
		return this.getHibernateTemplate().get(Services.class, services.getId());
	}
	/**
	 * 修改
	 * @param services
	 */
	public void updateServices(Services services){
		this.getHibernateTemplate().merge(services);
	}
	/**
	 * 删除服务
	 * @param services
	 */
	public void deleteServices(Services services){
		this.getHibernateTemplate().delete(services);
	}
}
