package cn.com.user.service.information;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.user.mapper.TExaQuestionsMapper;
import cn.com.user.mapper.TLesSubRelationMapper;
import cn.com.user.mapper.TSubjectInfoMapper;
import cn.com.user.pojo.TLesSubRelation;
import cn.com.user.pojo.TSubjectInfo;
import cn.com.user.pojo.information.MenuVO;
import cn.com.user.pojo.information.ProductAndSubject;
import cn.com.user.pojo.information.SubjectVO;
import cn.com.user.util.StateUtil;
@Service
public class SubjectService {
	@Resource
	private TSubjectInfoMapper subjectmapper;
	@Resource
	private TLesSubRelationMapper relationmapper;
	@Resource
	private TExaQuestionsMapper questionsmapper;
	public List<ProductAndSubject> findProductRelevanceSubject(String lessonid) {
		// TODO Auto-generated method stub
		List<ProductAndSubject> list=new ArrayList<>();
		list=subjectmapper.productAndSubject(lessonid);
		return list;
	}

	public int insertList(List<TLesSubRelation> list) {
		// TODO Auto-generated method stub
		try {
			relationmapper.insertList(list);
			return StateUtil.SUCCESSSTATE;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return StateUtil.FAILSTATE;
		}
	}

	public List<SubjectVO> findBySearche() {
		// TODO Auto-generated method stub
		List<SubjectVO> list=new ArrayList<>();
		list=subjectmapper.findBySearche();
		return list;
	}

	public TSubjectInfo findBySubjectno(String sunjectno) {
		// TODO Auto-generated method stub
		TSubjectInfo subject = new TSubjectInfo();
		BigDecimal subjectno=BigDecimal.valueOf(Long.parseLong(sunjectno));
		subject=subjectmapper.selectByPrimaryKey(subjectno);
		return subject;
	}

	public int updateSubject(TSubjectInfo subject) {
		// TODO Auto-generated method stub
		try {
			subjectmapper.updateByPrimaryKeySelective(subject);
			return StateUtil.SUCCESSSTATE;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return StateUtil.FAILSTATE;
		}
		
		
	}

	public void removeSubject(String subjectno) {
		// TODO Auto-generated method stub
		BigDecimal subject=BigDecimal.valueOf(Long.parseLong(subjectno));
		relationmapper.deleteBySubjectno(subject);
		questionsmapper.deleteBySubjectno(subject);
		subjectmapper.deleteByPrimaryKey(subject);
	}

	public int insertSubject(TSubjectInfo subject) {
		// TODO Auto-generated method stub
		try {
			Map<String, Object> map= new HashMap<>();
			map.put("father", subject.getFatherSubject());
			map.put("orders", subject.getSubjectOrder());
			int subjectno=subjectmapper.findMaxno(map)+1;
			subject.setSubjectNo(BigDecimal.valueOf(subjectno));
			subjectmapper.insertSelective(subject);
			return StateUtil.SUCCESSSTATE;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return StateUtil.FAILSTATE;
		}
	}

	public int removeAll(String lessonid) {
		// TODO Auto-generated method stub
		try {
			relationmapper.deleteByLessonid(lessonid);
			return StateUtil.SUCCESSSTATE;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return StateUtil.FAILSTATE;
		}
	}

	public List<MenuVO> ordermenu(Map<String, String> map) {
		// TODO Auto-generated method stub
		List<MenuVO> list= new ArrayList<>();
		list=subjectmapper.findMenu(map);
		return list;
	}

}
