package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

@Controller
public class LoginController {

	@RequestMapping("/login.do")
	public String login(UserVO vo, UserDAO userDAO, HttpSession session, HttpServletRequest req, HttpServletResponse response) {
		UserVO user = userDAO.getUser(vo);
		if (user != null) {
			session.setAttribute("userName", user.getName());
			session.setAttribute("id", user.getId());
			
			session.setAttribute("role", user.getRole());
			if(user.getRole().toString().equals("admin")) {
				return "getBoardAdminList.do";
			}
			return "getBoardList.do";
		} else
			return "login.jsp";
	}
}
