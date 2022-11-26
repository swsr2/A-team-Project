package com.spring.project.mypage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.project.mypage.dao.MypageReviewDAO;
import com.spring.project.mypage.dto.ReviewDTO;

@Service
public class MypageReviewServiceImpl implements MypageReviewService{
	@Autowired
	private MypageReviewDAO mypagereviewDAO;

	@Override
	public List<ReviewDTO> reviewList(String id) {
		// TODO Auto-generated method stub
		return mypagereviewDAO.reviewList(id);
	}

}
