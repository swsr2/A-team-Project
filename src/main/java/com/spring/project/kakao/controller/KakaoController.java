package com.spring.project.kakao.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ModelAttribute;

import com.spring.project.kakao.vo.KakaoVO;
import com.spring.project.member.dto.MemberDTO;

public interface KakaoController {

	void kakaoLogin(String code, HttpServletRequest request, HttpServletResponse response) throws Exception;

	String getAccessToken(String authorize_code);

	MemberDTO getUserInfo(String access_Token);
}
