package com.springbook.biz.exam;

//VO(Value Object)
public class ExamVO {
	private int num;
	private String question;
	private String example1;
	private String example2;
	private String example3;
	private String example4;
	private String answer;
	
	@Override
	public String toString() {
		return "ExamVO [num=" + num + ", question=" + question + ", example1=" + example1 + ", example2=" + example2
				+ ", example3=" + example3 + ", example4=" + example4 + ", answer=" + answer + "]";
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getExample1() {
		return example1;
	}
	public void setExample1(String example1) {
		this.example1 = example1;
	}
	public String getExample2() {
		return example2;
	}
	public void setExample2(String example2) {
		this.example2 = example2;
	}
	public String getExample3() {
		return example3;
	}
	public void setExample3(String example3) {
		this.example3 = example3;
	}
	public String getExample4() {
		return example4;
	}
	public void setExample4(String example4) {
		this.example4 = example4;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
}