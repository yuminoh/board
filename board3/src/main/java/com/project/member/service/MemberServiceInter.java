package com.project.member.service;

import java.util.HashMap;
import java.util.List;

import com.project.member.vo.MemberVO;

public interface MemberServiceInter {
	int insert(MemberVO membervo);
	
	int delete(int memberno);
	
	int update(MemberVO membervo);
	
	MemberVO selectOne(int memberno);
	
	
	//List<MemberVO> selectList(HashMap<String,Object> paramMap);
	
	MemberVO checkUser(MemberVO memberVO);
}
