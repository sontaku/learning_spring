package com.javaclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StartController {
	
	@RequestMapping("/start.do")
	public ModelAndView start() {
		System.out.println("start.do 요청에 의한 StartController 호출");
		ModelAndView mv = new ModelAndView();
		mv.addObject("name", "홍길동");
		mv.addObject("age", "25");
		
		mv.setViewName("hello"); // /WEB-INF/view/hello.jsp로 view 객체 전달
		return mv;
	}
}
