package com.javassem.service;

import java.util.List;

import com.javassem.domain.MemberVO;

public interface MemberService {
	public MemberVO idCheck_Login( MemberVO vo);
	public int userInsert(MemberVO vo );
	public List<MemberVO> selectAll();
}
