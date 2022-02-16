package com.project.post.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.project.board.HomeController;
import com.project.board.paging.Criteria;
import com.project.board.paging.PageBox;
import com.project.member.vo.MemberVO;
import com.project.post.service.PostServiceInter;
import com.project.post.vo.PostVO;
import com.project.reply.service.ReplyService;
import com.project.reply.vo.ReplyVO;

@Controller
public class PostCont {
	@Autowired
	PostServiceInter postService;
	
	@Autowired
	ReplyService replyService;
	
	MemberVO memberVO;
	
	private Logger logger = LoggerFactory.getLogger(PostCont.class);
	
	@RequestMapping(value="/post/add.do", method=RequestMethod.GET)
	public ModelAndView insert(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		String id = (String) session.getAttribute("id");
		if(id == null) {
			mav.setViewName("redirect:/member/login.do");
		} else {
			mav.setViewName("post/add"); //
		}
		
		return mav;
	}
	
	@RequestMapping(value="/post/add.do", method=RequestMethod.POST)
	public ModelAndView insert(HttpSession session, PostVO postVO) {
		ModelAndView mav = new ModelAndView();
		session.getAttribute("login");
		String id = (String) session.getAttribute("id");
		int memberno = (int) session.getAttribute("memberno");
		postVO.setWriter(id);
		postVO.setMemberno(memberno);
		int cnt = this.postService.insert(postVO);
		//mav.addObject("cnt", cnt);
		mav.setViewName("redirect:/");
		
		return mav;
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView selectList(Criteria criteria, @RequestParam(value="word", required=false, defaultValue="") String word) {
		ModelAndView mav = new ModelAndView();
		
		PageBox pageb = new PageBox();
		pageb.setCriteria(criteria);
		pageb.setTotalCount(postService.count(criteria));
		List<Map<String, Object>> list = this.postService.listsps(criteria);
		
		mav.addObject("pageb", pageb);
		mav.addObject("word", word);
		mav.addObject("list", list);
		mav.setViewName("post/list");
		return mav;
	}
	
	@RequestMapping(value="/post/delete.do", method=RequestMethod.GET)
	public ModelAndView delete_read(HttpSession session, int postno) {
		ModelAndView mav = new ModelAndView();
		
		String sessionid = (String) session.getAttribute("id");
		logger.info("{}", sessionid);
		PostVO postVO = this.postService.delete_read(postno);
		String id = postVO.getWriter();
		logger.info("{}", id);
		if(sessionid == null) {
			mav.setViewName("redirect:board//member/login.do");
		} else if(!sessionid.equals(id)) {
			mav.setViewName("post/deleteFail");
		} else {
			mav.addObject("postVO", postVO);
			mav.addObject("postno", postVO.getPostno());
			mav.setViewName("post/delete");
		}
		
		return mav;
	}
	
	@RequestMapping(value="/post/delete.do", method=RequestMethod.POST)
	public ModelAndView delete(int postno) {
		ModelAndView mav = new ModelAndView();
		int cnt = this.postService.delete(postno);
		mav.addObject("postno", postno);
		
		mav.setViewName("redirect:/");
		return mav;
	}
	
	@RequestMapping(value="/post/deleteFail.do", method=RequestMethod.GET)
	public ModelAndView deleteFail() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("post/deleteFail");
		
		return mav;
	}
	
	@RequestMapping(value="/post/update.do", method=RequestMethod.GET)
	public ModelAndView update_read(HttpSession session, int postno) {
		ModelAndView mav = new ModelAndView();
		session.getAttribute("login");
		String sessionid = (String) session.getAttribute("id");
		PostVO postVO = this.postService.update_read(postno);
		String id = postVO.getWriter();
		if(sessionid == null) {
			mav.setViewName("redirect:/member/login.do");
		} else if(!sessionid.equals(id)){
			mav.setViewName("post/updateFail");
		} else {
			mav.addObject("postVO", postVO);
			mav.addObject("postno", postVO.getPostno());
			mav.setViewName("post/update");
		}
		
		return mav;
	}
	
	@RequestMapping(value="/post/update.do", method=RequestMethod.POST)
	public ModelAndView update(PostVO postVO) {
		ModelAndView mav = new ModelAndView();
	
		int cnt = this.postService.update(postVO);
		mav.addObject("postVO", postVO);
		mav.addObject("postno", postVO.getPostno());
		mav.setViewName("redirect:/");
		
		return mav;
	}
	
	@RequestMapping(value="/post/updateFail.do", method=RequestMethod.GET)
	public ModelAndView updateFail() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("post/updateFail");
		
		return mav;
	}
	
	@RequestMapping(value="/post/read.do", method=RequestMethod.GET)
	public ModelAndView selectOne(int postno) {
		ModelAndView mav = new ModelAndView();
		PostVO postVO = this.postService.selectOne(postno);
		logger.info("{}", postno);
		
		mav.addObject("postVO", postVO);
		
		mav.setViewName("post/read");
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value = "/post/replylist.do",produces = "application/json", method = RequestMethod.GET)
	public String ajax_replylist(@RequestParam(value="postno")int postno, HttpSession session) {
		
		List<ReplyVO> replylist = this.postService.selectList(postno);
		Gson gson = new Gson();
		String json = gson.toJson(replylist);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value="/post/reinsert.do",produces = "application/json", method=RequestMethod.POST)
	public String insert(ReplyVO replyVO, HttpSession session){
		
		session.getAttribute("login");
		int memberno = (int) session.getAttribute("memberno");
		String rwriter = (String) session.getAttribute("id");
		logger.info("/post/reinsert.do memberno: {}", memberno);
		replyVO.setMemberno(memberno);
		replyVO.setRwriter(rwriter);
		postService.insert(replyVO);
		Gson gson = new Gson();
		String json = gson.toJson(replyVO);
		
		return json;
	}
	/*
	@ResponseBody
	@RequestMapping(value="/post/reupdate.do",produces = "application/json", method=RequestMethod.POST)
	public String update(ReplyVO replyVO, HttpSession session){
		
		session.getAttribute("login");
		int memberno = (int) session.getAttribute("memberno");
		int replyno = replyVO.getReplyno();
		String id = replyVO.getRwriter();
		replyVO.setMemberno(memberno);
		postService.update(replyVO);
		Gson gson = new Gson();
		String json = gson.toJson(replyVO);
		
		return json;
	}
	*/
	
	@ResponseBody
	@RequestMapping(value="/post/reupdate.do",produces = "application/json", method=RequestMethod.POST)
	public String update(ReplyVO replyVO, HttpSession session){
		
		session.getAttribute("login");
		String sessionid = (String) session.getAttribute("id");
		int memberno = (int) session.getAttribute("memberno");
		int replyno = replyVO.getReplyno();
		String id = replyVO.getRwriter();
		
		replyVO.setMemberno(memberno);
		postService.update(replyVO);
		Gson gson = new Gson();
		String json = gson.toJson(replyVO);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value="/post/redelete.do", produces="application/json", method=RequestMethod.POST)
	public String replydelete(@RequestParam(value="replyno")int replyno, HttpSession session, ModelAndView mav) {
		int cnt = postService.replydelete(replyno);
		Gson gson = new Gson();
		String json = gson.toJson(cnt);
		
		return json;
	}
	
}
