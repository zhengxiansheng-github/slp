package com.slp.service;

import java.util.List;

import com.slp.bean.Team;

public interface TeamService {
	
	/**
	 * 获取团队信息的总条数
	 * @return int : 总条数
	 */
	public int totalCount();
	/**
	 * 获取团队信息并分页
	 * @param start
	 * @param pageSize
	 * @return List<Team>
	 */
	public List<Team> findTeam(int start, int pageSize);
	/**
	 * 通过团队编号获取单个团队对象
	 * @param id编号
	 * @return Team 对象
	 */
	public Team findTeamById(int id);
	/**
	 * 更新团队信息
	 * @param team 对象
	 */
	public void updateTeam(Team team);
	/**
	 * 更新团队信息前查询id
	 * @param team 对象
	 * @return Team 对象
	 */
	public Team findTeamById(Team team);
	/**
	 * 团队信息模糊查询
	 * @param team 
	 * @param start 开始条数
	 * @param pageSize 每页显示条数
	 * @return List 集合：Team
	 */
	public List<Team> searchTeam(Team team, int start, int pageSize);
	/**
	 * 模糊查询 获取团队信息的总条数
	 * @param team
	 * @return int : 总条数
	 */
	public int totalCount(Team team);
	/**
	 * 添加团队信息
	 * @param team
	 */
	public void addTeam(Team team);
	/**
	 * 删除团队信息
	 * @param team
	 */
	public void deleteTeam(Team team);
}
