package example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
 * 	MVC에서 C(controller)가 서블릿이다.
 * 	이 서블릿이 spring에 DispatcherServlet 파일이다.
 * 	이 파일이 내가 지정한 요청 다시 호출해주는 구조이다.
 */

@Controller
public class HelloController {
	
	
	// 00_start.jsp에서
	// "start.do라는 이름을 찾아 이 메소드를 호출
	@RequestMapping("/start.do")
	public ModelAndView start() {
		System.out.println("start.do 요청 확인");
		// 뷰페이지를 지정하고 뷰 단으로 데이터 전달
		ModelAndView mv = new ModelAndView();
//		mv.addObject("속성이름", "value");
		mv.addObject("name", "홍길동");
		mv.addObject("message", "아 졸려\n");
//		mv.setViewName("/WEB-INF/view/hello.jsp");
		mv.setViewName("hello");
		
		return mv;
	}
}
