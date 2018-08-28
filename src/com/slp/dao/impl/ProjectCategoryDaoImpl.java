package com.slp.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.slp.bean.ProjectCategory;
import com.slp.dao.ProjectCategoryDao;
import com.slp.util.Tool;

@Repository("projectCategoryDao")
public class ProjectCategoryDaoImpl extends Tool implements ProjectCategoryDao {

	/**
	 * 获取案例分类的总条数
	 * @return int : 总条数
	 */
	public int totalCount(){
		return this.getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			public Integer doInHibernate(Session session) throws HibernateException {
				String hql = "select count(projectCategory) from ProjectCategory as projectCategory";
				Query query = session.createQuery(hql);
				return Integer.parseInt(query.uniqueResult().toString());
			}
		});
	}
	/**
	 * 列表出所有案例分类并分页
	 * @param start
	 * @param pageSize
	 * @return List<ProjectCategory>
	 */
	public List<ProjectCategory> findProjectCategory(int start, int pageSize) {
		return (List<ProjectCategory>) this.getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(ProjectCategory.class), start, pageSize);
	}
	/**
	 * 添加案例分类
	 * @param projectCategory
	 */
	public void addProjectCategory(ProjectCategory projectCategory){
		this.getHibernateTemplate().save(projectCategory);
	}
	
	/**
	 * 获取所有案例分类信息 
	 * @return List<ProjectCategory>
	 */
	public List<ProjectCategory> findAllProjectCategory(){
		return (List<ProjectCategory>) this.getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(ProjectCategory.class));
	}
	/**
	 * 修改案例分类信息 前根据id查询
	 * @param projectCategory
	 * @return ProjectCategory
	 */
	public ProjectCategory findProjectCategoryById(ProjectCategory projectCategory){
		return this.getHibernateTemplate().get(ProjectCategory.class, projectCategory.getId());
	}
	/**
	 * 修改案例分类信息
	 * @param projectCategory
	 */
	public void updateProjectCategory(ProjectCategory projectCategory){
		this.getHibernateTemplate().update(projectCategory);
	}
	/**
	 * 删除案例分类信息
	 * @param projectCategory
	 */
	public void deleteProjectCategory(ProjectCategory projectCategory){
		this.getHibernateTemplate().delete(projectCategory);
	}
}
