package com.spring.project.kakao.vo;

import org.springframework.stereotype.Component;

@Component("kakaoVO")
public class KakaoVO {
	private String k_nickname;
	
	public String getK_nickname() {
		return k_nickname;
	}
	public void setK_nickname(String k_nickname) {
		this.k_nickname = k_nickname;
	}	
}
