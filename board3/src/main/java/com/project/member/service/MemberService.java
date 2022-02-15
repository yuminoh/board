package com.project.member.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.member.dao.MemberDAO;
import com.project.member.dao.MemberDAOInter;
import com.project.member.vo.MemberVO;

@Service
public class MemberService implements MemberServiceInter{
	@Autowired
	MemberDAOInter memberDAO;

	@Override
	public int insert(MemberVO memberVO) {
		int cnt = this.memberDAO.insert(memberVO);
		return cnt;
	}
	
	@Override
	public int delete(int memberno) {
		return memberDAO.delete(memberno);
	}
	
	@Override
	public int update(MemberVO memberVO) {
		return memberDAO.update(memberVO);
	}
	
	@Override
	public MemberVO selectOne(int memberno) {
		return memberDAO.selectOne(memberno);
	}
	/*
	@Override
	public List<MemberVO> selectList(HashMap<String,Object> paramMap){
		return memberDAO.selectList(paramMap);
	}
	*/
	@Override
	public MemberVO checkUser(MemberVO memberVO) {
		return memberDAO.exist(memberVO);
	}
	
}
