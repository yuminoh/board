package com.project.board.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.project.member.vo.MemberVO;

@Service
public class Interceptor extends HandlerInterceptorAdapter {
	
	private Logger logger = LoggerFactory.getLogger(Interceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (logger.isDebugEnabled()) {
            logger.debug("===================       START       ===================");
            logger.debug(" Request URI \t:  " + request.getRequestURI());
        }
		
		HttpSession session = request.getSession();
        MemberVO memberVO = (MemberVO) session.getAttribute("login");
 

        if(session == null || memberVO == null){
            response.sendRedirect("/board/member/login.do");
            return false;
        }

        
        return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if (logger.isDebugEnabled()) {
            logger.debug("===================        END        ===================\n");
        }
		super.postHandle(request, response, handler, modelAndView);
	}
	
}
