package com.project.post.dao;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.board.paging.Criteria;
import com.project.member.vo.MemberVO;
import com.project.post.vo.PostVO;
import com.project.reply.vo.ReplyVO;

@Repository
public class PostDAO implements PostDAOInter{
	SqlSessionFactory sqlSessionFactory;
	@Autowired
	SqlSession sqlSession;
	
	@Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }
	
	public List<PostVO> selectList() {
		sqlSession = sqlSessionFactory.openSession(true);
		return sqlSession.selectList("mapper.post.selectList");
	}
	
	public int insert(PostVO postVO) {
		sqlSession = sqlSessionFactory.openSession(true);
		
		int count = sqlSession.insert("mapper.post.insert", postVO);
		String id = postVO.getWriter();
		
		System.out.println("-->"+id+ "폼 ");
		sqlSession.commit();
		return count;
	}
	
	public PostVO selectOne(int postno) {
		sqlSession = sqlSessionFactory.openSession(true);
		PostVO postVO = sqlSession.selectOne("mapper.post.selectOne", postno);
		return postVO;
	}
	
	public int update(PostVO postVO) {
		sqlSession = sqlSessionFactory.openSession(true);
		int count = sqlSession.update("mapper.post.update", postVO);
		//String t = postVO.getTitle();
		//String c = postVO.getContent();
		//System.out.println("-->"+t +c+ "폼 ");
		sqlSession.commit();
		
		return count;
	}
    
	public int delete(int postno) {
		sqlSession = sqlSessionFactory.openSession(true);
		
		int count = sqlSession.delete("mapper.post.delete", postno);
		sqlSession.commit();
		return count;
	}
	
	public List<Map<String, Object>> listsps(Criteria criteria) {
		return sqlSession.selectList("mapper.post.listsps", criteria);
	}
	
	public int count(Criteria criteria) {
		return sqlSession.selectOne("mapper.post.count", criteria);
	}
	
	//
	public List<ReplyVO> selectList(int postno){
		sqlSession = sqlSessionFactory.openSession(true);
		return sqlSession.selectList("mapper.reply.selectList", postno);
	}
	
	public int insert(ReplyVO replyVO) {
		sqlSession = sqlSessionFactory.openSession(true);
		int cnt = sqlSession.insert("mapper.reply.insert", replyVO);
		sqlSession.commit();
		return cnt;
	}
	
	public int update(ReplyVO replyVO) {
		sqlSession = sqlSessionFactory.openSession(true);
		int cnt = sqlSession.update("mapper.reply.update", replyVO);
		sqlSession.commit();
		return cnt;
	}
	
	public int replydelete(int replyno) {
sqlSession = sqlSessionFactory.openSession(true);
		
		int count = sqlSession.delete("mapper.reply.delete", replyno);
		sqlSession.commit();
		return count;
	}
	
	public ReplyVO read(int replyno) {
		sqlSession = sqlSessionFactory.openSession(true);
		ReplyVO replyVO = sqlSession.selectOne("mapper.reply.read", replyno);
		return replyVO;
	}
}
