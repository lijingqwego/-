package cn.com.user.controller.security;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.com.user.controller.BaseController;
import cn.com.user.pojo.PUmUser;
import cn.com.user.pojo.PUmUserRole;
import cn.com.user.pojo.PagetionVo;
import cn.com.user.pojo.UserAndRole;
import cn.com.user.service.security.RoleService;
import cn.com.user.service.security.UserAndRoleService;
import cn.com.user.service.security.UserService;
import cn.com.user.util.DateUtil;
import cn.com.user.util.StateUtil;

@Controller
@RequestMapping("/account")
public class AccountController extends BaseController{
	private static Logger log=Logger.getLogger(AccountController.class);
	@Resource
	private UserService userservice;
	@Resource
	private UserAndRoleService userandroleservice;
	@Resource
	private RoleService roleservice;
//	用于分页
	/**
	 * 根据条件查找用户
	 * @param request
	 * @return 
	 * @return
	 */
	@RequestMapping("/showAccounts")
	public ModelAndView findUser( HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		Map<String, String> map=new HashMap<>();
//		获取查询条件
		String loginid=request.getParameter("loginid");
		String username=request.getParameter("username");
//		完成分页操作
		String page=request.getParameter("page");
		if(page==null ||page.equals("")){
			page="1";
		}
		PagetionVo vo=new PagetionVo();
		vo.setpage(page);
		map.put("loginid", loginid);
		map.put("username", username);
		map.put("startnum", vo.getStartcount());
		map.put("endnum", vo.getEndcount());
		List <PUmUser> users=new ArrayList<>();
		users=userservice.findBySearche(map);
		String time=DateUtil.dateToStr(new Date(),DateUtil.DATETYPEONE);
		log.info("管理员在"+time+"对符合条件的用户进行查询："+loginid+"  "+username);
		mv.addObject("userlist", users);
		mv.setViewName("user.userList");
		return mv;
	}
	/**
	 * 用于查找用户信息到修改页面
	 * @param userid
	 * @return
	 */
	@RequestMapping("/findByUserid")
	public ModelAndView findByUserid(String userid){
		ModelAndView mv = new ModelAndView();
		PUmUser user = new PUmUser();
		user=userservice.findByUserid(userid);
		String time=DateUtil.dateToStr(new Date(),DateUtil.DATETYPEONE);
		log.info("管理员在"+time+"查询了id为："+userid+"的信息准备进行修改");
		mv.addObject("user", user);
		mv.setViewName("user.updateUser");
		return mv;
	}
	/**
	 * 更新用户信息
	 * @param user
	 * @return
	 */
	@RequestMapping("/updateUser")
	public ModelAndView updateUser(PUmUser user){
		ModelAndView mv = new ModelAndView();
		List <PUmUser> users=new ArrayList<>();
		Map<String, String> map = new HashMap<>();
		userservice.updateUser(user);
		PagetionVo vo=new PagetionVo();
		vo.setpage("1");
		map.put("startnum", vo.getStartcount());
		map.put("endnum", vo.getEndcount());
		users=userservice.findBySearche(map);
		mv.addObject("userlist", users);
		mv.setViewName("user.userList");
		return mv;
	}
	/**
	 * 删除用户信息
	 * @param userid
	 * @return
	 */
	@RequestMapping("/removeUser")
	public ModelAndView removeUser(String userid,HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		List <PUmUser> users=new ArrayList<>();
		Map<String,String> map= new HashMap<>();
//		先执行删除操作在执行查询操作
		userservice.removeUser(userid);
		PagetionVo vo=new PagetionVo();
		vo.setpage("1");
		map.put("startnum", vo.getStartcount());
		map.put("endnum", vo.getEndcount());
		users=userservice.findBySearche(map);
		mv.addObject("userlist", users);
		mv.setViewName("user.userList");
		return mv;
	}
	/**
	 * 添加用户按钮响应，完成页面跳转
	 * @param request
	 * @return
	 */
	@RequestMapping("/addUser")
	public ModelAndView addUser(HttpServletRequest request){
		ModelAndView mv =new ModelAndView();
		mv.setViewName("user.addUser");
		return mv;
	}
	/**
	 * 添加新的用户信息
	 * @param user
	 * @return
	 */
	@RequestMapping("/insertUser")
	public ModelAndView insertUser(PUmUser user){
		ModelAndView mv = new ModelAndView();
		List <PUmUser> users=new ArrayList<>();
		Map<String, String> map = new HashMap<>();
		int result =userservice.insertUser(user);
		System.out.println(result);
		PagetionVo vo=new PagetionVo();
		vo.setpage("1");
		map.put("startnum", vo.getStartcount());
		map.put("endnum", vo.getEndcount());
		users=userservice.findBySearche(map);
		mv.addObject("userlist", users);
		mv.setViewName("user.userList");
		return mv;
	}
	/**
	 * 用户角色间关联信息
	 * @param request
	 * @param userid 用户id
	 * @return
	 */
	@RequestMapping("/userandrole")
	public ModelAndView userandRole(HttpServletRequest request,String userid){
		ModelAndView mv =new ModelAndView();
		List<UserAndRole> roles=new ArrayList<>();
		roles=roleservice.findRoleRelevanceUser(userid);
//		保存当前关联操作的userid
		request.getSession().setAttribute("relevance_userid", userid);
		mv.addObject("roles", roles);
		mv.setViewName("user.userAndRole");
		return mv;
	}
	/**
	 * 关联已经选中的角色
	 * @param roles 角色id
	 * @param request 
	 * @return 操作状态
	 */
	@RequestMapping("/relevance")
	public @ResponseBody String userRelevanceRole(String roles,HttpServletRequest request){
//		判断数据传输是否异常
		if(roles == null || roles==""){
			return "0";
		}
//		获取当前执行关联操作的userid
		String userid=(String) request.getSession().getAttribute("relevance_userid");
		PUmUserRole userrole=new PUmUserRole();
		userrole.setUserid(userid);
		userrole.setRoleid(roles);
		userrole.setFlaginfo("1");
		int result=userandroleservice.insertList(userrole);
		if(result==StateUtil.FAILSTATE){
			return "0";
		}
		return "1";
	}
}
