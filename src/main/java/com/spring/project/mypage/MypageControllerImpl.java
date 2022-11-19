package com.spring.project.mypage;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/mypage")
public class MypageControllerImpl implements MypageController{
	
	@Override
	@RequestMapping(value="/mypagemain", method= {RequestMethod.GET, RequestMethod.POST})
	public String mypagemain(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "/mypage/mypagemain";
	}

	@Override
	@RequestMapping(value="/myreservation", method= {RequestMethod.GET, RequestMethod.POST})
	public String myreservation(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return "/mypage/myreservation";
	}

	@Override
	@RequestMapping(value="/myreview", method= {RequestMethod.GET, RequestMethod.POST})
	public String myreview(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return "/mypage/myreview";
	}

	@Override
	@RequestMapping(value="/mytravle", method= {RequestMethod.GET, RequestMethod.POST})
	public String mytravle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return "/mypage/mytravle";
	}
}
