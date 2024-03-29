package com.spring.project.mypage.service;

import java.util.List;

import com.spring.project.mypage.dto.PickDTO;
import com.spring.project.mypage.dto.TravleDTO;

public interface TravleService {
	public List<PickDTO> travleList(String id);

	public int addSchedule(TravleDTO travle);
	
	public List<TravleDTO> scheduleList(String id);
	
	public int modSchedule(TravleDTO travle);

	public int delSchedule(TravleDTO travle);

}
