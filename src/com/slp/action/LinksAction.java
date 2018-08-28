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
import com.slp.bean.Links;
import com.slp.service.LinksService;

@Controller("linksAction")
@Scope("prototype")
public class LinksAction {
	@Resource
	private LinksService linksService;
	private List<Links> linksList;
	private int pageSize = 3;//每页显示条数
	private int currentPage = 1;//当前页
	private int totalCount, totalPage;//总条数/总页数
	private Links links;
	private File fileImage;
	private String fileImageFileName;
	
	//显示友情链接列表
	public String list(){
		int start = (currentPage-1)*pageSize;
		totalCount = linksService.totalCount();
		totalPage = totalCount%pageSize>0?totalCount/pageSize+1:totalCount/pageSize;
		linksList = linksService.findlinksList(start, pageSize);
		return "list";
	}
	
	//后台模糊查询
	public String search(){
		if(links!=null){
				ActionContext.getContext().getSession().put("links", links);
		}
		links = (Links) ActionContext.getContext().getSession().get("links");
		int start = (currentPage-1)*pageSize;
		linksList = linksService.searchLinks(links, start, pageSize);
		totalCount = linksService.totalCount(links);
		totalPage = totalCount%pageSize>0?totalCount/pageSize+1:totalCount/pageSize;
		return "search";
	}
	
	//后台添加友情链接 + 文件上传
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
			links.setLinkImg(fileImageFileName);
		}
		linksService.addLinks(links);
		return "add";
	}
	
	// 跳转到修改界面 根据id查询单个友情链接 对象
	public String toUpdate(){
		links = linksService.findLinksById(links);
		return "toUpdate";
	}
	
	//修改
	public String update(){
		Links lin = linksService.findLinksById(links);
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
			links.setLinkImg(fileImageFileName);
			File file = new File(realPath, lin.getLinkImg());
			if(file.exists()){
				file.delete();//删除文件
			}
		}else{
			links.setLinkImg(lin.getLinkImg());
		}
		linksService.updateLinks(links);
		return "update";
	}
	
	//删除
	public String delete(){
		//删除图片
		links = linksService.findLinksById(links);
		//获取服务器根路径
		String realPath = ServletActionContext.getServletContext().getRealPath("/upload");
		File file = new File(realPath, links.getLinkImg());
		if(file.exists()){
			file.delete();//删除文件
		}
		//删除数据
		linksService.deleteLinks(links);
		return "delete";
	}
	
	public int getPageSize() {
		return pageSize;
	}

	public List<Links> getLinksList() {
		return linksList;
	}

	public void setLinksList(List<Links> linksList) {
		this.linksList = linksList;
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

	public Links getLinks() {
		return links;
	}

	public void setLinks(Links links) {
		this.links = links;
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
