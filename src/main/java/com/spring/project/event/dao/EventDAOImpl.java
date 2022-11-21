package com.spring.project.event.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.project.event.dto.AirplaneDTO;
import com.spring.project.event.dto.LodgingDTO;
import com.spring.project.event.dto.RoomInfoDTO;

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


	@Override
	public List<AirplaneDTO> selectList2(AirplaneDTO air) {
		// TODO Auto-generated method stub
		//System.out.println("*");
		//System.out.println(air.getAir_arrivalPlace());
		//System.out.println(air.getAir_departPlace());
		//System.out.println(air.getAir_date());
		List<AirplaneDTO> airplaneList2 = sqlSession.selectList("mapper.event.selectairList2", air);
		return airplaneList2;
	}


	@Override
	public AirplaneDTO selectAir_no_from(int air_no_from) {
		// TODO Auto-generated method stub
		AirplaneDTO  airplane_from = sqlSession.selectOne("mapper.event.selectAir_no_from", air_no_from);
		return airplane_from;
	}


	@Override
	public AirplaneDTO selectAir_no_to(int air_no_to) {
		// TODO Auto-generated method stub
		AirplaneDTO  airplane_to = sqlSession.selectOne("mapper.event.selectAir_no_to", air_no_to);
		return airplane_to;
	}


	@Override
	public void resetAir() {
		// TODO Auto-generated method stub
		sqlSession.delete("mapper.event.resetAir");
	}


	@Override
	public void addAirplane(AirplaneDTO air) {
		// TODO Auto-generated method stub
		sqlSession.insert("mapper.event.addAirplane",air);
	}


	@Override
	public int allLodCnt() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mapper.event.allLodCnt");
	}


	@Override
	public List<LodgingDTO> lodList(Map<String, Integer> page) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("mapper.event.lodList",page);
	}


	@Override
	public LodgingDTO lodDatail(int lod_id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mapper.event.lodDetail",lod_id);
	}


	@Override
	public List<RoomInfoDTO> roomList(int lod_id) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("mapper.event.roomList",lod_id);
	}



	/*
	@Override
	public int addReview(ReviewDTO review) {
		// TODO Auto-generated method stub
		return sqlSession.insert("mapper.food.addReview", review);
	}
	*/
}
