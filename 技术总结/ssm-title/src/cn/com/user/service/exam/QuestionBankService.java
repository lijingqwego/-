package cn.com.user.service.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.user.mapper.TExaQuestionDetailedMapper;
import cn.com.user.mapper.TExaQuestionsMapper;
import cn.com.user.pojo.TExaQuestionDetailed;
import cn.com.user.pojo.TExaQuestions;
import cn.com.user.pojo.exam.QuestionBankVO;
import cn.com.user.util.StateUtil;
@Service
public class QuestionBankService {
	@Resource
	private TExaQuestionsMapper bankmapper;
	@Resource
	private TExaQuestionDetailedMapper questionmapper;
	public List<QuestionBankVO> findBySearche(Map<String, String> map) {
		// TODO Auto-generated method stub
		List<QuestionBankVO> list =new ArrayList<>();
		list= bankmapper.findBySeacher(map);
		return list;
	}
	public void romovebank(String questionsno) {
		// TODO Auto-generated method stub
		bankmapper.deleteByPrimaryKey(questionsno);
	}
	public List<TExaQuestionDetailed> findRelation(Map<String, String> map) {
		// TODO Auto-generated method stub
		List<TExaQuestionDetailed> list= new ArrayList<>();
		list=questionmapper.findRelation(map);
		return list;
	}
	public int insertList(List<TExaQuestions> list) {
		// TODO Auto-generated method stub
		try {
			bankmapper.insertList(list);
			return StateUtil.SUCCESSSTATE;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return StateUtil.FAILSTATE;
		}
	}

}
