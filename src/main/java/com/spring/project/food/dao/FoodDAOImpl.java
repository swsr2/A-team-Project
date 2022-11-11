package com.spring.project.food.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.project.food.dto.FoodDTO;
import com.spring.project.food.dto.ReviewDTO;

@Repository
public class FoodDAOImpl implements FoodDAO{
	@Autowired
	private SqlSession sqlSession;

	@Override
	public FoodDTO selectOne(int fd_no) {
		// TODO Auto-generated method stub
		FoodDTO food = (FoodDTO) sqlSession.selectOne("mapper.food.selectfd_no", fd_no);
		return food;
	}

	@Override
	public int addReview(ReviewDTO review) {
		// TODO Auto-generated method stub
		return sqlSession.insert("mapper.food.addReview", review);
	}
}
