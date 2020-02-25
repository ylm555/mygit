package com.icss.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class UrlController {

	@RequestMapping("url.do")
	public String urlSet(String url){
		return url;
	}
}
