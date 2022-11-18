package com.spring.project.activity.service;

import java.util.List;

import com.spring.project.activity.dto.ActivityDTO;

public interface ActivityService {

	public int allActivityCnt();
	
	public int allCrsCnt();

	public List<ActivityDTO> activityList(int start, int end);

	public List<ActivityDTO> crsList(int start, int end);

}
