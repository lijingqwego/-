package cn.com.user.util;

import java.text.SimpleDateFormat;
import java.util.Date;
//ʱ���ʽת��
public class DateUtil {
	public static final String DATETYPEONE="yyyy ��  MM ��  dd �� HH:mm:ss";
	public static final String DATETYPETWO="yyyy ��  MM ��  dd ��";
	public static final String DATETYPETHREE="yyyy ��  MM �� ";
	public static final String DATETYPEFOUR="yyyy �� ";
	public static final String DATETYPESTRING="yyyyMMddHHmmss";
//	ʱ���ʽת�����ַ���
	public static String dateToStr(Date date,String dateytpe){
		SimpleDateFormat formatter=new SimpleDateFormat(dateytpe);
		String time=formatter.format(date);
		return time;
	}
	public static Date StrToDate(String str,String dateytpe){
		  
		   SimpleDateFormat format = new SimpleDateFormat(dateytpe);
		   Date date = null;
		   try {
		    date = format.parse(str);
		   } catch (Exception e) {
		    e.printStackTrace();
		   }
		   return date;
		}
}
