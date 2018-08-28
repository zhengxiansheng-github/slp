package com.slp.dao;

import java.util.List;

import com.slp.bean.NewsCategory;

public interface NewsCategoryDao {
	/**
	 * 获取所有新闻资讯分类信息
	 * @return List<NewsCategory>
	 */
	public List<NewsCategory> findAllNewsCategory();
	/**
	 * 获取新闻资讯分类信息的总条数
	 * @return int : 总条数
	 */
	public int totalCount();
	/**
	 * 新闻资讯分类信息列表并实现分页
	 * @param start 开始条数
	 * @param pageSize 每页显示条数
	 * @return List 集合：NewsCategory
	 */
	public List<NewsCategory> findNewsCategoryList(int start, int pageSize);
	/**
	 * 添加新闻资讯分类信息
	 * @param newsCategory
	 */
	public void addNewsCategory(NewsCategory newsCategory);
	/**
	 * 新闻资讯分类信息修改前查询
	 * @param newsCategory对象
	 * @return NewsCategory对象
	 */
	public NewsCategory findNewsCategoryById(NewsCategory newsCategory);
	/**
	 * 新闻资讯分类信息修改
	 * @param newsCategory 对象
	 */
	public void updateNewsCategory(NewsCategory newsCategory);
	/**
	 * 新闻资讯分类信息删除
	 * @param  newsCategory 对象
	 */
	public void deleteNewsCategory(NewsCategory newsCategory);
}
