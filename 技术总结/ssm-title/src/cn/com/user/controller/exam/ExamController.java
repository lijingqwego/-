package cn.com.user.controller.exam;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.com.user.controller.BaseController;
import cn.com.user.pojo.TExaminationInfo;
import cn.com.user.pojo.exam.AnswerList;
import cn.com.user.pojo.exam.QuestionInfoVO;
import cn.com.user.pojo.information.MenuVO;
import cn.com.user.service.exam.ExamService;
import cn.com.user.service.information.SubjectService;

//参加考试到结束
@Controller
@RequestMapping("/examtest")
public class ExamController extends BaseController{
	@Resource
	private ExamService examservice;
	@Resource
	private SubjectService subjectservice;
//	判断题目类型
	public final static String SINGLNKEY="sk_";
	public final static String MULTILKEY="mk_";
	public final static String DECIDEKEY="dk_";
	/**
	 * 去参加考试
	 * @return
	 */
	@RequestMapping("/totest")
	public ModelAndView toTest(){
		ModelAndView mv = new ModelAndView();
//		科目菜单
		Map<String, String> munemap= new HashMap<>();
		List<MenuVO> listmune=new ArrayList<>();
		munemap.put("subjectOrder", "1");
		listmune=subjectservice.ordermenu(munemap);
		mv.addObject("listmune", listmune);
		mv.setViewName("examtest.toTest");
		return mv;
	}
	@SuppressWarnings("unchecked")
	@RequestMapping("/getpage")
	public ModelAndView getpage(HttpServletRequest request,String subjectno){
		ModelAndView mv= new ModelAndView();
		List<QuestionInfoVO> list= new ArrayList<>();
		Map<String, Object> map= new HashMap<>();
		String username=this.getSessionUserLoginid(request);
		map=examservice.getPage(subjectno,username);
		list=(List<QuestionInfoVO>) map.get("list");
		TExaminationInfo examinfo=(TExaminationInfo) map.get("examinfo");
//		保存答题卡编号
		request.getSession().setAttribute("examno", examinfo.getExaminationInfoNo());
		mv.addObject("examinfo", examinfo);
		mv.addObject("questionlist", list);
		mv.setViewName("examtest.questionlist");
		return mv;
	}
	@RequestMapping("/testOver")
	public ModelAndView testOver(HttpServletRequest request){
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView mv = new ModelAndView();
		List<AnswerList> list= new ArrayList<>();
//		获取当前操作的答题卡号
		String examno=(String) request.getSession().getAttribute("examno");
		Boolean flast=true;
		int i=1;
//		读取单选题答案
		while (flast) {
			AnswerList vo= new AnswerList();
			String fromkey=SINGLNKEY+i;
			String choose=request.getParameter(fromkey);
			if(choose==null){
				flast=false;
			}else{
				if("".equals(choose)){
					
				}else{
					vo.setChooseKey(choose);
					vo.setExamno(examno);
					vo.setQuestionNum(i);
					list.add(vo);
				}
				i++;
			}
		}
//		读取多选题
		flast=true;
		while (flast) {
			AnswerList vo= new AnswerList();
			String fromkey=MULTILKEY+i;
			String[] choose=request.getParameterValues(fromkey);
			if(choose==null){
				flast=false;
			}else{
				if(choose.length>0){
					vo.setChooseKey(someToOne(choose));
					vo.setExamno(examno);
					vo.setQuestionNum(i);
					list.add(vo);
					i++;
				}else{
					i++;
				}
			}
			
		}
//		读取判断题
		flast=true;
		while (flast) {
			AnswerList vo= new AnswerList();
			String fromkey=DECIDEKEY+i;
			String choose=request.getParameter(fromkey);
			if(choose==null){
				flast=false;
			}else{
				if("".equals(choose)){
					
				}else{
					vo.setChooseKey(choose);
					vo.setExamno(examno);
					vo.setQuestionNum(i);
					list.add(vo);
				}
				i++;
			}
			
		}
		examservice.updateExamkey(list,examno);
		mv.setViewName("examintion.toScantron");
		return mv;
	}
	public String someToOne(String[] s){
		String m=s[0];
		for(int i=1;i<s.length;i++){
			m=m+","+s[i];
		}
		return m;
	}
}
