package cn.com.user.pojo.information;

import java.math.BigDecimal;

public class MenuVO {
	private BigDecimal subjectNo;
	private String subjectName;
	private String subjectOrder;
	public BigDecimal getSubjectNo() {
		return subjectNo;
	}
	public void setSubjectNo(BigDecimal subjectNo) {
		this.subjectNo = subjectNo;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getSubjectOrder() {
		return subjectOrder;
	}
	public void setSubjectOrder(String subjectOrder) {
		this.subjectOrder = subjectOrder;
	}
	public MenuVO(BigDecimal subjectNo, String subjectName, String subjectOrder) {
		super();
		this.subjectNo = subjectNo;
		this.subjectName = subjectName;
		this.subjectOrder = subjectOrder;
	}
	public MenuVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
