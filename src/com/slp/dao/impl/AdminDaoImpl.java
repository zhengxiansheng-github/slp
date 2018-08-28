package com.slp.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.slp.bean.Admin;
import com.slp.bean.SiteInfo;
import com.slp.dao.AdminDao;

@Repository("adminDao")
public class AdminDaoImpl extends HibernateDaoSupport implements AdminDao {
	
	@Resource(name="sessionFactory")
	public void setHibernateDaoSupport(SessionFactory sessionFactory){
		this.setSessionFactory(sessionFactory);
	}
	
	//登录
	public Admin login(Admin admin) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Admin.class);
		detachedCriteria.add(Restrictions.eq("adminName", admin.getAdminName()));
		detachedCriteria.add(Restrictions.eq("password", admin.getPassword()));
		List<Admin> userList = (List<Admin>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
		return userList!=null&&userList.size()>0?userList.get(0):null;
	}
	/**
	 * 获取管理员的总条数
	 * @return int : 总条数
	 */
	public int totalCount(){
		return this.getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			public Integer doInHibernate(Session session) throws HibernateException {
				String hql = "select count(admin) from Admin as admin";
				Query query = session.createQuery(hql);
				return Integer.parseInt(query.uniqueResult().toString());
			}
		});
	}
	/**
	 * 管理员列表并实现分页
	 * @param start 开始条数
	 * @param pageSize 每页显示条数
	 * @return List 集合：Admin
	 */
	public List<Admin> findAdminList(int start, int pageSize){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Admin.class);
		return (List<Admin>) this.getHibernateTemplate().findByCriteria(detachedCriteria, start, pageSize);
	}
	/**
	 * 管理员模糊查询
	 * @param admin 
	 * @param start 开始条数
	 * @param pageSize 每页显示条数
	 * @return List 集合：Admin
	 */
	public List<Admin> searchAdmin(Admin admin, int start, int pageSize){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Admin.class);
		detachedCriteria.add(Restrictions.like("adminName", admin.getAdminName(), MatchMode.ANYWHERE));
		detachedCriteria.addOrder(Order.asc("id"));
		return (List<Admin>) this.getHibernateTemplate().findByCriteria(detachedCriteria, start, pageSize);
	}
	/**
	 * 模糊查询 获取管理员的总条数
	 * @param admin
	 * @return int : 总条数
	 */
	public int totalCount(Admin admin){
		return this.getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			public Integer doInHibernate(Session session) throws HibernateException {
				String hql = "select count(admin) from Admin as admin where admin.adminName like '%"+admin.getAdminName()+"%'";
				Query query = session.createQuery(hql);
				return Integer.parseInt(query.uniqueResult().toString());
			}
		});
	}
	/**
	 * 添加管理员
	 * @param admin
	 */
	public void addAdmin(Admin admin, String repassword){
		if(admin.getPassword().equals(repassword)){
			this.getHibernateTemplate().save(admin);
		}else{
			System.out.println("两次输入的不一样");
		}
	}
	/**
	 * 删除管理员
	 * @param admin
	 */
	public void deleteAdmin(Admin admin){
		this.getHibernateTemplate().delete(admin);
	}
	/**
	 * 管理员修改前查询id
	 * @param admin对象
	 * @return Admin对象
	 */
	public Admin findAdminById(Admin admin){
		return this.getHibernateTemplate().get(Admin.class, admin.getId());
	}
	/**
	 * 管理员修改
	 * @param admin对象
	 */
	public void updateAdmin(Admin admin, String repassword){
		if(admin.getPassword().equals(repassword)){
			this.getHibernateTemplate().update(admin);
		}else{
			System.out.println("两次输入的不一样");
		}
	}
}
