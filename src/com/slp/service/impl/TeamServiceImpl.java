package com.slp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.slp.bean.Team;
import com.slp.dao.TeamDao;
import com.slp.service.TeamService;

@Service("teamService")
public class TeamServiceImpl implements TeamService {
	
	@Resource
	private TeamDao teamDao;
	/**
	 * 获取团队信息的总条数
	 * @return int : 总条数
	 */
	public int totalCount() {
		return teamDao.totalCount();
	}
	/**
	 * 获取团队信息并分页
	 * @param start
	 * @param pageSize
	 * @return List<Team>
	 */
	public List<Team> findTeam(int start, int pageSize){
		return teamDao.findTeam(start, pageSize);
	}
	/**
	 * 通过团队编号获取单个团队对象
	 * @param id编号
	 * @return Team 对象
	 */
	public Team findTeamById(int id){
		return teamDao.findTeamById(id);
	}
	/**
	 * 更新团队信息
	 * @param team 对象
	 */
	//spring 有几种传播特性：REQUIRED REQUIRES_NEW SUPPORTS NOT_SUPPORTED MANDATORY NEVER NESTED
	@Transactional(propagation=Propagation.REQUIRED)
	public void updateTeam(Team team){
		teamDao.updateTeam(team);
	}
	/**
	 * 更新团队信息前查询id
	 * @param team 对象
	 * @return Team 对象
	 */
	public Team findTeamById(Team team){
		return teamDao.findTeamById(team);
	}
	/**
	 * 团队信息模糊查询
	 * @param team 
	 * @param start 开始条数
	 * @param pageSize 每页显示条数
	 * @return List 集合：Team
	 */
	public List<Team> searchTeam(Team team, int start, int pageSize){
		return teamDao.searchTeam(team, start, pageSize);
	}
	/**
	 * 模糊查询 获取团队信息的总条数
	 * @param team
	 * @return int : 总条数
	 */
	public int totalCount(Team team){
		return teamDao.totalCount(team);
	}
	/**
	 * 添加团队信息
	 * @param team
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public void addTeam(Team team){
		teamDao.addTeam(team);
	}
	/**
	 * 删除团队信息
	 * @param team
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteTeam(Team team){
		teamDao.deleteTeam(team);
	}
}
