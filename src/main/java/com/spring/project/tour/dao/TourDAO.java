package com.spring.project.tour.dao;

import java.util.List;
import java.util.Map;

import com.spring.project.tour.dto.TourDTO;

public interface TourDAO {

	public int allTourCnt();

	public int allOrummCnt();

	public int allBeachCnt();

	public List<TourDTO> beachList(Map<String, Integer> page);

	public List<TourDTO> orummList(Map<String, Integer> page);

	public List<TourDTO> tourList(Map<String, Integer> page);

	public void dbInsert(TourDTO tour);
	
	

}
