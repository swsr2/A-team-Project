package com.spring.project.tour.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.project.tour.dto.TourDTO;

@Repository
public class TourDAOImpl implements TourDAO {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int allTourCnt() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mapper.tour.allTourCnt");
	}

	@Override
	public int allOrummCnt() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mapper.tour.allOrummCnt");
	}

	@Override
	public int allBeachCnt() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mapper.tour.allBeachCnt");
	}

	@Override
	public List<TourDTO> beachList(Map<String, Integer> page) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("mapper.tour.beachList",page);
	}

	@Override
	public List<TourDTO> orummList(Map<String, Integer> page) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("mapper.tour.orummList",page);
	}

	@Override
	public List<TourDTO> tourList(Map<String, Integer> page) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("mapper.tour.tourList",page);
	}

	@Override
	public void dbInsert(TourDTO tour) {
		// TODO Auto-generated method stub
		sqlSession.insert("mapper.tour.dbInsert",tour);
	}

}
