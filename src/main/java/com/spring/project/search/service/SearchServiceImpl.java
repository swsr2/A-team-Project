package com.spring.project.search.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.project.food.dto.FoodDTO;
import com.spring.project.search.dao.SearchDAO;

@Service
public class SearchServiceImpl implements SearchService{
	@Autowired
	private SearchDAO searchDAO;

	@Override
	public List<String> columnsList(String tableName) {
		// TODO Auto-generated method stub
		return searchDAO.columnsList(tableName);
	}

	@Override
	public List<FoodDTO> foodSearch(List<String> foodColumns,String search) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		map.put("columns", foodColumns);
		map.put("search", search);
		return searchDAO.foodSearch(map);
	}
}
