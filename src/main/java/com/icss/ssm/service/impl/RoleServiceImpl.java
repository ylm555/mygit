package com.icss.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.icss.ssm.dao.RoleDao;
import com.icss.ssm.entity.Role;
import com.icss.ssm.service.RoleService;
import com.icss.ssm.util.Log;
@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;
	@Override
	public List<Role> findAllRoleName() throws Exception {
		List<Role> list =null;
		try {
			list =roleDao.findAllRole();
		} catch (Exception e) {
			e.printStackTrace();
			Log.info("查询所有角色信息出现异常："+e.getMessage());
			throw new Exception("查询所有角色信息出现异常");
		}
		return list;
	}
	@Override
	public List<Role> findAllRole(int pageNum,int pageSize) throws Exception {
		List<Role> list =null;
		try {
			PageHelper.startPage(pageNum, pageSize);
			list =roleDao.findAllRole();
		} catch (Exception e) {
			e.printStackTrace();
			Log.info("分页查询所有角色信息出现异常："+e.getMessage());
			throw new Exception("分页查询所有角色信息出现异常");
		}
		return list;
	}
	@Override
	public Role findRoleById(int id) throws Exception {
		Role role =null;
		try {
			role =roleDao.findRoleById(id);
		} catch (Exception e) {
			e.printStackTrace();
			Log.info("查询角色详情出现异常："+e.getMessage());
			throw new Exception("查询角色详情出现异常");
		}
		return role;
	}
	@Override
	public int saveRole_Rights(int roleId, String rightsId) throws Exception {
		int row =0;
		//原有权限处理
		try {
			row=roleDao.saveRole_Rights(roleId, rightsId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.info("分配权限出现异常："+e.getMessage());
			throw new Exception("分配权限出现异常");
		}
		
		return 0;
	}
	

}
