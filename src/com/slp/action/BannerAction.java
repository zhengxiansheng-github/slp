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
import com.slp.bean.Banner;
import com.slp.service.BannerService;

@Controller("bannerAction")
@Scope("prototype")
public class BannerAction {
	@Resource
	private BannerService bannerService;
	private List<Banner> bannerList;
	private int pageSize = 3;//每页显示条数
	private int currentPage = 1;//当前页
	private int totalCount, totalPage;//总条数/总页数
	private Banner banner;
	private File fileImage;
	private String fileImageFileName;
	
	//显示banner列表
	public String list(){
		int start = (currentPage-1)*pageSize;
		totalCount = bannerService.totalCount();
		totalPage = totalCount%pageSize>0?totalCount/pageSize+1:totalCount/pageSize;
		bannerList = bannerService.findBanner(start, pageSize);
		return "list";
	}
	
	//后台模糊查询
	public String search(){
		if(banner!=null){
				ActionContext.getContext().getSession().put("banner", banner);
		}
		banner = (Banner) ActionContext.getContext().getSession().get("banner");
		int start = (currentPage-1)*pageSize;
		bannerList = bannerService.searchBanner(banner, start, pageSize);
		totalCount = bannerService.totalCount(banner);
		totalPage = totalCount%pageSize>0?totalCount/pageSize+1:totalCount/pageSize;
		return "search";
	}
	
	//后台添加banner + 文件上传
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
			banner.setBannerImg(fileImageFileName);
		}
		bannerService.addBanner(banner);
		return "add";
	}
	
	// 跳转到修改界面 根据id查询单个Banner对象
	public String toUpdate(){
		banner = bannerService.findBannerById(banner);
		return "toUpdate";
	}
	
	//修改
	public String update(){
		Banner bann = bannerService.findBannerById(banner);
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
			banner.setBannerImg(fileImageFileName);
			File file = new File(realPath, bann.getBannerImg());
			if(file.exists()){
				file.delete();//删除文件
			}
		}else{
			banner.setBannerImg(bann.getBannerImg());
		}
		bannerService.updateBanner(banner);
		return "update";
	}
	
	//删除
	public String delete(){
		//删除图片
		banner = bannerService.findBannerById(banner);
		//获取服务器根路径
		String realPath = ServletActionContext.getServletContext().getRealPath("/upload");
		File file = new File(realPath, banner.getBannerImg());
		if(file.exists()){
			file.delete();//删除文件
		}
		//删除数据
		bannerService.deleteBanner(banner);
		return "delete";
	}

	public List<Banner> getBannerList() {
		return bannerList;
	}

	public void setBannerList(List<Banner> bannerList) {
		this.bannerList = bannerList;
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

	public Banner getBanner() {
		return banner;
	}

	public void setBanner(Banner banner) {
		this.banner = banner;
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
