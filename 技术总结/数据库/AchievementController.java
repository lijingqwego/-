package com.controller.em;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.po.ExaminationInfo;
import com.po.PaperInfo;
import com.service.impl.PaperServiceImpl;
import com.util.ExcelDownload;
import com.util.SessionAdmin;

/**
 * 成绩
 * @author Admin
 *
 */
@Controller
@RequestMapping("/achievement")
public class AchievementController {
	
	@Autowired
	private PaperServiceImpl service;
	
	@RequestMapping("/initPage")
	public ModelAndView InitPage(PaperInfo info,HttpServletRequest request,HttpServletResponse response){
		
		ModelAndView mv = new ModelAndView();
		
		List<PaperInfo> list = service.findAchievement(info);
		
		mv.addObject("List",list);
		
		mv.addObject("info",info);
		
		
		mv.setViewName("achievement.page");
		
		return mv;
	}
	/**
	 * 下载
	 * @param info
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/download")
	public void findDataAndDownload(PaperInfo info,HttpServletRequest request,HttpServletResponse response){
		
           String[] rowsName = new String[]{"序号","试卷名称","试卷类型","考试人员","考试分数","考试时长"};
           List<Object[]>  dataList = new ArrayList<Object[]>();
           Object[] objs = null;
           
           List<PaperInfo> list = service.findAchievement(info);
           
           for (int i = 0; i < list.size(); i++) {
        	   PaperInfo man = list.get(i);
        	   for (ExaminationInfo exainfo : man.getExaminationInfo()) {
        		   objs = new Object[rowsName.length];
                   objs[0] = i;
                   objs[1] = man.getExamination_name();
                   objs[2] = man.getExamination_type();
                   objs[3] = exainfo.getExamination_user();
                   objs[4] = exainfo.getScore();
                   objs[5] = exainfo.getExamination_length();
                   dataList.add(objs);
        	   }
           }
           
           SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
           ExcelDownload ex = new ExcelDownload(df.format(new Date(new Date().getTime())), rowsName, dataList);
           try {
			ex.export(request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
