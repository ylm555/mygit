package com.icss.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.icss.ssm.dao.UserDao;
import com.icss.ssm.entity.User;
import com.icss.ssm.service.UserService;
import com.icss.ssm.util.Log;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	@Override
	public List<User> findAllUser(int pageNum,int pageSize) throws Exception {
		List<User> list =null;
		try {
			PageHelper.startPage(pageNum, pageSize);
			list =userDao.findAllUser();
		} catch (Exception e) {
			e.printStackTrace();
			Log.info("查询所有用户信息出现异常："+e.getMessage());
			throw new Exception("查询所有用户信息出现异常");
		}
		return list;
	}
	@Override
	public User LoginUser(String username,String password) throws Exception {
		User user =null;
		try {
			user=userDao.LoginUser(username, password);
		} catch (Exception e) {
			e.printStackTrace();
			Log.info("登录出现异常："+e.getMessage());
			throw new Exception("登录出现异常");
		}
		return user;
	}
	@Override
	public User findUserById(int id) throws Exception {
		User user =null;
		try {
			user =userDao.findUserById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.info("查询用户详情信息出现异常："+e.getMessage());
			throw new Exception("查询用户详情信息出现异常");
		}
		return user;
	}
	@Override
	public int updateUserRole(int id, int roleId) throws Exception {
		int row =0;
		try {
			row=userDao.updateUserRole(id, roleId);
		} catch (Exception e) {
			e.printStackTrace();
			Log.info("分配角色出现异常："+e.getMessage());
			throw new Exception("分配角色出现异常");
		}
		return row;
	}
	@Override
	public void updateFaceUrlById(Integer userId, String urlPath, String path) throws Exception {
		try {
			userDao.updateFaceUrlById(userId,urlPath,path);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
		
	}
	@Override
	public List<User> findAllUserList() throws Exception {
		List<User> list = null;
		try {
			list = userDao.findAllUserList();
		} catch (Exception e) {
			e.printStackTrace();
			Log.info("查询所有用户信息出现异常:"+e.getMessage());
			throw new Exception("查询所有用户信息出现异常");
		}
		return list;
	}

}
