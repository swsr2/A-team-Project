package com.spring.project.mypage.service;

import java.util.List;


import com.spring.project.mypage.dto.MyReservationDTO;
import com.spring.project.mypage.dao.MyReservationDAO;

public class MyReservationServiceImpl implements MyReservationService{
	
	private MyReservationDAO myreservationDAO;

	@Override
	public List<MyReservationDTO> reservationAirList(String id) {
		// TODO Auto-generated method stub
		return myreservationDAO.reservationAirList(id);
	}

}
