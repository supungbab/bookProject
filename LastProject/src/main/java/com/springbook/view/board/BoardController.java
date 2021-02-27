package com.springbook.view.board;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.SessionAttributes;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
@SessionAttributes("board")
public class BoardController {
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, BoardDAO boardDAO, Model model, HttpSession session, HttpServletRequest req, HttpServletResponse response) {
		model.addAttribute("boardList", boardDAO.getBoardList(vo));
		if(session.getAttribute("role").equals("admin"))
			return "getBoardAdminList.jsp";
		else
			return "getBoardList.jsp";
	}
	
	@RequestMapping("/getBoardAdminList.do")
	public String getBoardAdminList(BoardVO vo, BoardDAO boardDAO, Model model, HttpSession session, HttpServletRequest req, HttpServletResponse response) {

		model.addAttribute("boardList", boardDAO.getBoardList(vo));																
		return "getBoardAdminList.jsp"; // View 이름 리턴
	}
	
	// 글 등록
	@RequestMapping(value = "/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO, HttpSession session, HttpServletRequest req, HttpServletResponse response) {
		System.out.println(vo);
		//boardDAO.insertBoard(vo);
		return "getBoardList.do";
	}

	// 글 수정
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo, BoardDAO boardDAO, HttpSession session, HttpServletRequest req, HttpServletResponse response) {
		System.out.println("번호 : " + vo.getSeq());
		System.out.println("제목 : " + vo.getTitle());
		//System.out.println("작성자 : " + vo.getWriter());
		//System.out.println("내용 : " + vo.getContent());
		//System.out.println("등록일 : " + vo.getRegDate());
		//System.out.println("조회수 : " + vo.getCnt());
		
		boardDAO.updateBoard(vo);
		return "getBoardList.do";
	}

	// 글 삭제
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO, HttpSession session, HttpServletRequest req, HttpServletResponse response) {
		boardDAO.deleteBoard(vo);
		return "getBoardList.do";
	}

	// 글 상세 조회
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, BoardDAO boardDAO, Model model, HttpServletRequest req, HttpSession session, HttpServletResponse response) {
		System.out.println(req.getParameter("code"));
		model.addAttribute("board", boardDAO.getBoard(vo)); // Model 정보 저장
		return "getBoard.jsp"; // View 이름 리턴
	}

	// 글 목록 검색

}
