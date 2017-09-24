package cn.com.user.controller.security;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.com.user.pojo.PUmResources;
import cn.com.user.service.security.ResourceService;

@Controller
@RequestMapping("/resource")
public class ResourceController {
	@Resource
	private ResourceService Resourceservice;
	
	/**
	 * 展示所有的资源
	 * @param request
	 * @return
	 */
	@RequestMapping("/showResource")
	public ModelAndView findResource(HttpServletRequest request){
		ModelAndView mv =new ModelAndView();
		Map<String, String> map=new HashMap<>();
		String resourcename=request.getParameter("resourcename");
		map.put("resourcename", resourcename);
		List<PUmResources> list=new ArrayList<>();
		list=Resourceservice.findBySearche(map);
		mv.addObject("resourcelist", list);
		mv.setViewName("resource.resourceList");
		return mv;
	}
	@RequestMapping("/findByResourceid")
	public ModelAndView findByResourceid(String resourceid){
		ModelAndView mv = new ModelAndView();
		PUmResources resource= new PUmResources();
		resource=Resourceservice.findByRessourceid(resourceid);
		mv.addObject("resource", resource);
		mv.setViewName("resource.updateResource");
		return mv;
	}
	/**
	 * 更新资源
	 * @param record
	 * @return
	 */
	@RequestMapping("/updateResource")
	public ModelAndView updateResource(PUmResources record){
		ModelAndView mv =new ModelAndView();
		Resourceservice.updateResources(record);
		Map<String, String> map=new HashMap<>();
		List<PUmResources> list=new ArrayList<>();
		list=Resourceservice.findBySearche(map);
		mv.addObject("resourcelist", list);
		mv.setViewName("resource.resourceList");
		return mv;
	}
	/**
	 * 删除资源文件
	 * @param Resourceid
	 * @return
	 */
	@RequestMapping("/removeResource")
	public ModelAndView removeResource(String Resourceid){
		ModelAndView mv =new ModelAndView();
		Resourceservice.removeResources(Resourceid);
		Map<String, String> map=new HashMap<>();
		List<PUmResources> list=new ArrayList<>();
		list=Resourceservice.findBySearche(map);
		mv.addObject("resourcelist", list);
		mv.setViewName("resource.resourceList");
		return mv;
	}
}
