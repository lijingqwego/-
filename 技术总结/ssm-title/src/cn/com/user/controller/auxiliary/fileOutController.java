package cn.com.user.controller.auxiliary;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/file")
public class fileOutController {
	private static String[] USERSTRING={"用户名","昵称","时间"};
	@RequestMapping("/templet")
	public void templetfile(HttpServletRequest requset,HttpServletResponse response){
		String filetype=requset.getParameter("filetype");
		switch (filetype) {
		case "user":
			fileout(USERSTRING,"usertemplet.excl",response);
			break;

		default:
			break;
		}
		
	}
	public void fileout(String[] stringtds,String filename,HttpServletResponse response){
		response.setContentType("application/octet-stream;charset=UTF-8");  
		try {
			response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
