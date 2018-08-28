package com.slp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.slp.bean.Links;
import com.slp.bean.SiteInfo;
import com.slp.dao.LinksDao;
import com.slp.service.LinksService;
@Service("linksService")
public class LinksServiceImpl implements LinksService {
	@Resource
	private LinksDao linksDao;
	/**
	 * 获取所有的友情链接
	 * @return List<Links>
	 */
	public List<Links> findAllLinks() {
		return linksDao.findAllLinks();
	}
	/**
	 * 获取友情链接的总条数
	 * @return int : 总条数
	 */
	public int totalCount(){
		return linksDao.totalCount();
	}
	/**
	 * 友情链接列表并实现分页
	 * @param start 开始条数
	 * @param pageSize 每页显示条数
	 * @return List 集合：Links
	 */
	public List<Links> findlinksList(int start, int pageSize){
		return linksDao.findlinksList(start, pageSize);
	}
	/**
	 * 友情链接模糊查询
	 * @param Links 
	 * @param start 开始条数
	 * @param pageSize 每页显示条数
	 * @return List 集合：Links
	 */
	public List<Links> searchLinks(Links links, int start, int pageSize){
		return linksDao.searchLinks(links, start, pageSize);
	}
	/**
	 * 模糊查询 获取友情链接的总条数
	 * @param Links
	 * @return int : 总条数
	 */
	public int totalCount(Links links){
		return linksDao.totalCount(links);
	}
	/**
	 * 友情链接添加
	 * @param links
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public void addLinks(Links links){
		linksDao.addLinks(links);
	}
	/**
	 * 友情链接修改前查询id
	 * @param links 对象
	 * @return Links 对象
	 */
	public Links findLinksById(Links links){
		return linksDao.findLinksById(links);
	}
	/**
	 * 友情链接修改
	 * @param links 对象
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public void updateLinks(Links links){
		linksDao.updateLinks(links);
	}
	/**
	 * 友情链接修改删除
	 * @param links
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteLinks(Links links){
		linksDao.deleteLinks(links);
	}
}
