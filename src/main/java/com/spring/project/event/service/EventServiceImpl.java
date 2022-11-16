package com.spring.project.event.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.project.event.dao.EventDAO;
import com.spring.project.event.dto.AirplaneDTO;
import com.sun.mail.iap.Response;

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
	
	/*
	@Override
	public int addReview(ReviewDTO review) {
		// TODO Auto-generated method stub
		return eventDAO.addReview(review);
	}
	*/
}
