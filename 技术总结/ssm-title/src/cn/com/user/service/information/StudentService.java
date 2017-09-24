package cn.com.user.service.information;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.user.mapper.TUserStudentMapper;
import cn.com.user.pojo.TUserStudent;
import cn.com.user.util.StateUtil;

@Service
public class StudentService {
	@Resource
	private TUserStudentMapper studentmapper;
	@SuppressWarnings("finally")
	public List<TUserStudent> findBySearch(Map<String, String> map){
		List<TUserStudent> list=new ArrayList<TUserStudent>();
		try {
			list=studentmapper.findBySearch(map);
		} catch (Exception e) {
			// TODO: handle exception
			list.clear();
			e.printStackTrace();
			
		}finally{
			return list;
		}
	}
	@SuppressWarnings("finally")
	public TUserStudent findByStudentid(String studentid){
		TUserStudent student=null;
		try {
			 student = studentmapper.selectByPrimaryKey(studentid);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			return student;
		}
	}
	public int deleteStudent(String studentid){
		try {
			studentmapper.deleteByPrimaryKey(studentid);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return StateUtil.FAILSTATE;
		}
		return StateUtil.SUCCESSSTATE;
	}
	public int updateStudent(TUserStudent recode){
		if(recode.getClassId()==null || recode.getClassId()==""){
			return StateUtil.DATAEXCEPTION;
		}
		try {
			studentmapper.updateByPrimaryKeySelective(recode);
		} catch (Exception e) {
			e.printStackTrace();
			return StateUtil.FAILSTATE;
			// TODO: handle exception
		}
		return StateUtil.SUCCESSSTATE;
	}
	public int insertStudent(TUserStudent recode){
		if(recode.getClassId()==null || recode.getClassId()==""){
			return StateUtil.DATAEXCEPTION;
		}
		if(recode.getStudentName()==null || recode.getStudentName()==""){
			return StateUtil.DATAEXCEPTION;
		}
		if(recode.getStudentNo()==null || recode.getStudentNo()==""){
			return StateUtil.DATAEXCEPTION;
		}
//		查询是否存在该数据
		int check=studentmapper.check(recode.getStudentNo());
		if(check>0){
			return StateUtil.CHECKEXIST;
		}
		try {
			studentmapper.updateByPrimaryKeySelective(recode);
		} catch (Exception e) {
			e.printStackTrace();
			return StateUtil.FAILSTATE;
			// TODO: handle exception
		}
		return StateUtil.SUCCESSSTATE;
	}
}
