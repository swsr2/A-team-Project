package com.spring.project.member.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.project.member.dto.MemberDTO;
import com.spring.project.member.service.MemberService;

@Controller("memberController")
@EnableAspectJAutoProxy
public class MemberControllerImpl extends MultiActionController implements MemberController {
	@Autowired
	private MemberService memberService;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberControllerImpl.class);
	
	@Override
	@RequestMapping(value="/member/listMembers.do", method=RequestMethod.GET)
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		Boolean isLogOn = (Boolean) session.getAttribute("isLogOn");
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		
		if(isLogOn != null) {
			
			
			logger.info("info 레벨 : viewName = " + viewName);
			logger.debug("debug 레벨 : viewName = " + viewName);
			List<MemberDTO> membersList = memberService.listMembers();
			
			
			mav.addObject("membersList", membersList);
		} else {
			mav.setViewName("redirect:/member/loginForm.do");
		}
		return mav;
	}

	@Override
	@RequestMapping(value="/member/*Form.do", method=RequestMethod.GET)
	public ModelAndView memberForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String viewName = (String) request.getAttribute("viewName");
		
		ModelAndView mav = new ModelAndView(viewName);
		return mav;
	}

	@Override
	@RequestMapping(value="/member/addMember.do", method=RequestMethod.POST)
	public ModelAndView addMember(@ModelAttribute("member") MemberDTO member, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		memberService.addMember(member);
					
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
		return mav;
	}

	@Override
	@RequestMapping(value="/member/memberDetail.do", method=RequestMethod.GET)
	public ModelAndView memberDetail(@RequestParam("id") String id,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		MemberDTO member = memberService.selectOne(id);
		
		String viewName = (String) request.getAttribute("viewName");
		
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("member", member);
		
		return mav;
	}

	@Override
	@RequestMapping(value="/member/modMember.do", method=RequestMethod.POST)
	public void modMember(@ModelAttribute("member") MemberDTO member,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		
		int result = memberService.modMember(member);
		
		PrintWriter out = response.getWriter();
		out.println("<script>");
		if(result == 1) {
			out.println("alert('수정이 완료되었습니다');");
			out.println("location.href='"+ request.getContextPath() +"/member/listMembers.do';");
		} else {
			out.println("alert('수정이 완료되지 못했습니다. 다시 수정하세요');");
			out.println("location.href='"+ request.getContextPath() +"/member/modMember.do?id="+member.getId()+"';");
		}
		out.println("</script>");
	}

	@Override
	@RequestMapping(value="/member/delMember.do", method=RequestMethod.GET)
	public void delMember(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		int result = memberService.delMember(id);
		
		PrintWriter out = response.getWriter();
		out.println("<script>");
		if(result == 1) {
			out.println("alert('삭제 완료되었습니다');");
		} else {
			out.println("alert('삭제가 완료되지 못했습니다. 다시 삭제하세요');");
		}
		out.println("location.href='"+ request.getContextPath() +"/member/listMembers.do';");
		out.println("</script>");
	}

	@Override
	@RequestMapping(value="/member/login.do", method=RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("member") MemberDTO member, RedirectAttributes rAttr, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		ModelAndView mav = new ModelAndView();
		MemberDTO memberDTO = memberService.login(member);
		
		if(memberDTO != null) {
			HttpSession session = request.getSession();
			session.setAttribute("member", memberDTO);
			session.setAttribute("isLogOn", true);
			mav.setViewName("redirect:/main/main.do" );
		} else {
			rAttr.addAttribute("result", "loginFailed");
			mav.setViewName("redirect:/member/loginForm.do");
		}
		return mav;
	}

	@Override
	@RequestMapping(value="/member/logout.do", method=RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse resposne) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
//		session.removeAttribute("member");
//		session.removeAttribute("isLogOn");
		
		session.invalidate();
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/member/loginForm.do");
		return mav;
	}	
}



















