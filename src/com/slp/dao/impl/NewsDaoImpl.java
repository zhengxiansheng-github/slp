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

import com.slp.bean.News;
import com.slp.bean.Project;
import com.slp.bean.SiteInfo;
import com.slp.dao.NewsDao;
import com.slp.util.Tool;

@Repository("newsDao")
public class NewsDaoImpl extends Tool implements NewsDao {
	
	/**
	 * 获取新闻资讯信息的总条数
	 * @param cateId 新闻资讯分类编号
	 * @return int : 总条数
	 */
	public int totalCount(int cateId) {
		return this.getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			public Integer doInHibernate(Session session) throws HibernateException {
				String hql = "select count(news) from News as news";
				if(cateId>0){
					hql += " where news.newsCategory.id="+cateId;
				}
				Query query = session.createQuery(hql);
				return Integer.parseInt(query.uniqueResult().toString());
			}
		});
	}
	/**
	 * 获取新闻资讯信息并分页
	 * @param cateId
	 * @param start 开始条数
	 * @param pageSize 每页显示条数
	 * @return List<News>
	 */
	public List<News> findNews(int cateId, int start, int pageSize){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(News.class);
		detachedCriteria.add(Restrictions.eq("newsCategory.id", cateId));
		return (List<News>) this.getHibernateTemplate().findByCriteria(detachedCriteria, start, pageSize);
	}
	/**
	 * 通过新闻资讯编号获取单个新闻资讯对象
	 * @param id
	 * @return News
	 */
	public News findNewsById(int id){
		return this.getHibernateTemplate().get(News.class, id);
	}
	/**
	 * 更新新闻资讯
	 * @param news
	 */
	public void updateNews(News news){
		this.getHibernateTemplate().update(news);
	}
	/**
	 * 修改前根据id查询 信息
	 * @param news
	 * @return News
	 */
	public News findNewsById(News news){
		return this.getHibernateTemplate().get(News.class, news.getId());
	}
	/**
	 * 获取新闻资讯的总条数
	 * @return int : 总条数
	 */
	public int totalCount(){
		return this.getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			public Integer doInHibernate(Session session) throws HibernateException {
				String hql = "select count(news) from News as news";
				Query query = session.createQuery(hql);
				return Integer.parseInt(query.uniqueResult().toString());
			}
		});
	}
	/**
	 * 新闻资讯列表并实现分页
	 * @param start 开始条数
	 * @param pageSize 每页显示条数
	 * @return List 集合：News
	 */
	public List<News> findNewsList(int start, int pageSize){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(News.class);
		return (List<News>) this.getHibernateTemplate().findByCriteria(detachedCriteria, start, pageSize);
	}
	/**
	 * 新闻资讯模糊查询
	 * @param news 
	 * @param start 开始条数
	 * @param pageSize 每页显示条数
	 * @return List 集合：News
	 */
	public List<News> searchNews(News news, int start, int pageSize){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(News.class);
		detachedCriteria.add(Restrictions.like("newsTitle", news.getNewsTitle(), MatchMode.ANYWHERE));
		detachedCriteria.addOrder(Order.asc("id"));
		return (List<News>) this.getHibernateTemplate().findByCriteria(detachedCriteria, start, pageSize);
	}
	/**
	 * 模糊查询 获取新闻资讯的总条数
	 * @param news
	 * @return int : 总条数
	 */
	public int totalCount(News news){
		return this.getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			public Integer doInHibernate(Session session) throws HibernateException {
				String hql = "select count(news) from News as news where news.newsTitle like '%"+news.getNewsTitle()+"%'";
				Query query = session.createQuery(hql);
				return Integer.parseInt(query.uniqueResult().toString());
			}
		});
	}
	/**
	 * 添加新闻资讯
	 * @param news
	 */
	public void addNews(News news){
		this.getHibernateTemplate().save(news);
	}
	/**
	 * 删除新闻资讯
	 * @param news
	 */
	public void deleteNews(News news){
		this.getHibernateTemplate().delete(news);
	}
}
