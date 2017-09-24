package cn.com.user.service.exam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.user.mapper.TExaQuestionDetailedMapper;
import cn.com.user.pojo.exam.QuestionVO;
import cn.com.user.util.StateUtil;
@Service
public class QuestionService {
	@Resource
	private TExaQuestionDetailedMapper questionmapper;
	public int insertquestion(Map<String, Object> map) {
		// TODO Auto-generated method stub
		QuestionVO vo=(QuestionVO) map.get("vo");
		map.remove("vo");
//		判断题避免空报错
		if(vo.getQuestiontype()==3){
			vo.setAnswerone("没用");
			vo.setAnswertwo("没用");
			vo.setAnswerthree("没用");
			vo.setAnswerfour("没用");
		}
		map.put("vo", vo);
		try {
			questionmapper.insertquestion(map);
			int result=(int) map.get("result0");
			if(result==1){
				return StateUtil.SUCCESSSTATE;
			}else{
				return StateUtil.FAILSTATE;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return StateUtil.FAILSTATE;
		}
	}
	@SuppressWarnings("unchecked")
	public int insertList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		try {
			List<QuestionVO> list=(List<QuestionVO>) map.get("list");
			for(int i=0;i<list.size();i++){
				Map<String, Object> questions=new HashMap<>();
				QuestionVO vo=list.get(i);
				questions.put("vo", vo);
				questionmapper.insertquestion(questions);
				int result=(int) questions.get("result0");
				if(result!=1){
					throw new Exception("存储过程出错");
				}
			}
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}

}
