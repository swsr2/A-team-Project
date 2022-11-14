package com.spring.project.food.dao;

import java.util.List;

import com.spring.project.food.dto.FoodDTO;
import com.spring.project.food.dto.ReviewDTO;

public interface FoodDAO {

	public FoodDTO selectOne(int fd_no);

	public int addReview(ReviewDTO review);

	public List<FoodDTO> foodList();

	public void dbInsert(FoodDTO food);

	public List<FoodDTO> cafeList();


}
