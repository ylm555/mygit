package com.icss.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.icss.ssm.entity.Role;
import com.icss.ssm.service.RoleService;
import com.icss.ssm.util.PageBean;

@Controller
public class RoleController {

	@Autowired
	private RoleService roleService;
	@RequestMapping("/findAllRoleName.do")
	public String findAllRoleName(Model model){
		try {
			List<Role> list =roleService.findAllRoleName();
			model.addAttribute("roleList", list);
		
		} catch (Exception e) {
			return "error";
		}
		return "fpRole";
	}
	
	@RequestMapping("/findAllRole.do")
	public String findAllRole(Model model,@RequestParam(value="pageNum",required=false,defaultValue="1")int pageNum){
		List<Role> list =null;
		try {
			list =roleService.findAllRole(pageNum, 5);
			PageBean pageBean =new PageBean(list);
			model.addAttribute("pageBean", pageBean);
		
		} catch (Exception e) {
			return "error";
		}
		return "roleAll";
	}
	
	@RequestMapping("/findRoleById.do")
	public String findRoleById(int id,Model model){
		Role role =null;
		try {
			role=roleService.findRoleById(id);
			model.addAttribute("role", role);
		} catch (Exception e) {
			return "error";
		}
		return "forward:findAllRightsName.do";
	}
	
	@RequestMapping("/saveRole_Rights.do")
	public String saveRole_Rights(int roleId,String rightsId){
		int row =0;
		try {
			row=roleService.saveRole_Rights(roleId, rightsId);
		} catch (Exception e) {
			return "error";
		}
		return "main";
	}
}
