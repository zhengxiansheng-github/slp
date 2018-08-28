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

import com.slp.bean.Banner;
import com.slp.bean.SiteInfo;
import com.slp.dao.BannerDao;
import com.slp.util.Tool;
@Repository("bannerDao")
public class BannerDaoImpl extends Tool implements BannerDao {
	/**
	 * 获取banner的总条数
	 * @return int : 总条数
	 */
	public int totalCount(){
		return this.getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			public Integer doInHibernate(Session session) throws HibernateException {
				String hql = "select count(banner) from Banner as banner";
				Query query = session.createQuery(hql);
				return Integer.parseInt(query.uniqueResult().toString());
			}
		});
	}
	/**
	 * 查询banner并分页
	 * @param start
	 * @param pageSize
	 * @return List<Banner>
	 */
	public List<Banner> findBanner(int start, int pageSize) {
		return (List<Banner>) this.getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(Banner.class), start, pageSize);
	}
	/**
	 * banner模糊查询
	 * @param siteInfo 
	 * @param start 开始条数
	 * @param pageSize 每页显示条数
	 * @return List 集合：SiteInfo
	 */
	public List<Banner> searchBanner(Banner banner, int start, int pageSize){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Banner.class);
		detachedCriteria.add(Restrictions.like("name", banner.getName(), MatchMode.ANYWHERE));
		detachedCriteria.addOrder(Order.asc("id"));
		return (List<Banner>) this.getHibernateTemplate().findByCriteria(detachedCriteria, start, pageSize);
	}
	/**
	 * 模糊查询 获取banner的总条数
	 * @param siteInfo
	 * @return int : 总条数
	 */
	public int totalCount(Banner banner){
		return this.getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			public Integer doInHibernate(Session session) throws HibernateException {
				String hql = "select count(banner) from Banner as banner where banner.name like '%"+banner.getName()+"%'";
				Query query = session.createQuery(hql);
				return Integer.parseInt(query.uniqueResult().toString());
			}
		});
	}
	/**
	 * 添加banner
	 * @param banner
	 */
	public void addBanner(Banner banner){
		this.getHibernateTemplate().save(banner);
	}
	/**
	 * 根据id查询单个Banner对象 修改前查询
	 * @param banner
	 * @return Banner
	 */
	public Banner findBannerById(Banner banner){
		return this.getHibernateTemplate().get(Banner.class, banner.getId());
	}
	/**
	 * 修改
	 * @param banner
	 */
	public void updateBanner(Banner banner){
		this.getHibernateTemplate().merge(banner);
	}
	/**
	 * 删除
	 * @param banner
	 */
	public void deleteBanner(Banner banner){
		this.getHibernateTemplate().delete(banner);
	}
}
