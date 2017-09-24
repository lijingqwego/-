package cn.com.user.pojo.information;

import cn.com.user.pojo.TSubjectInfo;

public class ProductAndSubject extends TSubjectInfo{
	private String lessonid;

	public String getLessonid() {
		return lessonid;
	}

	public void setLessonid(String lessonid) {
		this.lessonid = lessonid;
	}

	public ProductAndSubject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductAndSubject(String lessonid) {
		super();
		this.lessonid = lessonid;
	}

}
