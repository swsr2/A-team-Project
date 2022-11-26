package com.spring.project.mypage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.project.mypage.dto.MyReviewDTO;

public interface MypageReviewController {
	public ModelAndView mypagereview(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception;
}
