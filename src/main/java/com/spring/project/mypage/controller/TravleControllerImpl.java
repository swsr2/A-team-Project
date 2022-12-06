package com.spring.project.mypage.controller;

import java.util.List;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.project.member.dto.MemberDTO;
import com.spring.project.mypage.dto.TravleDTO;
import com.spring.project.mypage.service.TravleService;

@Controller
@RequestMapping("/travle")
public class TravleControllerImpl implements TravleController{
	@Autowired
	TravleService travleService;

	@Override
	@RequestMapping("/mytravle")
	public ModelAndView travle(String id, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
		MemberDTO member = (MemberDTO) session.getAttribute("member");
		ModelAndView mav = null;
		
		String viewName = (String) request.getAttribute("viewName");
		mav = new ModelAndView(viewName);
		List<TravleDTO> mytra = travleService.travleList(member.getId());
		mav.addObject("travleList", mytra);
		return mav;
	}

}
