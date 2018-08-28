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

import com.slp.bean.SiteInfo;
import com.slp.dao.SiteInfoDao;
import com.slp.util.Tool;

@Repository("siteInfoDao")
public class SiteInfoDaoImpl extends Tool implements SiteInfoDao {
	
	/**
	 * 获取站点信息的总条数
	 * @return int : 总条数
	 */
	public int totalCount() {
		return this.getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			public Integer doInHibernate(Session session) throws HibernateException {
				String hql = "select count(siteInfo) from SiteInfo as siteInfo";
				Query query = session.createQuery(hql);
				return Integer.parseInt(query.uniqueResult().toString());
			}
		});
	}

	/**
	 * 站点信息列表并实现分页
	 * @param start 开始条数
	 * @param pageSize 每页显示条数
	 * @return List 集合：SiteInfo
	 */
	public List<SiteInfo> siteInfoList(int start, int pageSize) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SiteInfo.class);
		return (List<SiteInfo>) this.getHibernateTemplate().findByCriteria(detachedCriteria, start, pageSize);
	}
	/**
	 * 站点信息模糊查询
	 * @param siteInfo 
	 * @param start 开始条数
	 * @param pageSize 每页显示条数
	 * @return List 集合：SiteInfo
	 */
	public List<SiteInfo> search(SiteInfo siteInfo, int start, int pageSize) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SiteInfo.class);
		detachedCriteria.add(Restrictions.like("name", siteInfo.getName(), MatchMode.ANYWHERE));
		detachedCriteria.addOrder(Order.asc("id"));
		return (List<SiteInfo>) this.getHibernateTemplate().findByCriteria(detachedCriteria, start, pageSize);
	}
	/**
	 * 模糊查询 获取站点信息的总条数
	 * @param siteInfo
	 * @return int : 总条数
	 */
	public int totalCount(SiteInfo siteInfo){
		return this.getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			public Integer doInHibernate(Session session) throws HibernateException {
				String hql = "select count(siteInfo) from SiteInfo as siteInfo where siteInfo.name like '%"+siteInfo.getName()+"%'";
				Query query = session.createQuery(hql);
				return Integer.parseInt(query.uniqueResult().toString());
			}
		});
	}
	/**
	 * 添加站点信息
	 * @param siteInfo 站点对象
	 */
	public void addSiteInfo(SiteInfo siteInfo){
		this.getHibernateTemplate().save(siteInfo);
	}

	/**
	 * 站点信息修改前查询id
	 * @param siteInfo对象
	 * @return SiteInfo对象
	 */
	public SiteInfo findSiteInfoById(SiteInfo siteInfo) {
		return this.getHibernateTemplate().get(SiteInfo.class, siteInfo.getId());
	}

	/**
	 * 站点信息修改
	 * @param siteInfo对象
	 */
	public void update(SiteInfo siteInfo) {
		this.getHibernateTemplate().merge(siteInfo);//如果调用update()方法修改的话会报session重复的错，这里我们调用merge()方法
	}

	/**
	 * 站点信息删除
	 * @param siteInfo对象
	 */
	public void deleteSiteInfo(SiteInfo siteInfo) {
		this.getHibernateTemplate().delete(siteInfo);
	}
	/**
	 * 根据站点name查询部分站点对象
	 * @param names
	 * @return List<SiteInfo>
	 */
	public List<SiteInfo> findSiteInfo(String [] names){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SiteInfo.class);
		detachedCriteria.add(Restrictions.in("name", names));
		detachedCriteria.addOrder(Order.asc("id"));
		return (List<SiteInfo>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
	}
}
