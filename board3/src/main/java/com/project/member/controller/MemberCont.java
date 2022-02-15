package com.project.member.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.member.service.MemberService;
import com.project.member.service.MemberServiceInter;
import com.project.member.vo.MemberVO;
import com.project.post.controller.PostCont;
import com.project.post.vo.PostVO;

@Controller
public class MemberCont {
	@Autowired
	MemberServiceInter memberService;
	private Logger logger = LoggerFactory.getLogger(MemberCont.class);
	
	@RequestMapping(value="/member/add.do", method=RequestMethod.GET)
	public ModelAndView insert() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/add");
		return mav;
	}
	
	@RequestMapping(value="/member/add.do", method=RequestMethod.POST)
	public ModelAndView insert(MemberVO memberVO) {
		ModelAndView mav = new ModelAndView();
		int cnt = this.memberService.insert(memberVO);
		if(cnt == 1) {
			mav.setViewName("member/login");
		} else {
			mav.setViewName("redirect:/member/add.do");
		}
		return mav;
	}
	
	@RequestMapping(value="/member/update_read.do", method=RequestMethod.GET)
	public ModelAndView update_read(int memberno) {
		ModelAndView mav = new ModelAndView();
		
		MemberVO memberVO = this.memberService.selectOne(memberno);
		mav.addObject("memberVO", memberVO);
		mav.setViewName("member/update_read");
		
		return mav;
	}
	
	@RequestMapping(value="/member/update.do", method=RequestMethod.GET)
	public ModelAndView update(int memberno) {
		ModelAndView mav = new ModelAndView();
		
		MemberVO memberVO = this.memberService.selectOne(memberno);
		mav.addObject("memberVO", memberVO);
		mav.setViewName("member/update");
		
		return mav;
	}
	
	@RequestMapping(value="/member/update.do", method=RequestMethod.POST)
	public ModelAndView update(MemberVO memberVO) {
		ModelAndView mav = new ModelAndView();
		
		int cnt = this.memberService.update(memberVO);
		int memberno = memberVO.getMemberno();
		mav.addObject("memberno", memberno);
		if(cnt == 1) {
			mav.addObject("memberVO", memberVO);
			mav.setViewName("member/update");
		} else {
			mav.setViewName("member/update_read.do");
		}
		
		return mav;
	}
	
	@RequestMapping(value="/member/login.do", method=RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/login");
		return mav;
	}
	
	@RequestMapping(value="/member/login.do", method=RequestMethod.POST)
	public ModelAndView login(HttpSession session, MemberVO memberVO) {
		ModelAndView mav = new ModelAndView();
		
		memberVO = memberService.checkUser(memberVO);
		
		if(memberVO != null) {
			String id = memberVO.getId();
		    session.setAttribute("memberno", memberVO.getMemberno());
		    session.setAttribute("id", memberVO.getId());
		    session.setAttribute("mname", memberVO.getMname());
		    session.setAttribute("login", memberVO);
		    
		    int memberno =(int) session.getAttribute("memberno");
			logger.info("/member/login.do memberno: {}", memberno);
			mav.setViewName("redirect:/");
		} else {
			mav.setViewName("member/loginFail");
			System.out.println("-->로그인 실패");
		}
		
		return mav;
	}
	
	@RequestMapping(value="/member/logout.do", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView logout(HttpSession session, MemberVO memberVO) {
		ModelAndView mav = new ModelAndView();
		String id="";
		if(session != null && session.getAttribute("login") != null) {
			memberVO = (MemberVO) session.getAttribute("login");
			id = memberVO.getId();
		}
		
		//mav.addObject("id", id);
		mav.setViewName("redirect:/");
		session.invalidate();
		
		return mav;
	}
	
	@RequestMapping(value="/member/loginFail.do", method=RequestMethod.GET)
	public ModelAndView loginFail() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/loginFail");
		
		return mav;
	}
}
