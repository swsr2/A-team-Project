package com.spring.project.event.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.project.event.dto.AirplaneDTO;
import com.spring.project.food.dto.FoodDTO;

@Repository
public class EventDAOImpl implements EventDAO{
	@Autowired
	private SqlSession sqlSession;

	@Override
	public AirplaneDTO selectOne(int air_no) {
		// TODO Auto-generated method stub
		AirplaneDTO airplane = (AirplaneDTO) sqlSession.selectOne("mapper.event.selectair_no", air_no);
		return airplane;
	}


	/*
	@Override
	public int addReview(ReviewDTO review) {
		// TODO Auto-generated method stub
		return sqlSession.insert("mapper.food.addReview", review);
	}
	*/
}
