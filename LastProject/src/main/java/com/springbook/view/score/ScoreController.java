package com.springbook.view.score;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springbook.biz.exam.impl.ExamDAO;
import com.springbook.biz.score.ScoreVO;
import com.springbook.biz.score.impl.ScoreDAO;

@Controller
@SessionAttributes("exam")
public class ScoreController {
	
	@RequestMapping("/score.do")
	public String getScoreList(ScoreVO vo, ScoreDAO scoreDAO, ExamDAO examDAO, Model model, HttpServletRequest req, HttpSession session, HttpServletResponse response) {
		vo.setCode(req.getParameter("code"));
		vo.setId(session.getAttribute("id").toString());
		System.out.println(session.getAttribute("id").toString());
		List<ScoreVO> scorelist = scoreDAO.getScoreUserList(vo);
		session.setAttribute("check", scorelist);
		model.addAttribute("scorelist", scorelist);
		model.addAttribute("num",examDAO.getExamList(vo.getCode()).get(examDAO.getExamList(vo.getCode()).size() - 1).getNum());
		return "getScoreList.jsp"; // View 이름 리턴
	}
	

}
