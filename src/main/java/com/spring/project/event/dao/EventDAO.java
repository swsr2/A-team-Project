package com.spring.project.event.dao;

import java.util.List;

import com.spring.project.event.dto.AirplaneDTO;

public interface EventDAO {
	public List<AirplaneDTO> selectList(AirplaneDTO air);

	public List<AirplaneDTO> selectList2(AirplaneDTO air);

	public AirplaneDTO selectAir_no_from(int air_no_from);

	public AirplaneDTO selectAir_no_to(int air_no_to);



	// public int addReview(ReviewDTO review);

}
