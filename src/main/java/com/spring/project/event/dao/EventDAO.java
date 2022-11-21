package com.spring.project.event.dao;

import java.util.List;
import java.util.Map;

import com.spring.project.event.dto.AirplaneDTO;
import com.spring.project.event.dto.LodgingDTO;
import com.spring.project.event.dto.RoomInfoDTO;

public interface EventDAO {
	public List<AirplaneDTO> selectList(AirplaneDTO air);

	public List<AirplaneDTO> selectList2(AirplaneDTO air);

	public AirplaneDTO selectAir_no_from(int air_no_from);

	public AirplaneDTO selectAir_no_to(int air_no_to);

	public void resetAir();

	public void addAirplane(AirplaneDTO air);

	public int allLodCnt();

	public List<LodgingDTO> lodList(Map<String, Integer> page);

	public LodgingDTO lodDatail(int lod_id);

	public List<RoomInfoDTO> roomList(int lod_id);



	// public int addReview(ReviewDTO review);

}
