package cn.com.user.util;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonUtil {
	public static String listToJson(List<?> list){
		JSONArray jsona= JSONArray.fromObject(list);
		JSONObject jsono= new JSONObject();
//		datatable返回必须携带的数据
		jsono.put("data", jsona);
 		String jsonlist= jsono.toString();
		return jsonlist;
	}
	public static String objectToJson(Object recode){
		JSONObject jsono = JSONObject.fromObject(recode);
		JSONObject jsondata= new JSONObject();
		jsondata.put("data", jsono);
		String jsonobject=jsondata.toString();
		return jsonobject;
	}
	public static String mapToJson(Map<String, String> recode){
		JSONArray jsona= JSONArray.fromObject(recode);
		JSONObject jsondata= new JSONObject();
		jsondata.put("data", jsona);
		String jsonobject=jsondata.toString();
		return jsonobject;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
