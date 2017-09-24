package cn.com.user.pojo.exam;

import java.math.BigDecimal;
import java.util.List;

public class QuestionInfoVO {
	
	private String examinationId;
	private BigDecimal questionnum;
	private BigDecimal questiontype;
    private String questionname;
    private List<AnswerInfoVO> answerlist;
    
	public String getExaminationId() {
		return examinationId;
	}
	public void setExaminationId(String examinationId) {
		this.examinationId = examinationId;
	}
	public BigDecimal getQuestionnum() {
		return questionnum;
	}
	public void setQuestionnum(BigDecimal questionnum) {
		this.questionnum = questionnum;
	}
	public BigDecimal getQuestiontype() {
		return questiontype;
	}
	public void setQuestiontype(BigDecimal questiontype) {
		this.questiontype = questiontype;
	}
	public String getQuestionname() {
		return questionname;
	}
	public void setQuestionname(String questionname) {
		this.questionname = questionname;
	}
	public List<AnswerInfoVO> getAnswerlist() {
		return answerlist;
	}
	public void setAnswerlist(List<AnswerInfoVO> answerlist) {
		this.answerlist = answerlist;
	}
	public QuestionInfoVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public QuestionInfoVO(String examinationId, BigDecimal questionnum, BigDecimal questiontype, String questionname,
			List<AnswerInfoVO> answerlist) {
		super();
		this.examinationId = examinationId;
		this.questionnum = questionnum;
		this.questiontype = questiontype;
		this.questionname = questionname;
		this.answerlist = answerlist;
	}
	
    
}
