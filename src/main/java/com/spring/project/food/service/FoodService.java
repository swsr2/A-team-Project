package com.spring.project.food.service;

import com.spring.project.food.dto.FoodDTO;
import com.spring.project.food.dto.ReviewDTO;

public interface FoodService {

	public FoodDTO selectOne(int fd_no);

	public int addReview(ReviewDTO review);

}
