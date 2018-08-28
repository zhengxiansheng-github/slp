package com.slp.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="slp_newscategory")
public class NewsCategory {//存储资讯分类信息
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String cateName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	
    
}
