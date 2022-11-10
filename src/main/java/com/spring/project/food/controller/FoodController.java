package com.spring.project.food.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface FoodController {
	public String restaurant(HttpServletRequest request, HttpServletResponse response) throws Exception; 
	public String cafe(HttpServletRequest request, HttpServletResponse response) throws Exception; 
}
