package com.spring.project.food.dao;

import com.spring.project.food.dto.FoodDTO;
import com.spring.project.food.dto.ReviewDTO;

public interface FoodDAO {

	public FoodDTO selectOne(int fd_no);

	public int addReview(ReviewDTO review);

}
