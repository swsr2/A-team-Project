package com.spring.project.event.dao;

import java.util.List;

import com.spring.project.event.dto.AirplaneDTO;

public interface EventDAO {
	public List<AirplaneDTO> selectList(String fromDate);


	// public int addReview(ReviewDTO review);

}
