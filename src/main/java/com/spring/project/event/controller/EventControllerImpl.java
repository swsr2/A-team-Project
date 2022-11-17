package com.spring.project.event.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.project.event.dto.AirplaneDTO;
import com.spring.project.event.service.EventService;

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
	@RequestMapping("/lodging")
	public String lodging(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return "/event/lodging";
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
	

	


	
}
