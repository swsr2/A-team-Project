package com.spring.project.event.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



public interface EventController {
	public String airport(HttpServletRequest request, HttpServletResponse response) throws Exception; 
	public String lodging(HttpServletRequest request, HttpServletResponse response) throws Exception; 
	public ModelAndView airDetail(@RequestParam("air_no") int air_no, HttpServletRequest request, HttpServletResponse response) throws Exception; 
	// public String myReview(HttpServletRequest request, HttpServletResponse response) throws Exception; 
	// public void addReview(@ModelAttribute("review") ReviewDTO review, HttpServletRequest request, HttpServletResponse response) throws Exception;
}

