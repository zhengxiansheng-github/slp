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
import com.slp.bean.SiteInfo;
import com.slp.service.SiteInfoService;

@Controller("siteInfoAction")
@Scope("prototype")
public class SiteInfoAction {
	@Resource
	private SiteInfoService siteInfoService;
	private int pageSize = 5;//每页显示条数
	private int currentPage = 1;//当前页
	private List<SiteInfo> siteInfoList;
	private int totalCount, totalPage;//总条数/总页数
	private SiteInfo siteInfo;
	private File fileImage;
	private String fileImageFileName;
	
	//处理站点信息列表
	public String list(){
		int start = (currentPage-1)*pageSize;
		totalCount = siteInfoService.totalCount();
		totalPage = totalCount%pageSize>0?totalCount/pageSize+1:totalCount/pageSize;
		siteInfoList = siteInfoService.siteInfoList(start, pageSize);
		return "list";
	}
	
	//查询
	public String search(){
		if(siteInfo!=null){
			ActionContext.getContext().getSession().put("siteInfo", siteInfo);
		}
		siteInfo = (SiteInfo) ActionContext.getContext().getSession().get("siteInfo");
		int start = (currentPage-1)*pageSize;
		siteInfoList = siteInfoService.search(siteInfo, start, pageSize);
		totalCount = siteInfoService.totalCount(siteInfo);
		totalPage = totalCount%pageSize>0?totalCount/pageSize+1:totalCount/pageSize;
		return "search";
	}
	
	//添加+文件上传
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
			siteInfo.setInfoImg(fileImageFileName);
		}
		siteInfoService.addSiteInfo(siteInfo);
		return "add";
	}
	
	//删除
	public String delete(){
		//删除图片
		siteInfo = siteInfoService.findSiteInfoById(siteInfo);
		//获取服务器根路径
		String realPath = ServletActionContext.getServletContext().getRealPath("/upload");
		File file = new File(realPath, siteInfo.getInfoImg());
		if(file.exists()){
			file.delete();//删除文件
		}
		//删除数据
		siteInfoService.deleteSiteInfo(siteInfo);
		return "delete";
	}
	
	//跳转到修改页面
	public String toUpdate(){
		siteInfo = siteInfoService.findSiteInfoById(siteInfo);
		return "toUpdate";
	}
	
	//修改
	public String update(){
		SiteInfo info = siteInfoService.findSiteInfoById(siteInfo);
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
			siteInfo.setInfoImg(fileImageFileName);
			File file = new File(realPath, info.getInfoImg());
			if(file.exists()){
				file.delete();//删除文件
			}
		}else{
			siteInfo.setInfoImg(info.getInfoImg());
		}
		siteInfoService.update(siteInfo);
		return "update";
	}
	
	//前台站点 了解更多
	public String moreSiteInfo(){
		siteInfoList = siteInfoService.siteInfoList(0, 30);
		return "moreSiteInfo";
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
	public SiteInfo getSiteInfo() {
		return siteInfo;
	}
	public void setSiteInfo(SiteInfo siteInfo) {
		this.siteInfo = siteInfo;
	}
	public SiteInfoService getSiteInfoService() {
		return siteInfoService;
	}
	public void setSiteInfoService(SiteInfoService siteInfoService) {
		this.siteInfoService = siteInfoService;
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
	public List<SiteInfo> getSiteInfoList() {
		return siteInfoList;
	}
	public void setSiteInfoList(List<SiteInfo> siteInfoList) {
		this.siteInfoList = siteInfoList;
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
}
