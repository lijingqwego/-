package cn.com.user.security.rewrite;

import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;

import cn.com.user.util.MD5Util;
public class MyMessageDigestPasswordEncoder extends MessageDigestPasswordEncoder{

	public MyMessageDigestPasswordEncoder(String algorithm, boolean encodeHashAsBase64)
			throws IllegalArgumentException {
		super(algorithm, encodeHashAsBase64);
		// TODO Auto-generated constructor stub
	}
	public MyMessageDigestPasswordEncoder(String algorithm) {
		super(algorithm);
		// TODO Auto-generated constructor stub
	}
//	enc是从数据库查出来的密文密码，rawpassword是form表单的明文密码，salt为设定的盐值，
	public boolean isPasswordValid(String encPass, String rawPass,Object salt){
		String pass1 = "" + encPass;
		String username=(String) salt;
		System.out.println("encpass:"+encPass+"rawpass:"+rawPass+"   "+salt);
		String pass2 = MD5Util.md5_SystemWideSaltSource(rawPass, username);//自己写的加密方式
		boolean bool=false;
		System.out.println(pass1);
		System.out.println(pass2);
		if(pass1.equals(pass2)){
			bool=true;
		}
		return bool;
	}

}
