package com.spring.project.kakao.dao;

import java.util.HashMap;

import com.spring.project.kakao.vo.KakaoVO;

public interface KakaoDAO {

	void kakaoInsert(HashMap<String, Object> userInfo);

	KakaoVO findKakao(HashMap<String, Object> userInfo);

}
