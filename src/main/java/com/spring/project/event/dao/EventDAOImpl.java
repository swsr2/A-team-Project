package com.spring.project.event.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.project.event.dto.AirplaneDTO;

@Repository
public class EventDAOImpl implements EventDAO{
	@Autowired
	private SqlSession sqlSession;


	@Override
	public List<AirplaneDTO> selectList(AirplaneDTO air) {
		// TODO Auto-generated method stub
		List<AirplaneDTO> airplaneList = sqlSession.selectList("mapper.event.selectairList", air);
		return airplaneList;
	}


	/*
	@Override
	public int addReview(ReviewDTO review) {
		// TODO Auto-generated method stub
		return sqlSession.insert("mapper.food.addReview", review);
	}
	*/
}
