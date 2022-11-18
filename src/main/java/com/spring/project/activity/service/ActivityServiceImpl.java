package com.spring.project.activity.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.project.activity.dao.ActivityDAO;
import com.spring.project.activity.dto.ActivityDTO;

@Service
public class ActivityServiceImpl implements ActivityService{
	@Autowired
	ActivityDAO activityDAO;
	
	
	@Override
	public int allActivityCnt() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int allCrsCnt() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ActivityDTO> activityList(int start, int end) {
		// TODO Auto-generated method stub
		Map<String, Integer> page = new HashMap<String, Integer>();
		page.put("start", start);
		page.put("end", end);
		
		return activityDAO.activityList(page);
	}

	@Override
	public List<ActivityDTO> crsList(int start, int end) {
		// TODO Auto-generated method stub
		Map<String, Integer> page = new HashMap<String, Integer>();
		page.put("start", start);
		page.put("end", end);
		
		return activityDAO.crsList(page);
	}

}
