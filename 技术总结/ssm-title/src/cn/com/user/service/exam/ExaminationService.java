package cn.com.user.service.exam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.user.mapper.TExaminationInfoMapper;
import cn.com.user.mapper.TExaminationListMapper;
import cn.com.user.pojo.TExaminationInfo;
import cn.com.user.pojo.TExaminationList;

@Service
public class ExaminationService {
	
	@Resource
	private TExaminationInfoMapper examinfomapper;
	@Resource
	private TExaminationListMapper examlistmapper;
	public Map<String, Object> findExanination(Map<String, String> map) {
		// TODO Auto-generated method stub
		List<TExaminationList> list= new ArrayList<>();
		TExaminationInfo vo= new TExaminationInfo();
		Map<String, Object> resultmap= new HashMap<>();
		vo=examinfomapper.findOne(map);
		list=examlistmapper.findByExaminfo(map);
		resultmap.put("vo", vo);
		resultmap.put("list", list);
		return resultmap;
	}
}
