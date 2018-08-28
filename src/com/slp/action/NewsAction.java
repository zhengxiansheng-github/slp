package com.slp.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.slp.bean.News;
import com.slp.bean.NewsCategory;
import com.slp.service.NewsCategoryService;
import com.slp.service.NewsService;
import com.slp.util.Pager;

@Controller("newsAction") @Scope("prototype")
public class NewsAction {
	@Resource
	private NewsService newsService;
	@Resource
	private NewsCategoryService newsCategoryService;
	private List<News> newsList;
	private List<NewsCategory> newsCategoryList;
	private int pageSize = 3;//每页显示条数
	private int currentPage = 1;
	private int totalCount, totalPage;//总条数/总页数
	private Pager pager = new Pager();
	private int id;//id编号
	private int cateId;//id编号
	private News news;
	private File fileImage;
	private String fileImageFileName;
	
	//前台显示新闻资讯列表
	public String news(){
		newsCategoryList = newsCategoryService.findAllNewsCategory();
		if(cateId==0){
			cateId = newsCategoryList.get(0).getId();
		}
		newsList = newsService.findNews(cateId, (int)pager.getOffset(), pageSize);
		pager.setTotal(newsService.totalCount(cateId));
		return "news";
	}
	
	//前台显示新闻资讯详情
	public String newsDetails(){
		news = newsService.findNewsById(id);
		news.setCount(news.getCount()+1);
		newsService.updateNews(news);
		return "newsDetails";
	}
	
	//后台新闻资讯列表显示
	public String list(){
		int start = (currentPage-1)*pageSize;
		totalCount = newsService.totalCount();
		totalPage = totalCount%pageSize>0?totalCount/pageSize+1:totalCount/pageSize;
		newsList = newsService.findNewsList(start, pageSize);
		return "list";
	}
	
	//后台模糊查询
	public String search(){
		if(news!=null){
			ActionContext.getContext().getSession().put("news", news);
		}
		news = (News) ActionContext.getContext().getSession().get("news");
		int start = (currentPage-1)*pageSize;
		newsList = newsService.searchNews(news, start, pageSize);
		totalCount = newsService.totalCount(news);
		totalPage = totalCount%pageSize>0?totalCount/pageSize+1:totalCount/pageSize;
		return "search";
	}
	
	//查询所有分类信息并 跳转到添加页面
	public String toAdd(){
		newsCategoryList = newsCategoryService.findAllNewsCategory();
		return "toAdd";
	}
	
	//后台添加+文件上传
	public String add(){
		if(fileImage!=null&&fileImage.length()>0){
			//文件上传
			String realPath = ServletActionContext.getServletContext().getRealPath("/upload");
			//创建新的图片名称   .jpg .png
			String fileType = fileImageFileName.substring(fileImageFileName.lastIndexOf("."), fileImageFileName.length());
			fileImageFileName = System.currentTimeMillis()+fileType;
			File saveFile = new File(realPath, fileImageFileName);
			try {
				FileUtils.copyFile(fileImage, saveFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			news.setNewsImg(fileImageFileName);
		}
		newsService.addNews(news);
		return "add";
	}
	
	//跳转到修改页面 并查询所有分类信息传到页面上
	public String toUpdate(){
		news = newsService.findNewsById(news);
		newsCategoryList = newsCategoryService.findAllNewsCategory();
		return "toUpdate";
	}
	//修改 
	public String update(){
		//News ns = newsService.findNewsById(id);
		if(fileImage!=null&&fileImage.length()>0){
			//文件上传
			String realPath = ServletActionContext.getServletContext().getRealPath("/upload");
			//创建新的图片名称   .jpg .png
			String fileType = fileImageFileName.substring(fileImageFileName.lastIndexOf("."), fileImageFileName.length());
			fileImageFileName = System.currentTimeMillis()+fileType;
			File saveFile = new File(realPath, fileImageFileName);
			try {
				FileUtils.copyFile(fileImage, saveFile);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File file = new File(realPath, news.getNewsImg());
			if(file.exists()){
				file.delete();//删除文件
			}
			news.setNewsImg(fileImageFileName);
		}else{
			news.setNewsImg(news.getNewsImg());
		}
		newsService.updateNews(news);
		return "update";
	}
	
	//删除
	public String delete(){
		//删除图片
		news = newsService.findNewsById(news);
		//获取服务器根路径
		String realPath = ServletActionContext.getServletContext().getRealPath("/upload");
		File file = new File(realPath, news.getNewsImg());
		if(file.exists()){
			file.delete();//删除文件
		}
		//删除数据
		newsService.deleteNews(news);
		return "delete";
	}

	public List<News> getNewsList() {
		return newsList;
	}
	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
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
	public Pager getPager() {
		return pager;
	}
	public void setPager(Pager pager) {
		this.pager = pager;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCateId() {
		return cateId;
	}
	public void setCateId(int cateId) {
		this.cateId = cateId;
	}
	public News getNews() {
		return news;
	}
	public void setNews(News news) {
		this.news = news;
	}
	public File getFileImage() {
		return fileImage;
	}
	public void setFileImage(File fileImage) {
		this.fileImage = fileImage;
	}
	public String getFileImageFileName() {
		return fileImageFileName;
	}
	public void setFileImageFileName(String fileImageFileName) {
		this.fileImageFileName = fileImageFileName;
	}
}
