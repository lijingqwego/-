package cn.com.user.pojo.exam;

public class QuestionBankVO{
//	�����
	private String questionsNo;
//	��Ŀ���
    private String questionId;
//    �������
    private String questionsName;
//    �������
    private String questionsDesc;
//	��Ŀ����
	private String questionName;
//    ��Ŀ����
	private String subjectName;
	public String getQuestionsNo() {
		return questionsNo;
	}
	public void setQuestionsNo(String questionsNo) {
		this.questionsNo = questionsNo;
	}
	public String getQuestionId() {
		return questionId;
	}
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	public String getQuestionsName() {
		return questionsName;
	}
	public void setQuestionsName(String questionsName) {
		this.questionsName = questionsName;
	}
	public String getQuestionsDesc() {
		return questionsDesc;
	}
	public void setQuestionsDesc(String questionsDesc) {
		this.questionsDesc = questionsDesc;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getQuestionName() {
		return questionName;
	}
	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}
	public QuestionBankVO(String questionsNo, String questionId, String questionsName, String questionsDesc,
			String subjectName, String questionName) {
		super();
		this.questionsNo = questionsNo;
		this.questionId = questionId;
		this.questionsName = questionsName;
		this.questionsDesc = questionsDesc;
		this.subjectName = subjectName;
		this.questionName = questionName;
	}
	public QuestionBankVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
