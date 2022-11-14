package com.spring.project.food.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.project.food.dao.FoodDAO;
import com.spring.project.food.dto.FoodDTO;
import com.spring.project.food.dto.ReviewDTO;

@Service
public class FoodServiceImpl implements FoodService {
	@Autowired
	FoodDAO foodDAO;

	@Override
	public FoodDTO selectOne(int fd_no) {
		// TODO Auto-generated method stub
		return foodDAO.selectOne(fd_no);
	}

	@Override
	public int addReview(ReviewDTO review) {
		// TODO Auto-generated method stub
		return foodDAO.addReview(review);
	}

	@Override
	public List<FoodDTO> foodList(int start, int end) {
		// TODO Auto-generated method stub
		Map<String, Integer> page = new HashMap<String, Integer>();
		page.put("start", start);
		page.put("end", end);
		return foodDAO.foodList(page);
	}

	@Override
	public void dbInsert(FoodDTO food) {
		// TODO Auto-generated method stub
		foodDAO.dbInsert(food);
	}

	@Override
	public List<FoodDTO> cafeList(int start, int end) {
		// TODO Auto-generated method stub
		Map<String, Integer> page = new HashMap<String, Integer>();
		page.put("start", start);
		page.put("end", end);
		return foodDAO.cafeList(page);
	}

	@Override
	public int allFoodCnt() {
		// TODO Auto-generated method stub
		return foodDAO.allFoodCnt();
	}

	@Override
	public int allCafeCnt() {
		// TODO Auto-generated method stub
		return foodDAO.allCafeCnt();
	}

}
