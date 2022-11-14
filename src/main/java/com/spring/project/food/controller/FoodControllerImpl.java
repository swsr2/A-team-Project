package com.spring.project.food.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.project.food.dto.FoodDTO;
import com.spring.project.food.dto.ReviewDTO;
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
		// 테스트 하실때 공유드라이브에 api 받아오기 텍스트 파일안 내용을 요기다 넣고 한번 돌리시면
		// api 내용이 db에 저장이 될 겁니다 db에서 테이블 이랑 시퀀스 만들고 돌려주세요

		List<FoodDTO> foodList = foodService.foodList();
		request.setAttribute("foodList", foodList);
		return "/food/foodmain";
	}
	
	@Override
	@RequestMapping("/cafe")
	public String cafe(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		List<FoodDTO> cafeList = foodService.cafeList();
		request.setAttribute("cafeList", cafeList);
		return "/food/cafe";
	}

	@Override
	@RequestMapping("/resDetail")
	public ModelAndView resDetail(@RequestParam("fd_no") int fd_no, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		FoodDTO food = foodService.selectOne(fd_no);
		
		String viewName = (String) request.getAttribute("viewName");
		
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("food", food);
		
		return mav;
	}

	@Override
	@RequestMapping("/myReview")
	public String myReview(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		return "/food/reviewForm";
	}

	@Override
	@RequestMapping(value="/addReview", method=RequestMethod.POST)
	public void addReview(@ModelAttribute("review") ReviewDTO review, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		System.out.println(review.getRe_content());
		int result = foodService.addReview(review);
		
		PrintWriter out = response.getWriter();
		out.println("<script>");
		if(result == 1) {
			out.println("alert('리뷰등록이 완료 되었습니다. 작성하신 리뷰는 [마이페이지 > 나의 리뷰보기]에서 확인하실 수 있습니다.')");
		} else {
			out.println("alert('리뷰가 등록되지 않았습니다.');");
		}
		out.println("location.href='"+ request.getContextPath() +"/food/resDetail?fd_no=1';");
		out.println("</script>");
		
		
	}

	/* 
	@Override
	@RequestMapping(value="/myPick", method=RequestMethod.POST)
	public void myPick(@RequestParam("fd_no") int fd_no, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
			response.setContentType("text/html;charset=utf-8");
			
			int result = foodService.myPick(fd_no);
			
			PrintWriter out = response.getWriter();
			out.println("<script>");
			if(result == 1) {
				out.println("alert('찜하기가 완료되었습니다! 찜 리스트는 ‘마이페이지 > 나의 여행일정’에서 확인하실 수 있습니다.');");
				out.println("location.href='"+ request.getContextPath() +"/food/resDetail';");
			} else {
				out.println("alert('찜하기를 다시 시도해주세요.');");
				// out.println("location.href='"+ request.getContextPath() +"/food/resDetail?fd_no="+food.getFd_no()+"';");
			}
			out.println("</script>");
	}
	*/
	
	
	
	
}
