package com.spring.project.food.controller;

// import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.project.food.dto.FoodDTO;
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
	
	@Override
	@RequestMapping("/cafe")
	public String cafe(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
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
	@RequestMapping("/resDetail/myReview")
	public String myReview(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return "/food/review";
	}

	/* 
	@Override
	@RequestMapping(value="/resDetail/myPick", method=RequestMethod.POST)
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
