package cn.com.user.pojo.exam;

import java.math.BigDecimal;

public class AnswerInfoVO {
	private String answerNo;
	private BigDecimal answerNum;
	private String answerContent;
	public String getAnswerNo() {
		return answerNo;
	}
	public void setAnswerNo(String answerNo) {
		this.answerNo = answerNo;
	}
	public BigDecimal getAnswerNum() {
		return answerNum;
	}
	public void setAnswerNum(BigDecimal answerNum) {
		this.answerNum = answerNum;
	}
	public String getAnswerContent() {
		return answerContent;
	}
	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}
	public AnswerInfoVO(String answerNo, BigDecimal answerNum, String answerContent) {
		super();
		this.answerNo = answerNo;
		this.answerNum = answerNum;
		this.answerContent = answerContent;
	}
	public AnswerInfoVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
