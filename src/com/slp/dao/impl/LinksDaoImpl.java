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

import com.slp.bean.Links;
import com.slp.bean.SiteInfo;
import com.slp.dao.LinksDao;
import com.slp.util.Tool;
@Repository("linksDao")
public class LinksDaoImpl extends Tool implements LinksDao {
	/**
	 * 获取所有的友情链接
	 * @return List<Links>
	 */
	public List<Links> findAllLinks() {
		return (List<Links>) this.getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(Links.class));
	}
	/**
	 * 获取友情链接的总条数
	 * @return int : 总条数
	 */
	public int totalCount(){
		return this.getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			public Integer doInHibernate(Session session) throws HibernateException {
				String hql = "select count(links) from Links as links";
				Query query = session.createQuery(hql);
				return Integer.parseInt(query.uniqueResult().toString());
			}
		});
	}
	/**
	 * 友情链接列表并实现分页
	 * @param start 开始条数
	 * @param pageSize 每页显示条数
	 * @return List 集合：Links
	 */
	public List<Links> findlinksList(int start, int pageSize){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Links.class);
		return (List<Links>) this.getHibernateTemplate().findByCriteria(detachedCriteria, start, pageSize);
	}
	/**
	 * 友情链接模糊查询
	 * @param Links 
	 * @param start 开始条数
	 * @param pageSize 每页显示条数
	 * @return List 集合：Links
	 */
	public List<Links> searchLinks(Links links, int start, int pageSize){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Links.class);
		detachedCriteria.add(Restrictions.like("name", links.getName(), MatchMode.ANYWHERE));
		detachedCriteria.addOrder(Order.asc("id"));
		return (List<Links>) this.getHibernateTemplate().findByCriteria(detachedCriteria, start, pageSize);
	}
	/**
	 * 模糊查询 获取友情链接的总条数
	 * @param Links
	 * @return int : 总条数
	 */
	public int totalCount(Links links){
		return this.getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			public Integer doInHibernate(Session session) throws HibernateException {
				String hql = "select count(links) from Links as links where links.name like '%"+links.getName()+"%'";
				Query query = session.createQuery(hql);
				return Integer.parseInt(query.uniqueResult().toString());
			}
		});
	}
	/**
	 * 友情链接添加
	 * @param links
	 */
	public void addLinks(Links links){
		this.getHibernateTemplate().save(links);
	}
	/**
	 * 友情链接修改前查询id
	 * @param links 对象
	 * @return Links 对象
	 */
	public Links findLinksById(Links links){
		return this.getHibernateTemplate().get(Links.class, links.getId());
	}
	/**
	 * 友情链接修改
	 * @param links 对象
	 */
	public void updateLinks(Links links){
		this.getHibernateTemplate().merge(links);
	}
	/**
	 * 友情链接修改删除
	 * @param links
	 */
	public void deleteLinks(Links links){
		this.getHibernateTemplate().delete(links);
	}
}
