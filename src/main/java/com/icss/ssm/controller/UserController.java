package com.icss.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icss.ssm.entity.User;
import com.icss.ssm.service.UserService;
import com.icss.ssm.util.PageBean;


@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping("/findAllUser.do")
	public String findAllUser(@RequestParam(value="pageNum",required=false,defaultValue="1")int pageNum, Model model){
		List<User> list =null;
		try {
			int pageSize =5;//每页显示记录数
			list =userService.findAllUser(pageNum,pageSize);
			PageBean pageBean =new PageBean(list);
			model.addAttribute("pageBean",pageBean );
		} catch (Exception e) {
			return "error";
		}
		return "userAll";
	}
	
	@RequestMapping("/LoginUser.do")
	public String LoginUser(String username,String pwd,HttpServletRequest request){
		User user=null;
		try {
			user=userService.LoginUser(username, pwd);
			request.getSession().setAttribute("user", user);
		} catch (Exception e) {
			return "error";
		}
		if(user==null){
			request.setAttribute("msg","用户名或密码错误");
			return "forward:index.jsp";
		}
		if(user.getRole_id()==0){
			request.setAttribute("msg", "该用户没有权限");
			return "forward:index.jsp";
		}
		return "forward:findAllUserRights.do?roleId="+user.getRole_id();
		
		
			
		
	}
	
	@RequestMapping("/findUserById.do")
	public String findUserById(int id,Model model){
		User user =null;
		try {
			user =userService.findUserById(id);
			model.addAttribute("user", user);
		} catch (Exception e) {
			return "error";
		}
		return "forward:findAllRoleName.do";
	}
	
	@RequestMapping("/updateUserRole.do")
	@ResponseBody
	public String updateUserRole(int id,int roleId){
		int row=0;
		try {
			row=userService.updateUserRole(id, roleId);
		} catch (Exception e) {
			return "error";
		}
		String msg="成功分配权限";
		if(row==0){
			msg="分配权限失败";
		}
		return msg;
	}
}
