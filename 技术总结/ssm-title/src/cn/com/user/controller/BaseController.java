package cn.com.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.Assert;
public class BaseController {  
//    ��ȡ������session�еĵ�¼�˺�
    protected String getSessionUserLoginid(HttpServletRequest request) {  
        return (String) request.getSession().getAttribute("loginid");  
    }
  //���û��˺ŵ�¼�õ��˺ű��浽Session��  
    protected void setSessionUserLoginid(HttpServletRequest request,String loginid) {  
        request.getSession().setAttribute("loginid",loginid);
    } 
    //��ȡ����Ӧ�ó����url����·��
    public final String getAppbaseUrl(HttpServletRequest request, String url) {  
        Assert.hasLength(url, "url����Ϊ��");  
        Assert.isTrue(url.startsWith("/"), "������/��ͷ");  
        return request.getContextPath() + url;
    }
}  
