package com.spring.project.mypage.dao;

import java.util.List;

import com.spring.project.mypage.dto.TravleDTO;

public interface TravleDAO {
	public List<TravleDTO> travleList(String id);

}
