package com.spring.project.event.service;

import java.util.List;

import com.spring.project.event.dto.AirplaneDTO;

public interface EventService {

	public List<AirplaneDTO> selectList(AirplaneDTO air);

	public List<AirplaneDTO> selectList2(AirplaneDTO air);

	public List<AirplaneDTO> checkReserv(int air_no_from, int air_no_to);


	// public int addReview(ReviewDTO review);

}
