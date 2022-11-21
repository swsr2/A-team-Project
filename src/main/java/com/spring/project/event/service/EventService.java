package com.spring.project.event.service;

import java.util.List;

import com.spring.project.event.dto.AirplaneDTO;
import com.spring.project.event.dto.LodgingDTO;
import com.spring.project.event.dto.RoomInfoDTO;

public interface EventService {

	public List<AirplaneDTO> departList(AirplaneDTO air) throws Exception ;
	
	public List<AirplaneDTO> arrivalList(AirplaneDTO air) throws Exception ;

	public List<AirplaneDTO> checkReserv(int air_no_from, int air_no_to);

	public void resetAir();

	public int allLodCnt();

	public List<LodgingDTO> lodList(int start, int end);

	public LodgingDTO lodDatail(int lod_id);

	public List<RoomInfoDTO> roomList(int lod_id);


	// public int addReview(ReviewDTO review);

}
