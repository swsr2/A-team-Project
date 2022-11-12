package com.spring.project.event.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
		return "/event/eventmain";
	}

	@Override
	@RequestMapping("/lodging")
	public String lodging(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return "/event/lodging";
	}

	@Override
	@RequestMapping("/airDetail")
	public ModelAndView airDetail(@RequestParam("air_no") int air_no, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		AirplaneDTO airplane = eventService.selectOne(air_no);
		
		String viewName = (String) request.getAttribute("viewName");
		
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("airpalne", airplane);
		
		return mav;
	}

	
}
