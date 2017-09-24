package cn.com.user.controller.exam;

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

import cn.com.user.controller.BaseController;
import cn.com.user.pojo.TExaPaper;
import cn.com.user.pojo.exam.PageVO;
import cn.com.user.pojo.information.MenuVO;
import cn.com.user.service.exam.PageService;
import cn.com.user.service.information.SubjectService;

//定制试卷
@Controller
@RequestMapping("/page")
public class PageController extends BaseController{
	@Resource
	private PageService pageservice;
	@Resource
	private SubjectService subjectservice;
	@RequestMapping("/showPages")
	public ModelAndView showPages(HttpServletRequest request){
		ModelAndView mv=new ModelAndView();
		List<TExaPaper> list= new ArrayList<>();
		list=pageservice.findAll();
		mv.addObject("pagelist", list);
		mv.setViewName("page.pageList");
		return mv;
	}
	@RequestMapping("/toInsert")
	public ModelAndView toInsert(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
//		科目菜单
		Map<String, String> munemap= new HashMap<>();
		List<MenuVO> listmune=new ArrayList<>();
		munemap.put("subjectOrder", "1");
		listmune=subjectservice.ordermenu(munemap);
		mv.addObject("listmune", listmune);
		mv.setViewName("page.addPage");
		return mv;
	}
	@RequestMapping("/addPage")
	@ResponseBody
	public String insertPage(@RequestBody PageVO vo,HttpServletRequest request){
		String username=this.getSessionUserLoginid(request);
		vo.setUsername(username);
		int result=pageservice.insertPage(vo);
		if(result==1){
			return "1";
		}else{
			return "0";
		}
	}
}
