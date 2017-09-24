package cn.com.user.util;

import java.text.SimpleDateFormat;
import java.util.Date;
//时间格式转化
public class DateUtil {
	public static final String DATETYPEONE="yyyy 年  MM 月  dd 日 HH:mm:ss";
	public static final String DATETYPETWO="yyyy 年  MM 月  dd 日";
	public static final String DATETYPETHREE="yyyy 年  MM 月 ";
	public static final String DATETYPEFOUR="yyyy 年 ";
	public static final String DATETYPESTRING="yyyyMMddHHmmss";
//	时间格式转化成字符串
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
