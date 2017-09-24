package cn.com.user.service.exam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.user.mapper.TLesSubRelationMapper;
import cn.com.user.mapper.TLessonProductInfoMapper;
import cn.com.user.pojo.TLessonProductInfo;
import cn.com.user.util.DateUtil;
import cn.com.user.util.StateUtil;
@Service
public class ProductService {
	@Resource
	private TLessonProductInfoMapper productmapper;
	@Resource
	private TLesSubRelationMapper relationmapper;
	public List<TLessonProductInfo> findBySearche(Map<String, String> map) {
		// TODO Auto-generated method stub
		List<TLessonProductInfo> list = new ArrayList<>();
		list=productmapper.findBySearche(map);
		return list;
	}

	public TLessonProductInfo findByLessonid(String lessonid) {
		// TODO Auto-generated method stub
		TLessonProductInfo product =new TLessonProductInfo();
		product=productmapper.selectByPrimaryKey(lessonid);
		return product;
	}

	public int updateProduct(TLessonProductInfo product) {
		// TODO Auto-generated method stub
		try {
			productmapper.updateByPrimaryKeySelective(product);
			return StateUtil.SUCCESSSTATE;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return StateUtil.FAILSTATE;
		}
		
	}

	public void removeProduct(String lessonid) {
		// TODO Auto-generated method stub
//		先删除关联表，在删除主表
		relationmapper.deleteByLessonid(lessonid);
		productmapper.deleteByPrimaryKey(lessonid);
		
	}

	public int insertProduct(TLessonProductInfo product) {
		// TODO Auto-generated method stub
//		生成id
		String time="pd_"+DateUtil.dateToStr(new Date(), DateUtil.DATETYPESTRING);
		product.setLessonId(time);
//		判断数据库要求的非空列
		if(product.getLessonCode() == null || "".equals(product.getLessonCode())){
			return StateUtil.DATAEXCEPTION;
		}
		if(product.getLessonName() == null || "".equals(product.getLessonName())){
			return StateUtil.DATAEXCEPTION;
		}
//		查重
		int check=productmapper.check(time);
		if(check!=1){
			return StateUtil.CHECKEXIST;
		}
		productmapper.insertSelective(product);
		return StateUtil.SUCCESSSTATE;
	}

}
