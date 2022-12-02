package com.spring.project.member.kakao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class KakaoDAO {
	
	private static SqlSession sqlSession;
	
	public static final String MAPPER = "mapper.memeber.kakao";
	
	@Autowired
	public KakaoDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	// 정보 저장
	public static void kakaoInsert(HashMap<String, Object> userInfo) {
		sqlSession.insert(MAPPER + ".insert", userInfo);
	}
	
	// 정보 확인
	public static KakaoVO findKakao(HashMap<String, Object> userInfo) {
		System.out.println("RN : " + userInfo.get("k_nickname"));
		
		return sqlSession.selectOne(MAPPER + ".kakao", userInfo);
	}
}
