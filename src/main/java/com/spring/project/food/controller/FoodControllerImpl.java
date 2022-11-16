package com.spring.project.food.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	public String restaurant(@RequestParam("page") int page,HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		// 테스트 하실때 공유드라이브에 api 받아오기 텍스트 파일안 내용을 요기다 넣고 한번 돌리시면
		// api 내용이 db에 저장이 될 겁니다 db에서 테이블 이랑 시퀀스 만들고 돌려주세요
		
		int FoodCnt = foodService.allFoodCnt();
		
		int postNum = 12;
		
		int pageNum = (int)Math.ceil((double)FoodCnt/postNum);
		
		int start = page * postNum;
		
		int end = start + (postNum-1);
		
		// 한번에 표시할 페이징 번호의 갯수
		int pageNum_cnt = 10;

		// 표시되는 페이지 번호 중 마지막 번호
		int endPageNum = (int)(Math.ceil((double)page / (double)pageNum_cnt) * pageNum_cnt);

		// 표시되는 페이지 번호 중 첫번째 번호
		int startPageNum = endPageNum - (pageNum_cnt - 1);
		
		// 마지막 번호 재계산
		int endPageNum_tmp = (int)(Math.ceil((double)FoodCnt / (double)pageNum_cnt));
		 
		if(endPageNum > endPageNum_tmp) {
		 endPageNum = endPageNum_tmp;
		}
		boolean prev = startPageNum == 1 ? false : true;
		boolean next = endPageNum * pageNum_cnt >= FoodCnt ? false : true;

		List<FoodDTO> foodList = foodService.foodList(start, end);
		request.setAttribute("foodList", foodList);
		request.setAttribute("pageNum", pageNum);
		// 시작 및 끝 번호
		request.setAttribute("startPageNum", startPageNum);
		request.setAttribute("endPageNum", endPageNum);

		// 이전 및 다음 
		request.setAttribute("prev", prev);
		request.setAttribute("next", next);
		return "/food/foodmain";
	}
	
	@Override
	@RequestMapping("/cafe")
	public String cafe(@RequestParam("page") int page, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int cafeCnt = foodService.allCafeCnt();
		
		int postNum = 12;
		
		int pageNum = (int)Math.ceil((double)cafeCnt/postNum);
		int start = page * postNum;
		
		int end = start + (postNum-1);
		
		// 한번에 표시할 페이징 번호의 갯수
		int pageNum_cnt = 10;

		// 표시되는 페이지 번호 중 마지막 번호
		int endPageNum = (int)(Math.ceil((double)page / (double)pageNum_cnt) * pageNum_cnt);

		// 표시되는 페이지 번호 중 첫번째 번호
		int startPageNum = endPageNum - (pageNum_cnt - 1);
		
		// 마지막 번호 재계산
		int endPageNum_tmp = (int)(Math.ceil((double)cafeCnt / (double)pageNum_cnt));
		 
		if(endPageNum > endPageNum_tmp) {
		 endPageNum = endPageNum_tmp;
		}
		boolean prev = startPageNum == 1 ? false : true;
		boolean next = endPageNum * pageNum_cnt >= cafeCnt ? false : true;

		List<FoodDTO> cafeList = foodService.cafeList(start, end);
		request.setAttribute("cafeList", cafeList);
		request.setAttribute("pageNum", pageNum);
		// 시작 및 끝 번호
		request.setAttribute("startPageNum", startPageNum);
		request.setAttribute("endPageNum", endPageNum);

		// 이전 및 다음 
		request.setAttribute("prev", prev);
		request.setAttribute("next", next);
		return "/food/cafe";
	}

	@Override
	@RequestMapping("/resDetail")
	public ModelAndView resDetail(@RequestParam("fd_no") int fd_no, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		FoodDTO food = foodService.selectOne(fd_no);
		List<ReviewDTO> reviewList = foodService.reviewList(fd_no);
		String[] category = food.getFd_category().split(",");
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("food", food);
		mav.addObject("category",category);
		mav.addObject("reviewList",reviewList);
		
//		Map pickMap = new hashMap();
//		pickMap.put("id", "현재 세션에 있는 아이디값");
//		pickMap.put("fd_no", fd_no);
//		if(foodService.checkPick(pickMap)) {
//			mav.addObject("pick",true);
//		}else {
//			mav.addObject("pick",false);
//		}
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
		int result = foodService.addReview(review);
		
		PrintWriter out = response.getWriter();
		out.println("<script>");
		if(result == 1) {
			out.println("alert('리뷰등록이 완료 되었습니다. 작성하신 리뷰는 [마이페이지 > 나의 리뷰보기]에서 확인하실 수 있습니다.')");
		} else {
			out.println("alert('리뷰가 등록되지 않았습니다.');");
		}
		out.println("location.href='"+ request.getContextPath() 
				+ "/food/resDetail?fd_no="+review.getFd_no()+"';");
		out.println("</script>");
		
		
	}

	
	@Override
	@RequestMapping(value="/myPick", method=RequestMethod.GET)
	public ModelAndView myPick(@RequestParam("fd_no") int fd_no,@RequestParam("pick") boolean pick,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
			response.setContentType("text/html;charset=utf-8");
			
			FoodDTO food = foodService.selectOne(fd_no);
			List<ReviewDTO> reviewList = foodService.reviewList(fd_no);
			String[] category = food.getFd_category().split(",");
			ModelAndView mav = new ModelAndView("food/resDetail");
			mav.addObject("food", food);
			mav.addObject("category",category);
			mav.addObject("reviewList",reviewList);
			
			Map pickMap = new HashMap();
			pickMap.put("id", "hong");
			pickMap.put("fd_no", fd_no);
			
			if(pick) {
				foodService.myPick(pickMap);
				mav.addObject("pick",true);
			}else {
				foodService.delPick(pickMap);
				mav.addObject("pick",false);
			}
			return mav;
	}
	
	
}
