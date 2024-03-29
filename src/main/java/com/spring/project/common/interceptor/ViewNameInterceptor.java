package com.spring.project.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ViewNameInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		try {
			String viewName = getViewName(request);
			request.setAttribute("viewName", viewName);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return true;
	}

	private String getViewName(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String contextPath = request.getContextPath();
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
		
		if(uri==null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}
		
		int begin = 0;
		if(!(contextPath == null) || ("".equals(contextPath))) {
			begin=contextPath.length();
		}
		
		int end=0;
		if(uri.indexOf(";")!=-1) {
			end=uri.indexOf(";");
		} else if(uri.indexOf("?")!=-1) {
			end=uri.indexOf("?");
		} else {
			end=uri.length();
		}
		
		String viewName = uri.substring(begin, end);
		
		if(viewName.indexOf(".")!=-1) {
			viewName = viewName.substring(0, viewName.lastIndexOf("."));
		}
		if(viewName.indexOf("/")!=-1) {
			viewName = viewName.substring(viewName.lastIndexOf("/",1), viewName.length());
		}
		return viewName;
	}
	
}
