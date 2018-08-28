package com.slp.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.slp.bean.Services;
import com.slp.service.ServicesService;

@Controller("servicesCategoryAction") @Scope("prototype")
public class ServicesCategoryAction {
	@Resource
	private ServicesService servicesService;
	private List<Services> servicesList;
	private int pageSize=3;//每页显示条数条数
	private int currentPage=1;//当前页
	private int totalPage, totalCount;//总页数/总条数
	private Services services;
	
	//后台服务列表显示
	public String list(){
		int start = (currentPage-1)*pageSize;//从第几条数据开始
		totalCount = servicesService.totalCount();//总条数
		totalPage = totalCount%pageSize>0?totalCount/pageSize+1:totalCount/pageSize;
		servicesList = servicesService.findServicesList(start, pageSize);
		return "list";
	}

	//模糊查询
	public String search(){
		if(services!=null){
			ActionContext.getContext().getSession().put("services", services);
		}
		services = (Services) ActionContext.getContext().getSession().get("services");
		int start = (totalPage-1)*pageSize;//从第几条数据开始
		totalCount = servicesService.totalCount(services);//总条数
		totalPage = totalCount%pageSize>0?totalCount/pageSize+1:totalCount/pageSize;
		servicesList = servicesService.searchServicesList(services, start, pageSize);
		return "search";
	}
	
	public List<Services> getServicesList() {
		return servicesList;
	}

	public void setServicesList(List<Services> servicesList) {
		this.servicesList = servicesList;
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

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public Services getServices() {
		return services;
	}

	public void setServices(Services services) {
		this.services = services;
	}
}
