package com.spring.project.event.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.project.event.dto.AirplaneDTO;
import com.spring.project.event.service.EventService;
import com.spring.project.food.dto.FoodDTO;
import com.spring.project.food.dto.ReviewDTO;
import com.spring.project.event.dto.LodgingDTO;
import com.spring.project.event.dto.RoomInfoDTO;

@Controller("eventController")
@RequestMapping("/event")
public class EventControllerImpl implements EventController {
	@Autowired
	EventService eventService;

	@Override
	@RequestMapping("/main")
	public String airport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return "/event/airmain";
	}

	@Override
	@RequestMapping("/lodmain")
	public String lodging(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return "/event/lodmain";
	}

	@Override
	@RequestMapping("/airDetail")
	public ModelAndView airDetail(@ModelAttribute("air") AirplaneDTO air, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		eventService.resetAir();
		String date = request.getParameter("date");
		String fromdate = date.substring(0,10);
		String todate= date.substring(13);
		air.setAir_date(fromdate);
		
		List<AirplaneDTO> airplaneList = eventService.arrivalList(air);
		
		air.setAir_date(todate);
		//System.out.println(air.getAir_date());
		//System.out.println(air.getAir_arrivalPlace());
		//System.out.println(air.getAir_departPlace());
		
		List<AirplaneDTO> airplaneList2 = eventService.departList(air);
		
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("airplaneList", airplaneList);
		mav.addObject("airplaneList2", airplaneList2);
		
		return mav;
	}

	@Override
	@RequestMapping("/checkReserv")
	public ModelAndView checkReserv(@RequestParam("air_no_from") int air_no_from,@RequestParam("air_no_to") int air_no_to, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		List<AirplaneDTO> airplaneList = eventService.checkReserv(air_no_from, air_no_to);
		
		int price_from = airplaneList.get(0).getAir_price();
		int price_to = airplaneList.get(1).getAir_price();
		int sum = price_from + price_to; 
		
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("airplaneList", airplaneList);
		mav.addObject("sum", sum);
		return mav;
	}

	@Override
	@RequestMapping("/airReserv")
	public String airReserv(int air_no1, int air_no2, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping("/lodDetail")
	public ModelAndView lodDetail(@RequestParam("page") int page,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		
		if(!(request.getParameter("lodDate") == null)) {
			HttpSession session = request.getSession();
			session.setAttribute("from", request.getParameter("from"));
			session.setAttribute("to", request.getParameter("to"));
		}
		
		int lodCnt = eventService.allLodCnt();
		int postNum = 12;
		int pageNum = (int)Math.ceil((double)lodCnt/postNum);
		int start = page * postNum;
		int end = start + (postNum-1);
		
		// 한번에 표시할 페이징 번호의 갯수
		int pageNum_cnt = 10;

		// 표시되는 페이지 번호 중 마지막 번호
		int endPageNum = (int)(Math.ceil((double)page / (double)pageNum_cnt) * pageNum_cnt);

		// 표시되는 페이지 번호 중 첫번째 번호
		int startPageNum = endPageNum - (pageNum_cnt - 1);
		
		// 마지막 번호 재계산
		int endPageNum_tmp = (int)(Math.ceil((double)lodCnt / (double)postNum));
		 
		if(endPageNum > endPageNum_tmp) {
		 endPageNum = endPageNum_tmp;
		}
		boolean prev = startPageNum == 1 ? false : true;
		boolean next = endPageNum * pageNum_cnt >= lodCnt ? false : true;

		List<LodgingDTO> lodList = eventService.lodList(start, end);
		mav.addObject("lodList", lodList);
		mav.addObject("pageNum", pageNum);
		// 시작 및 끝 번호
		mav.addObject("startPageNum", startPageNum);
		mav.addObject("endPageNum", endPageNum);

		// 이전 및 다음 
		mav.addObject("prev", prev);
		mav.addObject("next", next);
		return mav;
	}

	@Override
	@RequestMapping("/lodInfo")
	public ModelAndView lodInfo(@RequestParam("lod_id") int lod_id, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		LodgingDTO lodging = eventService.lodDatail(lod_id);
		List<RoomInfoDTO> roomList = eventService.roomList(lod_id);
//		List<ReviewDTO> reviewList = eventService.reviewList(lod_id);
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		
		mav.addObject("lodging",lodging);
		mav.addObject("roomList",roomList);
		return mav;
	}
	
	
	


	
}
