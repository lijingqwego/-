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

import cn.com.user.pojo.PUmRole;
import cn.com.user.pojo.PUmRoleAuthority;
import cn.com.user.pojo.RoleAndAuthority;
import cn.com.user.service.security.AuthorityService;
import cn.com.user.service.security.RoleService;
import cn.com.user.util.StateUtil;

@Controller
@RequestMapping("/role")
public class RoleController {
	@Resource
	private RoleService roleservice;
	@Resource
	private AuthorityService authorityservice;
	/**
	 * չʾ���н�ɫ
	 * @param request
	 * @return
	 */
	@RequestMapping("/showRoles")
	public ModelAndView findRole(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
//		��ȡ��ѯ����
		String rolename=request.getParameter("rolename");
		String descn=request.getParameter("descn");
		Map<String, String> map=new HashMap<>();
		if(rolename !=null && rolename !=""){
			map.put("rolename", rolename);
		}
		if(descn !=null && descn !=""){
			map.put("descn", descn);
		}
		List <PUmRole> roles=new ArrayList<>();
		roles=roleservice.findBySearche(map);
		mv.addObject("rolelist", roles);
		mv.setViewName("role.roleList");
		return mv;
	}
	/**
	 * ��ѯ�����ɫ��Ϣ�����޸�
	 * @param roleid
	 * @return
	 */
	@RequestMapping("/findByRoleid")
	public ModelAndView findByRoleid(String roleid){
		ModelAndView mv = new ModelAndView();
		PUmRole role= new PUmRole();
		role=roleservice.findByRoleid(roleid);
		mv.addObject("role", role);
		mv.setViewName("role.updateRole");
		return mv;
	}
	/**
	 * ɾ���û���Ϣ
	 * @param userid
	 * @return
	 */
	@RequestMapping("/removeRole")
	public ModelAndView removeRole(String roleid){
		ModelAndView mv = new ModelAndView();
		List <PUmRole> roles=new ArrayList<>();
		Map<String,String> map= new HashMap<>();
//		������ɫ��ֹɾ��
		if(!"10001".equals(roleid)){
			roleservice.removeRole(roleid);
		}
		roles=roleservice.findBySearche(map);
		mv.addObject("rolelist", roles);
		mv.setViewName("role.roleList");
		return mv;
	}
	/**
	 * ���½�ɫ��Ϣ
	 * @param role
	 * @return
	 */
	@RequestMapping("/updateRole")
	public ModelAndView updateRole(PUmRole role){
		ModelAndView mv = new ModelAndView();
		List <PUmRole> roles=new ArrayList<>();
		Map<String, String> map = new HashMap<>();
		roleservice.updateRole(role);
		roleservice.findBySearche(map);
		roles=roleservice.findBySearche(map);
		mv.addObject("rolelist", roles);
		mv.setViewName("role.roleList");
		return mv;
	}
	/**
	 * ��ӽ�ɫ��ť��Ӧ�����ҳ����ת
	 * @param request
	 * @return
	 */
	@RequestMapping("/addRole")
	public ModelAndView addUser(HttpServletRequest request){
		ModelAndView mv =new ModelAndView();
		mv.setViewName("role.addRole");
		return mv;
	}
	/**
	 * ����µĽ�ɫ��Ϣ
	 * @param user
	 * @return
	 */
	@RequestMapping("/insertRole")
	public ModelAndView insertRole(PUmRole role){
		ModelAndView mv = new ModelAndView();
		List <PUmRole> roles=new ArrayList<>();
		Map<String, String> map = new HashMap<>();
		int result =roleservice.insertRole(role);
		System.out.println(result);
		roles=roleservice.findBySearche(map);
		mv.addObject("rolelist", roles);
		mv.setViewName("role.roleList");
		return mv;
	}
	/**
	 * ��ѯ��ɫ��Ȩ��֮��Ĺ�����ϵ
	 * @param roleid ��ɫid
	 * @param request
	 * @return
	 */
	@RequestMapping("/roleAndAuthority")
	public ModelAndView findRolerelevanceAuthority(String roleid,HttpServletRequest request){
		ModelAndView mv =new ModelAndView();
		List<RoleAndAuthority> authoritys=new ArrayList<>();
		authoritys=authorityservice.findRoleRelevanceAuthority(roleid);
		request.getSession().setAttribute("relevance_roleid", roleid);
		mv.addObject("authoritylist", authoritys);
		mv.setViewName("role.roleAndAuthority");
		return mv;
	}
	/**
	 * ������ɫѡ�е�Ȩ��
	 * @param authorityid ѡ��Ȩ��id�ַ�������
	 * @param request ��ȡ��ǰ�����Ľ�ɫid
	 * @return
	 */
	@RequestMapping("/relevance")
	public @ResponseBody String roleRelevanceAuthority(String authorityid,HttpServletRequest request){
		if(authorityid ==null || authorityid ==""){
			return "0";
		}
		String [] authorityids=authorityid.split("-");
		String roleid=(String) request.getSession().getAttribute("relevance_roleid");
		List<PUmRoleAuthority> list= new ArrayList<>();
		for(int i=0;i<authorityids.length;i++){
			PUmRoleAuthority item=new PUmRoleAuthority();
			item.setRoleid(roleid);
			item.setAuthorityid(authorityids[i]);
			item.setFlaginfo("1");
			list.add(item);
		}
		int result=authorityservice.insertList(list,roleid);
		if(result==StateUtil.FAILSTATE){
			return "0";
		}else{
			return "1";
		}
	}
}
