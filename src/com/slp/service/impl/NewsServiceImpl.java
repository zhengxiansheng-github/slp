package com.slp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.slp.bean.News;
import com.slp.dao.NewsDao;
import com.slp.service.NewsService;

@Service("newsService")
public class NewsServiceImpl implements NewsService {
	
	@Resource
	private NewsDao newsDao;
	/**
	 * 获取新闻资讯信息的总条数
	 * @param cateId 新闻资讯分类编号
	 * @return int : 总条数
	 */
	public int totalCount(int cateId) {
		return newsDao.totalCount(cateId);
	}
	/**
	 * 获取新闻资讯信息并分页
	 * @param cateId
	 * @param start 开始条数
	 * @param pageSize 每页显示条数
	 * @return List<News>
	 */
	public List<News> findNews(int cateId, int start, int pageSize){
		return newsDao.findNews(cateId, start, pageSize);
	}
	/**
	 * 通过新闻资讯编号获取单个新闻资讯对象
	 * @param id
	 * @return News
	 */
	public News findNewsById(int id){
		return newsDao.findNewsById(id);
	}
	/**
	 * 更新新闻资讯
	 * @param news
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public void updateNews(News news){
		newsDao.updateNews(news);
	}
	/**
	 * 修改前根据id查询 信息
	 * @param news
	 * @return News
	 */
	public News findNewsById(News news){
		return newsDao.findNewsById(news);
	}
	/**
	 * 获取新闻资讯的总条数
	 * @return int : 总条数
	 */
	public int totalCount(){
		return newsDao.totalCount();
	}
	/**
	 * 新闻资讯列表并实现分页
	 * @param start 开始条数
	 * @param pageSize 每页显示条数
	 * @return List 集合：News
	 */
	public List<News> findNewsList(int start, int pageSize){
		return newsDao.findNewsList(start, pageSize);
	}
	/**
	 * 新闻资讯模糊查询
	 * @param news 
	 * @param start 开始条数
	 * @param pageSize 每页显示条数
	 * @return List 集合：News
	 */
	public List<News> searchNews(News news, int start, int pageSize){
		return newsDao.searchNews(news, start, pageSize);
	}
	/**
	 * 模糊查询 获取新闻资讯的总条数
	 * @param news
	 * @return int : 总条数
	 */
	public int totalCount(News news){
		return newsDao.totalCount(news);
	}
	/**
	 * 添加新闻资讯
	 * @param news
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public void addNews(News news){
		newsDao.addNews(news);
	}
	/**
	 * 删除新闻资讯
	 * @param news
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteNews(News news){
		newsDao.deleteNews(news);
	}
}
