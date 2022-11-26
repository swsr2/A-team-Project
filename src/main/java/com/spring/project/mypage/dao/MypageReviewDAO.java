package com.spring.project.mypage.dao;

import java.util.List;


import com.spring.project.mypage.dto.MyReviewDTO;

public interface MypageReviewDAO {
	
	public List<MyReviewDTO> reviewList(String id);

}
