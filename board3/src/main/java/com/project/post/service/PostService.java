package com.project.post.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.board.paging.Criteria;
import com.project.member.vo.MemberVO;
import com.project.post.dao.PostDAOInter;
import com.project.post.vo.PostVO;
import com.project.reply.vo.ReplyVO;

@Service
public class PostService implements PostServiceInter{
	@Autowired
	PostDAOInter postDAO;
	
	@Override
	public int insert(PostVO postVO) {
		int cnt = this.postDAO.insert(postVO);
		return cnt;
	}
	
	@Override
	public PostVO delete_read(int postno) {
		PostVO postVO = this.postDAO.selectOne(postno);
		return postVO;
	}
	
	@Override
	public int delete(int postno) {
		//return postDAO.delete(postno);
		int cnt = this.postDAO.delete(postno);
		return cnt;
	}
	
	@Override
	public int update(PostVO postVO) {
		int cnt = this.postDAO.update(postVO);
		
		return cnt;
	}
	
	@Override
	public PostVO update_read(int postno) {
		PostVO postVO = this.postDAO.selectOne(postno);
		
		return postVO;
	}
	
	@Override
	public List<PostVO> selectList() {
		List<PostVO> list;
		list = this.postDAO.selectList();
		return list;
	}
	
	@Override
	public List<Map<String, Object>> listsps(Criteria criteria) {
		return postDAO.listsps(criteria);
	}
	
	@Override
	public PostVO selectOne(int postno) {
		PostVO postVO = this.postDAO.selectOne(postno);
		
		String title = postVO.getTitle();
		String content = postVO.getContent();
		return postDAO.selectOne(postno);
	}
	
	@Override
	public int count(Criteria criteria) {
		return postDAO.count(criteria);
	}
	
	//
	@Override
	public List<ReplyVO> selectList(int postno){
		List<ReplyVO> relist;
		relist = postDAO.selectList(postno);
		return relist;
	}
	
	@Override
	public int insert(ReplyVO replyVO) {
		return postDAO.insert(replyVO);
	}
	
	@Override
	public int update(ReplyVO replyVO) {
		return postDAO.update(replyVO);
	}
	
	@Override
	public int replydelete(int replyno) {
		return postDAO.replydelete(replyno);
	}
	
	@Override
	public ReplyVO read(int replyno) {
		ReplyVO replyVO = this.postDAO.read(replyno);
		
		return replyVO;
	}
}
