package com.icss.ssm.service;

import java.util.List;

import com.icss.ssm.entity.User;

public interface UserService {

	public List<User> findAllUser(int pageNum,int pageSize) throws Exception;//查询所有用户信息
	public User LoginUser(String username,String password) throws Exception;//登录
	
	public User findUserById(int id) throws Exception;//查询用户信息
	public int updateUserRole(int id,int roleId) throws Exception;//分配角色
	
	public void updateFaceUrlById(Integer userId, String urlPath, String path) throws Exception;

	public List<User> findAllUserList() throws Exception;//查询所有用户信息
}
