package com.javassem.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.javassem.domain.BoardVO;
import com.javassem.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;

	
	// ~~.do로 끝나는걸 받음
	@RequestMapping("{step}.do")
	public String test(@PathVariable String step) {
		System.out.println(step + "요청 확인");
		return step;
	}
	
	
//	@RequestMapping("insertBoard.do")
//	public void insertBoard() {
//		System.out.println("insertBoard 호출");
//	}

	@RequestMapping("saveBoard.do")
	public String saveBoard(BoardVO vo) {
		boardService.insertBoard(vo);
		return "redirect:/getBoardList.do";
	}

//	@RequestMapping("getBoardList.do")
//	public ModelAndView listBoard(BoardVO vo) {
//		System.out.println("listBoard 호출");
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("boardList", boardService.getBoardList(vo));
//		mv.setViewName("getBoardList");
//		return mv;
//	}
	
	@RequestMapping("getBoardList.do")
	public ModelAndView listBoard(String searchCondition, String searchKeyword) {
		System.out.println("listBoard 호출");
		System.out.println(searchCondition + " : " + searchKeyword);
		HashMap map = new HashMap();
		map.put("searchCondition", searchCondition);
		map.put("searchKeyword", searchKeyword);
		
		List<BoardVO> list = boardService.getBoardList(map);
		ModelAndView mv = new ModelAndView();
		mv.addObject("boardList", list);
		mv.setViewName("getBoardList");
		return mv;
	}

	@RequestMapping("getBoard.do")
	public void getBoard(BoardVO vo, Model m) {
//		System.out.println("getListBoardOne 호출");
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("board", boardService.getBoard(vo));
//		mv.setViewName("getBoard");
//		return mv;
		
		// 조회수 증가
		boardService.updateBoardCnt(vo.getSeq());
		
		// 파라미터로 String seq를 받아도되지만 VO(DTO)로 받아도 됨
		BoardVO result = boardService.getBoard(vo);
		m.addAttribute("board", result);
	}
	
	@RequestMapping("updateBoard.do")
	public void updateBoard(BoardVO vo) {
		System.out.println("updateBoard 호출");
		boardService.updateBoard(vo);
	}
	
	
	@RequestMapping("deleteBoard.do")
	public void deleteBoard(BoardVO vo) {
		System.out.println("deleteBoard 호출");
		boardService.deleteBoard(vo);
	}
}
