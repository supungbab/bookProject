package com.springbook.biz.board;

//VO(Value Object)
public class BookVO {
	private String code;
	private String title;
	private String author;
	private String exits;
	private String userid;
	
	@Override
	public String toString() {
		return "BookVO [code=" + code + ", title=" + title + ", author=" + author + ", exits=" + exits + ", userid="
				+ userid + "]";
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setExits(String exits) {
		this.exits = exits;
	}
	public String getExits() {
		return exits;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
}