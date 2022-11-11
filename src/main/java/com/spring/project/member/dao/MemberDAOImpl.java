package com.spring.project.member.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.project.member.dto.MemberDTO;

@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<MemberDTO> selectAllMembers() {
		// TODO Auto-generated method stub
		List<MemberDTO> membersList = sqlSession.selectList("mapper.member.selectAllMemberList"); 
		return membersList;
	}

	@Override
	public void addMember(MemberDTO member) {
		// TODO Auto-generated method stub
		sqlSession.insert("mapper.member.insertMember", member);
	}

	@Override
	public MemberDTO selectOne(String id) {
		// TODO Auto-generated method stub
		MemberDTO member = (MemberDTO) sqlSession.selectOne("mapper.member.selectMemberById", id);
		return member;
	}

	@Override
	public int modMember(MemberDTO member) {
		// TODO Auto-generated method stub
		int result = sqlSession.update("mapper.member.updateMember", member);
		return result;
	}

	@Override
	public int delMember(String id) {
		// TODO Auto-generated method stub
		int result = sqlSession.delete("mapper.member.deleteMember", id);
		return result;
	}

	@Override
	public MemberDTO login(MemberDTO member) {
		// TODO Auto-generated method stub
		MemberDTO memberDTO = sqlSession.selectOne("mapper.member.loginById", member);
		return memberDTO;
	}

}















