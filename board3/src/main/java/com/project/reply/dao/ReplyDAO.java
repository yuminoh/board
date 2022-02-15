package com.project.reply.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.post.vo.PostVO;
import com.project.reply.vo.ReplyVO;

@Repository
public class ReplyDAO {
	SqlSessionFactory sqlSessionFactory;
	@Autowired
	SqlSession sqlSession;
	
	@Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }
	
	public List<ReplyVO> selectList(int postno){
		sqlSession = sqlSessionFactory.openSession(true);
		return sqlSession.selectList("mapper.reply.selectList", postno);
	}
	
	public int insert(ReplyVO replyVO) {
		sqlSession = sqlSessionFactory.openSession(true);
		
		int count = sqlSession.insert("mapper.reply.insert", replyVO);
		sqlSession.commit();
		return count;
	}
	
	public int update(ReplyVO replyVO) {
		sqlSession = sqlSessionFactory.openSession(true);
		int count = sqlSession.update("mapper.reply.update", replyVO);
		sqlSession.commit();
		
		return count;
	}
	
	public int redelete(int replyno) {
		sqlSession = sqlSessionFactory.openSession(true);
		
		int count = sqlSession.delete("mapper.reply.redelete", replyno);
		sqlSession.commit();
		return count;
	}
}
