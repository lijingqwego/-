package cn.com.user.service.exam;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.user.mapper.TExaPaperInfoMapper;
import cn.com.user.mapper.TExaPaperMapper;
import cn.com.user.mapper.TExaminationInfoMapper;
import cn.com.user.mapper.TExaminationListMapper;
import cn.com.user.pojo.TExaPaper;
import cn.com.user.pojo.TExaminationInfo;
import cn.com.user.pojo.exam.AnswerList;
import cn.com.user.pojo.exam.QuestionInfoVO;

@Service
public class ExamService {
	@Resource
	private TExaPaperMapper papermapper;
	@Resource
	private TExaPaperInfoMapper paperinfomapper;
	@Resource
	private TExaminationListMapper examlistmapper;
	@Resource
	private TExaminationInfoMapper examinfomapper;
	public Map<String, Object> getPage(String subjectno, String username) {
		// TODO Auto-generated method stub
//		
		List<QuestionInfoVO> list= new ArrayList<>();
		List<TExaPaper> paperlist=new ArrayList<>();
		Map<String, Object> resultmap=new HashMap<>();
		Map<String, String> papermap= new HashMap<>();
		Map<String, Object> questionmap= new HashMap<>();
		Random rand = new Random();
		papermap.put("subjectno", subjectno);
		paperlist=papermapper.findBySubject(papermap);
		if(paperlist.size()<1){
			return null;
		}
		int rn=rand.nextInt(paperlist.size());
		String examinationno =paperlist.get(rn).getExaminationNo();
		questionmap.put("examinationno", examinationno);
		questionmap.put("subjectno", subjectno);
		questionmap.put("username", username);
		list=paperinfomapper.findQuestions(questionmap);
		paperinfomapper.insertExaminationInfo(questionmap);
		int result=(int) questionmap.get("result0");
		String examinfono=(String) questionmap.get("vc_examinfono");
		TExaminationInfo examinfo=examinfomapper.selectByPrimaryKey(examinfono);
		if(result==1){
			resultmap.put("examinfo", examinfo);
			resultmap.put("list", list);
		}
		return resultmap;
	}

	public void updateExamkey(List<AnswerList> list, String examno) {
		// TODO Auto-generated method stub
		Map<String, Object> map= new HashMap<>();
		for(int i=0;i<list.size();i++){
			AnswerList vo=list.get(i);
			examlistmapper.updatelist(vo);
		}
		map.put("vc_examination_info_no", examno);
		examlistmapper.updateExam(map);
	}

}
