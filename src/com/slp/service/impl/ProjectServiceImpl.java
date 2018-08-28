package com.slp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.slp.bean.Project;
import com.slp.dao.ProjectDao;
import com.slp.service.ProjectService;

@Service("srojectService")
public class ProjectServiceImpl implements ProjectService {
	
	@Resource
	private ProjectDao projectDao;
	/**
	 * 获取案例信息的总条数
	 * @param cateId 案例分类编号
	 * @return int : 总条数
	 */
	public int totalCount(int cateId) {
		return projectDao.totalCount(cateId);
	}
	/**
	 * 获取案例信息的总条数
	 * @return int
	 */
	public int totalCount(){
		return projectDao.totalCount();
	}
	/**
	 * 查询案例并分页
	 * @param start
	 * @param pageSize
	 * @return List<Project>
	 */
	public List<Project> findProject(int start, int pageSize){
		return projectDao.findProject(start, pageSize);
	}
	/**
	 * 查询案例并分页
	 * @param cateId 案例分类编号
	 * @param start
	 * @param pageSize
	 * @return List<Project>
	 */
	public List<Project> findProject(int cateId, int start, int pageSize){
		return projectDao.findProject(cateId, start, pageSize);
	}
	/**
	 * 通过id编号获得单个案例信息
	 * @param id
	 * @return Project
	 */
	public Project findProjectById(int id){
		return projectDao.findProjectById(id);
	}
	/**
	 * 修改案例前查询
	 * @param project
	 * @return Project
	 */
	public Project findProjectById(Project project){
		return projectDao.findProjectById(project);
	}
	/**
	 * 更新案例信息
	 * @param project
	 */
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void updateProject(Project project){
		projectDao.updateProject(project);
	}
	/**
	 * 模糊查询案例信息
	 * @param project
	 * @param start 开始条数
	 * @param pageSize 每页显示几条
	 * @return List<Project>
	 */
	public List<Project> searchProject(Project project, int start, int pageSize){
		return projectDao.searchProject(project, start, pageSize);
	}
	/**
	 * 模糊查询 获取案例信息总条数
	 * @param project
	 * @return int
	 */
	public int totalCount(Project project){
		return projectDao.totalCount(project);
	}
	/**
	 * 添加案例信息
	 * @param project
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public void addProject(Project project){
		projectDao.addProject(project);
	}
	/**
	 * 删除案例信息
	 * @param project
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteProject(Project project){
		projectDao.deleteProject(project);
	}
}
