package com.spring.project.search.service;

import java.util.List;

import com.spring.project.food.dto.FoodDTO;

public interface SearchService {

	List<String> columnsList(String tableName);

	List<FoodDTO> foodSearch(List<String> foodColumns, String search);

}
