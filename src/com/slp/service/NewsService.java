package com.slp.service;

import java.util.List;

import com.slp.bean.News;

public interface NewsService {
	
	/**
	 * 获取新闻资讯信息的总条数
	 * @param cateId 新闻资讯分类编号
	 * @return int : 总条数
	 */
	public int totalCount(int cateId);
	/**
	 * 获取新闻资讯信息并分页
	 * @param cateId
	 * @param start 开始条数
	 * @param pageSize 每页显示条数
	 * @return List<News>
	 */
	public List<News> findNews(int cateId, int start, int pageSize);
	/**
	 * 通过新闻资讯编号获取单个新闻资讯对象
	 * @param id
	 * @return News
	 */
	public News findNewsById(int id);
	/**
	 * 更新新闻资讯
	 * @param news
	 */
	public void updateNews(News news);
	/**
	 * 修改前根据id查询 信息
	 * @param news
	 * @return News
	 */
	public News findNewsById(News news);
	/**
	 * 获取新闻资讯的总条数
	 * @return int : 总条数
	 */
	public int totalCount();
	/**
	 * 新闻资讯列表并实现分页
	 * @param start 开始条数
	 * @param pageSize 每页显示条数
	 * @return List 集合：News
	 */
	public List<News> findNewsList(int start, int pageSize);
	/**
	 * 新闻资讯模糊查询
	 * @param news 
	 * @param start 开始条数
	 * @param pageSize 每页显示条数
	 * @return List 集合：News
	 */
	public List<News> searchNews(News news, int start, int pageSize);
	/**
	 * 模糊查询 获取新闻资讯的总条数
	 * @param news
	 * @return int : 总条数
	 */
	public int totalCount(News news);
	/**
	 * 添加新闻资讯
	 * @param news
	 */
	public void addNews(News news);
	/**
	 * 删除新闻资讯
	 * @param news
	 */
	public void deleteNews(News news);
}
