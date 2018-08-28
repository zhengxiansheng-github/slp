package com.slp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.slp.bean.Services;
import com.slp.dao.ServicesDao;
import com.slp.service.ServicesService;

@Service("servicesService")
public class ServicesServiceImpl implements ServicesService {
	@Resource
	private ServicesDao servicesDao;
	/**
	 * 获取所有服务信息
	 * @return List<Services>
	 */
	public List<Services> findAllServices() {
		return servicesDao.findAllServices();
	}
	/**
	 * 查询服务总条数
	 * @return int
	 */ 
	public int totalCount(){
		return servicesDao.totalCount();
	}
	/**
	 * 后台显示服务 列表
	 * @param start
	 * @param pageSize
	 * @return List<Services>
	 */ 
	public List<Services> findServicesList(int start, int pageSize){
		return servicesDao.findServicesList(start, pageSize);
	}
	/**
	 * 模糊查询 查询之后显示列表
	 * @param services 对象
	 * @param start 开始条数
	 * @param pageSize 每页显示条数
	 * @return List<Services>
	 */
	public List<Services> searchServicesList(Services services, int start, int pageSize){
		return servicesDao.searchServicesList(services, start, pageSize);
	}
	/**
	 * 模糊查询 查询之后的总条数
	 * @param services
	 * @return
	 */
	public int totalCount(Services services){
		return servicesDao.totalCount(services);
	}
	/**
	 * 添加服务
	 * @param services
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public void addServices(Services services){
		servicesDao.addServices(services);
	}
	/**
	 * 修改前根据id查询 并 跳转到修改界面
	 * @param services
	 * @return Services
	 */
	public Services findServicesById(Services services){
		return servicesDao.findServicesById(services);
	}
	/**
	 * 修改
	 * @param services
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public void updateServices(Services services){
		servicesDao.updateServices(services);
	}
	/**
	 * 删除服务
	 * @param services
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteServices(Services services){
		servicesDao.deleteServices(services);
	}
}
