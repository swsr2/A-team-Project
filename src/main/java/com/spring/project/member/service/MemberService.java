package com.spring.project.member.service;

import java.util.List;

import com.spring.project.member.dto.MemberDTO;

public interface MemberService {
//	public List<MemberDTO> listMembers();
	public void addMember(MemberDTO member);
	public MemberDTO selectOne(String id);
	public int modMember(MemberDTO member);
	public int delMember(String id);
	public MemberDTO login(MemberDTO member);
}
