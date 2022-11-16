package com.spring.project.event.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.project.event.dao.EventDAO;
import com.spring.project.event.dto.AirplaneDTO;

@Service
public class EventServiceImpl implements EventService {
	@Autowired
	EventDAO eventDAO;

	@Override
	public List<AirplaneDTO> selectList(AirplaneDTO air) {
		// TODO Auto-generated method stub
		List<AirplaneDTO> airplaneList = eventDAO.selectList(air);
		return airplaneList;
	}

	@Override
	public List<AirplaneDTO> selectList2(AirplaneDTO air) {
		// TODO Auto-generated method stub
		List<AirplaneDTO> airplaneList2 = eventDAO.selectList2(air);
		return airplaneList2;
	}


	@Override
	public List<AirplaneDTO> checkReserv(int air_no_from, int air_no_to) {
		// TODO Auto-generated method stub
		AirplaneDTO airplane_from = eventDAO.selectAir_no_from(air_no_from);
		AirplaneDTO airplane_to = eventDAO.selectAir_no_to(air_no_to);
		
		List<AirplaneDTO> airplaneList = new ArrayList<AirplaneDTO>();
		airplaneList.add(airplane_from);
		airplaneList.add(airplane_to);
		
		return airplaneList;
	}


	
	/*
	@Override
	public int addReview(ReviewDTO review) {
		// TODO Auto-generated method stub
		return eventDAO.addReview(review);
	}
	*/
}
