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
	 * ��ת���˵�ҳ��
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
			//��¼��¼��Ϣ
			userservice.updateLogin(loginid);
//			���浱ǰ��¼loginid��Ϣ��session���У�����springsecurity�Դ����û��ռ����̫�鷳
			this.setSessionUserLoginid(request,loginid);
			String time=DateUtil.dateToStr(new Date(),DateUtil.DATETYPEONE);
			log.info("�û���"+loginid+"��"+time+"�����˵�¼����");
		}
		mv.setViewName("base.definition");
		return mv;
	}
	/**
	 * ��ת׼���޸��ǳ�
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
	 * �޸��û��ǳ�
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
//		��ת���˵�ҳ��
		mv.setViewName("base.definition");
		return mv;
	}
	/**
	 * ��ת�޸�����ҳ��
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
	 * �����޸�
	 * @param oldpassword ������
	 * @param newpassword ������
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
			return "0";//�޸�����ʧ�ܣ���������µ���޸�
		}
		if(result==StateUtil.DATAEXCEPTION){
			return "3";//ԭ���벻��ȷ��������������ٵ���޸�
		}
		return "1";
	}
	/**
	 * ע���˻�ʱ��֤�Ƿ����
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
	 * ע���û�
	 * @param loginid �˺�id
	 * @param username �ǳ�
	 * @param password ����
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
