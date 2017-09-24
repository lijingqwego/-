package cn.com.user.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import cn.com.user.pojo.exam.QuestionVO;

public class ExcelUtil {
	@SuppressWarnings("rawtypes")
	public static Map imputExcel(MultipartFile file){

		Map<String,Object> listMap = new HashMap<>();
		String fileName = file.getOriginalFilename();		//原始文件名
		//System.out.println("原始文件名------->"+fileName);
		String uploadPath = "d:/";//PropertiesUtil.;//.getProperty("xlsxUploadSavePath");	//这里可以写死一个本地磁盘路径： 如 d:/upload/xlsx等（具体到xlsx文件夹下面）
		 
		System.out.println("配置文件uploadPath------>"+uploadPath);
		//String ss = request.getSession().getServletContext().getRealPath(uploadPath);
		String newFileName = null;
		String newFilePath = null;
		if(!file.isEmpty()){  
             //加上分隔符号
			  String newDatePath =  File.separator+ "teml"+ File.separator;	//加上分隔符号
			//  System.out.println("日期格式的文件夹------->"+newDatePath);
			  String savepath = uploadPath + newDatePath;
			 // System.out.println("保存路径------->"+savepath);
              String fileType = fileName.substring(fileName.lastIndexOf("."), fileName.length());
             // System.out.println("后缀名------->"+fileType);
              //如过是 2007 文件开始保存
              if(".xlsx".equals(fileType)){		
            	  newFileName = new Date().getTime()+ fileType;	//随机生产新文件名//这里是获得一个随机文件夹名称，可以不写，具体根据自己的需求
            	//  System.out.println("随机生产新文件名------->"+newFileName);
            	  File dirFile = new File(savepath);		//新建文件上传 到 的目的 文件夹
            	  
            	  if (!dirFile.exists()) {
            		  dirFile.mkdir();
            	  }
            	  File saveFile = new File(savepath+File.separator+newFileName);
            	  newFilePath = savepath+newFileName;
            	//  System.out.println("上传文件的地址------->"+newFilePath);
            	  try {
            		  FileOutputStream os = new FileOutputStream(saveFile);  
            		  InputStream in = file.getInputStream();  
            		  int b=0;  
            		  while((b=in.read())!=-1){  
            			  os.write(b);  
            		  }  
            		  os.flush();  
            		  os.close();  
            		  in.close();  
            	  } catch (Exception e) { 
            		  e.printStackTrace();
            	  }
            	  
            	//------------开始解析----------------  
            	//------------开始解析----------------  
            	//------------开始解析----------------  
            	  try {
						String filecopy = newFilePath;		//这里路径就是刚才咱们上传的文件位置
						XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new FileInputStream(filecopy));
						// 循环excel工作表Sheet
						XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
						List<QuestionVO> list=new ArrayList<>();
						if(xssfSheet == null){
							listMap.put("list", list);
							return listMap;
						}
					//excel工作表名称
					// 循环行Row  
					 for(int rowNum = 2; rowNum <= xssfSheet.getLastRowNum(); rowNum++ ){
					      XSSFRow xssfRow = xssfSheet.getRow( rowNum);
					      if(xssfRow == null){
					        continue;
					      }
					      QuestionVO vo= new QuestionVO();
//					      第一行的题目内容
				          XSSFCell xssfCell0 = xssfRow.getCell(0);
				          if(xssfCell0==null){
				        	  continue;
				          }
				          String questionname=xssfCell0.getStringCellValue();
				          if(questionname.length()<3){
				        	  continue;
				          }else{
				        	  vo.setQuestionname(questionname);
				          }
//				          题目类型
				          XSSFCell xssfCell1 = xssfRow.getCell(1);
				          if(xssfCell1==null){
				        	  continue;
				          }
				          xssfCell1.setCellType(Cell.CELL_TYPE_STRING);
				          String questiontype=xssfCell1.getStringCellValue();
				          if(questiontype.equals("")){
				        	  continue;
				          }else{
				        	  vo.setQuestiontype(Integer.parseInt(questiontype));
				          }
//				          题目答案
				          XSSFCell xssfCell2 = xssfRow.getCell(2);
				          if(xssfCell2==null){
				        	  continue;
				          }
				          String rightkey=xssfCell2.getStringCellValue();
				          if(rightkey.equals("")){
				        	  continue;
				          }else{
				        	  vo.setRightkey(rightkey);
				          }
				          if(questiontype.equals("3")){
				        	  vo.setAnswerone("meiyong");
				        	  vo.setAnswertwo("meiyong");
				        	  vo.setAnswerthree("meiyong");
				        	  vo.setAnswerfour("meiyong");
				          }else{
				        	  XSSFCell xssfCell3 = xssfRow.getCell(3);
				        	  if(xssfCell3==null){
					        	  continue;
					          }
					          String answerone=xssfCell3.getStringCellValue();
					          if(answerone.equals("")){
					        	  continue;
					          }else{
					        	  vo.setAnswerone(answerone);
					          }
					          XSSFCell xssfCell4 = xssfRow.getCell(4);
					          if(xssfCell4==null){
					        	  continue;
					          }
					          String answertwo=xssfCell4.getStringCellValue();
					          if(answertwo.equals("")){
					        	  continue;
					          }else{
					        	  vo.setAnswertwo(answertwo);
					          }
					          XSSFCell xssfCell5 = xssfRow.getCell(5);
					          if(xssfCell5==null){
					        	  continue;
					          }
					          String answerthree=xssfCell5.getStringCellValue();
					          if(answerthree.equals("")){
					        	  continue;
					          }else{
					        	  vo.setAnswerthree(answerthree);
					          }
					          XSSFCell xssfCell6 = xssfRow.getCell(6);
					          if(xssfCell6==null){
					        	  continue;
					          }
					          String answerfour=xssfCell6.getStringCellValue();
					          if(answerfour.equals("")){
					        	  continue;
					          }else{
					        	  vo.setAnswerfour(answerfour);
					          }
				          }
				          list.add(vo);
					 }
					 listMap.put("list", list);
				} catch (IOException e) {
					e.printStackTrace();
				}
            	//System.out.println("上传表中的单表记录个数是："+tList.size());
            	//执行保存数据库  
				//equipmentService.addBatch(tList);	
              }else{
            	  //非 2007 文件(非.xlsx文件)
            	  
              }
		}
		return listMap;
	}
}
