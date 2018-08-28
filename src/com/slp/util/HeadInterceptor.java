package com.slp.util;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.slp.bean.NewsCategory;
import com.slp.bean.ProjectCategory;
import com.slp.bean.Services;
import com.slp.service.NewsCategoryService;
import com.slp.service.ProjectCategoryService;
import com.slp.service.ServicesService;

@Component
public class HeadInterceptor implements Interceptor{
	
	@Resource
	private ServicesService servicesService;
	@Resource
	private ProjectCategoryService projectCategoryService;
	@Resource
	private NewsCategoryService newsCategoryService;
	public void destroy() {
		
	}

	public void init() {
		
	}

	public String intercept(ActionInvocation invocation) throws Exception {
		List<Services> servicesList = servicesService.findAllServices();
		List<ProjectCategory> projectCategoryList = projectCategoryService.findAllProjectCategory();
		List<NewsCategory> newsCategoryList = newsCategoryService.findAllNewsCategory();
		ActionContext.getContext().put("servicesList", servicesList);
		ActionContext.getContext().put("projectCategoryList", projectCategoryList);
		ActionContext.getContext().put("newsCategoryList", newsCategoryList);
		return invocation.invoke();
	}

}
