package com.slp.service;

import java.util.List;

import com.slp.bean.Links;

public interface LinksService {
	/**
	 * 获取所有的友情链接
	 * @return List<Links>
	 */
	public List<Links> findAllLinks();
	/**
	 * 获取友情链接的总条数
	 * @return int : 总条数
	 */
	public int totalCount();
	/**
	 * 友情链接列表并实现分页
	 * @param start 开始条数
	 * @param pageSize 每页显示条数
	 * @return List 集合：Links
	 */
	public List<Links> findlinksList(int start, int pageSize);
	/**
	 * 友情链接模糊查询
	 * @param Links 
	 * @param start 开始条数
	 * @param pageSize 每页显示条数
	 * @return List 集合：Links
	 */
	public List<Links> searchLinks(Links links, int start, int pageSize);
	/**
	 * 模糊查询 获取友情链接的总条数
	 * @param Links
	 * @return int : 总条数
	 */
	public int totalCount(Links links);
	/**
	 * 友情链接添加
	 * @param links
	 */
	public void addLinks(Links links);
	/**
	 * 友情链接修改前查询id
	 * @param links 对象
	 * @return Links 对象
	 */
	public Links findLinksById(Links links);
	/**
	 * 友情链接修改
	 * @param links 对象
	 */
	public void updateLinks(Links links);
	/**
	 * 友情链接修改删除
	 * @param links
	 */
	public void deleteLinks(Links links);
}
