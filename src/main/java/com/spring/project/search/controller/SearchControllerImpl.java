package com.spring.project.search.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.project.food.dto.FoodDTO;
import com.spring.project.search.service.SearchService;

@Controller
@EnableAspectJAutoProxy
@RequestMapping("/search")
public class SearchControllerImpl implements SearchController{
	@Autowired
	private SearchService searchService;

	@Override
	@RequestMapping("/key")
	public ModelAndView searchKey(@RequestParam("search")String search,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		// food 검색
		List<String> foodColumns = searchService.columnsList("food");
		List<FoodDTO> foodSearch = searchService.foodSearch(foodColumns,search);
		System.out.println(foodSearch.size());
		// lodging 검색
		List<String> lodgingColumns = searchService.columnsList("lodging_info");
		// activity 검색
		List<String> activityColumns = searchService.columnsList("activity");
		// tour 검색
		List<String> tourColumns = searchService.columnsList("tour");
		return null;
	}
}
