package com.slp.service;

import java.util.List;

import com.slp.bean.SiteInfo;

public interface SiteInfoService {
	
	/**
	 * 获取站点信息的总条数
	 * @return int : 总条数
	 */
	public int totalCount();
	/**
	 * 站点信息列表并实现分页
	 * @param start 开始条数
	 * @param pageSize 每页显示条数
	 * @return List 集合：SiteInfo
	 */
	public List<SiteInfo> siteInfoList(int start, int pageSize);
	/**
	 * 站点信息模糊查询
	 * @param siteInfo 
	 * @param start 开始条数
	 * @param pageSize 每页显示条数
	 * @return List 集合：SiteInfo
	 */
	public List<SiteInfo> search(SiteInfo siteInfo, int start, int pageSize);
	/**
	 * 模糊查询 获取站点信息的总条数
	 * @param siteInfo
	 * @return int : 总条数
	 */
	public int totalCount(SiteInfo siteInfo);
	/**
	 * 添加站点信息
	 * @param siteInfo 站点对象
	 */
	public void addSiteInfo(SiteInfo siteInfo);
	/**
	 * 站点信息修改前查询id
	 * @param siteInfo对象
	 * @return SiteInfo对象
	 */
	public SiteInfo findSiteInfoById(SiteInfo siteInfo);
	/**
	 * 站点信息修改
	 * @param siteInfo对象
	 */
	public void update(SiteInfo siteInfo);
	/**
	 * 站点信息修改
	 * @param siteInfo对象
	 */
	public void deleteSiteInfo(SiteInfo siteInfo);
	/**
	 * 根据站点name查询部分站点对象
	 * @param names
	 * @return List<SiteInfo>
	 */
	public List<SiteInfo> findSiteInfo(String [] names);
}
