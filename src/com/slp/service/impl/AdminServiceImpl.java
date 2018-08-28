package com.slp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;
import com.slp.bean.Admin;
import com.slp.dao.AdminDao;
import com.slp.service.AdminService;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
	@Resource
	private AdminDao adminDao;
	/**
	 * 登录
	 */
	public String login(Admin admin) {
		admin = adminDao.login(admin);
		if(admin!=null){
			ActionContext.getContext().getSession().put("admin", admin);
			return "main";
		}
		return "login";
	}
	/**
	 * 获取管理员的总条数
	 * @return int : 总条数
	 */
	public int totalCount(){
		return adminDao.totalCount();
	}
	/**
	 * 管理员列表并实现分页
	 * @param start 开始条数
	 * @param pageSize 每页显示条数
	 * @return List 集合：Admin
	 */
	public List<Admin> findAdminList(int start, int pageSize){
		return adminDao.findAdminList(start, pageSize);
	}
	/**
	 * 管理员模糊查询
	 * @param admin 
	 * @param start 开始条数
	 * @param pageSize 每页显示条数
	 * @return List 集合：Admin
	 */
	public List<Admin> searchAdmin(Admin admin, int start, int pageSize){
		return adminDao.searchAdmin(admin, start, pageSize);
	}
	/**
	 * 模糊查询 获取管理员的总条数
	 * @param admin
	 * @return int : 总条数
	 */
	public int totalCount(Admin admin){
		return adminDao.totalCount(admin);
	}
	/**
	 * 添加管理员
	 * @param admin
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public void addAdmin(Admin admin, String repassword){
		adminDao.addAdmin(admin, repassword);
	}
	/**
	 * 删除管理员
	 * @param admin
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteAdmin(Admin admin){
		adminDao.deleteAdmin(admin);
	}
	/**
	 * 管理员修改前查询id
	 * @param admin对象
	 * @return Admin对象
	 */
	public Admin findAdminById(Admin admin){
		return adminDao.findAdminById(admin);
	}
	/**
	 * 管理员修改
	 * @param admin对象
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public void updateAdmin(Admin admin, String repassword){
		adminDao.updateAdmin(admin, repassword);
	}
}
