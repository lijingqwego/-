package cn.com.user.pojo.exam;

public class QuestionVO {
	private int questionnum;
	private int questiontype;
    private String questionname;
    private String answerone;
    private String answertwo;
    private String answerthree;
    private String answerfour;
    private String rightkey;
	public int getQuestiontype() {
		return questiontype;
	}
	public void setQuestiontype(int questiontype) {
		this.questiontype = questiontype;
	}
	public String getQuestionname() {
		return questionname;
	}
	public void setQuestionname(String questionname) {
		this.questionname = questionname;
	}
	public String getAnswerone() {
		return answerone;
	}
	public void setAnswerone(String answerone) {
		this.answerone = answerone;
	}
	public String getAnswertwo() {
		return answertwo;
	}
	public void setAnswertwo(String answertwo) {
		this.answertwo = answertwo;
	}
	public String getAnswerthree() {
		return answerthree;
	}
	public void setAnswerthree(String answerthree) {
		this.answerthree = answerthree;
	}
	public String getAnswerfour() {
		return answerfour;
	}
	public void setAnswerfour(String answerfour) {
		this.answerfour = answerfour;
	}
	public String getRightkey() {
		return rightkey;
	}
	public void setRightkey(String rightkey) {
		this.rightkey = rightkey;
	}
	public int getQuestionnum() {
		return questionnum;
	}
	public void setQuestionnum(int questionnum) {
		this.questionnum = questionnum;
	}
	public QuestionVO(int questionnum, int questiontype, String questionname, String answerone, String answertwo,
			String answerthree, String answerfour, String rightkey) {
		super();
		this.questionnum = questionnum;
		this.questiontype = questiontype;
		this.questionname = questionname;
		this.answerone = answerone;
		this.answertwo = answertwo;
		this.answerthree = answerthree;
		this.answerfour = answerfour;
		this.rightkey = rightkey;
	}
	public QuestionVO() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
