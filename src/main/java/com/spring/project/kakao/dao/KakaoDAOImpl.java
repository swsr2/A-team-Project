package com.spring.project.kakao.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.project.kakao.vo.KakaoVO;

@Repository("kakaoDAO")
public class KakaoDAOImpl implements KakaoDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	// 정보 저장
	@Override
	public void kakaoInsert(HashMap<String, Object> userInfo) {
		sqlSession.insert("mapper.kakao.insert", userInfo);
	}
	
	// 정보 확인
	@Override
	public KakaoVO findKakao(HashMap<String, Object> userInfo) {
		System.out.println("RN : " + userInfo.get("k_nickname"));
		
		return sqlSession.selectOne("mapper.kakao.kakao", userInfo);
	}
}
