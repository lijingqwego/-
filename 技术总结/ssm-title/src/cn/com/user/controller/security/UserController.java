package cn.com.user.controller.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.com.user.controller.BaseController;
import cn.com.user.pojo.PUmUser;
import cn.com.user.service.security.UserService;
import cn.com.user.util.DateUtil;
import cn.com.user.util.StateUtil;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
	private static Logger log=Logger.getLogger(UserController.class);
	@Resource
	private UserService userservice;
	/**
	 * 跳转到菜单页面
	 * @param request
	 * @return
	 */
	@RequestMapping("/menu")
	public ModelAndView ToMenu(HttpServletRequest request){
		ModelAndView mv= new ModelAndView();
		SecurityContextImpl securityContextImpl = (SecurityContextImpl) request
				.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
		String loginid=securityContextImpl.getAuthentication().getName();
		if(loginid!=null && loginid !=""){
			//记录登录信息
			userservice.updateLogin(loginid);
//			保存当前登录loginid信息到session域中，采用springsecurity自带的用户空间调用太麻烦
			this.setSessionUserLoginid(request,loginid);
			String time=DateUtil.dateToStr(new Date(),DateUtil.DATETYPEONE);
			log.info("用户："+loginid+"在"+time+"进行了登录操作");
		}
		mv.setViewName("base.definition");
		return mv;
	}
	/**
	 * 跳转准备修改昵称
	 * @param request
	 * @return
	 */
	@RequestMapping("/toChangeUser")
	public ModelAndView toChangeUser(HttpServletRequest request){
		ModelAndView mv= new ModelAndView();
		PUmUser user = new PUmUser();
		String loginid=this.getSessionUserLoginid(request);
		user=userservice.findByLoginid(loginid);
		mv.addObject("username", user.getUsername());
		mv.setViewName("user.changeUser");
		return mv;
	}
	/**
	 * 修改用户昵称
	 * @param request
	 * @return
	 */
	@RequestMapping("/changeUser")
	public ModelAndView changeUser(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		Map<String, String> map= new HashMap<>();
		String loginid=this.getSessionUserLoginid(request);
		String username=request.getParameter("username");
		map.put("loginid", loginid);
		map.put("username", username);
		userservice.updateUsername(map);
//		跳转到菜单页面
		mv.setViewName("base.definition");
		return mv;
	}
	/**
	 * 跳转修改密码页面
	 * @param request
	 * @return
	 */
	@RequestMapping("/toChangePassword")
    public ModelAndView ChangePassword(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user.ChangePassword");
		return mv;
    }
	/**
	 * 密码修改
	 * @param oldpassword 旧密码
	 * @param newpassword 新密码
	 * @param request
	 * @return
	 */
	@RequestMapping("/changePassword")
	public @ResponseBody String changePassword(String oldpassword,String newpassword, HttpServletRequest request){
		Map<String, String> map = new HashMap<>();
		String loginid=this.getSessionUserLoginid(request);
		map.put("loginid", loginid);
		map.put("oldpassword", oldpassword);
		map.put("newpassword", newpassword);
		int result=userservice.changepassword(map);
		if(result==StateUtil.FAILSTATE){
			return "0";//修改密码失败，请检查后重新点击修改
		}
		if(result==StateUtil.DATAEXCEPTION){
			return "3";//原密码不正确，请重新输入后再点击修改
		}
		return "1";
	}
	/**
	 * 注册账户时验证是否存在
	 * @param loginid
	 * @param request
	 * @return
	 */
	@RequestMapping("/check")
	public @ResponseBody String check(String loginid, HttpServletRequest request){
		String message="1";
		int result=userservice.check(loginid);
		if(result!=0){
			message="0";
		}
		return message;
	}
	/**
	 * 注册用户
	 * @param loginid 账号id
	 * @param username 昵称
	 * @param password 密码
	 * @param request
	 * @return
	 */
	@RequestMapping("/sign")
	public @ResponseBody String sign(String loginid,String username,String password, HttpServletRequest request){
		PUmUser user=new PUmUser();
		String userid=DateUtil.dateToStr(new Date(), DateUtil.DATETYPESTRING);
		user.setUserid(userid);
		user.setLoginid(loginid);
		user.setUsername(username);
		user.setPassword(password);
		int result=userservice.insertUser(user);
		if(result==StateUtil.FAILSTATE){
			return "0";
		}
		if(result==StateUtil.CHECKEXIST){
			return "2";
		}
		if(result==StateUtil.DATAEXCEPTION){
			return "3";
		}
		return "1";
	}
}
