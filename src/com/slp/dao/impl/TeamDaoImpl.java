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
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.slp.bean.SiteInfo;
import com.slp.bean.Team;
import com.slp.dao.TeamDao;
import com.slp.util.Tool;

@Repository("teamDao")
public class TeamDaoImpl extends Tool implements TeamDao {
	
	/**
	 * 获取团队信息的总条数
	 * @return int : 总条数
	 */
	public int totalCount() {
		return this.getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			public Integer doInHibernate(Session session) throws HibernateException {
				String hql = "select count(team) from Team as team";
				Query query = session.createQuery(hql);
				return Integer.parseInt(query.uniqueResult().toString());
			}
		});
	}
	/**
	 * 获取团队信息并分页
	 * @param start
	 * @param pageSize
	 * @return List<Team>
	 */
	public List<Team> findTeam(int start, int pageSize){
		return (List<Team>) this.getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(Team.class), start, pageSize);
	}
	/**
	 * 通过团队编号获取单个团队对象
	 * @param id编号
	 * @return Team 对象
	 */
	public Team findTeamById(int id){
		return this.getHibernateTemplate().get(Team.class, id);
	}
	/**
	 * 更新团队信息
	 * @param team 对象
	 */
	public void updateTeam(Team team){
		this.getHibernateTemplate().merge(team);
	}
	/**
	 * 更新团队信息前查询id
	 * @param team 对象
	 * @return Team 对象
	 */
	public Team findTeamById(Team team){
		return this.getHibernateTemplate().get(Team.class, team.getId());
	}
	/**
	 * 团队信息模糊查询
	 * @param team 
	 * @param start 开始条数
	 * @param pageSize 每页显示条数
	 * @return List 集合：Team
	 */
	public List<Team> searchTeam(Team team, int start, int pageSize){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Team.class);
		detachedCriteria.add(Restrictions.like("name", team.getName(), MatchMode.ANYWHERE));
		detachedCriteria.addOrder(Order.asc("id"));
		return (List<Team>) this.getHibernateTemplate().findByCriteria(detachedCriteria, start, pageSize);
	}
	/**
	 * 模糊查询 获取团队信息的总条数
	 * @param team
	 * @return int : 总条数
	 */
	public int totalCount(Team team){
		return this.getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			public Integer doInHibernate(Session session) throws HibernateException {
				String hql = "select count(team) from Team as team where team.name like '%"+team.getName()+"%'";
				Query query = session.createQuery(hql);
				return Integer.parseInt(query.uniqueResult().toString());
			}
		});
	}
	/**
	 * 添加团队信息
	 * @param team
	 */
	public void addTeam(Team team){
		this.getHibernateTemplate().save(team);
	}
	/**
	 * 删除团队信息
	 * @param team
	 */
	public void deleteTeam(Team team){
		this.getHibernateTemplate().delete(team);
	}
}
