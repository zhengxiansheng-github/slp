package com.slp.dao;

import java.util.List;

import com.slp.bean.Services;

public interface ServicesDao {
	/**
	 * 获取所有服务信息
	 * @return List<Services>
	 */
	public List<Services> findAllServices();
	/**
	 * 查询服务总条数
	 * @return int
	 */ 
	public int totalCount();
	/**
	 * 后台显示服务 列表
	 * @param start
	 * @param pageSize
	 * @return List<Services>
	 */ 
	public List<Services> findServicesList(int start, int pageSize);
	/**
	 * 模糊查询 查询之后显示列表
	 * @param services 对象
	 * @param start 开始条数
	 * @param pageSize 每页显示条数
	 * @return List<Services>
	 */
	public List<Services> searchServicesList(Services services, int start, int pageSize);
	/**
	 * 模糊查询 查询之后的总条数
	 * @param services
	 * @return
	 */
	public int totalCount(Services services);
	/**
	 * 添加服务
	 * @param services
	 */
	public void addServices(Services services);
	/**
	 * 修改前根据id查询 并 跳转到修改界面
	 * @param services
	 * @return Services
	 */
	public Services findServicesById(Services services);
	/**
	 * 修改
	 * @param services
	 */
	public void updateServices(Services services);
	/**
	 * 删除服务
	 * @param services
	 */
	public void deleteServices(Services services);
}
