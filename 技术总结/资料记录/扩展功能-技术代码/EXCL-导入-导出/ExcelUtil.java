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
		String fileName = file.getOriginalFilename();		//ԭʼ�ļ���
		//System.out.println("ԭʼ�ļ���------->"+fileName);
		String uploadPath = "d:/";//PropertiesUtil.;//.getProperty("xlsxUploadSavePath");	//�������д��һ�����ش���·���� �� d:/upload/xlsx�ȣ����嵽xlsx�ļ������棩
		 
		System.out.println("�����ļ�uploadPath------>"+uploadPath);
		//String ss = request.getSession().getServletContext().getRealPath(uploadPath);
		String newFileName = null;
		String newFilePath = null;
		if(!file.isEmpty()){  
             //���Ϸָ�����
			  String newDatePath =  File.separator+ "teml"+ File.separator;	//���Ϸָ�����
			//  System.out.println("���ڸ�ʽ���ļ���------->"+newDatePath);
			  String savepath = uploadPath + newDatePath;
			 // System.out.println("����·��------->"+savepath);
              String fileType = fileName.substring(fileName.lastIndexOf("."), fileName.length());
             // System.out.println("��׺��------->"+fileType);
              //����� 2007 �ļ���ʼ����
              if(".xlsx".equals(fileType)){		
            	  newFileName = new Date().getTime()+ fileType;	//����������ļ���//�����ǻ��һ������ļ������ƣ����Բ�д����������Լ�������
            	//  System.out.println("����������ļ���------->"+newFileName);
            	  File dirFile = new File(savepath);		//�½��ļ��ϴ� �� ��Ŀ�� �ļ���
            	  
            	  if (!dirFile.exists()) {
            		  dirFile.mkdir();
            	  }
            	  File saveFile = new File(savepath+File.separator+newFileName);
            	  newFilePath = savepath+newFileName;
            	//  System.out.println("�ϴ��ļ��ĵ�ַ------->"+newFilePath);
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
            	  
            	//------------��ʼ����----------------  
            	//------------��ʼ����----------------  
            	//------------��ʼ����----------------  
            	  try {
						String filecopy = newFilePath;		//����·�����Ǹղ������ϴ����ļ�λ��
						XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new FileInputStream(filecopy));
						// ѭ��excel������Sheet
						XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
						List<QuestionVO> list=new ArrayList<>();
						if(xssfSheet == null){
							listMap.put("list", list);
							return listMap;
						}
					//excel����������
					// ѭ����Row  
					 for(int rowNum = 2; rowNum <= xssfSheet.getLastRowNum(); rowNum++ ){
					      XSSFRow xssfRow = xssfSheet.getRow( rowNum);
					      if(xssfRow == null){
					        continue;
					      }
					      QuestionVO vo= new QuestionVO();
//					      ��һ�е���Ŀ����
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
//				          ��Ŀ����
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
//				          ��Ŀ��
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
            	//System.out.println("�ϴ����еĵ����¼�����ǣ�"+tList.size());
            	//ִ�б������ݿ�  
				//equipmentService.addBatch(tList);	
              }else{
            	  //�� 2007 �ļ�(��.xlsx�ļ�)
            	  
              }
		}
		return listMap;
	}
}
