package com.slp.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.slp.bean.ProjectCategory;
import com.slp.service.ProjectCategoryService;

@Controller("projectCategoryAction") @Scope("prototype")
public class ProjectCategoryAction {
	@Resource
	private ProjectCategoryService projectCategoryService;
	private	List<ProjectCategory> projectCategoryList;
	private int pageSize = 2;//每页显示条数
	private int currentPage = 1;//当前页
	private int totalCount, totalPage;//总条数/总页数
	private ProjectCategory projectCategory;
	
	//列表出所有案例分类并分页
	public String list(){
		int start = (currentPage-1)*pageSize;
		totalCount = projectCategoryService.totalCount();
		totalPage = totalCount%pageSize>0?totalCount/pageSize+1:totalCount/pageSize;
		projectCategoryList= projectCategoryService.findProjectCategory(start, pageSize);
		return "list";
	}
	
	//添加案例分类
	public String add(){
		projectCategoryService.addProjectCategory(projectCategory);
		return "add";
	}
	
	//修改案例分类前根据id查询并跳转到修改页面
	public String toUpdate(){
		projectCategory = projectCategoryService.findProjectCategoryById(projectCategory);
		return "toUpdate";
	}
	
	//修改
	public String update(){
		projectCategoryService.updateProjectCategory(projectCategory);
		return "update";
	}
	
	//删除
	public String delete(){
		projectCategoryService.deleteProjectCategory(projectCategory);
		return "delete";
	}

	public List<ProjectCategory> getProjectCategoryList() {
		return projectCategoryList;
	}
	public void setProjectCategoryList(List<ProjectCategory> projectCategoryList) {
		this.projectCategoryList = projectCategoryList;
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
	public ProjectCategory getProjectCategory() {
		return projectCategory;
	}
	public void setProjectCategory(ProjectCategory projectCategory) {
		this.projectCategory = projectCategory;
	}
}
