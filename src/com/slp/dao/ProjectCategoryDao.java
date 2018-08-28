package com.slp.dao;

import java.util.List;

import com.slp.bean.ProjectCategory;

public interface ProjectCategoryDao {
	/**
	 * 获取案例分类的总条数
	 * @return int : 总条数
	 */
	public int totalCount();
	/**
	 * 列表出所有案例分类并分页
	 * @param start
	 * @param pageSize
	 * @return List<ProjectCategory>
	 */
	public List<ProjectCategory> findProjectCategory(int start, int pageSize);
	/**
	 * 添加案例分类
	 * @param projectCategory
	 */
	public void addProjectCategory(ProjectCategory projectCategory);
	
	/**
	 * 获取所有案例分类信息 
	 * @return List<ProjectCategory>
	 */
	public List<ProjectCategory> findAllProjectCategory();
	/**
	 * 修改案例分类信息 前根据id查询
	 * @param projectCategory
	 * @return ProjectCategory
	 */
	public ProjectCategory findProjectCategoryById(ProjectCategory projectCategory);
	/**
	 * 修改案例分类信息
	 * @param projectCategory
	 */
	public void updateProjectCategory(ProjectCategory projectCategory);
	/**
	 * 删除案例分类信息
	 * @param projectCategory
	 */
	public void deleteProjectCategory(ProjectCategory projectCategory);
}
