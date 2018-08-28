package com.slp.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.slp.bean.Banner;
import com.slp.bean.Links;
import com.slp.bean.Project;
import com.slp.bean.SiteInfo;
import com.slp.bean.Team;
import com.slp.service.BannerService;
import com.slp.service.LinksService;
import com.slp.service.ProjectService;
import com.slp.service.SiteInfoService;
import com.slp.service.TeamService;

@Controller("indexAction") @Scope("prototype")
public class IndexAction {
	@Resource
	private BannerService bannerService;
	@Resource
	private SiteInfoService siteInfoService;
	@Resource
	private LinksService linksService;
	@Resource
	private ProjectService projectService;
	@Resource
	private TeamService teamService;
	
	private List<Banner> bannerList;
	private List<SiteInfo> siteInfoList;
	private List<Links> linksList;
	private List<Project> projectList;
	private List<Team> teamList;
	//首页
	public String index(){
		bannerList = bannerService.findBanner(0, 5);
		siteInfoList = siteInfoService.siteInfoList(0, 4);
		linksList = linksService.findAllLinks();
		projectList = projectService.findProject(1, 6);
		teamList = teamService.findTeam(0, 1);
		return "index";
	}
	
	
	
	public List<Banner> getBannerList() {
		return bannerList;
	}
	public void setBannerList(List<Banner> bannerList) {
		this.bannerList = bannerList;
	}
	public List<SiteInfo> getSiteInfoList() {
		return siteInfoList;
	}
	public void setSiteInfoList(List<SiteInfo> siteInfoList) {
		this.siteInfoList = siteInfoList;
	}
	public List<Links> getLinksList() {
		return linksList;
	}
	public void setLinksList(List<Links> linksList) {
		this.linksList = linksList;
	}
	public List<Project> getProjectList() {
		return projectList;
	}
	public void setProjectList(List<Project> projectList) {
		this.projectList = projectList;
	}
	public List<Team> getTeamList() {
		return teamList;
	}
	public void setTeamList(List<Team> teamList) {
		this.teamList = teamList;
	}
}
