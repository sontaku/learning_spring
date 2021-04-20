package com.javaclass.controller;

import java.lang.reflect.Member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.javaclass.model.MemberVO;

@Controller
@RequestMapping("/re")
public class RequestMappingController {
	
	@RequestMapping(value= {"/a.do", "/b.do"})
	public String test() {
		System.out.println("a.do 요청 확인");
		return "hello";
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("id", 123);
//		mv.addObject("name", "홍길동");
//		mv.addObject("age", 25);
//		
//		mv.setViewName(viewName);
	}
	/*
	 * [중요]
	 * 	뷰페이지 지정 방식
	 * 	1) ModelAndView에 setViewName()지정
	 * 	2) 함수의 리턴형을 String인 경우
	 *		그 리턴값이 뷰페이지
	 */
	
//	@RequestMapping(value="c.do")
//	public void test2() {
//		System.out.println("c.do 요청 확인");
//	}
//	
//	/*
//	 * [중요]
//	 * 	함수의 리턴형이 void인 경우
//	 * 	요청명과 동일한 뷰페이지 자동으로 지정됨
//	 */
	
	@RequestMapping(value="c.do")
	public void test2(String id) {
		System.out.println("c.do 요청 확인" + id);
	}
	
	/*
	 * [중요]
	 * 	함수의 리턴형이 void인 경우
	 * 	요청명과 동일한 뷰페이지 자동으로 지정됨
	 */
	
	@RequestMapping("request.do")
	public void req(MemberVO vo) {
		System.out.println("request.do 요청");
	}
//	@RequestMapping("request.do")
//	public void req(@ModelAttribute("vo") MemberVO vo) {
//		System.out.println("request.do 요청");
//	}
}






