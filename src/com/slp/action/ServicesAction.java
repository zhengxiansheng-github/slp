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
import com.slp.bean.Services;
import com.slp.service.ServicesService;

@Controller("servicesAction") @Scope("prototype")
public class ServicesAction {
	@Resource
	private ServicesService servicesService;
	private List<Services> servicesList;
	private int pageSize=3;//每页显示条数条数
	private int currentPage=1;//当前页
	private int totalPage, totalCount;//总页数/总条数
	private Services services;
	private File fileImage;
	private String fileImageFileName;
	
	//前台 服务显示显示
	public String services(){
		servicesList = servicesService.findAllServices();
		return "services";
	}
	
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
			services.setServiceImg(fileImageFileName);
		}
		servicesService.addServices(services);
		return "add";
	}
	
	//修改前根据id查询服务并跳转到修改界面
	public String toUpdate(){
		services = servicesService.findServicesById(services);
		return "toUpdate";
	}
	
	//修改
	public String update(){
		//Services sece = servicesService.findServicesById(services);
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
			File file = new File(realPath, services.getServiceImg());
			if(file.exists()){
				file.delete();//删除文件
			}
			services.setServiceImg(fileImageFileName);
		}else{
			services.setServiceImg(services.getServiceImg());
		}
		servicesService.updateServices(services);
		return "update";
	}
	
	//删除
	public String delete(){
		//删除图片
		services = servicesService.findServicesById(services);
		//获取服务器根路径
		String realPath = ServletActionContext.getServletContext().getRealPath("/upload");
		File file = new File(realPath, services.getServiceImg());
		if(file.exists()){
			file.delete();//删除文件
		}
		//删除数据
		servicesService.deleteServices(services);
		return "delete";
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
