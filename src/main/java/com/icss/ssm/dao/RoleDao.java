package com.icss.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.icss.ssm.entity.Role;

public interface RoleDao {

	@Select("select * from role")
	public List<Role> findAllRole();//查询所有的角色名称
	
	@Select("select * from role where id=#{id}")
	public Role findRoleById(int id);
	
	@Select("insert into role_rights(role_id,rights_id) values(#{0},#{1})")
	public int saveRole_Rights(int roleId,String rightsId);//分配权限
}
