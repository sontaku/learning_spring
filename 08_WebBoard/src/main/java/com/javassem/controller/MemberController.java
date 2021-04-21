package com.javassem.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.javassem.dao.MemberDAO;
import com.javassem.domain.MemberVO;
import com.javassem.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;

//	@RequestMapping("{step}.do")
//	public String viewPage(@PathVariable String step) {
//		System.out.println(step + " 호출");
//		
//		if(step.equals("login")) return "user/Main";
//		return "user/" + step;
//	}
	@RequestMapping("user/{step}.do")
	public String viewPage2(@PathVariable String step) {
		System.out.println(step + " 호출");

		if (step.equals("login"))
			return "user/login_ok";
		else if (step.equals("login_ok"))
			System.out.println("스텝쓰지마용");
		return "user/" + step;
	}

//	@RequestMapping("user/userJoin.do")
//	public void userJoin(MemberVO vo) {
//		System.out.println("userJoin 실행");
//	}

	@RequestMapping("user/userInsert.do")
	public String userInsert(MemberVO vo) {
		System.out.println("userInsert 실행");
		memberService.userInsert(vo);
		return "user/userJoin_ok";
	}

//	@RequestMapping("user/userJoin.do")
//	public void userInsert2(MemberVO vo) {
//		memberService.userInsert(vo);
//	}
//	
	@RequestMapping("user/userLogin.do")
	public void userLogin(MemberVO vo) {
		System.out.println("userLogin 실행");
		memberService.idCheck_Login(vo);
	}

	@RequestMapping("user/main1.do")
	public void main() {
		System.out.println("main1 실행");
	}
}
