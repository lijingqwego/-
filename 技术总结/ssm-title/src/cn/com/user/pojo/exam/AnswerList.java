package cn.com.user.pojo.exam;

public class AnswerList {
//	ѡ���
	private String chooseKey;
//	��Ŀ���
	private int questionNum;
//	���⿨���
	private String examno;
	public String getChooseKey() {
		return chooseKey;
	}
	public void setChooseKey(String chooseKey) {
		this.chooseKey = chooseKey;
	}
	public int getQuestionNum() {
		return questionNum;
	}
	public void setQuestionNum(int questionNum) {
		this.questionNum = questionNum;
	}
	public String getExamno() {
		return examno;
	}
	public void setExamno(String examno) {
		this.examno = examno;
	}
	public AnswerList(String chooseKey, int questionNum, String examno) {
		super();
		this.chooseKey = chooseKey;
		this.questionNum = questionNum;
		this.examno = examno;
	}
	public AnswerList() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
