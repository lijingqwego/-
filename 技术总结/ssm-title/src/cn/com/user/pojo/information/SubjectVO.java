package cn.com.user.pojo.information;

import java.math.BigDecimal;

public class SubjectVO {
	 	private BigDecimal subjectNo;
	    private String subjectCode;
	    private String subjectName;

	    private String classContent;

	    private String classTarget;
	    private BigDecimal classHour;

	    private String fatherName;
	    private BigDecimal subjectOrder;
		public BigDecimal getSubjectNo() {
			return subjectNo;
		}
		public void setSubjectNo(BigDecimal subjectNo) {
			this.subjectNo = subjectNo;
		}
		public String getSubjectCode() {
			return subjectCode;
		}
		public void setSubjectCode(String subjectCode) {
			this.subjectCode = subjectCode;
		}
		public String getSubjectName() {
			return subjectName;
		}
		public void setSubjectName(String subjectName) {
			this.subjectName = subjectName;
		}
		public String getClassContent() {
			return classContent;
		}
		public void setClassContent(String classContent) {
			this.classContent = classContent;
		}
		public String getClassTarget() {
			return classTarget;
		}
		public void setClassTarget(String classTarget) {
			this.classTarget = classTarget;
		}
		public BigDecimal getClassHour() {
			return classHour;
		}
		public void setClassHour(BigDecimal classHour) {
			this.classHour = classHour;
		}
		public String getFatherName() {
			return fatherName;
		}
		public void setFatherName(String fatherName) {
			this.fatherName = fatherName;
		}
		public BigDecimal getSubjectOrder() {
			return subjectOrder;
		}
		public void setSubjectOrder(BigDecimal subjectOrder) {
			this.subjectOrder = subjectOrder;
		}
		public SubjectVO() {
			super();
			// TODO Auto-generated constructor stub
		}

}
