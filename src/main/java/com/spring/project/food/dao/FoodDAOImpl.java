package com.spring.project.food.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.project.food.dto.FoodDTO;

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
}
