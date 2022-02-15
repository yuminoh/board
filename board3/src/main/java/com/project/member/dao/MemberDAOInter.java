package com.project.member.dao;

import java.util.HashMap;
import java.util.List;

import com.project.member.vo.MemberVO;

public interface MemberDAOInter {
	int insert(MemberVO membervo);
	
	int delete(int memberno);
	
	int update(MemberVO membervo);
	
	MemberVO selectOne(int memberno);
	
	MemberVO exist(MemberVO memberVO);

	//List<MemberVO> selectList(HashMap<String, Object> paramMap);
}
