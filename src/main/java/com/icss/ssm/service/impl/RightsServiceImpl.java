package com.icss.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icss.ssm.dao.RightsDao;
import com.icss.ssm.entity.Rights;
import com.icss.ssm.service.RightsService;
import com.icss.ssm.util.Log;
@Service
public class RightsServiceImpl implements RightsService {

	@Autowired
	private RightsDao rightsDao;
	@Override
	public List<Rights> findAllRights() throws Exception {
		List<Rights> list =null;
		try {
			list=rightsDao.findAllRights();
		} catch (Exception e) {
			e.printStackTrace();
			Log.info("查询所有权限失败："+e.getMessage());
			throw new Exception("查询所有权限失败");
		}
		return list;
	}
	@Override
	public List<Rights> findAllUserRights(int roleId) throws Exception {
		List<Rights> list =null;
		try {
			list=rightsDao.findAllUserRights(roleId);
		} catch (Exception e) {
			e.printStackTrace();
			Log.info("查询用户的权限列表失败："+e.getMessage());
			throw new Exception("查询用户的权限列表失败");
		}
		return list;
	}
	@Override
	public List<Rights> findAllRightsByPId(String parent_id) throws Exception {
		List<Rights> firstList =null;
		try {
			firstList=rightsDao.findAllRightsByPId(parent_id);//一级菜单权限列表
			if(firstList!=null && firstList.size()>0){
				for(Rights firstRights:firstList){
					List<Rights> secList =rightsDao.findAllRightsByPId(firstRights.getId());//二级菜单权限列表
					firstRights.setSubRightsList(secList);//设置一级菜单子列表
					if(secList!=null && secList.size()>0){
						for (Rights secRights : secList) {
							List<Rights> thirdList =rightsDao.findAllRightsByPId(secRights.getId());//三级菜单权限列表
							secRights.setSubRightsList(thirdList);//设置二级菜单子列表
						}
					}
				}
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			Log.info("分层查询用户的权限列表失败："+e.getMessage());
			throw new Exception("分层查询用户的权限列表失败");
		}
		return firstList;
	}


}
