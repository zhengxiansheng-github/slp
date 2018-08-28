package com.slp.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.slp.bean.NewsCategory;
import com.slp.bean.SiteInfo;
import com.slp.dao.NewsCategoryDao;
import com.slp.util.Tool;

@Repository("newsCategoryDao")
public class NewsCategoryDaoImpl extends Tool implements NewsCategoryDao {
	
	/**
	 * 获取所有新闻资讯分类信息
	 * @return List<NewsCategory>
	 */
	public List<NewsCategory> findAllNewsCategory() {
		return (List<NewsCategory>) this.getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(NewsCategory.class));
	}
	/**
	 * 获取新闻资讯分类信息的总条数
	 * @return int : 总条数
	 */
	public int totalCount(){
		return this.getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			public Integer doInHibernate(Session session) throws HibernateException {
				String hql = "select count(newsCategory) from NewsCategory as newsCategory";
				Query query = session.createQuery(hql);
				return Integer.parseInt(query.uniqueResult().toString());
			}
		});
	}
	/**
	 * 新闻资讯分类信息列表并实现分页
	 * @param start 开始条数
	 * @param pageSize 每页显示条数
	 * @return List 集合：NewsCategory
	 */
	public List<NewsCategory> findNewsCategoryList(int start, int pageSize){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(NewsCategory.class);
		return (List<NewsCategory>) this.getHibernateTemplate().findByCriteria(detachedCriteria, start, pageSize);
	}
	/**
	 * 添加新闻资讯分类信息
	 * @param newsCategory
	 */
	public void addNewsCategory(NewsCategory newsCategory){
		this.getHibernateTemplate().save(newsCategory);
	}
	/**
	 * 新闻资讯分类信息修改前查询
	 * @param newsCategory对象
	 * @return NewsCategory对象
	 */
	public NewsCategory findNewsCategoryById(NewsCategory newsCategory){
		return this.getHibernateTemplate().get(NewsCategory.class, newsCategory.getId());
		/*return this.getHibernateTemplate().execute(new HibernateCallback<NewsCategory>() {
			public NewsCategory doInHibernate(Session session) throws HibernateException {
				String hql = "select * from NewsCategory as newsCategory where id = "+newsCategory.getId()+" or cateName = "+newsCategory.getCateName();
				Query query = session.createQuery(hql);
				return (NewsCategory) query.uniqueResult();
			}
		});*/
	}
	/**
	 * 新闻资讯分类信息修改
	 * @param newsCategory 对象
	 */
	public void updateNewsCategory(NewsCategory newsCategory){
		this.getHibernateTemplate().update(newsCategory);
	}
	/**
	 * 新闻资讯分类信息删除
	 * @param  newsCategory 对象
	 */
	public void deleteNewsCategory(NewsCategory newsCategory){
		this.getHibernateTemplate().delete(newsCategory);
	}
}
