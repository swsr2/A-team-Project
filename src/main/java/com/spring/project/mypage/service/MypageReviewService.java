package com.spring.project.mypage.service;

import java.util.List;

import com.spring.project.mypage.dto.MyReviewDTO;

public interface MypageReviewService {

	public List<MyReviewDTO> reviewList(String id);

}
