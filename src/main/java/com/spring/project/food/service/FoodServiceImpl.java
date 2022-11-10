package com.spring.project.food.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.project.food.dao.FoodDAO;
import com.spring.project.food.dto.FoodDTO;

@Service
public class FoodServiceImpl implements FoodService {
	@Autowired
	FoodDAO foodDAO;

	@Override
	public FoodDTO selectOne(int fd_no) {
		// TODO Auto-generated method stub
		return foodDAO.selectOne(fd_no);
	}
}
