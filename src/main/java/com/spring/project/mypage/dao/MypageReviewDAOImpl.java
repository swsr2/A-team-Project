package com.spring.project.mypage.dao;

import java.util.List;



import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.project.mypage.dto.ReviewDTO;

@Repository
public class MypageReviewDAOImpl implements MypageReviewDAO{
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<ReviewDTO> reviewList(String id) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("mapper.mypage.reviewList", id);

	}

}
