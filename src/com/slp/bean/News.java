package com.slp.bean;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="slp_news")
public class News {//存储资讯信息
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String newsTitle;
	//private int cateId;
	private String newsDate;
	
	//@Lob
	private String newsContent;
	private String newsImg;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="cateId")
	private NewsCategory newsCategory;

	private int count;
	
	public NewsCategory getNewsCategory() {
		return newsCategory;
	}
	public void setNewsCategory(NewsCategory newsCategory) {
		this.newsCategory = newsCategory;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNewsTitle() {
		return newsTitle;
	}
	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}
//	public int getCateId() {
//		return cateId;
//	}
//	public void setCateId(int cateId) {
//		this.cateId = cateId;
//	}
	public String getNewsDate() {
		return newsDate;
	}
	public void setNewsDate(String newsDate) {
		this.newsDate = newsDate;
	}
	public String getNewsContent() {
		return newsContent;
	}
	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}
	public String getNewsImg() {
		return newsImg;
	}
	public void setNewsImg(String newsImg) {
		this.newsImg = newsImg;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}


	
}
