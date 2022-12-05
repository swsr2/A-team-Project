package com.spring.project.kakao.controller;

import javax.servlet.http.HttpSession;

import com.spring.project.kakao.vo.KakaoVO;

public interface KakaoController {

	String kakaoLogin(String code, HttpSession session);

	String getAccessToken(String authorize_code);

	KakaoVO getUserInfo(String access_Token);
}
