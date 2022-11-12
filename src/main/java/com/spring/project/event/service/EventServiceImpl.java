package com.spring.project.event.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.project.event.dao.EventDAO;
import com.spring.project.event.dto.AirplaneDTO;

@Service
public class EventServiceImpl implements EventService {
	@Autowired
	EventDAO eventDAO;

	@Override
	public AirplaneDTO selectOne(int air_no) {
		// TODO Auto-generated method stub
		return eventDAO.selectOne(air_no);
	}

	/*
	@Override
	public int addReview(ReviewDTO review) {
		// TODO Auto-generated method stub
		return eventDAO.addReview(review);
	}
	*/
}
