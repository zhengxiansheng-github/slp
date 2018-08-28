package com.slp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.slp.bean.SiteInfo;
import com.slp.dao.SiteInfoDao;
import com.slp.service.SiteInfoService;

@Service("siteInfoService")
public class SiteInfoServiceImpl implements SiteInfoService {
	
	@Resource
	private SiteInfoDao siteInfoDao;
	/**
	 * 获取站点信息的总条数
	 * @return int : 总条数
	 */
	public int totalCount() {
		return siteInfoDao.totalCount();
	}
	/**
	 * 站点信息列表并实现分页
	 * @param start 开始条数
	 * @param pageSize 每页显示条数
	 * @return List 集合：SiteInfo
	 */
	public List<SiteInfo> siteInfoList(int start, int pageSize) {
		return siteInfoDao.siteInfoList(start, pageSize);
	}
	/**
	 * 站点信息模糊查询
	 * @param siteInfo 
	 * @param start 开始条数
	 * @param pageSize 每页显示条数
	 * @return List 集合：SiteInfo
	 */
	public List<SiteInfo> search(SiteInfo siteInfo, int start, int pageSize){
		return siteInfoDao.search(siteInfo, start, pageSize);
	}
	/**
	 * 模糊查询 获取站点信息的总条数
	 * @param siteInfo
	 * @return int : 总条数
	 */
	public int totalCount(SiteInfo siteInfo){
		return siteInfoDao.totalCount(siteInfo);
	}
	/**
	 * 添加站点信息
	 * @param siteInfo 站点对象
	 */
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void addSiteInfo(SiteInfo siteInfo){
		siteInfoDao.addSiteInfo(siteInfo);
	}
	/**
	 * 站点信息修改前查询id
	 * @param siteInfo对象
	 * @return SiteInfo对象
	 */
	public SiteInfo findSiteInfoById(SiteInfo siteInfo){
		return siteInfoDao.findSiteInfoById(siteInfo);
	}
	/**
	 * 站点信息修改
	 * @param siteInfo对象
	 */
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void update(SiteInfo siteInfo){
		siteInfoDao.update(siteInfo);
	}
	/**
	 * 站点信息修改
	 * @param siteInfo对象
	 */
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void deleteSiteInfo(SiteInfo siteInfo){
		siteInfoDao.deleteSiteInfo(siteInfo);
	}
	/**
	 * 根据站点name查询部分站点对象
	 * @param names
	 * @return List<SiteInfo>
	 */
	public List<SiteInfo> findSiteInfo(String [] names){
		return siteInfoDao.findSiteInfo(names);
	}
}
