package com.springbook.biz.exam.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.exam.ExamService;
import com.springbook.biz.exam.ExamVO;

@Service("examService")
public class ExamServiceImpl implements ExamService {
	@Autowired
	private ExamDAO examDAO;

	public void insertExam(ExamVO vo, String code) {
		examDAO.insertExam(vo, code); 
	}

	public void updateExam(ExamVO vo, String code) {
		examDAO.updateExam(vo, code);
	}

	public void deleteExam(ExamVO vo, String code) {
		examDAO.deleteExam(vo, code);
	}

	public ExamVO getExam(ExamVO vo, String code) {
		return examDAO.getExam(vo, code);
	}

	public List<ExamVO> getExamList(String code) {
		return examDAO.getExamList(code);
	}
}