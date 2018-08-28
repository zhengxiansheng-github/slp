package com.slp.bean;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="slp_project")
public class Project {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String projectName;
	//private int cateId;
	private String projectDate;
	

	private String projectContent;
	private String projectImg;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="cateId")
	private ProjectCategory projectCategory;
	
	private int count;
	
	public ProjectCategory getProjectCategory() {
		return projectCategory;
	}
	public void setProjectCategory(ProjectCategory projectCategory) {
		this.projectCategory = projectCategory;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
//	public int getCateId() {
//		return cateId;
//	}
//	public void setCateId(int cateId) {
//		this.cateId = cateId;
//	}
	public String getProjectDate() {
		return projectDate;
	}
	public void setProjectDate(String projectDate) {
		this.projectDate = projectDate;
	}
	public String getProjectContent() {
		return projectContent;
	}
	public void setProjectContent(String projectContent) {
		this.projectContent = projectContent;
	}
	public String getProjectImg() {
		return projectImg;
	}
	public void setProjectImg(String projectImg) {
		this.projectImg = projectImg;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

	
}
