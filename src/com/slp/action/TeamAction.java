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
import com.slp.bean.Team;
import com.slp.service.TeamService;
import com.slp.util.Pager;

@Controller("teamAction") @Scope("prototype")
public class TeamAction {
	@Resource
	private TeamService teamService;
	private List<Team> teamList;
	private int pageSize = 3;//每页显示条数
	private int currentPage = 1;
	private int totalCount, totalPage;//总条数/总页数
	private Pager pager = new Pager();
	private int id;//id编号
	private Team team;
	private File fileImage;
	private String fileImageFileName;
	
	//显示团队列表
	public String team(){
		//int start = (currentPage-1)*pageSize;
		teamList = teamService.findTeam((int)pager.getOffset(), pageSize);
		totalCount = teamService.totalCount();
		totalPage = totalCount%pageSize>0 ? totalCount/pageSize+1 : totalCount/pageSize;
		return "team";
	}
	
	//显示团队详情
	public String teamMember(){
		team = teamService.findTeamById(id);
		team.setCount(team.getCount()+1);
		teamService.updateTeam(team);
		return "teamMember";
	}
	
	//后台显示团队列表
	public String list(){
		int start = (currentPage-1)*pageSize;
		totalCount = teamService.totalCount();
		totalPage = totalCount%pageSize>0?totalCount/pageSize+1:totalCount/pageSize;
		teamList = teamService.findTeam(start, pageSize);
		return "list";
	}
	
	//后台模糊查询
	public String search(){
		if(team!=null){
			ActionContext.getContext().getSession().put("team", team);
		}
		team = (Team) ActionContext.getContext().getSession().get("team");
		int start = (currentPage-1)*pageSize;
		teamList = teamService.searchTeam(team, start, pageSize);
		totalCount = teamService.totalCount(team);
		totalPage = totalCount%pageSize>0?totalCount/pageSize+1:totalCount/pageSize;
		return "search";
	}
	
	//后台添加团队信息+文件上传
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
			team.setPhoto(fileImageFileName);
		}
		teamService.addTeam(team);
		return "add";
	}
	
	//后台修改之前根据id跳转到修改界面
	public String toUpdate(){
		team = teamService.findTeamById(team);
		return "toUpdate";
	}
	
	//后台修改
	public String update(){
		Team tm = teamService.findTeamById(team);
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
			team.setPhoto(fileImageFileName);
			File file = new File(realPath, tm.getPhoto());
			if(file.exists()){
				file.delete();//删除文件
			}
		}else{
			team.setPhoto(tm.getPhoto());
		}
		teamService.updateTeam(team);
		return "update";
	}
	
	//删除
	public String delete(){
		//删除图片
		team = teamService.findTeamById(team);
		//获取服务器根路径
		String realPath = ServletActionContext.getServletContext().getRealPath("/upload");
		File file = new File(realPath, team.getPhoto());
		if(file.exists()){
			file.delete();//删除文件
		}
		//删除数据
		teamService.deleteTeam(team);
		return "delete";
	}

	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Pager getPager() {
		return pager;
	}
	public void setPager(Pager pager) {
		this.pager = pager;
	}
	public List<Team> getTeamList() {
		return teamList;
	}
	public void setTeamList(List<Team> teamList) {
		this.teamList = teamList;
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
