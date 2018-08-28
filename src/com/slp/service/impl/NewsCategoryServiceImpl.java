package com.slp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.slp.bean.NewsCategory;
import com.slp.bean.ProjectCategory;
import com.slp.dao.NewsCategoryDao;
import com.slp.dao.ProjectCategoryDao;
import com.slp.service.NewsCategoryService;
import com.slp.service.ProjectCategoryService;

@Service("newsCategoryService")
public class NewsCategoryServiceImpl implements NewsCategoryService {
	@Resource
	private NewsCategoryDao newsCategoryDao;

	/**
	 * 获取所有新闻资讯分类信息
	 * @return List<NewsCategory>
	 */
	public List<NewsCategory> findAllNewsCategory() {
		return newsCategoryDao.findAllNewsCategory();
	}
	/**
	 * 获取新闻资讯分类信息的总条数
	 * @return int : 总条数
	 */
	public int totalCount(){
		return newsCategoryDao.totalCount();
	}
	/**
	 * 新闻资讯分类信息列表并实现分页
	 * @param start 开始条数
	 * @param pageSize 每页显示条数
	 * @return List 集合：NewsCategory
	 */
	public List<NewsCategory> findNewsCategoryList(int start, int pageSize){
		return newsCategoryDao.findNewsCategoryList(start, pageSize);
	}
	/**
	 * 添加新闻资讯分类信息
	 * @param newsCategory
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public void addNewsCategory(NewsCategory newsCategory){
		newsCategoryDao.addNewsCategory(newsCategory);
	}
	/**
	 * 新闻资讯分类信息修改前查询
	 * @param newsCategory对象
	 * @return NewsCategory对象
	 */
	public NewsCategory findNewsCategoryById(NewsCategory newsCategory){
		return newsCategoryDao.findNewsCategoryById(newsCategory);
	}
	/**
	 * 新闻资讯分类信息修改
	 * @param newsCategory 对象
	 */
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void updateNewsCategory(NewsCategory newsCategory){
		newsCategoryDao.updateNewsCategory(newsCategory);
	}
	/**
	 * 新闻资讯分类信息删除
	 * @param  newsCategory 对象
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteNewsCategory(NewsCategory newsCategory){
		newsCategoryDao.deleteNewsCategory(newsCategory);
	}
}
