package com.slp.dao;

import java.util.List;

import com.slp.bean.Banner;

public interface BannerDao {
	/**
	 * 获取banner的总条数
	 * @return int : 总条数
	 */
	public int totalCount();
	/**
	 * 查询banner并分页
	 * @param start
	 * @param pageSize
	 * @return List<Banner>
	 */
	public List<Banner> findBanner(int start, int pageSize);
	/**
	 * banner模糊查询
	 * @param siteInfo 
	 * @param start 开始条数
	 * @param pageSize 每页显示条数
	 * @return List 集合：SiteInfo
	 */
	public List<Banner> searchBanner(Banner banner, int start, int pageSize);
	/**
	 * 模糊查询 获取banner的总条数
	 * @param siteInfo
	 * @return int : 总条数
	 */
	public int totalCount(Banner banner);
	/**
	 * 添加banner
	 * @param banner
	 */
	public void addBanner(Banner banner);
	/**
	 * 根据id查询单个Banner对象 修改前查询
	 * @param banner
	 * @return Banner
	 */
	public Banner findBannerById(Banner banner);
	/**
	 * 修改
	 * @param banner
	 */
	public void updateBanner(Banner banner);
	/**
	 * 删除
	 * @param banner
	 */
	public void deleteBanner(Banner banner);
}
