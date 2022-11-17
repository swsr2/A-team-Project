package com.spring.project.member.service;


import com.spring.project.member.dto.MemberDTO;

public interface MemberService {
//	public List<MemberDTO> listMembers();
	public void addMember(MemberDTO member);
	public int modMember(MemberDTO member);
	public int delMember(String id);
	public MemberDTO login(MemberDTO member);
	public int idChk(MemberDTO member);
}
