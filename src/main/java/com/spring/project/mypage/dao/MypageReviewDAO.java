package com.spring.project.mypage.dao;

import java.util.List;



import com.spring.project.mypage.dto.ReviewDTO;

public interface MypageReviewDAO {
	
	public List<ReviewDTO> reviewList(String id);

}
