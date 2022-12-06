package com.spring.project.kakao.service;

import java.util.HashMap;

import com.spring.project.kakao.vo.KakaoVO;

public interface KakaoService {

	public KakaoVO findKakao(HashMap<String, Object> userInfo);

	public void kakaoInsert(HashMap<String, Object> userInfo);

	public KakaoVO kakaoLogin(KakaoVO userInfo);

}
