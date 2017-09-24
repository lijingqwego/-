package cn.com.user.controller.exam;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.com.user.pojo.exam.QuestionVO;
import cn.com.user.service.exam.QuestionService;
import cn.com.user.util.ExcelUtil;

//�������
@Controller
@RequestMapping("/question")
public class QuestionController {
	@Resource
	private QuestionService questionservcie;
	@RequestMapping("/toQuestion")
	public ModelAndView toQuestion(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("question.toquestion");
		return mv;
	}
	@RequestMapping("/addQuestion")
	@ResponseBody
	public String addQuestion(@RequestBody QuestionVO vo){
		Map<String, Object> map= new HashMap<>();
		map.put("vo", vo);
		int result=questionservcie.insertquestion(map);
		if(result==1){
			return "1";
		}else{
			return "0";
		}
		
	}
	/**
	 * ����������
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/inputQuestions")
	public ModelAndView inputQuestions(@RequestParam(value = "file", required = false) MultipartFile file){
		ModelAndView mv = new ModelAndView();
		System.out.println("                    ");
		//��������  
		Map<String,Object> map= ExcelUtil.imputExcel(file);
		int result=questionservcie.insertList(map);
		System.out.println(result);
		mv.setViewName("question.toquestion");
		return mv;
	}
	/**
	 * ����
	 * @param fileName
	 * @param request
	 * @param response
	 */
	@RequestMapping("/downloadExcel")
	public void	downloadExcel(String fileName,HttpServletRequest  request,HttpServletResponse response){
		  	response.setContentType("application/x-download; charset=utf-8"); 
		  	   String xlsxDemoName = "QuestionsModlue.xlsx";       //������Ҫ���ص�ģ���ļ���������д��  
	        String xlsxUploadSavePath =  request.getSession().getServletContext().getRealPath("");//����Ҫ�����ļ���·�������ߺ��������ķ�������ַ�������Ǳ��ش��̣���d:/XXX  
	        try {  
	            if (request.getHeader("User-Agent").toLowerCase().indexOf("firefox") > 0) {    
	                xlsxDemoName = new String(xlsxDemoName.getBytes("UTF-8"), "ISO8859-1"); // firefox�����    
	                response.setHeader("Content-disposition", "attachment; filename="+xlsxDemoName);  
	                xlsxDemoName = new String(xlsxDemoName.getBytes("ISO-8859-1"),"UTF-8");  
	            } else if (request.getHeader("User-Agent").toUpperCase().indexOf("MSIE") > 0) {   
	                response.setHeader("Content-disposition", "attachment; filename="+xlsxDemoName);  
	                xlsxDemoName = URLEncoder.encode(xlsxDemoName, "UTF-8");// IE�����  
	                xlsxDemoName = new String(xlsxDemoName.getBytes("ISO-8859-1"),"UTF-8");  
	            }else if (request.getHeader("User-Agent").toUpperCase().indexOf("CHROME") > 0) {    
	                xlsxDemoName = new String(xlsxDemoName.getBytes("UTF-8"), "ISO8859-1");// �ȸ�   
	                response.setHeader("Content-disposition", "attachment; filename="+xlsxDemoName);  
	                xlsxDemoName = new String(xlsxDemoName.getBytes("ISO-8859-1"),"UTF-8");  
	            }else{  
	                response.setHeader("Content-disposition", "attachment; filename="+URLEncoder.encode(xlsxDemoName,"utf-8"));  
	            }  
	              
	        } catch (Exception e1) {  
	            e1.printStackTrace();  
	        }
	        try {   
	            File file=new File(xlsxUploadSavePath+File.separator+xlsxDemoName);    
	            InputStream inputStream=new FileInputStream(file);    
	            OutputStream os = response.getOutputStream();  
	            byte[] b=new byte[1024];    
	            int length;    
	            while((length=inputStream.read(b))>0){    
	                os.write(b,0,length);  //os���Զ�����  
	            }   
	            inputStream.close();    
	        } catch (FileNotFoundException e) {    
	            e.printStackTrace();    
	        } catch (IOException e) {    
	            e.printStackTrace();    
	        }   
	         
	}
}
