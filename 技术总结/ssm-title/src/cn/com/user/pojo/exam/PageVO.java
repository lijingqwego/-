package cn.com.user.pojo.exam;

public class PageVO {
	private String examinationName;
	private int examinationType;
	private String examinationContent;
	private String subjectNo;
	private int examLength;
	private int singln;
	private int multil;
	private int decide;
	private String username;
	public String getExaminationName() {
		return examinationName;
	}
	public void setExaminationName(String examinationName) {
		this.examinationName = examinationName;
	}
	public int getExaminationType() {
		return examinationType;
	}
	public void setExaminationType(int examinationType) {
		this.examinationType = examinationType;
	}
	public String getExaminationContent() {
		return examinationContent;
	}
	public void setExaminationContent(String examinationContent) {
		this.examinationContent = examinationContent;
	}
	public String getSubjectNo() {
		return subjectNo;
	}
	public void setSubjectNo(String subjectNo) {
		this.subjectNo = subjectNo;
	}
	public int getExamLength() {
		return examLength;
	}
	public void setExamLength(int examLength) {
		this.examLength = examLength;
	}
	public int getSingln() {
		return singln;
	}
	public void setSingln(int singln) {
		this.singln = singln;
	}
	public int getMultil() {
		return multil;
	}
	public void setMultil(int multil) {
		this.multil = multil;
	}
	public int getDecide() {
		return decide;
	}
	public void setDecide(int decide) {
		this.decide = decide;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public PageVO(String examinationName, int examinationType, String examinationContent, String subjectNo,
			int examLength, int singln, int multil, int decide, String username) {
		super();
		this.examinationName = examinationName;
		this.examinationType = examinationType;
		this.examinationContent = examinationContent;
		this.subjectNo = subjectNo;
		this.examLength = examLength;
		this.singln = singln;
		this.multil = multil;
		this.decide = decide;
		this.username = username;
	}
	public PageVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
