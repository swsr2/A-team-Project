package com.spring.project.event.service;

import java.util.List;

import com.spring.project.event.dto.AirplaneDTO;

public interface EventService {

	public List<AirplaneDTO> departList(AirplaneDTO air) throws Exception ;
	
	public List<AirplaneDTO> arrivalList(AirplaneDTO air) throws Exception ;

	public List<AirplaneDTO> checkReserv(int air_no_from, int air_no_to);

	public void resetAir();


	// public int addReview(ReviewDTO review);

}
