package cn.com.user.controller.security;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.com.user.pojo.AuthorityAndResource;
import cn.com.user.pojo.PUmAuthority;
import cn.com.user.pojo.PUmAuthorityResource;
import cn.com.user.service.security.AuthorityService;
import cn.com.user.service.security.ResourceService;
import cn.com.user.util.StateUtil;

@Controller
@RequestMapping("/authority")
public class AuthorityController {
	@Resource
	private AuthorityService authorityservice;
	@Resource
	private ResourceService Resourceservice;
	/**
	 * չʾ���е�Ȩ��
	 * @param request
	 * @return
	 */
	@RequestMapping("/showAuthority")
	public ModelAndView findAuthority(HttpServletRequest request){
		ModelAndView mv =new ModelAndView();
		Map<String, String> map=new HashMap<>();
		String authorityname=request.getParameter("authorityname");
		String descn=request.getParameter("descn");
		map.put("authorityname", authorityname);
		map.put("descn", descn);
		List<PUmAuthority> list=new ArrayList<>();
		list=authorityservice.findBySearch(map);
		mv.addObject("authoritylist", list);
		mv.setViewName("authority.authorityList");
		return mv;
	}
	/**
	 * ����ĳ��Ȩ�������޸�
	 * @param authorityid
	 * @return
	 */
	@RequestMapping("/findByAuthorityid")
	public ModelAndView findByAuthority(String authorityid){
		ModelAndView mv =new ModelAndView();
		PUmAuthority authority=new PUmAuthority();
		authority=authorityservice.findByAuthorityid(authorityid);
		mv.addObject("authority", authority);
		mv.setViewName("authority.updateAuthority");
		return mv;
	}
	/**
	 * �޸�Ȩ��
	 * @param record
	 * @return
	 */
	@RequestMapping("/updateAuthority")
	public ModelAndView updateAuthority(PUmAuthority record){
		ModelAndView mv =new ModelAndView();
		authorityservice.updateAuthority(record);
		Map<String, String> map=new HashMap<>();
		List<PUmAuthority> list=new ArrayList<>();
		list=authorityservice.findBySearch(map);
		mv.addObject("authoritylist", list);
		mv.setViewName("authority.authorityList");
		return mv;
	}
	/**
	 * ɾ��Ȩ��
	 * @param authorityid
	 * @return
	 */
	@RequestMapping("/removeAuthority")
	public ModelAndView removeAuthority(String authorityid){
		ModelAndView mv =new ModelAndView();
//		����Ȩ�޽�ֹɾ��
		if(!"10001".equals(authorityid)){
			authorityservice.removeAuthority(authorityid);
		}
		Map<String, String> map=new HashMap<>();
		List<PUmAuthority> list=new ArrayList<>();
		list=authorityservice.findBySearch(map);
		mv.addObject("authoritylist", list);
		mv.setViewName("authority.authorityList");
		return mv;
	}
	/**
	 * ��ѯȨ�޺���Դ֮��Ĺ�����ϵ
	 * @param authorityd Ȩ��id
	 * @param request �洢��ǰ������Ȩ��id
	 * @return
	 */
	@RequestMapping("/authorityAndResource")
	public ModelAndView findRolerelevanceResource(String authorityid,HttpServletRequest request){
		ModelAndView mv =new ModelAndView();
		List<AuthorityAndResource> Resources=new ArrayList<>();
		Resources=Resourceservice.findAuthorityRelevanceResource(authorityid);
		request.getSession().setAttribute("relevance_authorityid", authorityid);
		mv.addObject("resourcelist", Resources);
		mv.setViewName("authority.authorityAndResource");
		return mv;
	}
	/**
	 * ����Ȩ��ѡ�е���Դ
	 * @param authorityid ѡ��Ȩ��id�ַ�������
	 * @param request ��ȡ��ǰ������Ȩ��id
	 * @return
	 */
	@RequestMapping("/relevance")
	public @ResponseBody String roleRelevanceResource(String resourceid,HttpServletRequest request){
		if(resourceid ==null || resourceid ==""){
			return "0";
		}
		String [] resourceids=resourceid.split("-");
		String authorityid=(String) request.getSession().getAttribute("relevance_authorityid");
		List<PUmAuthorityResource> list= new ArrayList<>();
		for(int i=0;i<resourceids.length;i++){
			PUmAuthorityResource item=new PUmAuthorityResource();
			item.setAuthorityid(authorityid);
			item.setResourceId(resourceids[i]);;
			item.setFlaginfo("1");
			list.add(item);
		}
		int result=Resourceservice.insertList(list,authorityid);
		if(result==StateUtil.FAILSTATE){
			return "0";
		}else{
			return "1";
		}
		
	}
}
