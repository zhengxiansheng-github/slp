package com.slp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.slp.bean.ProjectCategory;
import com.slp.dao.ProjectCategoryDao;
import com.slp.service.ProjectCategoryService;

@Service("projectCategoryService")
public class ProjectCategoryServiceImpl implements ProjectCategoryService {
	@Resource
	private ProjectCategoryDao projectCategoryDao;
	/**
	 * 获取案例分类的总条数
	 * @return int : 总条数
	 */
	public int totalCount(){
		return projectCategoryDao.totalCount();
	}
	/**
	 * 列表出所有案例分类并分页
	 * @param start
	 * @param pageSize
	 * @return List<ProjectCategory>
	 */
	public List<ProjectCategory> findProjectCategory(int start, int pageSize) {
		return projectCategoryDao.findProjectCategory(start, pageSize);
	}
	/**
	 * 添加案例分类
	 * @param projectCategory
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public void addProjectCategory(ProjectCategory projectCategory){
		projectCategoryDao.addProjectCategory(projectCategory);
	}
	/**
	 * 获取所有案例分类信息 
	 * @return List<ProjectCategory>
	 */
	public List<ProjectCategory> findAllProjectCategory(){
		return projectCategoryDao.findAllProjectCategory();
	}
	/**
	 * 修改案例分类信息 前根据id查询
	 * @param projectCategory
	 * @return ProjectCategory
	 */
	public ProjectCategory findProjectCategoryById(ProjectCategory projectCategory){
		return projectCategoryDao.findProjectCategoryById(projectCategory);
	}
	/**
	 * 修改案例分类信息
	 * @param projectCategory
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public void updateProjectCategory(ProjectCategory projectCategory){
		projectCategoryDao.updateProjectCategory(projectCategory);
	}
	/**
	 * 删除案例分类信息
	 * @param projectCategory
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteProjectCategory(ProjectCategory projectCategory){
		projectCategoryDao.deleteProjectCategory(projectCategory);
	}
}
