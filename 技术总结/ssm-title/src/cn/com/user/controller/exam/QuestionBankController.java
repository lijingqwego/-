package cn.com.user.controller.exam;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.com.user.pojo.TExaQuestionDetailed;
import cn.com.user.pojo.TExaQuestions;
import cn.com.user.pojo.exam.QuestionBankVO;
import cn.com.user.pojo.information.MenuVO;
import cn.com.user.service.exam.QuestionBankService;
import cn.com.user.service.information.SubjectService;
import cn.com.user.util.DateUtil;

//题库信息管理
@Controller
@RequestMapping("/bank")
public class QuestionBankController {
	@Resource
	private QuestionBankService bankservice;
	@Resource
	private SubjectService subjectservice;
	@RequestMapping("/showBank")
	public ModelAndView showBank(HttpServletRequest request){
		ModelAndView mv =new ModelAndView();
		List<QuestionBankVO> list= new ArrayList<>();
		Map<String, String> map= new HashMap<>();
		list=bankservice.findBySearche(map);
		mv.addObject("banklist", list);
		mv.setViewName("bank.bankList");
		return mv;
	}
	@RequestMapping("/removebank")
	public ModelAndView removeBank(HttpServletRequest request,String questionsno){
		ModelAndView mv = new ModelAndView();
		List<QuestionBankVO> list= new ArrayList<>();
		Map<String, String> map= new HashMap<>();
		bankservice.romovebank(questionsno);
		list=bankservice.findBySearche(map);
		mv.addObject("banklist", list);
		mv.setViewName("bank.bankList");
		return mv;
	}
	@RequestMapping("/relation")
	public ModelAndView relation(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
//		科目菜单
		Map<String, String> munemap= new HashMap<>();
		List<MenuVO> listmune=new ArrayList<>();
//		未分配的题目
		Map<String, String> map = new HashMap<>();
		List<TExaQuestionDetailed> listexa=new ArrayList<>();
		String questionname=request.getParameter("questionname");
		if(questionname !=null && !questionname.equals("")){
			map.put("questionname", questionname);
		}
		munemap.put("subjectOrder", "1");
		listexa=bankservice.findRelation(map);
		listmune=subjectservice.ordermenu(munemap);
		mv.addObject("relationlist", listexa);
		mv.addObject("listmune", listmune);
		mv.setViewName("bank.relation");
		return mv;
	}
	@RequestMapping("/toRelation")
	@ResponseBody
	public String toRelation(HttpServletRequest request){
//		避免未选题就确认入库
		String questionno= request.getParameter("questionno");
		String subjectno= request.getParameter("subjectno");
//		父级科目
		String subjecttwo= request.getParameter("subjecttwo");
		String questionsname= request.getParameter("questionsname");
		String questionsdesc= request.getParameter("questionsdesc");
		if(questionno == null || "".equals(questionno)){
			return "0";
		}
		String[] questionnos=questionno.split("-");
		BigDecimal subject=BigDecimal.valueOf(Long.parseLong(subjectno));
		BigDecimal subject2=BigDecimal.valueOf(Long.parseLong(subjecttwo));
		List<TExaQuestions> list=new ArrayList<>();
		String time=DateUtil.dateToStr((new Date()),DateUtil.DATETYPESTRING);
		for(int i=0;i<questionnos.length;i++){
			TExaQuestions record=new TExaQuestions();
			record.setQuestionsNo((time+i).toString());
			record.setSubjectNo(subject);
			record.setQuestionId(questionnos[i]);
			record.setQuestionsName(questionsname);
			record.setQuestionsDesc(questionsdesc);
			list.add(record);
		}
//		用于一起为二级菜单完成综合测试
		String timetwo=time+"1";
		for(int i=0;i<questionnos.length;i++){
			TExaQuestions record=new TExaQuestions();
			record.setQuestionsNo((timetwo+i).toString());
			record.setSubjectNo(subject2);
			record.setQuestionId(questionnos[i]);
			record.setQuestionsName(questionsname);
			record.setQuestionsDesc(questionsdesc);
			list.add(record);
		}
		
		int result =bankservice.insertList(list);
		if(result==1){
			return "1";
		}else{
			return "0";
		}
		
	}
}
