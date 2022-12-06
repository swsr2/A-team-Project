package com.spring.project.mypage.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.project.member.dto.MemberDTO;
import com.spring.project.mypage.dto.ReviewDTO;
import com.spring.project.mypage.service.MypageReviewService;


@Controller
@EnableAspectJAutoProxy
@RequestMapping("/myreview")
public class MypageReviewControllerImpl implements MypageReviewController {
	@Autowired
	private MypageReviewService reviewService;
	
	@Override
	@RequestMapping("/review")
	public ModelAndView mypagereview(String id, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
		MemberDTO member = (MemberDTO) session.getAttribute("member");
		ModelAndView mav = null;
		
		String viewName = (String) request.getAttribute("viewName");
		mav = new ModelAndView(viewName);
		List<ReviewDTO> review =  reviewService.reviewList(member.getId());
		
		mav.addObject("reviewList",review);
		return mav;
	}
	
	@Override
	@RequestMapping("/reviewDel")
	public void reviewDel(int re_no, HttpServletRequest request, 
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		String msg = null;
		String url = null;

			try {
				reviewService.reviewDel(re_no);
				msg = "삭제가 완료 되었습니다.";
				url = request.getContextPath() + "/myreview/review";
			} catch(Exception e) {
				msg = "삭제에 실패했습니다. 다시 시도하세요.";
				url = request.getContextPath() + "/myreview/review";
				e.printStackTrace();
			}
			out.println("<script>");
			out.println("alert('" + msg + "');");
			out.println("location.href='" + url + "';");
			out.println("</script>");
	}
}
