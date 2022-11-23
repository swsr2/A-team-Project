package com.spring.project.activity.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.project.activity.dto.ActivityDTO;

@Repository
public class ActivityDAOImpl implements ActivityDAO{
	@Autowired
	private SqlSession sqlSession;


	@Override
	public List<ActivityDTO> crsList(Map<String, Integer> page) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("mapper.activity.crsList", page);
	}

	@Override
	public List<ActivityDTO> activityList(Map<String, Integer> page) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("mapper.activity.activityList", page);
	}

	@Override
	public void dbInsert(ActivityDTO activity) {
		// TODO Auto-generated method stub
		sqlSession.insert("mapper.activity.dbInsert", activity);
	}

	@Override
	public int allActivityCnt() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mapper.activity.allActivityCnt");
	}

	@Override
	public int allCrsCnt() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mapper.activity.allCrsCnt");
	}

}