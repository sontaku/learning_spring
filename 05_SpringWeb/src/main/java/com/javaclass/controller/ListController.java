package com.javaclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaclass.model.MemberVO;
import com.javaclass.model.MemberVOList;

@Controller
public class ListController {

	// 추후 모델 호출 영역(DB insert 등)
	@RequestMapping("/multiInsert.do")
	public void list(MemberVOList memberVOList) {
		System.out.println("ListController list 실행!");
		for(MemberVO m : memberVOList.getList()) {
			System.out.println(m.isState() + "/" + m.getId() + "/" + m.getName() + "/" + m.getAge());
		}
		
	}
	// 함수의 리턴형이 void 인 경우
	// 요청 : multiInsert.do
	// => 뷰 : multiInsert.jsp
}
