package com.icss.ssm.service;

import java.util.List;

import com.icss.ssm.entity.Rights;

public interface RightsService {

	public List<Rights> findAllRights() throws Exception;//查询所有权限
	public List<Rights> findAllUserRights(int roleId) throws Exception;//查询用户的权限列表

	public List<Rights> findAllRightsByPId(String parent_id) throws Exception;//分层查询所有权限

}
