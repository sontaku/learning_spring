package com.javaclass.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/* 
 * 	[중요] 뷰페이지로 데이터 전달 방식
 * 	1. ModelAndView
 * 	2. Map(HashMap) - 잘 사용안함
 * 	3. Model
 */
@Controller
public class ReturnTypeController {
	
	@RequestMapping("modelandview.do")
	public ModelAndView a() {
		System.out.println("modelandview.do 전달");
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", "오늘도 맛점");
		mv.addObject("addr", "버거킹");
		mv.setViewName("test");
		return mv;
	}
	
	@RequestMapping("map.do")
	public Map b() {
		System.out.println("map.do 전달");
		Map m = new HashMap();
		m.put("message", "오늘도 맛점");
		m.put("addr", "버거킹");
		// 단점 : view 페이지 지정을 못함
		// 리턴값이 Map 형태로 정해져있어 view 페이지 지정방법은
		// 자동으로 map.do -> map.jsp
		
		return m;
	}
	
	// 1, 2 방법의 경우 데이터가 많으면 
	// 코드라인이 길어짐
	//
	// Model 객체를 이용해서 view 페이지로 지정할 때
	// 리턴이 아니라 인자에 지정하기
	@RequestMapping("model.do")
	public String c(Model m) {
		System.out.println("model.do 전달");
		m.addAttribute("message", "오늘도 맛점");
		m.addAttribute("addr", "버거킹");
		return "test";
	}
}
