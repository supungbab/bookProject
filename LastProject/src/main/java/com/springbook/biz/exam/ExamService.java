package com.springbook.biz.exam;

import java.util.List;

public interface ExamService {
	void insertExam(ExamVO vo, String code);

	void updateExam(ExamVO vo, String code);

	void deleteExam(ExamVO vo, String code);

	ExamVO getExam(ExamVO vo, String code);

	List<ExamVO> getExamList(String code);
}
