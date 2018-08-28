package com.slp.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.slp.bean.NewsCategory;
import com.slp.service.NewsCategoryService;

@Controller("newsCategoryAction") @Scope("prototype")
public class NewsCategoryAction {
	@Resource
	private NewsCategoryService newsCategoryService;
	private List<NewsCategory> newsCategoryList;
	private int pageSize = 3;//每页显示条数
	private int currentPage = 1;
	private int totalCount, totalPage;//总条数/总页数
	private NewsCategory newsCategory;
	
	//新闻资讯分类信息列表显示
	public String list(){
		int start = (currentPage-1)*pageSize;
		totalCount = newsCategoryService.totalCount();
		totalPage = totalCount%pageSize>0?totalCount/pageSize+1:totalCount/pageSize;
		newsCategoryList = newsCategoryService.findNewsCategoryList(start, pageSize);
		return "list";
	}
	
	//添加新闻资讯分类
	public String add(){
		newsCategoryService.addNewsCategory(newsCategory);
		return "add";
	}
	
	//修改前查询
	public String toUpdate(){
		newsCategory = newsCategoryService.findNewsCategoryById(newsCategory);
		return "toUpdate";
	}
	
	//修改
	public String update(){
		newsCategoryService.updateNewsCategory(newsCategory);
		return "update";
	}
	
	//删除
	public String delete(){
		newsCategoryService.deleteNewsCategory(newsCategory);
		return "delete";
	}
	
	public List<NewsCategory> getNewsCategoryList() {
		return newsCategoryList;
	}
	public void setNewsCategoryList(List<NewsCategory> newsCategoryList) {
		this.newsCategoryList = newsCategoryList;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public NewsCategory getNewsCategory() {
		return newsCategory;
	}
	public void setNewsCategory(NewsCategory newsCategory) {
		this.newsCategory = newsCategory;
	}
}
