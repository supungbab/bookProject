package com.springbook.biz.board;

//VO(Value Object)
public class BoardVO {
	private int seq;
	private String title;
	private String code;
	
	@Override
	public String toString() {
		return "BoardVO [seq=" + seq + ", title=" + title + ", code=" + code + "]";
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
}