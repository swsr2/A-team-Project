package com.spring.project.activity.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;

public interface ActivityController {
	public String activity(@RequestParam("page") int page, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public String crs(@RequestParam("page") int page, HttpServletRequest request, HttpServletResponse response) throws Exception;
//	public String myReview(HttpServletRequest request, HttpServletResponse response) throws Exception; 

	
}
