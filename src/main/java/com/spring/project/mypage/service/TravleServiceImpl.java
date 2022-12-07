package com.spring.project.mypage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.project.mypage.dao.TravleDAO;
import com.spring.project.mypage.dto.PickDTO;
import com.spring.project.mypage.dto.TravleDTO;

@Service
public class TravleServiceImpl implements TravleService{
	
	@Autowired
	private TravleDAO travleDAO;

	@Override
	public List<PickDTO> travleList(String id) {
		// TODO Auto-generated method stub
		return travleDAO.travleList(id);
	}

}