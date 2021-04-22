package com.javassem.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.javassem.dao.MemberDAO;
import com.javassem.domain.MemberVO;
import com.javassem.service.MemberService;
import com.javassem.service.MemberServiceImpl;

@Controller
public class MemberController {
   
   @Autowired
   MemberServiceImpl service;
   
   // 로그인 페이지로 이동
   @RequestMapping("user/userLogin.do")
   public String moveLogin() {
      return "user/userLogin";
   }
   
   // 로그인 요청
   @RequestMapping("user/login.do")
   public String Login(Model m, MemberVO vo) {
      
      MemberVO ourMember = service.idCheck_Login(vo);
      
      // DB로부터 가져온 값이 없으면 다시 로그인 값으로 이동
      if(ourMember==null) {
         return "user/userLogin";
      }
      
      // DB값에서 패스워드가 일치하면 로그인 ok로 이동
      if(ourMember.getUserPass().equals(vo.getUserPass())) {
         m.addAttribute("userName", service.idCheck_Login(vo).getUserId());
         return "user/login_ok";
      }
      
      // 그외는 다시 로그인 화면
      return "user/userLogin";
   }
   
   // 회원가입 페이지로 이동
   @RequestMapping("user/userJoin.do")
   public String join() {
//      System.out.println(service.idCheck_Login(vo).getUserId());
      return "user/userJoin";
   }
   
   // 회원가입 요청
   @RequestMapping("user/userInsert.do")
   public String insertDB(MemberVO vo) {
      service.userInsert(vo);
      return "user/userJoin_ok";
   }
   
   // 멤버 리스트 요청
   @RequestMapping("user/memberInfo.do")
   public ModelAndView memberInfo() {
      ModelAndView mv = new ModelAndView();
      mv.addObject("memberList", service.selectAll());
      mv.setViewName("user/memberInfo");
      return mv;
   }
   
   //***********************************************
   @RequestMapping(value="user/idCheck.do", produces = "application/text; charset=utf8")
   @ResponseBody //ResponseBody return을 String타입의 문자열이 아닌 데이터로 리턴하려고 사용
   public String idCheck(MemberVO vo) {
	   MemberVO result = service.idCheck_Login(vo);
	   String message = "사용가능한 아이디입니다.";
	   if( result != null) message = "중복된 ID가 있습니다.";
	   return message;
   }
}