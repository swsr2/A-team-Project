package com.spring.project.main;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MainControllerImpl implements MainController{

	@Override
	@RequestMapping(value="/main", method= {RequestMethod.GET, RequestMethod.POST})
	public String main(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "/main/main";
	}

	@RequestMapping(value="/main/introduce")
	public String introduce(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "/main/introduce";
	}

}



