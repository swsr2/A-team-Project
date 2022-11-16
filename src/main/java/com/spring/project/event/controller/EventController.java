package com.spring.project.event.controller;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.project.event.dto.AirplaneDTO;



public interface EventController {
	public String airport(HttpServletRequest request, HttpServletResponse response) throws Exception; 
	public String lodging(HttpServletRequest request, HttpServletResponse response) throws Exception; 
	//public ModelAndView airDetail(@RequestParam("date") String date, HttpServletRequest request, HttpServletResponse response) throws Exception; 
	public ModelAndView airDetail(@ModelAttribute("air") AirplaneDTO air, HttpServletRequest request, HttpServletResponse response) throws Exception; 
	// public String myReview(HttpServletRequest request, HttpServletResponse response) throws Exception; 
	// public void addReview(@ModelAttribute("review") ReviewDTO review, HttpServletRequest request, HttpServletResponse response) throws Exception;
}

