package com.icss.ssm.dao;

import java.util.List;

import com.icss.ssm.entity.Rights;

public interface RightsDao {

	public List<Rights> findAllRights();//查询所有权限
	
	public List<Rights> findAllUserRights(int roleId);//查询用户的权限列表
	public List<Rights> findAllRightsByPId(String parent_id);//分层查询所有权限
}
