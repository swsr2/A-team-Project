package com.spring.project.tour.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.project.tour.dao.TourDAO;
import com.spring.project.tour.dto.TourDTO;

@Service
public class TourServiceImpl implements TourService {
	@Autowired
	TourDAO tourDAO;
	
	@Override
	public int allTourCnt() {
		// TODO Auto-generated method stub
		return tourDAO.allTourCnt();
	}

	@Override
	public int allOrummCnt() {
		// TODO Auto-generated method stub
		return tourDAO.allOrummCnt();
	}

	@Override
	public int allBeachCnt() {
		// TODO Auto-generated method stub
		return tourDAO.allBeachCnt();
	}

	@Override
	public List<TourDTO> tourList(int start, int end) {
		// TODO Auto-generated method stub
		Map<String, Integer> page = new HashMap<String, Integer>();
		page.put("start", start);
		page.put("end", end);
		return tourDAO.tourList(page);
	}

	@Override
	public List<TourDTO> orummList(int start, int end) {
		// TODO Auto-generated method stub
		Map<String, Integer> page = new HashMap<String, Integer>();
		page.put("start", start);
		page.put("end", end);
		return tourDAO.orummList(page);
	}

	@Override
	public List<TourDTO> beachList(int start, int end) {
		// TODO Auto-generated method stub
		Map<String, Integer> page = new HashMap<String, Integer>();
		page.put("start", start);
		page.put("end", end);
		return tourDAO.beachList(page);
	}

	@Override
	public void dbInsert(TourDTO tour) {
		// TODO Auto-generated method stub
		tourDAO.dbInsert(tour);
	}

}
