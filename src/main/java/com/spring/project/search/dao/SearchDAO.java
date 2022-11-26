package com.spring.project.search.dao;

import java.util.List;
import java.util.Map;

import com.spring.project.food.dto.FoodDTO;

public interface SearchDAO {

	List<String> columnsList(String tableName);

	List<FoodDTO> foodSearch(Map map);

}
