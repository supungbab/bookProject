package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

@Controller
public class JoinController {
	@RequestMapping(value = "/join.do", method=RequestMethod.POST)
	public String insertBoard(UserVO vo, UserDAO userDAO, HttpSession session, HttpServletRequest req, HttpServletResponse response) {
		if(userDAO.getUserChek(vo.getId())) {
			System.out.println("아이디가 있어요 다시만드세요.");
			return "join.jsp";
		}
		System.out.println("회원가입 성공.");
		userDAO.insertUser(vo);
		return "login.jsp";
	}
	@RequestMapping(value = "/join.do", method=RequestMethod.GET)
	public String joinBoard(HttpSession session, HttpServletRequest req, HttpServletResponse response) {
		return "join.jsp";

	}
}
