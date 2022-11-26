package com.spring.project.mypage.controller;

import java.util.List;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.project.activity.dto.ReviewDTO;
import com.spring.project.member.dto.MemberDTO;
import com.spring.project.mypage.dto.MyReviewDTO;
import com.spring.project.mypage.service.MypageReviewService;


@Controller
@RequestMapping("/mypage")
public class MypageReviewControllerImpl implements MypageReviewController {

	@Override
	@RequestMapping("/myreview")
	public ModelAndView mypagereview(String id, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
		MemberDTO member = (MemberDTO) session.getAttribute("member");
		ModelAndView mav = null;
		
		String viewName = (String) request.getAttribute("viewName");
		mav = new ModelAndView(viewName);
		
		return mav;
	}

}
