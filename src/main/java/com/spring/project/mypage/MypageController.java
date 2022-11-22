package com.spring.project.mypage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MypageController {
	public String mypagemain(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public String myreservation(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public String myreview(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public String mytravle(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
