package cn.com.user.util;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

import cn.com.user.pojo.RoleList;
import net.sf.json.JSONArray;
//MD5����
public class MD5Util {
	private static final Log logger = LogFactory.getLog(MD5Util.class);
	public static String md5(String password) {     
        Md5PasswordEncoder md5 = new Md5PasswordEncoder();     
        // false ��ʾ������32λ��Hex��, ��Ҳ��encodeHashAsBase64��, Acegi Ĭ������; true  ��ʾ������24λ��Base64��     
        md5.setEncodeHashAsBase64(false);     
        String pwd = md5.encodePassword(password, null);     
        logger.debug("MD5: " + pwd + " len=" + pwd.length());
        return pwd;
    }  
    public static String sha_256(String password) throws NoSuchAlgorithmException {       
        ShaPasswordEncoder sha = new ShaPasswordEncoder(256);     
        sha.setEncodeHashAsBase64(true);     
        String pwd = sha.encodePassword(password, null);     
        logger.debug("��ϣ�㷨 256: " + pwd + " len=" + pwd.length());     
       return pwd;
    }     
         
        
    public static String sha_SHA_256(String password) {     
        ShaPasswordEncoder sha = new ShaPasswordEncoder();     
        sha.setEncodeHashAsBase64(false);     
        String pwd = sha.encodePassword(password, null);      
        logger.debug("��ϣ�㷨 SHA-256: " + pwd + " len=" + pwd.length());     
        return pwd;
    }     
         
        
    public static String md5_SystemWideSaltSource (String password,String username) {     
        Md5PasswordEncoder md5 = new Md5PasswordEncoder();     
        md5.setEncodeHashAsBase64(false);     
        username="huiji"+username+"name";
        password="jiami"+password+"tao";
        // ʹ�ö�̬�����ε�ֻ��Ҫ��ע���û���ʱ�򽫵ڶ������������û�������   
        String pwd = md5.encodePassword(password, username);
       return pwd;
    }
    public static void main(String[] args) {
		System.out.println(md5_SystemWideSaltSource("rihe2016","rihe2017"));
		List<RoleList> list=new ArrayList<>();
		for(int i=0;i<5;i++){
			RoleList role=new RoleList();
			role.setRolecode("ssssssssss");
			list.add(role);
		}
		JSONArray fromObject = JSONArray.fromObject(list);
		System.out.println(fromObject.toString());
	}
}
