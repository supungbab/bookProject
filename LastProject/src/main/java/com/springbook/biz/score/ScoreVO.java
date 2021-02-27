package com.springbook.biz.score;

import java.sql.Date;

//VO(Value Object)
public class ScoreVO {
	private int seq;
	private String code;
	private String id;
	private String score;
	private Date examdate;
	
	@Override
	public String toString() {
		return "ScoreVO [seq=" + seq + ", code=" + code + ", id=" + id + ", score=" + score + ", examdate=" + examdate
				+ "]";
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public Date getExamdate() {
		return examdate;
	}
	public void setExamdate(Date examdate) {
		this.examdate = examdate;
	}
	
}