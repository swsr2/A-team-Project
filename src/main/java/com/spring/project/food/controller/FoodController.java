package com.spring.project.food.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.project.food.dto.ReviewDTO;

public interface FoodController {
	public String restaurant(HttpServletRequest request, HttpServletResponse response) throws Exception; 
	public String cafe(HttpServletRequest request, HttpServletResponse response) throws Exception; 
	public ModelAndView resDetail(@RequestParam("fd_no") int fd_no, HttpServletRequest request, HttpServletResponse response) throws Exception; 
	// public void myPick(@RequestParam("fd_no") int fd_no, HttpServletRequest request, HttpServletResponse response) throws Exception; 
	public String myReview(HttpServletRequest request, HttpServletResponse response) throws Exception; 
	public void addReview(@ModelAttribute("review") ReviewDTO review, HttpServletRequest request, HttpServletResponse response) throws Exception;
}
