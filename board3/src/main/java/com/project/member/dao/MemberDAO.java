package com.project.member.dao;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.project.member.vo.MemberVO;

@Repository
public class MemberDAO implements MemberDAOInter {
	SqlSessionFactory sqlSessionFactory;
	@Autowired
	SqlSession sqlSession;
	
	@Autowired
	  public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
	    this.sqlSessionFactory = sqlSessionFactory;
	  }
	/*
	public List<MemberVO> selectList(HashMap<String,Object> paramMap) {
		sqlSession = sqlSessionFactory.openSession(true);
		return sqlSession.selectList("mapper.member.selectList", paramMap);
	}
	*/
	public int insert(MemberVO memberVO) {
		sqlSession = sqlSessionFactory.openSession(true);
		
		int count = sqlSession.insert("mapper.member.insert", memberVO);
		sqlSession.commit();
		return count;
	}
	
	public MemberVO selectOne(int memberno) {
		sqlSession = sqlSessionFactory.openSession(true);
		
		return sqlSession.selectOne("mapper.member.selectOne", memberno);
	}
	
	public int update(MemberVO memberVO) {
		sqlSession = sqlSessionFactory.openSession(true);
		int count = sqlSession.update("mapper.member.update", memberVO);
		sqlSession.commit();
		return count;
    	
	}
    
	public int delete(int memberno) {
		sqlSession = sqlSessionFactory.openSession(true);
		
		int count = sqlSession.delete("mapper.member.delete", memberno);
		sqlSession.commit();
		return count;
	}
	
	public MemberVO exist(MemberVO memberVO) {
	  	sqlSession = sqlSessionFactory.openSession(true);
	  	return sqlSession.selectOne("mapper.member.exist", memberVO);
	}

}
