package com.spring.project.activity.dao;

import java.util.List;
import java.util.Map;

import com.spring.project.activity.dto.ActivityDTO;


public interface ActivityDAO {

	public void dbInsert(ActivityDTO activity);

	List<ActivityDTO> crsList(Map<String, Integer> page);

	List<ActivityDTO> activityList(Map<String, Integer> page);

}
