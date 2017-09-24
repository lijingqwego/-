package cn.com.user.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.com.user.service.security.UserService;
import cn.com.user.util.DateUtil;

@Controller
@RequestMapping("/login")
public class LoginController extends BaseController{
	@Resource
	private UserService userservice;
	private static Logger log=Logger.getLogger(LoginController.class);
	/**
	 * 跳转到菜单页面
	 * @param request
	 * @return
	 */
	@RequestMapping("/menu")
	public ModelAndView LoginToMenu(HttpServletRequest request){
		ModelAndView mv= new ModelAndView();
		SecurityContextImpl securityContextImpl = (SecurityContextImpl) request
				.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
		String username=securityContextImpl.getAuthentication().getName();
		if(username!=null && username !=""){
			//记录登录信息
			userservice.updateLogin(username);
//			保存当前登录loginid信息到session域中，采用springsecurity自带的用户空间调用太麻烦
			this.setSessionUserLoginid(request,username);
			String time=DateUtil.dateToStr(new Date(),DateUtil.DATETYPEONE);
			log.info("用户："+username+"在"+time+"进行了登录操作");
		}
		mv.setViewName("base.definition");
		return mv;
	}
	/**
	 * 安全退出
	 * @return 退出界面
	 */
	@RequestMapping("/loginOut")
	public ModelAndView loginOut(HttpServletRequest request){
		ModelAndView mv=new ModelAndView();
		SecurityContextImpl securityContextImpl = (SecurityContextImpl) request
				.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
		String username=securityContextImpl.getAuthentication().getName();
		if(username!=null && username !=""){
			//记录登录信息
			String time=DateUtil.dateToStr(new Date(),DateUtil.DATETYPEONE);
			log.info("用户"+username+"在"+time+"进行了退出操作");
		}
		mv.setViewName("base.logout");
		return mv;
	}
}
