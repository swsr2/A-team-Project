package com.spring.project.event.service;

import java.util.List;

import com.spring.project.event.dto.AirplaneDTO;

public interface EventService {


	public List<AirplaneDTO> selectList(AirplaneDTO air);

	// public int addReview(ReviewDTO review);

}
