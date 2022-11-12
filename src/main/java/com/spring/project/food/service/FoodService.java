package com.spring.project.food.service;

import java.util.List;

import com.spring.project.food.dto.FoodDTO;
import com.spring.project.food.dto.ReviewDTO;

public interface FoodService {

	public FoodDTO selectOne(int fd_no);

	public int addReview(ReviewDTO review);
	
	public void dbInsert(FoodDTO food);

	public List<FoodDTO> foodList();


}
