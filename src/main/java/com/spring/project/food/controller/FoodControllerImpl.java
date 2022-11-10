package com.spring.project.food.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.project.food.service.FoodService;

@Controller("foodController")
@RequestMapping("/food")
public class FoodControllerImpl implements FoodController {
	@Autowired
	FoodService foodService;
	
	@Override
	@RequestMapping("/main")
	public String restaurant(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return "/food/foodmain";
	}

	@RequestMapping("/cafe")
	public String cafe(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return "/food/cafe";
	}
	
}
