
package com.springbook.biz.exam.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.springbook.biz.common.JDBCUtil;
import com.springbook.biz.exam.ExamVO;

// DAO(Data Access Object)
@Repository("examDAO")
public class ExamDAO {
	// JDBC 관련 변수
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	// SQL 명령어들
	
	// CRUD 기능의 메소드 구현
	// 문제 등록
	public void insertExam(ExamVO vo, String code) {
		final String EXAM_INSERT = "insert into "+code+" (num, question, example1, example2, example3, example4, answer) values((select nvl(max(num), 0)+1 from "+code+"),?,?,?,?,?,?)";
		System.out.println("===> JDBC로 insertExam() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(EXAM_INSERT);
			stmt.setString(1, vo.getQuestion());
			stmt.setString(2, vo.getExample1());
			stmt.setString(3, vo.getExample2());
			stmt.setString(4, vo.getExample3());
			stmt.setString(5, vo.getExample4());
			stmt.setString(6, vo.getAnswer());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	// 문제 수정
	public void updateExam(ExamVO vo, String code) {
		final String EXAM_UPDATE = "update "+code+" set question=?, example1=?, example2=?, example3=?, example4=?, answer=? where num=?";
		System.out.println("===> JDBC로 updateExam() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(EXAM_UPDATE);
			stmt.setString(1, vo.getQuestion());
			stmt.setString(2, vo.getExample1());
			stmt.setString(3, vo.getExample2());
			stmt.setString(4, vo.getExample3());
			stmt.setString(5, vo.getExample4());
			stmt.setString(6, vo.getAnswer());
			stmt.setInt(7, vo.getNum());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	// 문제 삭제
	public void deleteExam(ExamVO vo, String code) {
		final String EXAM_DELETE = "delete "+code+" where num=?";
		System.out.println("===> JDBC로 deleteExam() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(EXAM_DELETE);
			stmt.setInt(1, vo.getNum());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	// 문제 상세 조회
	public ExamVO getExam(ExamVO vo, String code) {
		final String EXAM_GET = "select * from "+code+" where num=?";
		System.out.println("===> JDBC로 getExam() 기능 처리");
		ExamVO exam = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(EXAM_GET);
			stmt.setInt(1, vo.getNum());
			rs = stmt.executeQuery();
			if (rs.next()) {
				exam = new ExamVO();
				exam.setNum(rs.getInt("NUM"));
				exam.setQuestion(rs.getString("QUESTION"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return exam;
	}

	// 문제 목록 조회
	public List<ExamVO> getExamList(String code) {
		final String EXAM_LIST = "select * from "+code+" order by num asc";
		System.out.println("===> JDBC로 getExamList() 기능 처리");
		List<ExamVO> examList = new ArrayList<ExamVO>();
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(EXAM_LIST);
			rs = stmt.executeQuery();
			while (rs.next()) {
				ExamVO exam = new ExamVO();
				exam.setNum(rs.getInt("NUM"));
				exam.setQuestion(rs.getString("QUESTION"));
				exam.setExample1(rs.getString("EXAMPLE1"));
				exam.setExample2(rs.getString("EXAMPLE2"));
				exam.setExample3(rs.getString("EXAMPLE3"));
				exam.setExample4(rs.getString("EXAMPLE4"));
				exam.setAnswer(rs.getString("ANSWER"));
				examList.add(exam);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return examList;
	}
	
}