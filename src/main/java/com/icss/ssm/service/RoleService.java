package com.icss.ssm.service;

import java.util.List;

import com.icss.ssm.entity.Role;

public interface RoleService {

	public List<Role> findAllRoleName() throws Exception;//查询所有的角色名称(分配角色时角色的展示)


	List<Role> findAllRole(int pageNum, int pageSize) throws Exception;

	public Role findRoleById(int id) throws Exception;//查询角色详情
	public int saveRole_Rights(int roleId,String rightsId) throws Exception;//分配权限

}
