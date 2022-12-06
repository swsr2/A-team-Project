package com.spring.project.mypage.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.project.mypage.dto.PickDTO;
import com.spring.project.mypage.dto.TravleDTO;

@Repository
public class TravleDAOImpl implements TravleDAO{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<PickDTO> travleList(String id) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("mapper.mypage.travlecheck", id);
	}

}
