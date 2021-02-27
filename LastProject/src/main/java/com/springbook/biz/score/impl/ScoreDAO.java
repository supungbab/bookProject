package com.springbook.biz.score.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.springbook.biz.common.JDBCUtil;
import com.springbook.biz.score.ScoreVO;

// DAO(Data Access Object)
@Repository("scoreDAO")
public class ScoreDAO {
	// JDBC 관련 변수
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	// SQL 명령어들
	private final String SCORE_INSERT = "insert into score(seq, code, id, score) values((select nvl(max(seq), 0)+1 from score),?,?,?)";
	private final String SCORE_DELETE = "delete score where seq=?";
	private final String SCORE_GET = "select * from score where seq=?";
	private final String SCORE_LIST = "select * from score order by seq desc";
	private final String SCORE_USERLIST = "select * from score where code=? and id=? order by examdate desc";

	// CRUD 기능의 메소드 구현
	// 점수 기록
	public void insertScore(ScoreVO vo) {
		System.out.println("===> JDBC로 insertScore() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(SCORE_INSERT);
			stmt.setString(1, vo.getCode());
			stmt.setString(2, vo.getId());
			stmt.setString(3, vo.getScore());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	// 글 삭제
	public void deleteScore(ScoreVO vo) {
		System.out.println("===> JDBC로 deleteScore() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(SCORE_DELETE);
			stmt.setInt(1, vo.getSeq());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	// 글 상세 조회
	public ScoreVO getScore(ScoreVO vo) {
		System.out.println("===> JDBC로 getScore() 기능 처리");
		ScoreVO score = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(SCORE_GET);
			stmt.setInt(1, vo.getSeq());
			rs = stmt.executeQuery();
			if (rs.next()) {
				score = new ScoreVO();
				score.setSeq(rs.getInt("SEQ"));
				//score.setTitle(rs.getString("TITLE"));
				//board.setWriter(rs.getString("WRITER"));
				//board.setContent(rs.getString("CONTENT"));
				//board.setRegDate(rs.getDate("REGDATE"));
				//board.setCnt(rs.getInt("CNT"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return score;
	}

	// 글 목록 조회
	public List<ScoreVO> getScoreList(ScoreVO vo) {
		System.out.println("===> JDBC로 getScoreList() 기능 처리");
		List<ScoreVO> scoreList = new ArrayList<ScoreVO>();
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(SCORE_LIST);
			rs = stmt.executeQuery();
			while (rs.next()) {
				ScoreVO score = new ScoreVO();
				score.setSeq(rs.getInt("SEQ"));
				//score.setTitle(rs.getString("TITLE"));
				score.setCode(rs.getString("CODE"));
				scoreList.add(score);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return scoreList;
	}
	
	public List<ScoreVO> getScoreUserList(ScoreVO vo) {
		System.out.println("===> JDBC로 getScoreUserList() 기능 처리");
		List<ScoreVO> scoreList = new ArrayList<ScoreVO>();
		int i=1;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(SCORE_USERLIST);
			stmt.setString(1, vo.getCode());
			stmt.setString(2, vo.getId());
			rs = stmt.executeQuery();
			while (rs.next()) {
				ScoreVO score = new ScoreVO();
				score.setSeq(i++);
				score.setCode(rs.getString("CODE"));
				score.setId(rs.getString("ID"));
				score.setScore(rs.getString("SCORE"));
				score.setExamdate(rs.getDate("EXAMDATE"));
				scoreList.add(score);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return scoreList;
	}
}