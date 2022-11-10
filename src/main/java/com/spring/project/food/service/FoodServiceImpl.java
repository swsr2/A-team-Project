package com.spring.project.food.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.project.food.dao.FoodDAO;

@Service
public class FoodServiceImpl implements FoodService {
	@Autowired
	FoodDAO foodDAO;
}
