package com.springbook.biz.score.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.score.ScoreService;
import com.springbook.biz.score.ScoreVO;

@Service("scoreService")
public class ScoreServiceImpl implements ScoreService {
	@Autowired
	private ScoreDAO scoreDAO;

	public void insertScore(ScoreVO vo) {
		scoreDAO.insertScore(vo); 
	}

	public void deleteScore(ScoreVO vo) {
		scoreDAO.deleteScore(vo);
	}

	public ScoreVO getScore(ScoreVO vo) {
		return scoreDAO.getScore(vo);
	}

	public List<ScoreVO> getScoreList(ScoreVO vo) {
		return scoreDAO.getScoreList(vo);
	}
	
	public List<ScoreVO> getScoreUserList(ScoreVO vo) {
		return scoreDAO.getScoreUserList(vo);
	}
}