package com.slp.service;

import java.util.List;

import com.slp.bean.Project;

public interface ProjectService {
	
	/**
	 * 获取案例信息的总条数
	 * @param cateId 案例分类编号
	 * @return int : 总条数
	 */
	public int totalCount(int cateId);
	/**
	 * 获取案例信息的总条数
	 * @return int
	 */
	public int totalCount();
	/**
	 * 查询案例并分页
	 * @param start
	 * @param pageSize
	 * @return List<Project>
	 */
	public List<Project> findProject(int start, int pageSize);
	/**
	 * 查询案例并分页
	 * @param cateId 案例分类编号
	 * @param start
	 * @param pageSize
	 * @return List<Project>
	 */
	public List<Project> findProject(int cateId, int start, int pageSize);
	/**
	 * 通过id编号获得单个案例信息
	 * @param id
	 * @return Project
	 */
	public Project findProjectById(int id);
	/**
	 * 修改案例前查询
	 * @param project
	 * @return Project
	 */
	public Project findProjectById(Project project);
	/**
	 * 更新案例信息
	 * @param project
	 */
	public void updateProject(Project project);
	/**
	 * 模糊查询案例信息
	 * @param project
	 * @param start 开始条数
	 * @param pageSize 每页显示几条
	 * @return List<Project>
	 */
	public List<Project> searchProject(Project project, int start, int pageSize);
	/**
	 * 模糊查询 获取案例信息总条数
	 * @param project
	 * @return int
	 */
	public int totalCount(Project project);
	/**
	 * 添加案例信息
	 * @param project
	 */
	public void addProject(Project project);
	/**
	 * 删除案例信息
	 * @param project
	 */
	public void deleteProject(Project project);
}
