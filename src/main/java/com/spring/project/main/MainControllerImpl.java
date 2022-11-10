package com.spring.project.main;


import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/main")
public class MainControllerImpl implements MainController{
	@Autowired
	MailService mailService;
	
	@Override
	@RequestMapping(value="/main.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String main(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "/main/main";
	}

	@RequestMapping("/introduce")
	public String introduce(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "/main/introduce";
	}

	@RequestMapping("/support")
	public String support(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "/main/support";
	}
	
	@RequestMapping(value="/sendMail", method=RequestMethod.POST)
	public void sendEmail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		String id = "id"; // request.getParameter("id");
		String title =request.getParameter("title");
		String content = request.getParameter("content");
		
		mailService.sendMail("tkfkd9119@gmail.com", id+"님의 문의:: "+ title, content);
		
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('문의가 완료되었습니다.');");
		out.println("location.href='http://localhost:8080/project/main/main';");
		out.println("</script>");
	}
	
}



