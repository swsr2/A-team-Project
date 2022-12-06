package com.spring.project.mypage.dao;

import java.util.List;

import com.spring.project.mypage.dto.PickDTO;

public interface TravleDAO {
	public List<PickDTO> travleList(String id);

}
