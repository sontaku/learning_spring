package com.javaclass.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.javaclass.model.MemberVO;

// 메모리 등록
@Controller
public class ParameterController {
	
//	// from 04_parameter.jsp
//	@RequestMapping("param.do")
//	public void param() {
//		System.out.println("param.do 요청 확인");
//	}
	/*
	 * 	[중요] RequestMapping 되는 함수
	 * 	view 페이지 지정 방식
	 * 	1. ModelAndView에 setViewName()으로 지정하고
	 * 		ModelAndView 객체를 리턴
	 * 	2. String을 리턴하면 그 리턴값이 view 페이지명
	 * 	3. void로 리턴하면 요청명과 동일한 view 페이지 자동 지정됨
	 * 
	 * 
	 */
	
	
//	@RequestMapping("param.do")
//	public void param(String id, int age) {
//		System.out.println("param.do 요청 확인");
//	}
	
	// 파라미터를 받는 경우
	// 파라미터로 null 값이 들어오면 에러가 발생한다.
	@RequestMapping("param.do")
	public void param(String id, @RequestParam(defaultValue = "0") int age) {
		System.out.println("param.do 요청 확인");
	}
	
	@RequestMapping(value = "paramForm.do", method = RequestMethod.POST)
	// [중요] 로그인 세션 처리
	public ModelAndView paramForm(MemberVO vo, HttpSession session) {
		System.out.println("paramForm.do 요청 확인");
		
		String id = "sontaku";
		String pw = "1234";
		if(vo.getId().equals(id) && vo.getName().equals(pw)) {
			// "login" 이라는 속성명으로 세션 저장
			session.setAttribute("login", id + "님 로그인 중");
		}
		
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("param2");
		return mv;
	}
}





