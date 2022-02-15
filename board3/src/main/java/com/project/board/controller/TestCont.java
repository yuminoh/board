package com.project.board.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.board.interceptor.Interceptor;

public class TestCont {
	private Logger logger = LoggerFactory.getLogger(TestCont.class);
	
	@RequestMapping(value="/interceptorTest.do")
    public ModelAndView interceptorTest() throws Exception{
         
        ModelAndView mav = new ModelAndView("");
        logger.debug("인터셉터 테스트");
        return mav;
    }
}
