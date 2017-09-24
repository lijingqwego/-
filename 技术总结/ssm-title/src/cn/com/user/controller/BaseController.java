package cn.com.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.Assert;
public class BaseController {  
//    获取保存在session中的登录账号
    protected String getSessionUserLoginid(HttpServletRequest request) {  
        return (String) request.getSession().getAttribute("loginid");  
    }
  //将用户账号登录用的账号保存到Session中  
    protected void setSessionUserLoginid(HttpServletRequest request,String loginid) {  
        request.getSession().setAttribute("loginid",loginid);
    } 
    //获取基于应用程序的url绝对路径
    public final String getAppbaseUrl(HttpServletRequest request, String url) {  
        Assert.hasLength(url, "url不能为空");  
        Assert.isTrue(url.startsWith("/"), "必须以/打头");  
        return request.getContextPath() + url;
    }
}  
