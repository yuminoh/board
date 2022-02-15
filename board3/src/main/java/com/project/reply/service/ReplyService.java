package com.project.reply.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.post.vo.PostVO;
import com.project.reply.dao.ReplyDAO;
import com.project.reply.vo.ReplyVO;

@Service
public class ReplyService {
	@Autowired
	ReplyDAO replyDAO;
	
	public int insert(ReplyVO replyVO) {
		int cnt = this.replyDAO.insert(replyVO);
		return cnt;
	}
	
	public int redelete(int replyno) {
		int cnt = this.replyDAO.redelete(replyno);
		return cnt;
	}
	
	public int update(ReplyVO replyVO) {
		int cnt = this.replyDAO.update(replyVO);
		
		return cnt;
	}
	
	public List<ReplyVO> selectList(int postno) {
		List<ReplyVO> list;
		list = this.replyDAO.selectList(postno);
		return list;
	}
}
