package com.javaclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaclass.model.MemberVO;

@Controller
public class ModelAttrController {
	
	@RequestMapping("modelAttr.do")
	public void modelAttr() {
		System.out.println("modelAttr.do 요청 확인");
	}
	
	@ModelAttribute("message")
	public String str() {
		return "행복한 화요일";
	}
	
	@ModelAttribute("memberVO")
	public MemberVO obj() {
		MemberVO vo = new MemberVO();
		vo.setId("sontaku");
		vo.setName("손진영");
		vo.setAge(20);
		return vo;
	}
}
