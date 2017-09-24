package cn.com.user.controller.information;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.com.user.controller.BaseController;
import cn.com.user.pojo.TSubjectInfo;
import cn.com.user.pojo.information.MenuVO;
import cn.com.user.pojo.information.SubjectVO;
import cn.com.user.service.exam.QuestionService;
import cn.com.user.service.information.SubjectService;
import cn.com.user.util.JsonUtil;
//�Կ�Ŀ���й���
@Controller
@RequestMapping("/subject")
public class SubjectController extends BaseController{
	private static Logger log=Logger.getLogger(SubjectController.class);
	@Resource
	private SubjectService subjectservice;
	@Resource
	private QuestionService questiontservice;
//	���ڷ�ҳ
	/**
	 * �����������ҿ�Ŀ
	 * @param request
	 * @return 
	 * @return
	 */
	@RequestMapping("/showSubjects")
	public ModelAndView findSubject( HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		List <SubjectVO> subjects=new ArrayList<>();
		subjects=subjectservice.findBySearche();
		mv.addObject("subjectlist", subjects);
		mv.setViewName("subject.subjectList");
		return mv;
	}
	/**
	 * ���ڲ��ҿ�Ŀ��Ϣ���޸�ҳ��
	 * @param subjectno
	 * @return
	 */
	@RequestMapping("/findBysubjectno")
	public ModelAndView findBySubjectno(String subjectno){
		ModelAndView mv = new ModelAndView();
		TSubjectInfo subject = new TSubjectInfo();
		subject=subjectservice.findBySubjectno(subjectno);
		mv.addObject("subject", subject);
		mv.setViewName("subject.updateSubject");
		return mv;
	}
	/**
	 * ���¿�Ŀ��Ϣ
	 * @param subject
	 * @return
	 */
	@RequestMapping("/updateSubject")
	@ResponseBody
	public String updateSubject(@RequestBody TSubjectInfo subject){
		int result=subjectservice.updateSubject(subject);
		if(result==1){
			return "1";
		}else{
			return "0";
		}
	}
	/**
	 * ɾ����Ŀ��Ϣ
	 * @param subjectno
	 * @return
	 */
	@RequestMapping("/removeSubject")
	public ModelAndView removeSubject(String subjectno,HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		List <SubjectVO> subjects=new ArrayList<>();
//		��ִ��ɾ��������ִ�в�ѯ����
		subjectservice.removeSubject(subjectno);
		subjects=subjectservice.findBySearche();
		mv.addObject("subjectlist", subjects);
		mv.setViewName("subject.subjectList");
		return mv;
	}
	@RequestMapping("/toInsert")
	public ModelAndView toInsert(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("subject.toInsert");
		return mv;
	}
	/**
	 * ����µĿ�Ŀ��Ϣ
	 * @param subject
	 * @return
	 */
	@RequestMapping("/insertSubject")
	@ResponseBody
	public String insertSubject(@RequestBody TSubjectInfo subject){
		String message="1";
		int result =subjectservice.insertSubject(subject);
		switch (result) {
		case 1:
			message="1";
			break;
		case 0:
			message="0";
			break;
		default:
			message="2";
			break;
		}
		return message;
	}
	@RequestMapping(value = { "/ordermenu" },produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String ordermenu(String subjectNo,String subjectOrder){
		Map<String, String>  map= new HashMap<>();
		List<MenuVO> list= new ArrayList<>();
		map.put("subjectNo", subjectNo);
		map.put("subjectOrder", subjectOrder);
		list=subjectservice.ordermenu(map);
		String menu=JsonUtil.listToJson(list);
		return menu;
	}
}
