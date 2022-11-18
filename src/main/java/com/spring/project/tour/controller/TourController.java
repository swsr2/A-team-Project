package com.spring.project.tour.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;


public interface TourController {
	public String tourmain(@RequestParam("page") int page, HttpServletRequest request, HttpServletResponse response) throws Exception; 
	public String orumm(@RequestParam("page") int page, HttpServletRequest request, HttpServletResponse response) throws Exception; 
	public String beach(@RequestParam("page") int page, HttpServletRequest request, HttpServletResponse response) throws Exception; 
	// public ModelAndView resDetail(@RequestParam("fd_no") int fd_no, HttpServletRequest request, HttpServletResponse response) throws Exception; 
	// public void myPick(@RequestParam("fd_no") int fd_no, HttpServletRequest request, HttpServletResponse response) throws Exception; 
	// public String myReview(HttpServletRequest request, HttpServletResponse response) throws Exception; 
	// public void addReview(@ModelAttribute("review") ReviewDTO review, HttpServletRequest request, HttpServletResponse response) throws Exception;
	// public ModelAndView myPick(@RequestParam("fd_no") int fd_no,@RequestParam("pick") boolean pick,
	//		HttpServletRequest request, HttpServletResponse response) throws Exception;
}

