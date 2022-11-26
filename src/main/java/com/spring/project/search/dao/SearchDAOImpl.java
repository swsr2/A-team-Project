package com.spring.project.search.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.project.food.dto.FoodDTO;

@Repository
public class SearchDAOImpl implements SearchDAO{
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<String> columnsList(String tableName) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("mapper.search.columnsList",tableName);
	}

	@Override
	public List<FoodDTO> foodSearch(Map map) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("mapper.search.foodColumns",map);
	}
}
