package com.javaclass.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.javaclass.model.MemberVO;

@Controller
public class AutoScanController {

	@Autowired
	private MemberVO vo;
	/*
	 * 	멤버변수 객체 지정
	 * 	(1) 생성자
	 * 	(2) setter
	 * 	(3) annotation : @Autowired
	 */
	
	@RequestMapping("/autoScan.do")
	public ModelAndView test() {
		System.out.println("autoScan.do 요청 확인");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("autoScan");
		mv.addObject("vo", vo);
		return mv;
	}
}
