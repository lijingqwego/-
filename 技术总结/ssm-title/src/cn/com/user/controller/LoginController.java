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
	 * ��ת���˵�ҳ��
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
			//��¼��¼��Ϣ
			userservice.updateLogin(username);
//			���浱ǰ��¼loginid��Ϣ��session���У�����springsecurity�Դ����û��ռ����̫�鷳
			this.setSessionUserLoginid(request,username);
			String time=DateUtil.dateToStr(new Date(),DateUtil.DATETYPEONE);
			log.info("�û���"+username+"��"+time+"�����˵�¼����");
		}
		mv.setViewName("base.definition");
		return mv;
	}
	/**
	 * ��ȫ�˳�
	 * @return �˳�����
	 */
	@RequestMapping("/loginOut")
	public ModelAndView loginOut(HttpServletRequest request){
		ModelAndView mv=new ModelAndView();
		SecurityContextImpl securityContextImpl = (SecurityContextImpl) request
				.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
		String username=securityContextImpl.getAuthentication().getName();
		if(username!=null && username !=""){
			//��¼��¼��Ϣ
			String time=DateUtil.dateToStr(new Date(),DateUtil.DATETYPEONE);
			log.info("�û�"+username+"��"+time+"�������˳�����");
		}
		mv.setViewName("base.logout");
		return mv;
	}
}
