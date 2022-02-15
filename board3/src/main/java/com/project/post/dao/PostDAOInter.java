package com.project.post.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.project.board.paging.Criteria;
import com.project.post.vo.PostVO;
import com.project.reply.vo.ReplyVO;


public interface PostDAOInter {
	int insert(PostVO postVO);
	
	int delete(int postno);
	
	int update(PostVO postVO);
	
	PostVO selectOne(int postno);
	
	List<PostVO> selectList();
	
	List<Map<String, Object>> listsps(Criteria criteria);
	
	int count(Criteria criteria);
	
	//
	List<ReplyVO> selectList(int postno);
	
	int insert(ReplyVO replyVO);
	
	int update(ReplyVO replyVO);
	
	int replydelete(int replyno);
	
	ReplyVO read(int replyno);
}
