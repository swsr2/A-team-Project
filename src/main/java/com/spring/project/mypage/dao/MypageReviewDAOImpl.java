package com.spring.project.mypage.dao;

import java.util.List;


import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.project.mypage.dto.MyReviewDTO;

@Repository
public class MypageReviewDAOImpl implements MypageReviewDAO{
	
	private SqlSession sqlSession;

	@Override
	public List<MyReviewDTO> reviewList(String id) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("mapper.mypage.reviewList", id);

	}

}
