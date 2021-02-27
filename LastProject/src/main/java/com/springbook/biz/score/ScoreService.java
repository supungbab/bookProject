package com.springbook.biz.score;

import java.util.List;


public interface ScoreService {

	void insertScore(ScoreVO vo);

	ScoreVO getScore(ScoreVO vo);
	
	void deleteScore(ScoreVO vo);
	
	List<ScoreVO> getScoreList(ScoreVO vo);
	
	List<ScoreVO> getScoreUserList(ScoreVO vo);
}
