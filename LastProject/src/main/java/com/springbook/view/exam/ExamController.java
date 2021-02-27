package com.springbook.view.exam;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springbook.biz.exam.ExamVO;
import com.springbook.biz.exam.impl.ExamDAO;
import com.springbook.biz.score.ScoreVO;
import com.springbook.biz.score.impl.ScoreDAO;

@Controller
@SessionAttributes("exam")
public class ExamController {
	
	@RequestMapping("/Exam.do")
	public String getExamList(ExamVO vo, ExamDAO examDAO, Model model, HttpServletRequest req, HttpSession session, HttpServletResponse reesponse) {
		//System.out.println(req.getParameter("code"));
		List<ExamVO> examlist = examDAO.getExamList(req.getParameter("code"));
		model.addAttribute("examList", examlist);
		model.addAttribute("code", req.getParameter("code"));
		return "getExamList.jsp"; // View 이름 리턴
	}
	
	@RequestMapping("/ExamManagement.do")
	public String getExamAdminList(ExamVO vo, ExamDAO examDAO, Model model, HttpServletRequest req, HttpSession session, HttpServletResponse response) {
		System.out.println("ExamManagement.do 들어옴");
		if(session.getAttribute("role").equals("admin")) {
		//System.out.println(req.getParameter("code"));
		List<ExamVO> examlist = examDAO.getExamList(req.getParameter("code"));
		model.addAttribute("examList", examlist);
		model.addAttribute("code", req.getParameter("code"));
		return "getExamAdminList.jsp"; // View 이름 리턴
		}
		return "getExamList.jsp";
	}
	
	@RequestMapping("/insertExam.do")
	public String insertExam(ExamVO vo, ExamDAO examDAO, HttpSession session, HttpServletRequest req, HttpServletResponse response) {
		examDAO.insertExam(vo,req.getParameter("code"));
		return "ExamManagement.do?"+req.getParameter("code");
	}
	
	@RequestMapping("/updateExam.do")
	public String updateExam(ExamVO vo, ExamDAO examDAO, HttpSession session, HttpServletRequest req, HttpServletResponse response) {
		//System.out.println("들어는 왔다. "+ vo);
		examDAO.updateExam(vo, req.getParameter("code"));
		return "ExamManagement.do?"+req.getParameter("code");
	}
	
	@RequestMapping("/ExamCheck.do")
	public String checkExam(ExamDAO examDAO,ScoreDAO scoreDAO,ScoreVO svo, HttpSession session, HttpServletRequest req, HttpServletResponse response) {
		List<ExamVO> examlist = examDAO.getExamList(req.getParameter("code"));
		int score=0;
		List<String> Question = new ArrayList<String>();
		Enumeration<String> names = req.getParameterNames();
		//문제 라디오 개수를 배열로 만드는 작업.
		do {
			String name = names.nextElement();
			String value = req.getParameter(name);
			if(name.startsWith("Q")) {
				Question.add(value);
			  }
		}while(names.hasMoreElements());
		for(int i=0;i<examlist.size();i++) {
			if(Question.get(i).equals(examlist.get(i).getAnswer()))
					++score;
		}
		svo.setCode(req.getParameter("code"));
		svo.setId(session.getAttribute("id").toString());
		svo.setScore(Integer.toString(score));
		scoreDAO.insertScore(svo);
		
		if(session.getAttribute("role").equals("admin"))
			return "getBoardAdminList.do";
		else
			return "getBoardList.do";
	}

}
