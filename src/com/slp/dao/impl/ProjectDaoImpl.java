package com.slp.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.slp.bean.Project;
import com.slp.bean.SiteInfo;
import com.slp.dao.ProjectDao;
import com.slp.util.Tool;

@Repository("projectDao")
public class ProjectDaoImpl extends Tool implements ProjectDao {
	
	/**
	 * 获取案例信息的总条数
	 * @param cateId 案例分类编号
	 * @return int : 总条数
	 */
	public int totalCount(int cateId) {
		return this.getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			public Integer doInHibernate(Session session) throws HibernateException {
				String hql = "select count(project) from Project as project";
				if(cateId>0){
					hql += " where project.projectCategory.id="+cateId;
				}
				Query query = session.createQuery(hql);
				return Integer.parseInt(query.uniqueResult().toString());
			}
		});
	}
	/**
	 * 获取案例信息的总条数
	 * @return int
	 */
	public int totalCount(){
		return this.getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			public Integer doInHibernate(Session session) throws HibernateException {
				String hql = "select count(project) from Project as project";
				Query query = session.createQuery(hql);
				return Integer.parseInt(query.uniqueResult().toString());
			}
		});
	}

	/**
	 * 查询案例并分页
	 * @param start
	 * @param pageSize
	 * @return List<Project>
	 */
	public List<Project> findProject(int start, int pageSize){
		return (List<Project>) this.getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(Project.class), start, pageSize);
	}
	/**
	 * 查询案例并分页
	 * @param cateId 案例分类编号
	 * @param start
	 * @param pageSize
	 * @return List<Project>
	 */
	public List<Project> findProject(int cateId, int start, int pageSize){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Project.class);
		detachedCriteria.add(Restrictions.eq("projectCategory.id", cateId));
		return (List<Project>) this.getHibernateTemplate().findByCriteria(detachedCriteria, start, pageSize);
	}
	/**
	 * 通过id编号获得单个案例信息
	 * @param id
	 * @return Project
	 */
	public Project findProjectById(int id){
		return this.getHibernateTemplate().get(Project.class, id);
	}
	/**
	 * 修改案例前查询
	 * @param project
	 * @return Project
	 */
	public Project findProjectById(Project project){
		return this.getHibernateTemplate().get(Project.class, project.getId());
	}
	/**
	 * 更新案例信息
	 * @param project
	 */
	public void updateProject(Project project){
		this.getHibernateTemplate().update(project);
	}
	/**
	 * 模糊查询案例信息
	 * @param project
	 * @param start 开始条数
	 * @param pageSize 每页显示几条
	 * @return List<Project>
	 */
	public List<Project> searchProject(Project project, int start, int pageSize){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Project.class);
		detachedCriteria.add(Restrictions.like("projectName", project.getProjectName(), MatchMode.ANYWHERE));
		detachedCriteria.addOrder(Order.asc("id"));
		return (List<Project>) this.getHibernateTemplate().findByCriteria(detachedCriteria, start, pageSize);
	}
	/**
	 * 模糊查询 获取案例信息总条数
	 * @param project
	 * @return int
	 */
	public int totalCount(Project project){
		return this.getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			public Integer doInHibernate(Session session) throws HibernateException {
				String hql = "select count(project) from Project as project where project.projectName like '%"+project.getProjectName()+"%'";
				Query query = session.createQuery(hql);
				return Integer.parseInt(query.uniqueResult().toString());
			}
		});
	}
	/**
	 * 添加案例信息
	 * @param project
	 */
	public void addProject(Project project){
		this.getHibernateTemplate().save(project);
	}
	/**
	 * 删除案例信息
	 * @param project
	 */
	public void deleteProject(Project project){
		this.getHibernateTemplate().delete(project);
	}
}
