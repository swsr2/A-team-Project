package com.spring.project.event.service;

import java.sql.Date;
import java.util.List;

import com.spring.project.event.dto.AirplaneDTO;

public interface EventService {


	public List<AirplaneDTO> selectList(String fromDate);

	// public int addReview(ReviewDTO review);

}
