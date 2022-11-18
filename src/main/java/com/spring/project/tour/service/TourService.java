package com.spring.project.tour.service;

import java.util.List;

import com.spring.project.tour.dto.TourDTO;

public interface TourService {

	public int allTourCnt();

	public int allOrummCnt();

	public int allBeachCnt();

	public List<TourDTO> tourList(int start, int end);

	public List<TourDTO> orummList(int start, int end);

	public List<TourDTO> beachList(int start, int end);

	public void dbInsert(TourDTO tour);

}
