package com.icss.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.icss.ssm.entity.User;
/**
 * 用户数据层
 * @author Administrator
 *
 */
public interface UserDao {

	public List<User> findAllUser();//查询所有用户信息
	public User LoginUser(String username,String password);//登录
	
	public User findUserById(int id);//查询用户信息
	public int updateUserRole(int id,int roleId);//分配角色
	
	@Update("UPDATE user SET faceurl=#{faceUrl},facepath=#{facepath} WHERE id=#{id}")
	public void updateFaceUrlById(@Param("id")Integer userId,@Param("faceUrl") String faceUrl,@Param("facepath") String facepath);
	@Select("select * from user")
	public List<User> findAllUserList();
}
