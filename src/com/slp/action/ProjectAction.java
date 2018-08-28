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
import com.slp.bean.Project;
import com.slp.bean.ProjectCategory;
import com.slp.service.ProjectCategoryService;
import com.slp.service.ProjectService;

@Controller("projectAction") @Scope("prototype")
public class ProjectAction {
	@Resource
	private ProjectService projectService;
	@Resource
	private ProjectCategoryService projectCategoryService;
	private List<Project> projectList;
	private	List<ProjectCategory> projectCategoryList;
	private int cateId;//分类编号
	private int pageSize = 9;//每页显示条数
	private int currentPage = 1;
	private int totalCount, totalPage;//总条数/总页数
	private int id;//id编号
	private Project project;
	private File fileImage;
	private String fileImageFileName;
	
	//前台 案例列表显示
	public String project(){
		projectCategoryList = projectCategoryService.findAllProjectCategory();
		if(cateId==0){
			cateId = projectCategoryList.get(0).getId();
		}
		int start = (currentPage-1)*pageSize;
		projectList = projectService.findProject(cateId, start, pageSize);
		totalCount = projectService.totalCount(cateId);
		totalPage = totalCount%pageSize>0 ? totalCount/pageSize+1 : totalCount/pageSize;
		return "project";
	}
	
	//前台显示 案例详情
	public String projectDetails(){
		project = projectService.findProjectById(id);
		project.setCount(project.getCount()+1);
		projectService.updateProject(project);
		return "projectDetails";
	}
	
	//后台 案例列表显示
	public String list(){
		int start = (currentPage-1)*pageSize;
		totalCount = projectService.totalCount();
		totalPage = totalCount%pageSize>0?totalCount/pageSize+1:totalCount/pageSize;
		projectList = projectService.findProject(start, pageSize);
		return "list";
	}
	
	//后台 模糊查询
	public String search(){
		if(project!=null){
			ActionContext.getContext().getSession().put("project", project);
		}
		project = (Project) ActionContext.getContext().getSession().get("project");
		int start = (currentPage-1)*pageSize;
		projectList = projectService.searchProject(project, start, pageSize);
		totalCount = projectService.totalCount(project);
		totalPage = totalCount%pageSize>0?totalCount/pageSize+1:totalCount/pageSize;
		return "search";
	} 
	
	public String toAdd(){
		projectCategoryList = projectCategoryService.findAllProjectCategory();
		return "toAdd";
	}
	
	//后台 添加+文件上传
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
			project.setProjectImg(fileImageFileName);
		}
		projectService.addProject(project);
		return "add";
	}
	
	//修改前查询
	public String toUpdate(){
		project = projectService.findProjectById(project);
		projectCategoryList = projectCategoryService.findAllProjectCategory();
		return "toUpdate";
	}
	
	//后台修改案例
	public String update(){
		//Project pro = projectService.findProjectById(project);
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
			File file = new File(realPath, project.getProjectImg());
			if(file.exists()){
				file.delete();//删除文件
			}
			project.setProjectImg(fileImageFileName);
		}else{
			project.setProjectImg(project.getProjectImg());
		}
		projectService.updateProject(project);
		return "update";
	}
	
	//后台删除案例
	public String delete(){
		//删除图片
		project = projectService.findProjectById(project);
		//获取服务器根路径
		String realPath = ServletActionContext.getServletContext().getRealPath("/upload");
		File file = new File(realPath, project.getProjectImg());
		if(file.exists()){
			file.delete();//删除文件
		}
		//删除数据
		projectService.deleteProject(project);
		return "delete";
	}

	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Project> getProjectList() {
		return projectList;
	}
	public void setProjectList(List<Project> projectList) {
		this.projectList = projectList;
	}
	public List<ProjectCategory> getProjectCategoryList() {
		return projectCategoryList;
	}
	public void setProjectCategoryList(List<ProjectCategory> projectCategoryList) {
		this.projectCategoryList = projectCategoryList;
	}
	public int getCateId() {
		return cateId;
	}
	public void setCateId(int cateId) {
		this.cateId = cateId;
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
