package com.icss.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.icss.ssm.entity.Rights;
import com.icss.ssm.service.RightsService;
@Controller
public class RightsController {

	@Autowired
	private RightsService rightsService;
	
	@RequestMapping("/findAllRightsName.do")
	public String findAllRights(Model model){
//		List<Rights> list =null;
//		try {
//			list =rightsService.findAllRights();
//			model.addAttribute("rightsList", list);
//		} catch (Exception e) {
//			return "error";
//		}
		List<Rights> list =null;
		try {
			list =rightsService.findAllRightsByPId("-1");
			model.addAttribute("rightsList", list);
		} catch (Exception e) {
			return "error";
		}
		return "fpRight";
	}
	
	@RequestMapping("/findAllUserRights.do")
	public String findAllUserRights(int roleId,Model model,HttpServletRequest request){
		List<Rights> list =null;
		try {
			list =rightsService.findAllUserRights(roleId);
			if(list!=null && list.size()>0){
				request.getSession().setAttribute("rightsList", list);
			}else{
				model.addAttribute("msg", "该用户没有权限");
				return "forward:index.jsp";
			}
			
		} catch (Exception e) {
			return "error";
		}
		return "main";
	}
}
