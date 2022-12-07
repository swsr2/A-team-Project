package com.spring.project.mypage.controller;

import java.util.List;
import java.util.Map;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.project.member.dto.MemberDTO;
import com.spring.project.mypage.dto.PickDTO;
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
		List<PickDTO> mytra = travleService.travleList(member.getId());
		mav.addObject("travleList", mytra);
		return mav;
	}
	
	@RequestMapping("/schedule")
	public String schedule(@RequestBody String json , HttpServletRequest request) throws Exception {
		TravleDTO travle = new TravleDTO();
		JSONParser parser = new JSONParser();
		JSONObject obj = (JSONObject) parser.parse(json);
		HttpSession session = request.getSession();
		MemberDTO mem = (MemberDTO) session.getAttribute("member");
		travle.setDate((String) obj.get("date"));
		travle.setTitle((String) obj.get("title"));
		travle.setId(mem.getId());
		return "travle/mytravle";
	}

}