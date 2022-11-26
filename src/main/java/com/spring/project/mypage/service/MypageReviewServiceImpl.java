package com.spring.project.mypage.service;

import java.util.List;


import com.spring.project.mypage.dao.MypageReviewDAO;
import com.spring.project.mypage.dto.MyReviewDTO;

public class MypageReviewServiceImpl implements MypageReviewService{
	
	private MypageReviewDAO mypagereviewDAO;

	@Override
	public List<MyReviewDTO> reviewList(String id) {
		// TODO Auto-generated method stub
		return mypagereviewDAO.reviewList(id);
	}

}
