package com.slp.dao;

import java.util.List;

import com.slp.bean.Admin;

public interface AdminDao {
	//登录
	public Admin login(Admin admin);
	/**
	 * 获取管理员的总条数
	 * @return int : 总条数
	 */
	public int totalCount();
	/**
	 * 管理员列表并实现分页
	 * @param start 开始条数
	 * @param pageSize 每页显示条数
	 * @return List 集合：Admin
	 */
	public List<Admin> findAdminList(int start, int pageSize);
	/**
	 * 管理员模糊查询
	 * @param admin 
	 * @param start 开始条数
	 * @param pageSize 每页显示条数
	 * @return List 集合：Admin
	 */
	public List<Admin> searchAdmin(Admin admin, int start, int pageSize);
	/**
	 * 模糊查询 获取管理员的总条数
	 * @param admin
	 * @return int : 总条数
	 */
	public int totalCount(Admin admin);
	/**
	 * 添加管理员
	 * @param admin
	 */
	public void addAdmin(Admin admin, String repassword);
	/**
	 * 删除管理员
	 * @param admin
	 */
	public void deleteAdmin(Admin admin);
	/**
	 * 管理员修改前查询id
	 * @param admin对象
	 * @return Admin对象
	 */
	public Admin findAdminById(Admin admin);
	/**
	 * 管理员修改
	 * @param admin对象
	 */
	public void updateAdmin(Admin admin, String repassword);
}
