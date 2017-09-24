package cn.com.user.controller.exam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.com.user.pojo.TExaminationInfo;
import cn.com.user.pojo.TExaminationList;
import cn.com.user.service.exam.ExaminationService;

//答题卡查看，以及分数记录
@Controller
@RequestMapping("/examination")
public class ExaminationController {
	@Resource
	private ExaminationService examinationservice;
	@RequestMapping("/toScantron")
	public ModelAndView toScantron(HttpServletRequest request){
		ModelAndView mv= new ModelAndView();
		mv.setViewName("examintion.toScantron");
		return mv;
	}
	@SuppressWarnings("unchecked")
	@RequestMapping("/seeScantron")
	public ModelAndView seeScantron(HttpServletRequest request){
		ModelAndView mv= new ModelAndView();
		String examinationno= request.getParameter("examinationno");
		Map<String, String> map =new HashMap<>();
		Map<String, Object> resultmap=new HashMap<>();
		map.put("exammo", examinationno);
		resultmap=examinationservice.findExanination(map);
		TExaminationInfo vo = new TExaminationInfo();
		vo=(TExaminationInfo) resultmap.get("vo");
		mv.addObject("vo", vo);
		List<TExaminationList> list= new ArrayList<>();
		list=(List<TExaminationList>) resultmap.get("list");
		mv.addObject("list", list);
		mv.setViewName("examintion.seeScantron");
		return mv;
	}
}
