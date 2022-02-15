package com.project.post.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.project.board.paging.Criteria;
import com.project.member.vo.MemberVO;
import com.project.post.vo.PostVO;
import com.project.reply.vo.ReplyVO;

public interface PostServiceInter {
	int insert(PostVO postVO);
	
	PostVO selectOne(int postno);
	
	int delete(int postno);
	
	int update(PostVO postVO);
	
	List<PostVO> selectList();
	
	List<Map<String, Object>> listsps(Criteria criteria);
	
	PostVO update_read(int postno);
	
	PostVO delete_read(int postno);
	
	int count(Criteria criteria);
	
	//
	List<ReplyVO> selectList(int postno);
	
	int insert(ReplyVO replyVO);
	
	int update(ReplyVO replyVO);
	
	int replydelete(int replyno);
	
	ReplyVO read(int replyno);
}
