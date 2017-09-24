package cn.com.user.controller.information;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.com.user.pojo.TUserStudent;
import cn.com.user.service.information.StudentService;
import cn.com.user.util.StateUtil;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Resource
	private StudentService studentservice;
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/showStudents")
	public ModelAndView showStudents(HttpServletRequest request){
		ModelAndView mv =new ModelAndView();
		String studentName=request.getParameter("studentname");
		String studentNo=request.getParameter("studentno");
		String classId=request.getParameter("classid");
		Map<String, String> map=new HashMap<>();
		if(studentName != null && studentName !=""){
			map.put("studentName", studentName);
		}
		if(studentNo != null && studentNo !=""){
			map.put("studentNo", studentNo);
		}
		if(classId != null && classId !=""){
			map.put("classId", classId);
		}
		List<TUserStudent> list =new ArrayList<>();
		list=studentservice.findBySearch(map);
		mv.addObject("list", list);
		mv.setViewName("student.studentList");
		return mv;
	}
	/**
	 * 
	 * @param studentid
	 * @return
	 */
	@RequestMapping("/findByStudentid")
	public ModelAndView findByStudentid(String studentid){
		ModelAndView mv =new ModelAndView();
		TUserStudent student= new TUserStudent();
		student=studentservice.findByStudentid(studentid);
		mv.addObject("student", student);
		mv.setViewName("student.updateStudent");
		return mv;
	}
	/**
	 * 
	 * @param student
	 * @return
	 */
	@RequestMapping("/updateStudent")
	public @ResponseBody String updateStudent(@RequestBody TUserStudent student){
		String message="success";
		int result=studentservice.insertStudent(student);
		if(result==StateUtil.FAILSTATE){
			message="0";
		}
		return message;
	}
	/**
	 * 
	 * @param student
	 * @return
	 */
	@RequestMapping("/insertStudent")
	public @ResponseBody String insertStudent(@RequestBody TUserStudent student){
		String message="sucess";
		int result=studentservice.insertStudent(student);
		if(result==StateUtil.FAILSTATE){
			message="0";
		}
		if(result==StateUtil.CHECKEXIST){
			message="2";
		}
		if(result==StateUtil.DATAEXCEPTION){
			message="3";
		}
		return message;
	}
	@RequestMapping("/deleteStudent")
	public @ResponseBody String deleteStudent(@RequestBody String studentid){
		String message="sucess";
		int result=studentservice.deleteStudent(studentid);
		if(result==StateUtil.FAILSTATE){
			message="0";
		}
		return message;
	}
}
