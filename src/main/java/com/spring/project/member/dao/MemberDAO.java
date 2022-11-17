package com.spring.project.member.dao;


import com.spring.project.member.dto.MemberDTO;

public interface MemberDAO {
//	public List<MemberDTO> selectAllMembers();
	public void addMember(MemberDTO member);
//	public MemberDTO selectOne(String id);
	public int modMember(MemberDTO member);
	public int delMember(String id);
	public MemberDTO login(MemberDTO member);
	public int idChk(MemberDTO member);
}
