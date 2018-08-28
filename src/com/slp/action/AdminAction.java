package com.slp.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.slp.bean.Admin;
import com.slp.service.AdminService;
import com.slp.service.NewsService;
import com.slp.service.ProjectService;
import com.slp.service.SiteInfoService;
import com.slp.service.TeamService;

@Controller("adminAction")
@Scope("prototype")
public class AdminAction {
	@Resource
	private AdminService adminService;
	@Resource
	private SiteInfoService siteInfoService;
	@Resource
	private NewsService newsService;
	@Resource
	private ProjectService projectService;
	@Resource
	private TeamService teamService;
	private int siteInfoTotalCount,newsTotalCount,projectTotalCount,teamTotalCount;
	
	private Admin admin;
	private List<Admin> adminList;
	private int pageSize = 3;//每页显示条数
	private int currentPage = 1;//当前页
	private int totalCount, totalPage;//总条数/总页数
	private String repassword;
	
	//登录
	public String login(){
		return adminService.login(admin);
	}
	
	//控制台
	public String main(){
		siteInfoTotalCount = siteInfoService.totalCount();
		newsTotalCount = newsService.totalCount(0);
		projectTotalCount = projectService.totalCount(0);
		teamTotalCount = teamService.totalCount();
		return "toMain";
	}
	
	//管理员列表
	public String list(){
		int start = (currentPage-1)*pageSize;
		totalCount = adminService.totalCount();
		totalPage = totalCount%pageSize>0?totalCount/pageSize+1:totalCount/pageSize;
		adminList = adminService.findAdminList(start, pageSize);
		return "list";
	}
	
	//模糊查询
	public String search(){
		if(admin!=null){
			ActionContext.getContext().getSession().put("admin", admin);
		}
		admin = (Admin) ActionContext.getContext().getSession().get("admin");
		int start = (currentPage-1)*pageSize;
		adminList = adminService.searchAdmin(admin, start, pageSize);
		totalCount = adminService.totalCount(admin);
		totalPage = totalCount%pageSize>0?totalCount/pageSize+1:totalCount/pageSize;
		return "search";
	}
	
	//添加管理员
	public String add(){
		adminService.addAdmin(admin, repassword);
		return "add";
	}
	
	//删除
	public String delete(){
		adminService.deleteAdmin(admin);
		return "delete";
	}
	
	//修改前根据id查询并跳转到修改界面
	public String toUpdate(){
		admin = adminService.findAdminById(admin);
		return "toUpdate";
	}
	
	//修改
	public String update(){
		adminService.updateAdmin(admin, repassword);
		return "update";
	}

	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public int getSiteInfoTotalCount() {
		return siteInfoTotalCount;
	}
	public void setSiteInfoTotalCount(int siteInfoTotalCount) {
		this.siteInfoTotalCount = siteInfoTotalCount;
	}
	public int getNewsTotalCount() {
		return newsTotalCount;
	}
	public void setNewsTotalCount(int newsTotalCount) {
		this.newsTotalCount = newsTotalCount;
	}
	public int getProjectTotalCount() {
		return projectTotalCount;
	}
	public void setProjectTotalCount(int projectTotalCount) {
		this.projectTotalCount = projectTotalCount;
	}
	public int getTeamTotalCount() {
		return teamTotalCount;
	}
	public void setTeamTotalCount(int teamTotalCount) {
		this.teamTotalCount = teamTotalCount;
	}
	public List<Admin> getAdminList() {
		return adminList;
	}
	public void setAdminList(List<Admin> adminList) {
		this.adminList = adminList;
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
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
}
