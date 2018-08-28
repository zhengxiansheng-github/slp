package com.slp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.slp.bean.Banner;
import com.slp.dao.BannerDao;
import com.slp.service.BannerService;
@Service("bannerService")
public class BannerServiceImpl implements BannerService {
	@Resource
	private BannerDao bannerDao;
	/**
	 * 获取banner的总条数
	 * @return int : 总条数
	 */
	public int totalCount(){
		return bannerDao.totalCount();
	}
	/**
	 * 查询banner并分页         前台显示时在indexAction调用
	 * @param start
	 * @param pageSize
	 * @return List<Banner>
	 */
	public List<Banner> findBanner(int start, int pageSize) {
		return bannerDao.findBanner(start, pageSize);
	}
	/**
	 * banner模糊查询
	 * @param siteInfo 
	 * @param start 开始条数
	 * @param pageSize 每页显示条数
	 * @return List 集合：SiteInfo
	 */
	public List<Banner> searchBanner(Banner banner, int start, int pageSize){
		return bannerDao.searchBanner(banner, start, pageSize);
	}
	/**
	 * 模糊查询 获取banner的总条数
	 * @param siteInfo
	 * @return int : 总条数
	 */
	public int totalCount(Banner banner){
		return bannerDao.totalCount(banner);
	}
	/**
	 * 添加banner
	 * @param banner
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public void addBanner(Banner banner){
		bannerDao.addBanner(banner);
	}
	/**
	 * 根据id查询单个Banner对象 修改前查询
	 * @param banner
	 * @return Banner
	 */
	public Banner findBannerById(Banner banner){
		return bannerDao.findBannerById(banner);
	}
	/**
	 * 修改
	 * @param banner
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public void updateBanner(Banner banner){
		bannerDao.updateBanner(banner);
	}
	/**
	 * 删除
	 * @param banner
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteBanner(Banner banner){
		bannerDao.deleteBanner(banner);
	}
}
